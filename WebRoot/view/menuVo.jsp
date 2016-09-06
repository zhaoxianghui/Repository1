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
	<script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/jquery-easyui-1.3.3/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/jquery-easyui-1.3.3/themes/default/easyui.css"/>
    <script type="text/javascript">
   	    $(function(){
   	        $('#win').window('close');  // close a window 
	        $('#dg').datagrid({    
			    url:'showMenu.do?methodName=showMenu&pageNo=1&pageSize=10', 
			    frozenColumns:[[{field:'code',checkbox:true}]], 
			    rownumbers:true,
			    striped:true,
			    pagination:true,  
			    columns:[[    
			        {field:'mid',title:'菜单编号',width:100,align:'center'},
			        {field:'name',title:'名称',width:50,align:'center'},
			        {field:'url',title:'URl地址',width:300,align:'center'},
			        {field:'isshow',title:'是否展示',width:100,align:'center'},    
			        {field:'level',title:'菜单级别',width:100,align:'center'},    
			        {field:'parentiname',title:'父级菜单',width:100,align:'center'}    
			    ]],
			    toolbar:[{
			        text:'添加',
			        iconCls:'icon-add',
			        handler: function(){
			            $('#win').window('open');
			        }
			    },'-',{
			        text:'修改',
			        iconCls:'icon-modify',
			        handler: function(){
			            alert('修改按钮');
			        } 
			    },'-',{
			        text:'删除',
			        iconCls:'icon-delete',
			        handler: function(){
			            alert('删除按钮');
			        } 
			    },'-',{
			        text:'刷新',
			        iconCls:'icon-refresh',
			        handler: function(){
			          refreshData(1,10);  
			        } 
			    }]
			});
			var pager = $('#dg').datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNumber, pageSize){
					refreshData(pageNumber, pageSize);
				}
			});
			//添加菜单时加载父级菜单列表
			$('#parentid').combobox({
			    url:'addmenu.do?methodName=lianJieByMenu',
			    textField:'name',
			    valueField:'mid',
			    value:-1
		    });
		}); 
		//刷新表格数据
		function refreshData(){
		    $('#dg').pagination('loading');
			$.post("showMenu.do",{
			    methodName:'showMenu',
			    pageNo:pageNumber,
			    pageSize:pageSize
			},function(data){
			    $('#dg').datagrid('loadData',{
			        rows:data.rows,
			        total:data.total
			    })
			    $('#dg').pagination('loaded');
			},'json');
		} 
    </script>
    <style type="text/css">
        #form{
            text-align: center;
            margin-top: 20px;
            
        }
    </style>
  </head>
  <body>
      <table id="dg"></table> 
      <div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px;top:100px;minimizable:false;maximizable:false;collapsible:false;"   
        data-options="iconCls:'icon-save',modal:true">   
           <form id="form" action="addmenuJM.do" method="post">
	           <input type="hidden" name="methodName" value="addmenus"/>
	           <label>名称：</label></br>
	           <input type="text" name="name" id="name" class="easyui-validatabox in" required/></br>
	           <label>地址：</label></br>
	           <input type="text" name="url" id="url" class="easyui-validatabox in" required/></br>
	           <label>是否展示：</label></br>
	           <input type="radio" name="isshow" value="1"/>展示
	           <input type="radio" name="isshow" value="0"/>不展示</br>
	           <label>父类级别：</label></br>
	           <select name="parentid" id="parentid" class="easyui-combobox in" style="width: 200px;">
	            
	            <!-- 
	             <c:forEach items="${listmenus}" var="l">
	             <option value="${l.mid}">
	                  <c:if test="${l.level==1}">一级菜单--${l.name}</c:if>
	                  <c:if test="${l.level==2}">二级菜单--${l.name}</c:if>
	                </option>
	            </c:forEach>
	             -->
	          </select></br>
	          <input type="submit" name="m" value="提交"/>  
	          <input type="reset" name="m" value="重置 "/> 
	       </form>
	  </div>   
  </body>
</html>
