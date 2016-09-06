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
    
    <title>My JSP 'updateUserRole.jsp' starting page</title>
    
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
      <h1>${userRole}</h1>
        <form action="updateUserRoles.do" method="post" >
  	  	<input type="hidden" name="methodName" value="updateUserRoles" />
  	  	<input type="hidden" name="rid" value="${role.rid}" />
	    <fmt:formatDate value="${data}" pattern="yyyy-MM-dd HH:mm:ss "/>
	      <p>角色名称：${role.rname} ，编辑人物角色</p>
	      <table border="0" bgcolor="" cellpadding="0" cellspacing="0" class="table_top">
  	  	  	  <c:forEach items="${userRoleList}" var="u">
  	  	  	  	  <input type="checkbox" name="uids" value="${u[0]}"  <c:if test="${u[2]==1}">checked</c:if> />${u[1]}<br/>
  	  	  	  </c:forEach>
  	  	  </table> 
  	  	   <input type="submit"  value="确认修改"  />
	  </form>
  </body>
</html>
