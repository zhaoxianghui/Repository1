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
    
    <title>welcom</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
      <h1>用户列表</h1>
      <p>${Error3}</p>
      <p>
      <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
      </p>
      <table border="1" width=550px; bordercolor="blue" cellpadding="0">
          <tr>
              <td>编号</td>
              <td>账号</td>
              
                                                           
              <td>验证码</td>
              <td>操作</td>
          </tr>
          <c:forEach items="${userList}" var="u">
          <tr>
               <td>${u.sid}</td>
               <td>${u.mobile}</td>
               <td>${u.code}</td>
               <td>
                   <a href='see.do?methodName=seeUser&sid=${u.sid}methodName=seeUser'>查看资料</a> &nbsp;&nbsp;
                   <a href='delete.do?methodName=deUser&sid=${u.sid}'>删除资料</a>&nbsp;&nbsp;
                   <a href='xiugai.do?sid=${u.sid}'>修改资料</a>
               </td>
          </tr>
          </c:forEach>
      </table>
  </body>
</html>
