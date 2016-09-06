<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'class.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	    #f{
	        width: 450px;
	        height: 210px;
	        margin-left: 200px;
	        margin-top: 120px;
	    }
	    #c{
	        margin-left: 100px;
	        margin-top: 50px;
	    }
	    #i:HOVER{
	        color: blue;
	        margin-top: 30px;
	    }
	</style>
  </head>
  
  <body>
  <form action="class" method="post">
      <fieldset id="f">
          <legend style="color: red;margin-left: 80px;font-size: 25px;">班级管理系统</legend>
		 <div id="c">
		     <input type="hidden" name="methodName" value="addclass">
			 <input type="text" name="cname" placeholder="请输入班级" 
			 style="width: 200px;height: 30px;"  maxlength="11"/> </br>
		     <div id="i">
		     <input type="submit" value="提交" style="margin-top: 10px;margin-left: 15px;"> &nbsp;&nbsp;
		     <input type="reset" value="重置" style="margin-left: 10px;"/>
		     </div>
		 </div>
	 </fieldset>
	 </form>
  </body>
</html>
