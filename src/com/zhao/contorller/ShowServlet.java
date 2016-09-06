package com.zhao.contorller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.User;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.*;

public class ShowServlet extends HttpServlet {
	
	private UserModel userModel=new UserModelImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		//User user=(User)Session.req.getAttribute("logil");
//		String sql="select * from uu";
//		List<Object[]> list =DButil.executeQurry(sql,null);
		List<User> userList=userModel.loadAllUser();
		
		req.setAttribute("userList", userList);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/Show.jsp").forward(req, resp);
		
		
		
		
	} 

}
