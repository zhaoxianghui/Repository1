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
    
    <title>My JSP 'role.jsp' starting page</title>
    
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
       <h1>角色列表</h1>
      <p>${Error3}</p>
      <p>
      <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
      </p>
      <table border="1" width=550px; bordercolor="blue" cellpadding="0">
          <tr>
              <td>角色编号</td>
              <td>名称</td>
              <td>操作</td>
          </tr>
          <c:forEach items="${rolelist}" var="r">
          <tr>
               <td>${r.rid}</td>
               <td>${r.rname}</td>
          
               <td>
	               <a href="updateUserRole.do?methodName=updateUserRole&rid=${r.rid}">修改用户角色</a>
	               <a href="updateUserQx.do?methodName=updateRoleMenu&rid=${r.rid}">修改用户权限</a>
               </td>
          </tr>
          </c:forEach>
      </table>
  </body>
</html>
