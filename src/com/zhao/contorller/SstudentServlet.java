package com.zhao.contorller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.Student;
import com.zhao.entity.User;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.*;

public class SstudentServlet extends HttpServlet{
	
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
		System.out.println(mobile);
		
		List<Student> studentList=userModel.loadAllStudent();

			req.setAttribute("student", studentList);
			req.setAttribute("date", new Date());
		    req.getRequestDispatcher("view/Sstudent.jsp").forward(req, resp);
	}
}
