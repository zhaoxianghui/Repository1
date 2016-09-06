package com.zhao.dao.impl;



import java.util.ArrayList;
import java.util.List;


import com.zhao.contorller.MainServlet;
import com.zhao.dao.UserDao;
import com.zhao.entity.Classs;
import com.zhao.entity.Menu;
import com.zhao.entity.MenuVo;
import com.zhao.entity.Page;
import com.zhao.entity.Role;
import com.zhao.entity.Student;
import com.zhao.entity.User;
import com.zhao.util.DButil;

public class UserDaoImpl implements UserDao{
	/**
	 * 通过用户加载一个用户对象（登录）
	 * @param mobile 用户输入的账号
	 * @return 返回NULL 表示账号不存在
	 */
	public User loadUserByMobile(String mobile) {
		System.out.println("UserDaoIpml数据层");
		String sql="select * from uu where mobile=?";
		List<Object[]> list =DButil.executeQurry(sql,new Object[]{mobile});
		User user=null;
		if(null!=list&&list.size()>0){
			Object[] os=list.get(0);
			user=new User((Integer)os[0],mobile,String.valueOf(os[2]),String.valueOf(os[3]));
		}
		return user;
	}
	/**
	 * 加载所有用户
	 * @return
	 */
	public List<User> loadAllUser() {
		String sql="select * from uu";
		List<Object[]> list =DButil.executeQurry(sql,null);
		List<User> userList=new ArrayList<User>();
		User user=null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				user=new User((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),String.valueOf(os[3]));
				userList.add(user);
			}
		}
		return userList;
	}
	/**
	 * 加载个人用户
	 */
	public List<User> loadSelfUser(String sid) {
		String sql="select * from uu where sid=?";
		List<Object[]> list =DButil.executeQurry(sql,new Object[]{Integer.valueOf(sid)});
		List<User> userList=new ArrayList<User>();
		User user=null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				user=new User((Integer)os[0],(String)os[1],String.valueOf(os[2]),String.valueOf(os[3]));
				userList.add(user);
			}
		}
		return userList;
	}
	/**
	 * 加载所有学生
	 * @return
	 */
	public List<Student> loadAllStudent() {
		String sql="select * from studend order by times desc";
		List<Object[]> list =DButil.executeQurry(sql,null);
		List<Student> studentList=new ArrayList<Student>();
		Student student=null;
		if(null!=list&&list.size()>0){
			for(Object[] o:list){
				student=new Student((Integer)o[0],String.valueOf(o[1]),String.valueOf(o[2]),(Integer)o[3]);
				studentList.add(student);
			}
		}
		return studentList;
	}
	
	/**
	 * 加载所有班级
	 * @return
	 */
	public List<Classs> loadAllClass() {
		String sql="select * from class";
		List<Object[]> list =DButil.executeQurry(sql,null);
		List<Classs> classList=new ArrayList<Classs>();
		Classs classs=null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				classs=new Classs((Integer)os[0],String.valueOf(os[1]));
				classList.add(classs);
			}
		}
		return classList;
	}
	/**
	 * 注册
	 * @param mobile
	 * @return
	 */
	public void zhuce(String mobile,String passwd,String code){
//		String sql="select * from uu where mobile=? and passwd=?";
//		List<Object[]> list =DButil.executeQurry(sql,new Object[]{mobile});
//		if(list.size()>0){
//			MainServlet.getServletContext().setAttribute("Error", "账号已存在，请重新注册或登录");
//			requset.getRequestDispatcher("view/zhuCe.jsp").forward(req, resp);
//		}else{
//		    String sql2="insert into uu(mobile,passwd,code) values(?,?,?)";
//		    DButil.executeDML(sql2, new Object[]{mobile,passwd,code});
//		}
//		return;
		
//		String sql="select * from uu";
//		List<Object[]> list =DButil.executeQurry(sql,new Object[]{null});
//		User user=null;
//		if(null!=list&&list.size()>0){
//			Object[] os=list.get(0);
//			user=new User((Integer)os[0],mobile,String.valueOf(os[2]),String.valueOf(os[3]));
//		
//		String sql1 ="insert into uu(mobile,passwd,code) values(?,?,?)";
//		DButil.executeDML(sql1, new Object[]{mobile,passwd,code});
//		}
	}
	
	/**
	 * 链接到用户页面
	 * @return
	 */
	public List<User> showUser(){
		String sql ="select * from menu where level in(1,2)";
		List<Object[]> listUser = DButil.executeQurry(sql, null);
		List<User> userList = new ArrayList<User>();
		User user=null;
		System.out.println("sfasfasf");
		if(null!=listUser&&listUser.size()>0){
			for(Object[] os:listUser){
				user = new User((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),String.valueOf(os[3]));
				userList.add(user);
			}
		}
		return userList;
	}
	
	
	/**
	 * 菜单权限管理
	 */
	public List<Menu> loadMenu(int sid){
		String sql = "select m.* from uurole ur,rolemenu rm,menu m where" +
				" ur.rid=rm.rid and rm.mid=m.mid and isshow=1 and ur.sid=?";
		List<Object[]> list = DButil.executeQurry(sql,new Object[]{sid});
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu=null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				menu = new Menu((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),(Integer)os[5],(Integer)os[4],(Integer)os[5]);
				menuList.add(menu);
			}
		}
		return menuList;
	}
	

	/**展示菜单
	 * 
	 * @return
	 */
	public Page<MenuVo> showMenu(int pageNo,int pageSize){
		String sql ="select m.mid,m.name,m.url,m.isshow,m.level,(select m2.name from menu m2 where m2.mid=m.parentid) from  menu m limit ?,?";
		List<Object[]> objectList = DButil.executeQurry(sql, new Object[]{(pageNo-1)*pageSize,pageSize});
		MenuVo menu=null;
		List<MenuVo> menulist =new ArrayList<MenuVo>();
		for(Object[] os:objectList){
			menu = new MenuVo((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], String.valueOf(os[5]));
			menulist.add(menu);
		}
		sql="select count(*) from menu";
		objectList = DButil.executeQurry(sql, null);
		long total=(Long)objectList.get(0)[0];
		return new Page<MenuVo>(pageNo,pageSize,menulist,total);
//		return menulist;
		
	}
	/**
	 *查询一二级菜单
	 * @return
	 */
	public List<Menu> showMenus(){
		String sql ="select * from menu where level in(1,2)";
		List<Object[]> listMenus = DButil.executeQurry(sql, null);
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu=null;
		System.out.println("sfasfasf");
		if(null!=listMenus&&listMenus.size()>0){
			for(Object[] os:listMenus){
				menu = new Menu((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),(Integer)os[5],(Integer)os[4],(Integer)os[5]);
				menuList.add(menu);
			}
		}
		return menuList;
	}
	
	/**
	 * 添加菜单
	 */
	public void insertMenu(String name,String url,int isshow,int parentid){
		String sql ="select * from menu where mid=?";
		List<Object[]> listMenus = DButil.executeQurry(sql,new Object[]{parentid});
		Menu menu=null;
		Object[] os = listMenus.get(0);
			menu = new Menu((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),(Integer)os[5],(Integer)os[4],(Integer)os[5]);
		
		String sql1 ="insert into menu(name,url,isshow,level,parentid) values(?,?,?,?,?)";
		DButil.executeDML(sql1, new Object[]{name,url,isshow,menu.getLevel()+1,parentid});
	}
	
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> showRole(){
		String sql ="select * from role";
		List<Object[ ]> list = DButil.executeQurry(sql,null);
		List<Role> roleList = new ArrayList<Role>();
		Role role=null;
		System.out.println("sfasfasf");
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				role = new Role((Integer)os[0],String.valueOf(os[1]));
				roleList.add(role);
			}
		}
		return roleList;
	}
	
	/**
	 * 查询菜单和角色拥有的菜单
	 */
	public List<Object[]> showRolemenu(int rid){
		
		String sql = "select m.mid,m.name,m.parentid,(select 1 from rolemenu rm where " +
				"rm.mid=m.mid and rm.rid=?) from menu m";
		return DButil.executeQurry(sql,new Object[]{rid});
	}
	
	
	/**
	 * 查询出rid的角色
	 * @param rid
	 * @return
	 */
	public Role showRoleRid(int rid){
		
		String sql = "select * from role where rid=?";
		List<Object[]> roleList = DButil.executeQurry(sql, new Object[]{rid});
		Role role = null;
			Object[] o = roleList.get(0);
				role = new Role((Integer)o[0], String.valueOf(o[1]));
		return role;
	}
	/**
	 * 修改角色权限
	 */
	public void delectRoleMenu(int rid, String[] mids) {
		String sql ="delete from rolemenu where rid=?";
		DButil.executeDML(sql, new Object[]{rid});
		
		sql = "insert into rolemenu (rid,mid) values(?,?)";
		for(String s:mids){
			DButil.executeDML(sql, new Object[]{rid,s});
		}
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public User showUsers(){
		String sql ="select * from uu";
		List<Object[]> objectList = DButil.executeQurry(sql, null);
		User user = null;
		for(Object[] o :objectList){
			user = new User((Integer)o[0], String.valueOf(o[1]),String.valueOf(o[2]),(String)(o[3]));
		}
		return user;
	}
	
	/**
	 * 查询出用户所拥有的角色
	 * @return
	 */
	public List<Object[]> showUserRoles(int sid){
		String sql = "select b.sid, b.mobile,(select 1 from uurole  br where  br.sid=b.sid and br.rid=?) from uu b;";
		
		return DButil.executeQurry(sql, new Object[]{sid});
	}
	
	/**
	 * 修改用户角色
	 * @param name
	 * @param rids
	 */
	public void updateUserRoles(String rid,String[] uids){
		
		String sql ="delete from uurole where rid=?";
		DButil.executeDML(sql, new Object[]{rid});
		sql = "insert into uurole(sid,rid) values(?,?)";
		for(String s:uids){
			DButil.executeDML(sql, new Object[]{s,rid});
		}
	}
	
	/**
	 * 检查过滤用户菜单
	 * @param sid
	 * @param mid
	 * @return
	 */
	public boolean chekedUserMenu(String url,int sid){
		String sql = "select 1 from uurole ur,rolemenu rm,menu m where" +
				" ur.rid=rm.rid and rm.mid = m.mid and ur.sid=? and m.url like '%"+url+"%'";
		List<Object[]> list = DButil.executeQurry(sql, new Object[]{sid});
		if(null!=list&&list.size()>0){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	public void addmenu(int mid, String name, String url, int isshow,
			int level, int parentid) {
		// TODO Auto-generated method stub
		
	}
	public List<MenuVo> loadAllMenuVo() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Menu> loadMenuBy(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
