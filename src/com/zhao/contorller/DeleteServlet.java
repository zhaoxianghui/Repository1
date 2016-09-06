package com.zhao.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.util.*;

public class DeleteServlet extends HttpServlet {
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
		
		String sql="delete from uu where sid=?";
		DButil.executeDML(sql,new Object[]{Integer.valueOf(sid)});
		req.setAttribute("Error3", "删除成功");
		req.getRequestDispatcher("Show").forward(req, resp);
		
	}

}