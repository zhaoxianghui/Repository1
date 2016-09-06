package com.zhao.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.User;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;
import com.zhao.util.*;


public class SeeServlet extends HttpServlet {
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

}
