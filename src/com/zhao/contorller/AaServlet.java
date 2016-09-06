package com.zhao.contorller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String fileName="view/学习记录一到四章java(1).txt";
		String realPath=this.getServletContext().getRealPath("/")+fileName;
		File f=new File(realPath);
		
		Enumeration<String> es=req.getHeaders("User-Agent");
		fileName =es.nextElement().contains("Firefox")?
				new  String(f.getName().getBytes("utf-8"),"iso-8859-1"):
					URLEncoder.encode(f.getName(),"utf-8");
	    
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("Application/octet-stream");
		resp.setHeader("content-Disposition","attachment;"+
				"filename="+fileName);
		
		resp.setHeader("content-Location", fileName);
		resp.setHeader("content-Length", f.length()+"");
		
		InputStream in=new FileInputStream(f);
		OutputStream out=resp.getOutputStream();
		byte[] bs=new byte[1024*1024];
		int i;
		while((i=in.read(bs))!=-1){
			out.write(bs,0,i);
		}
		out.flush();
		out.close();
		in.close();
		
	}
	

}
