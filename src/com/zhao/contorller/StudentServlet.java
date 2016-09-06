package com.zhao.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.*;

public class StudentServlet extends HttpServlet {
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
		String times=req.getParameter("times");
		String cid=req.getParameter("cid");
		
		String sql2="insert into studend(mobile,times,cid) values(?,?,?)";
	    DButil.executeDML(sql2, new Object[]{mobile,times,cid});
	    req.getRequestDispatcher("view/student.jsp").forward(req, resp);
//	    req.getSession().setAttribute("login", "添加成功");
		}
}
		
