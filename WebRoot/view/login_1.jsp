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

<link rel="stylesheet" href="css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/loginMy.css"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js" ></script>

<style>
    html,body{width:100%;}
</style>
    <script type="text/javascript">
	    function login(){
	        /*//创建对象
	        var xmlHttpRequest;
	        //判断浏览器版本
	        var un=document.getElementById("user").Value;
	        var up=document.getElementById("pwd").Value;
	        if(window.ActiveXObject){//IE
	            xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	        }else if(window.XMLHttpRequest){//DOM
	            xmlHttpRequest=new XMLHttpRequest();
	        }
	        //绑定回调函数
	        xmlHttpRequest.onreadystatechange=function(){
	        //0未初始化,1正在加载,2加载,3交互中,4完成
	            if(xmlHttpRequest.readyState==4){
	        //200成功，404找不到路径
	                if(xmlHttpRequest.status==200){
	                    var t=xmlHttpRequest.responseText;
	                    if(t==1){
	                        window.location.href="view/welcom.jsp";
	                    }else if(t==2){
	                        Document.getElementById("Error1").innerHTML="密码错误";
	                    }else{
	                        Document.getElementById("Error2").innerHTML="用户不存在";
	                    }
	                }
	            }
	        }
	        //打开连接
	        xmlHttpRequest.open("post","login.do?methodName=login&mobile="+user+"&passwd="+pwd,true);
	        //发送请求
	        xmlHttpRequest.send(null);*/
	    
		    $.post('login.do',{
		        methodName:'login',
		        mobile:$('#user').val,
		        passwd:$('#pwd').val,
		    },function(data){
		        if(t==1){
	                window.location.href="view/welcom.jsp";
	            }else if(t==2){
	                $("Error1").html("密码错误");
	            }else{
	                $("Error2").html("用户不存在");
	            }
		    });
	    }
	</script>
  </head>
  <body>
	<div class="main">
		<div class="center">
			<form action="login.do" id="formOne" method="post"onsubmit="return submitB()" >
				<i class="fa fa-user Cone">  | </i>
				<input type="hidden" name="methodName" value="login"/>
				<input type="text" name="mobile" id="user" placeholder="用户名"onblur="checkUser()"/>
				     <p style="margin-top: 30px;
				     margin-left: 170px;font-size:15px;color: red;"id="Error2"> ${Error1} ${Error2}</p>   
				<span id="user_pass"></span>
				<br/>
				<i class="fa fa-key Cone">  | </i>
				<input type="password" name="passwd" id="pwd" placeholder="密码"onblur="checkUser1()"/>
				<span id="pwd_pass"></span>
				<p style="margin-top: 30px;
				     margin-left: 170px;font-size:15px;color: red; "id="Error1"></p>
				<br/>
				
				<span id="surePwd_pass" ></span><br/>
				<!--<input type="submit" value="登录" id="submit" name="submit">  -->
				<a href="javascript:login();" id="submit" name="submit">登录</a>
				
				<p><a href="zhuce.jsp" style="font-size: 20px; margin-left: 200px; margin-top: 20px;">立即注册</a></p>
				<br/>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/loginMy.js"></script>
  </body>
</html>
