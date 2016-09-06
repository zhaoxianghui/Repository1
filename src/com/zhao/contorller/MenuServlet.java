package com.zhao.contorller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.Classs;
import com.zhao.entity.Menu;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;

public class MenuServlet extends HttpServlet {
	private UserModel userModel=new UserModelImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Menu> menulist=userModel.loadMenu(sid);
		req.setAttribute("menulist", menulist);
		req.getRequestDispatcher("view/welcom.jsp").forward(req, resp);	
	}
}