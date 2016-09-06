package com.zhao.model.impl;

import java.util.List;

import com.zhao.dao.UserDao;
import com.zhao.dao.impl.UserDaoImpl;

import com.zhao.entity.Menu;
import com.zhao.entity.MenuVo;
import com.zhao.entity.Page;
import com.zhao.entity.Role;
import com.zhao.entity.Student;
import com.zhao.entity.User;
import com.zhao.entity.Classs;
import com.zhao.model.UserModel;

public class UserModelImpl implements UserModel{
	
	private UserDao userDao=new UserDaoImpl();
	
	
	/**
	 * 通过用户加载一个用户对象（登录）
	 * @param mobile 用户输入的账号
	 * @return 返回NULL 表示账号不存在
	 */
	public User loadUserByMobile(String mobile) {
        System.out.println("UserModelIpml模型层");
		return userDao.loadUserByMobile(mobile);
	}
	
	/**
	 * 注册
	 * @param mobile
	 * @return
	 */
	public void zhuce(String mobile,String passwd,String code){
		userDao.zhuce(mobile,passwd,code);
	}
	
	
	/**
	 * 链接到用户页面
	 * @return
	 */
	public List<User> showUser(){
		return userDao.showUser();
	}
	
	/**
	 * 加载所有用户
	 * @return
	 */
	public List<User> loadAllUser(){
		return userDao.loadAllUser();
	}
	
	/**
	 * 加载所个人用户
	 * @return
	 */
	public List<User> loadSelfUser(String sid){
		return userDao.loadSelfUser(sid);
	}
	
	/**
	 * 加载所有学生
	 * @return
	 */
	public List<Student> loadAllStudent(){
		return userDao.loadAllStudent();
	}
	
	/**
	 * 加载所有班级
	 * @return
	 */
	public List<Classs> loadAllClass(){
		return userDao.loadAllClass();
	}
	
	/**
	 * 权限管理
	 */
	public List<Menu> loadMenu(int sid){
		return userDao.loadMenu(sid);
	}
	/**
	 * 展示菜单
	 * @return
	 */
	public List<MenuVo> loadAllMenuVo(){
		return userDao.loadAllMenuVo();
	}
	
	/**
	 * 通过主键ID
	 * @param mid
	 * @return
	 */
	public List<Menu> loadMenuBy(int mid){
		return userDao.loadMenuBy(mid);
	}
	/**
	 * 添加菜单
	 * @param mid
	 * @param name
	 * @param url
	 * @param isshow
	 * @param level
	 * @param parentid
	 */
	public void addmenu(int mid,String name,String url,int isshow,int level,int parentid){
		
	}
	
	/**展示菜单
	 * 
	 * @return
	 */
	public Page<MenuVo> showMenu(int pageNo,int pageSize){
		
		return userDao.showMenu(pageNo,pageSize);
	}
	
	/**
	 *查询一二级菜单
	 * @return
	 */
	public List<Menu> showMenus(){
		return userDao.showMenus();
	}
	
	/**
	 * 添加菜单
	 */
	public void insertMenu(String name,String url,int isshow,int parentid){
		userDao.insertMenu(name, url, isshow, parentid);
	}
	
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> showRole(){
		return userDao.showRole();
	}
	
	/**
	 * 查询菜单和角色拥有的菜单
	 */
	public List<Object[]> showRolemenu(int rid){
		return userDao.showRolemenu(rid);	
	}
	
	/**
	 * 查询出rid的角色
	 * @param rid
	 * @return
	 */
	public Role showRoleRid(int rid){
		return userDao.showRoleRid(rid);
	}

	
	/**
	 * 修改用户权限
	 */
	public void delectRoleMenu(int rid, String[] mids){
		userDao.delectRoleMenu(rid, mids);
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public User showUsers(){
		return userDao.showUsers();
	}
	
	
	
	/**
	 * 查询出用户所拥有的角色
	 * @return
	 */
	public List<Object[]> showUserRoles(int sid){
		return userDao.showUserRoles(sid);
	}
	
	/**
	 * 修改用户角色
	 * @param name
	 * @param rids
	 */
	public void updateUserRoles(String rid,String[] uids){
		userDao.updateUserRoles(rid, uids);
	}
	
	/**
	 * 检查过滤用户菜单
	 * @param sid
	 * @param mid
	 * @return
	 */
	public boolean chekedUserMenu(String url,int sid){
	    return userDao.chekedUserMenu(url,sid);
	}
}
