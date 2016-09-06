package com.zho.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.*;
import com.zhao.model.UserModel;
import com.zhao.model.impl.UserModelImpl;

public class LoginFilter implements Filter{

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg0.setCharacterEncoding("utf-8");
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		String methodName=arg0.getParameter("methodName");
		if(methodName.equals("login")||methodName.equals("zhuce")||methodName.equals("logout")){
			arg2.doFilter(request,response);
		}else{
			User user=(User)request.getSession().getAttribute("login");
			if(null!=user){
				String url=request.getServletPath();
				url=url.substring(1);
				System.out.println(url+"===============");
				UserModel userModel=new UserModelImpl();
				boolean b=userModel.chekedUserMenu(url,user.getSid());
				if(b){
					arg2.doFilter(request,response);
				}else{
					request.getSession().setAttribute("cheked","您没有访问该内容的权限");
					request.getRequestDispatcher("view/chekedUserMenu.jsp").forward(request, response);
				}
				
			}else{
				request.getSession().setAttribute("logins","请先登录");
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
				PrintWriter out=response.getWriter();
				out.write("<script type='text/javascript'>window.top.location.href='"+
						basePath+"login.jsp'</script>");
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
