<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
   <title>欢迎，${login.mobile}</title>
	    <base href="<%=basePath%>">
	    
	    <title>My JSP 'cc.jsp' starting page</title>
	    <!--border: 3px solid royalblue;
			border-radius:8px;
			padding: 3px;  -->
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>/jquery-easyui-1.3.3/themes/icon.css"/>
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>/jquery-easyui-1.3.3/themes/default/easyui.css"/>
  	    <script type="text/javascript">
  	        function show(title,url){
  	            $('#tab').tabs('add',{    
			    title:title,    
			    selected: true, 
			    content:"<iframe style='height:100%;width:100%;' src='"+url+"'></iframe>",
			    closable:true    
				});  
  	        }  
  	    </script>
  	    <style type="text/css">
  	        .c{
  	            font-size:30px;
  	            margin-left: 50px;
  	            margin-top: 6px;
  	            font-weight: bolder;
  	            font-style: italic;
  	            color: graytext;
  	            letter-spacing: 20px;
  	        }
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
  	    </style>
  	</head>
  	<body class="easyui-layout"> 
  	     
        <div data-options="region:'north',split:true" style="height:125px;background-color: #00FFFF;">
           <h4>If we dream,everthing is possible!<a href="logout.do?methodName=logout">退出</a></h4>
          <h5 style="margin-top:-45px;">欢迎你,${login.mobile}</h5>
        </div>
        <div data-options="region:'west',title:'网站管理系统',split:true" style="width:200px;">
	        
	        <div id="aa" class="easyui-accordion" style="width:300px;height:240px;">   
			    <%-- <div title="关于JQuery" data-options="iconCls:'icon-save'" style="overflow:auto;padding:18px;">   
			        <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
			        <p>Accordion is a part of easyui framework for jQuery.     
			        It lets you define your accordion component on web page more easily.</p>   
			    </div>   
			      --%>
			    <div title="权限管理系统">   
			        <ul id="tt" class="easyui-tree">   
					    <c:forEach items="${menulist}" var="m2">
	                        <c:if test="${m2.level==2}">
	                      	    <li>
			                        <span>${m2.name}</span>
			                        <ul>
			                            <c:forEach items="${menulist}" var="m3">
			                                <c:if test="${m3.parentid==m2.mid}">
			                                    <li><a href="javascript:void(0);" onclick="show('${m3.name}','${m3.url}');" >${m3.name}</a></li>
			                                </c:if>
			                            </c:forEach>
			                        </ul>
			                    </li>
	                        </c:if>
			            </c:forEach>
			        </ul>    
			    </div> 
			    <div title="帮助"><ul id="t" class="easyui-tree"> </ul></div>  
		   </div> 
		    
        </div>   
        <div data-options="region:'center'" style="padding:5px;background:#eee;">
            <div id="tab" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
			</div>  
        </div>   
	</body>  
</html>
