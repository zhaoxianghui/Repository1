<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My dreams!</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.9.1.min.js" ></script>
	<script type="text/javascript">
	    $(function(){
	        /*  (一)
	        //创建对象  AJAX编程
	        var xmlHttpRequest;
	        //判断浏览器版本
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
	                    alert("ajax来了！！！！！！！！");
	                }
	            }
	        }
	        //打开连接
	        xmlHttpRequest.open("post","ajax.do?methodName=ajax",true);
	        //发送请求
	        xmlHttpRequest.send(null);
	        */
	        
	        /* （二）
	        $(".c").click(function(){
          		$.ajax({
          		    type:'post',
          		    url :'ajax.do?methodName=ajax',
          		    dataType:'text',
          		    success:function(url){
          		        alert(url);
          		    }
          		});
          	});*/
          	
          	/* (三)
          	$.get('ajax.do',{methodName:'ajax'},function(data){
          	    alert(data);
          	},"text");*/
          	
          	/* (四)
          	$.getJSON('ajax.do',{methodName:'ajax'},function(data){
          	    alert(data.Motto);
          	});*/
          	// (五)
          	$.post('ajax.do',{methodName:'ajax'},function(data){
          	    var d=eval("("+data+")");//将JSON格式字符串转换为JSON对象
          	    alert(d.Motto);
          	},"text");
          	$.post('ajax.do',{methodName:'ajax'},function(data){
          	    alert(data.Motto);
          	},"json");
          	
	    });
	    
	 </script>
  </head>
  <body>
      <span class="c">测试</span>
      
  </body>
</html>
