package com.zhao.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.util.*;

public class XiugaiServlet extends HttpServlet{
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
		
		String sql="update uu set sid=2 where sid=?";
		DButil.executeDML(sql,new Object[]{Integer.valueOf(sid)});
		req.setAttribute("Error4", "修改成功");
		req.getRequestDispatcher("Show").forward(req, resp);
		
//		List<Object[]> list =DBuilt.executeQurry(sql,new Object[]{Integer.valueOf(sid)});
//		Object[] os=list.get(0);
//		User user=new User((Integer)os[0],(String)os[1],String.valueOf(os[2]),String.valueOf(os[3]));	
//		req.setAttribute("user", user);
//		req.getRequestDispatcher("xiugai.jsp").forward(req, resp);
		
	}

}
