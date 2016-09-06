package com.zhao.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zhao.dao.UserDao;
import com.zhao.dao.impl.UserDaoImpl;
import com.zhao.entity.User;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.*;

public class LoginServlet extends HttpServlet{
	
	private UserModel userModel=new UserModelImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String mobile=req.getParameter("mobile");
		String passwd=req.getParameter("passwd");
		System.out.println(mobile);
		
		System.out.println("contorller控制层");
		User user =userModel.loadUserByMobile(mobile);
		if(null!=user){
			if(passwd.equals(user.getPasswd())){
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
}
