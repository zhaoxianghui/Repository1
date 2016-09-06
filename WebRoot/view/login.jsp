<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js" ></script>
<link rel="stylesheet" href="css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/loginMy.css"/>
<script type="text/javascript">
	   /* function login(){
		    $.post('login.do',{
		        methodName:'login',
		        mobile:$('#user').val,
		        passwd:$('#pwd').val,
		    },function(data){
		        if(t==1){
	                window.location.href="view/welcom.jsp";
	            }else if(t==2){
	                $("#Error1").html("密码错误");
	            }else{
	                $("#Error2").html("用户不存在");
	            }
		    });
	    }*/
	</script>
<style>
    html,body{width:100%;}
</style>
  </head>
  <body>
      
<div class="main">
	<div class="center">
		<form action="login.do" id="formOne" method="post"onsubmit="return submitB()" >
			<i class="fa fa-user Cone">  | </i>
			<input type="hidden" name="methodName" value="login"/>
			<input type="text" name="mobile" id="user" placeholder="用户名"onblur="checkUser()"/>
			     <p style="margin-top: 30px;
			     margin-left: 170px;font-size:15px;color: red; " id="Error2">${Error2}</p> 
			<span id="user_pass"></span>
			<br/>
			<i class="fa fa-key Cone">  | </i>
			<input type="password" name="passwd" id="pwd" placeholder="密码"onblur="checkUser1()"/>
			<span id="pwd_pass"></span>
			<p style="margin-top: 30px;
			     margin-left: 170px;font-size:15px;color: red; " id="Error1"> ${Error1}</p>
			<br/>
			
			
			<span id="surePwd_pass" ></span><br/>
			<input type="submit" value="登录" id="submit" name="submit">
			<!--<a href="javascript:login();" id="submit" name="submit">登录</a>  -->
				
			<p><a href="zhuce.jsp" style="font-size: 20px; margin-left: 200px; margin-top: 20px;">立即注册</a></p>
			<br/>
		</form>
	</div>
</div>


<script type="text/javascript" src="js/loginMy.js"></script>
<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
  </body>
</html>
