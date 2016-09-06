package com.zhao.contorller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.Classs;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.*;

public class AclassServlet extends HttpServlet{
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
		String cname=req.getParameter("cname");
		System.out.println(cname);
		
		List<Classs> classlist=userModel.loadAllClass();
		req.setAttribute("aclass", classlist);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/aclass.jsp").forward(req, resp);
	} 
}
