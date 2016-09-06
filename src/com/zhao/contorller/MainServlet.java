package com.zhao.contorller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zhao.entity.Classs;
import com.zhao.entity.Menu;
import com.zhao.entity.MenuVo;
import com.zhao.entity.Page;
import com.zhao.entity.Role;
import com.zhao.entity.Student;
import com.zhao.entity.User;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.DButil;

public class MainServlet extends HttpServlet{
	//控制层持有模型层
	private UserModel userModel=new UserModelImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接受所有请求
		req.setCharacterEncoding("utf-8");
		String methodName=req.getParameter("methodName");
		Class c=MainServlet.class;
		Method m;
		try {
			m = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this,req,resp);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		String mobile=req.getParameter("mobile");
//		String passwd=req.getParameter("passwd");
//		System.out.println(mobile);
//		
//		System.out.println("contorller控制层");
//		User user = userModel.loadUserByMobile(mobile);
//		int reslut=1;
//		if(null!=user){
//			if(passwd.equals(user.getPasswd())){
//				List<Menu> menulist = userModel.loadMenu(user.getSid());
//				req.setAttribute("menulist", menulist);
//				//登录成功，保存数据
//				req.getSession().setAttribute("login", user);
//				reslut=1;
//			}else{
//				reslut=2;
//			}
//		}else{
//			reslut=3;
//		}
//		resp.setCharacterEncoding("utf-8");
//		resp.getWriter().write(reslut+"");
//		resp.getWriter().flush();
	
		req.setCharacterEncoding("utf-8");
		String mobile=req.getParameter("mobile");
		String passwd=req.getParameter("passwd");
		System.out.println(mobile);
		
		System.out.println("contorller控制层");
		User user = userModel.loadUserByMobile(mobile);
		if(null!=user){
			if(passwd.equals(user.getPasswd())){
				List<Menu> menulist = userModel.loadMenu(user.getSid());
				req.setAttribute("menulist", menulist);
				//登录成功，保存数据
				req.getSession().setAttribute("login", user);
				req.getRequestDispatcher("view/welcom.jsp").forward(req, resp);
		
			}else{
				//this.getServletContext().setAttribute("login", user);
				req.setAttribute("Error1", "密码错误");
				req.getRequestDispatcher("view/login.jsp").forward(req, resp);
			}
		}else{
			this.getServletContext().setAttribute("Error2", "账号不存在");
			req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		}
	}
	
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void zhuce(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String mobile=req.getParameter("mobile");
		String passwd=req.getParameter("passwd");
		String code=req.getParameter("code");
		String sid=req.getParameter("mid");
		System.out.println(code);
		
		userModel.zhuce(mobile,passwd,code);
		this.addzhuce(req, resp);
//		this.getServletContext().setAttribute("Error", "账号已存在，请重新注册或登录");
//		req.getRequestDispatcher("view/zhuCe.jsp").forward(req, resp);
		//req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		 
//		if(userList.size()>0){
//			this.getServletContext().setAttribute("Error", "账号已存在，请重新注册或登录");
//			req.getRequestDispatcher("view/zhuCe.jsp").forward(req, resp);
//		}else{
//		    String sql2="insert into uu(mobile,passwd,code) values(?,?,?)";
//		    DButil.executeDML(sql2, new Object[]{mobile,passwd,code});
//		    req.getRequestDispatcher("view/login.jsp").forward(req, resp);
//		}
	}
	/**
	 * 链接到用户页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addzhuce(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		List<User> zhuCe = userModel.showUser();
		req.setAttribute("zhuCe", zhuCe);
		req.getRequestDispatcher("view/zhuCe.jsp").forward(req, resp);

		
	}
	
	/**
	 * 查询显示用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUser(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		System.out.println("dfszhde");
		//User user=(User)Session.req.getAttribute("logil");
		List<User> userList=userModel.loadAllUser();
		
		req.setAttribute("userList", userList);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/Show.jsp").forward(req, resp);
	}
	
	/**
	 * 查询显示个人用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void seeUser(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		System.out.println("d165789/841");
		req.setCharacterEncoding("utf-8");
		String sid=req.getParameter("sid");
		System.out.println(sid);
		
//		String sql="select * from uu where sid=?";
//		List<Object[]> list =DButil.executeQurry(sql,new Object[]{Integer.valueOf(sid)});
//		Object[] os=list.get(0);
//		User user=new User((Integer)os[0],(String)os[1],String.valueOf(os[2]),String.valueOf(os[3]));	
		List<User> userList=userModel.loadSelfUser(sid);
		req.setAttribute("user", userList);
		req.getRequestDispatcher("see.jsp").forward(req, resp);
	}
	
	
	
	/**
	 * 查询显示班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void aclass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("186789841681");
		req.setCharacterEncoding("utf-8");
//		String cname=req.getParameter("cname");
//		System.out.println(cname);
		
		List<Classs> classlist=userModel.loadAllClass();
		req.setAttribute("aclass", classlist);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/aclass.jsp").forward(req, resp);
		
	}
	
	/**
	 * 注册添加班级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addclass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}
	
	/**
	 * 查询显示学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sstudent(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		System.out.println("szDgrfbhsfd925654");
		
		List<Student> studentList=userModel.loadAllStudent();
		req.setAttribute("student", studentList);
		req.setAttribute("date", new Date());
	    req.getRequestDispatcher("view/Sstudent.jsp").forward(req, resp);
	}
	
	/**
	 * 注册添加学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addstudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}
	
	/**
	 * 文件下载
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void xiazai(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String fileName="view/学习记录一到四章java(1).txt";
		String realPath=this.getServletContext().getRealPath("/")+fileName;
		File f=new File(realPath);
		
		Enumeration<String> es=req.getHeaders("User-Agent");
		fileName =es.nextElement().contains("Firefox")?
				new  String(f.getName().getBytes("utf-8"),"iso-8859-1"):
					URLEncoder.encode(f.getName(),"utf-8");
	    
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("Application/octet-stream");
		resp.setHeader("content-Disposition","attachment;"+
				"filename="+fileName);
		
		resp.setHeader("content-Location", fileName);
		resp.setHeader("content-Length", f.length()+"");
		
		InputStream in=new FileInputStream(f);
		OutputStream out=resp.getOutputStream();
		byte[] bs=new byte[1024*1024];
		int i;
		while((i=in.read(bs))!=-1){
			out.write(bs,0,i);
		}
		out.flush();
		out.close();
		in.close();
	}
	
	/**
	 * 退出登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		req.getSession().invalidate();
		req.getRequestDispatcher("view/login.jsp").forward(req, resp);
	}
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void menu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		System.out.println("===================================");
		List<MenuVo> menuList=userModel.loadAllMenuVo();
		req.setAttribute("menuList", menuList);
		req.setAttribute("date", new Date());
	    req.getRequestDispatcher("view/menuVo.jsp").forward(req, resp);
//		req.setAttribute("menuList", menuList);
//		req.setAttribute("date", new Date());
//	    req.getRequestDispatcher("view/menuVo.jsp").forward(req, resp);
	}
	
	/**
	 * 链接到菜单页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void lianJieByMenu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		List<Menu> listmenus = userModel.showMenus();
		
		listmenus.add(0,new Menu(-1,"请选择父类"));
		String json = JSONArray.fromObject(listmenus).toString();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
//		req.setAttribute("listmenus", listmenus);
//		req.getRequestDispatcher("view/addmenu.jsp").forward(req, resp);

		
	}
	/**
	 * 添加菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addmenus(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String url=req.getParameter("url");
		String isshow=req.getParameter("isshow");
		String parentid=req.getParameter("parentid");
		
		userModel.insertMenu(name, url,Integer.valueOf(isshow),Integer.valueOf(parentid));
	    this.showMenu(req, resp);
	}
	
	
	/**
	 * 查询菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		int pageNo=Integer.valueOf(req.getParameter("pageNo"));
		int pageSize=Integer.valueOf(req.getParameter("pageSize"));
		Page<MenuVo> page=userModel.showMenu(pageNo,pageSize);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", page.getDataList());
		map.put("total", page.getTotal());
		
		String json = JSONObject.fromObject(map).toString();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
//		List<MenuVo> menuvoList = userModel.showMenu();
//		req.setAttribute("MenuList", menuvoList);
		
//		req.getRequestDispatcher("view/menuVo.jsp").forward(req, resp);
	}
	/**
	 * 查看角色
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showroel(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		List<Role> rolelist=userModel.showRole();
		req.setAttribute("rolelist", rolelist);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/role.jsp").forward(req, resp);
	}
	
	/**
	 * 查询出用户所拥有的权限返回   Jurisdiction
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateRoleMenu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String rid = req.getParameter("rid");
		
		List<Object[]>  objectList = userModel.showRolemenu(Integer.valueOf(rid));
		req.setAttribute("show", objectList);
		Role role = userModel.showRoleRid(Integer.valueOf(rid));
		
		req.setAttribute("role", role);
		req.getRequestDispatcher("view/updateRoleMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 修改角色权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void delectRoleMenu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String rid = req.getParameter("rid");
		String[] mids = req.getParameterValues("mids");
		
		userModel.delectRoleMenu(Integer.valueOf(rid), mids);
		req.setAttribute("userRoleList", "修改用户权限成功");
		this.updateRoleMenu(req, resp);
	}
	
	/**
	 * 修改用户角色
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserRole(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String rid = req.getParameter("rid");
		
		Role role = userModel.showRoleRid(Integer.valueOf(rid));
		req.setAttribute("role", role);
		//返回一个角色集合
		List<Object[]> objectList = userModel.showUserRoles(Integer.valueOf(rid));
		
		req.setAttribute("userRoleList", objectList);
		req.getRequestDispatcher("view/updateUserRole.jsp").forward(req, resp);
	}
	/**
	 * 修改角色
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserRoles(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String rid = req.getParameter("rid");
		String[] bids = req.getParameterValues("uids");
		
		userModel.updateUserRoles(rid, bids);
		req.setAttribute("userRole", "修改角色成功");
		this.updateUserRole(req, resp);
	}
	
	/**
	 * AJAX 测试
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ajax(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException{
		System.out.println("AJAX测试来了。。。。。");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("{\"name\":\"赵翔\",\"Motto\":\"" +
				"If we dream,everthing is possible!\"}");
		resp.getWriter().flush();
		
	}

	
}
