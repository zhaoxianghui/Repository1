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
    
    <title>My JSP 'updateRoleMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
      <h1>${userRoleList}</h1>
        <form action="delectRoleMenu.do" method="post" >
  	  	<input type="hidden" name="methodName" value="delectRoleMenu" />
  	  	<input type="hidden" name="rid" value="${role.rid}" />
	    <fmt:formatDate value="${data}" pattern="yyyy-MM-dd HH:mm:ss "/>
	      <p>角色名称：${role.rname} ，编辑人物权限</p>
	      <table border="0" bgcolor="" cellpadding="0" cellspacing="0" class="table_top">
  	  	  	  <c:forEach items="${show}" var="a">
  	  	  	  	  <input type="checkbox" name="mids" value="${a[0]}"  <c:if test="${a[3]==1}">checked</c:if> />${a[1]}<br/>
  	  	  	  </c:forEach>
  	  	  </table> 
  	  	   <input type="submit"  value="确认修改" />
	  </form>  
  </body>
</html>
