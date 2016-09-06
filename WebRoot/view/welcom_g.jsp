<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎，${login.mobile}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		h4{
			margin-left: 100px;
			margin-top:35px;
			font-size: 30px;
			color:blue;
			letter-spacing: 5px;
		}
		h5{
			margin-left: 400px;
			margin-top:-30px;
			font-size: 30px;
			color:green;
			letter-spacing: 5px;
		}
	    body{
	        margin: 0;
	        background-color:white;
	        
	    }
	    #top{
	        height: 100px;
	        margin: 0;
	        background-color:aqua;
	        border-right: 2px solid orange; 
	    }
	    #center{
	        width: 1360px;
	        height: 800px;
	        float: left;
	        background-color:green;
	    }
	    a{
	    display: block;
	    font-size: 20px;
	    }
	    #left{
	        text-decoration: none;
	        width:200px;
	        background-color:gray;
	        font-family: serif;
	        font-size: 15px;
	        font-weight: bold;
	        padding-left: 16px;
	        margin-top: 5px;
	        float: left;
	        display: block;
	    }
	    #left a:hover {
	        text-decoration: underline;
	        background-color: maroon;
	        color: blue;  
        }
        #iframe{
            width: 500px;
            height: 400px;
            
        }
  </style>

  </head>
  <body>
      <div id="top">
          <h4>If we dream,everthing is possible!<a href="logout.do?methodName=logout">退出</a></h4>
          <h5 style="margin-top:-45px;">欢迎你,${login.mobile}</h5>
      </div>
          <div id="left">
              <ul>
                  <c:forEach items="${menulist}" var="m2">
                      <c:if test="${m2.level==2}">
                      	  <li>
		                      <span>${m2.name}</span>
		                      <ul>
		                          <c:forEach items="${menulist}" var="m3">
		                              <c:if test="${m3.parentid==m2.mid}">
		                                  <li><a href="${m3.url}" target="center">${m3.name}</a></li>
		                              </c:if>
		                          </c:forEach>
		                      </ul>
		                  </li>
                      </c:if>
                  </c:forEach>
              </ul>
          
            
          <a href="SStudent.do?methodName=sstudent" target="center">学生列表</a>
          <a href="class.do?methodName=aclass" target="center">班级列表</a>
          <a href="bb.do?methodName=xiazai" target="center">文件下载</a>
          </div>
          <div id="center">
              <iframe name="center" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>
          </div> 
       
  </body>
</html>
