<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
        #l{
            font-size: 20px;
            color:gray;
            margin-left: 100px
        }
        #f{
            width:500px;
            height:280px;
            margin-left: 300px;
            margin-top: 120px;
        }
        #i{
            margin-left: 140px;
            margin-top: 20px;
        }
    </style>
  </head>
      
  <body>
  <form action="student" method="post">
  <fieldset id="f">
      <legend id="l">学生管理系统</legend>
    <div id="i">
        <input type="hidden" name="methodName" value="addstudent">
		<input type="text" name="mobile" placeholder="请输入名称"  
		maxlength="11" style="padding-top: 16px;width: 200px;font-size: 17px; "/></br> 
		
		<input type="text" name="times" placeholder="请输入时间" 
		 maxlength="11" style="padding-top: 16px;margin-top: 25px;width: 200px;font-size: 17px;"/></br> 
		 
		<input type="text" name="cid" placeholder="请输入班级编号"  
		maxlength="11" style="padding-top: 16px;margin-top: 25px;width: 200px;font-size: 17px;"/> </br> 
	 
	     <input type="submit" value="提交" style="margin-top: 10px;margin-left: 15px;font-size: 18px;"/>
	     <input type="reset" value="重置" style="margin-top: 10px;margin-left: 42px;font-size: 18px;"/>
	     
	 </div>
	 </fieldset>
	 </form>
  </body>
</html>
