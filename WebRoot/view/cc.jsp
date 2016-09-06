<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
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
  	        function addTab(title,url){
  	            $('#tab').tabs('add',{    
			    title:title,    
			    selected: true, 
			    content:"<iframe style='height:100%;width:100%;' src='"+url+"'></iframe>",
			    closable:true    
				});  
  	        }
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
  	        .cc{
  	            float: left;
  	            word-spacing:75px;
  	            font-size:30px;
  	            margin-left: 350px;margin-top: 5px;
  	            text-decoration: none;
  	        }
  	        .ccc{
  	            float: left;
  	            word-spacing:25px;
  	            font-size:18px;
  	            margin-left: 1400px;margin-top: -56px;
  	        }
  	    </style>
  	</head>
  	<body class="easyui-layout"> 
        <div data-options="region:'north',split:true" style="height:125px;background-color: #00FFFF;">
            <p class="c">XX网站管理功能界面</p>
            <p class="cc">
                <span ><a href="#">首页</a></span>
	            <span><a href="#">简介</a></span>
	            <span><a href="#">面向领域</a></span>
	            <span><a href="#">最新信息</a></span>
	            <span><a href="#">联系我们</a></span>
            </p>
            <p class="ccc">
                <span><a href="#">登录</a></span>
                <span><a href="#">注册</a></span>
            </p>
        </div>
        <div data-options="region:'west',title:'网站管理系统',split:true" style="width:200px;">
	        <div id="aa" class="easyui-accordion" style="width:300px;height:240px;">   
			    <div title="关于JQuery" data-options="iconCls:'icon-save'" style="overflow:auto;padding:18px;">   
			        <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
			        <p>Accordion is a part of easyui framework for jQuery.     
			        It lets you define your accordion component on web page more easily.</p>   
			    </div>   
			    <div title="网站类型" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
			        <ul id="tt" class="easyui-tree">   
	                    <li>   
	                        <span><a href="javascript:addTab('百度','http://www.baidu.com');">百度</a></span>   
	                    </li>   
	                    <li>   
	                        <span><a href="javascript:addTab('优酷','http://www.youku.com');">优酷</a></span>   
	                    </li>   
	                    <li>   
	                        <span><a href="javascript:addTab('搜狐','http://www.baidu.com');">搜狐</a></span>   
	                    </li> 
	                    <li>   
	                        <span><a href="javascript:addTab('网易','http://www.163.com');">网易</a></span>   
	                    </li>   
	                    <li>   
	                        <span><a href="javascript:addTab('爱奇艺','http://www.iqiyi.com');">爱奇艺</a></span>   
	                    </li>     
			        </ul>   
			    </div>   
			    <div title="权限管理系统">   
			        <ul id="tt" class="easyui-tree">   
					    <li>   
					        <span>用户管理系统</span>   
			                <ul>   
			                    <li>   
			                        <span><a href="javascript:show('用户列表','Show.do?methodName=showUser');">用户列表</a></span>   
			                    </li>   
			                    <li>   
			                        <span><a href="javascript:show('菜单列表','Show.do?methodName=showMenu');">菜单列表</a></span>   
			                    </li>   
			                    <li>   
			                        <span><a href="javascript:show('角色列表','aclass.do?methodName=showroel');">角色列表</a></span>   
			                    </li>   
			                    <li>   
			                        <span><a href="javascript:show('班级列表','menu.do?methodName=aclass');">班级列表</a></span>   
			                    </li>  
			                    <li>   
			                        <span><a href="javascript:show('添加菜单','addmenu.do?methodName=lianJieByMenu');">添加菜单</a></span>   
			                    </li>    
			                </ul>   
					    </li>
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
