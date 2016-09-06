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

public class ZhuceServlet extends HttpServlet{
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
		String code=req.getParameter("code");
		System.out.println(code);
//		String [] sh = req.getParameterValues("states");
//		String hoppay = "";
//		for(String s : sh){
//			hoppay += s+",";
//		}
//		if(hoppay.endsWith(",")){
//			hoppay = hoppay.substring(0,hoppay.length() - 1);
//		}
		
//		String sql="select * from uu where mobile=? and passwd=?";
//		List<Object[]> list =DButil.executeQurry(sql,new Object[]{mobile,passwd});
		List<User> userList=userModel.zhuce(mobile);
		if(userList.size()>0){
			this.getServletContext().setAttribute("Error", "账号已存在，请重新注册或登录");
			req.getRequestDispatcher("view/zhuCe.jsp").forward(req, resp);
		}else{
		    String sql2="insert into uu(mobile,passwd,code) values(?,?,?)";
		    DButil.executeDML(sql2, new Object[]{mobile,passwd,code});
		    req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		}
	}
}