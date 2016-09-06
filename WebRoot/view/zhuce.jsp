<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册 - 源码之家</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
      
  </head>
  <body>
      
      <div class="wrap">
	<div class="banner-show" id="js_ban_content">
		<div class="cell bns-01">
			<div class="con">
			</div>
		</div>
		<div class="cell bns-02" style="display:none;">
			<div class="con">
				<a href="http://www.mycodes.net/" target="_blank" class="banner-link">
				<i>圈子</i></a> </div>
		</div>
		<div class="cell bns-03" style="display:none;">
			<div class="con">
				<a href="http://www.mycodes.net/" target="_blank" class="banner-link">
				<i>企业云</i></a> </div>
		</div>
	</div>
	<div class="banner-control" id="js_ban_button_box">
		<a href="javascript:;" class="left">左</a>
		<a href="javascript:;" class="right">右</a>
	</div>
<script type="text/javascript">
;(function(){
	
	var defaultInd = 0;
	var list = $('#js_ban_content').children();
	var count = 0;
	var change = function(newInd, callback){
		if(count) return;
		count = 2;
		$(list[defaultInd]).fadeOut(400, function(){
			count--;
			if(count <= 0){
				if(start.timer) window.clearTimeout(start.timer);
				callback && callback();
			}
		});
		$(list[newInd]).fadeIn(400, function(){
			defaultInd = newInd;
			count--;
			if(count <= 0){
				if(start.timer) window.clearTimeout(start.timer);
				callback && callback();
			}
		});
	}
	
	var next = function(callback){
		var newInd = defaultInd + 1;
		if(newInd >= list.length){
			newInd = 0;
		}
		change(newInd, callback);
	}
	
	var start = function(){
		if(start.timer) window.clearTimeout(start.timer);
		start.timer = window.setTimeout(function(){
			next(function(){
				start();
			});
		}, 8000);
	}
	
	start();
	
	$('#js_ban_button_box').on('click', 'a', function(){
		var btn = $(this);
		if(btn.hasClass('right')){
			//next
			next(function(){
				start();
			});
		}
		else{
			//prev
			var newInd = defaultInd - 1;
			if(newInd < 0){
				newInd = list.length - 1;
			}
			change(newInd, function(){
				start();
			});
		}
		return false;
	});
	
})();
</script>

<script type="text/javascript">
var FancyForm=function(){
	return{
		inputs:".reg-form input",
		setup:function(){
			var a=this;bu
			this.inputs=$(this.inputs);
			a.inputs.each(function(){
				var c=$(this);
				a.checkVal(c)
			});
			a.inputs.live("keyup blur",function(){
				var c=$(this);
				a.checkVal(c);
			});
		},checkVal:function(a){
			a.val().length>0?a.parent("div").addClass("val"):a.parent("div").removeClass("val")
		}
	}
}();
</script>

	<div class="container">
		<div class="register-box">
			<div class="reg-slogan">新用户注册</div>
			<form action="zhuCe" method="post">
				<div class="reg-form" id="js-form-mobile">
					<br>
					<br>
					<div class="cell">
					    <input type="hidden" name="methodName" value="zhuce"/>
						<label for="js-mobile_ipt"></label>
						<input type="text" name="mobile" placeholder="请输入用户名" id="js-mobile_ipt" class="text" maxlength="11" 
						style="height: 35px;" />
					</div>
					<div class="cell">
						<label for="js-mail_pwd_ipt" style="pal" ></label>
						<input type="password" name="passwd" placeholder="请输入密码" id="js-mail_pwd_ipt" class="text" style="height: 35px;" />
						<input type="text" name="passwd" id="js-mail_pwd_ipt_txt" class="text" maxlength="20" style="display:none;height: 35px;" />
						<b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none">
						查看密码</b>
					 </div>
					
					<!-- !短信验证码 -->
					<div class="cell vcode">
						<label for="js-mail_vcode_ipt"></label>
						<input type="text" name="code" placeholder="填入验证码" id="js-mail_vcode_ipt" class="text" maxlength="4" style="height: 35px;" />
						<img id="js-mail_vcode_img" src="http://www.mycodes.net/" alt="code" />
						<span>
						<a id="js-mail_vcode_a" href="javascript:;" code_src="http://www.mycodes.net/">
						换一张</a></span> </div>
					<div class="user-agreement">
						<input type="checkbox" id="js-mail_chk" checked="true" />
						<label for="js-mail_chk">同意<a href="http://www.mycodes.net/" target="_blank">《源码之家用户服务协议》</a></label>
					</div>
					<div class="bottom">
						<input type="submit" value="立即注册" id="js-mail_btn" class="button btn-green"/>
						<p style="margin-top:10px;"><a href="view/login.jsp" class="button btn-green">登录</a></p>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
	FancyForm.setup();
});
</script>
<!-- 代码 结束 -->

  </body>
</html>
