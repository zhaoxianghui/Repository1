<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Sstudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h4>${Error5}</h4>
    <p>
      <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
      </p>
      <table border="1" width=550px; bordercolor="blue" cellpadding="0">
          <tr>
              <td>学生编号</td>
              <td>学生</td>
              <td>时间</td>
              <td>班级编号</td>
              <td>操作</td>
              
          </tr>
          <c:forEach items="${student}" var="s">
          <tr>
               <td>${s.sid}</td>
               <td>${s.mobile}</td>
               <td>${s.times}</td>
               <td>${s.cid}</td>
               <td>
                   <a href='see.do?sid=${s.sid}'>查看</a> &nbsp;&nbsp;
                   <a href='delete.do?sid=${s.sid}'>删除</a>&nbsp;&nbsp;
                   <a href='xiugai.do?sid=${s.sid}'>修改</a>
               </td>
          </tr>
          </c:forEach>
  </body>
</html>
