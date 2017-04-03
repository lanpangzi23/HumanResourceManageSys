<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>   
<%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<div class="easyui-tabs" id="tt">
<p style="color:#00F">您正在做的业务是：人力资源--激励管理--添加激励项目</p>
<div title="添加激励项目名称">
<input style="width:100px; background-color:#CCC " value="激励项目名称:" readonly="true"/>
<input style="width:100px" name="addtype" /><input class="easyui" type="button" style=" background:#CFC;" value="添加" onclick="addtype()"/>
</div>
<br/><br/>
<div title="添加激励等级">
<input style="width:100px; background-color:#CCC"" value="(请输入大写字母)激励项目等级:" readonly="true"/>
<input style="width:100px" name="addrate" />
         &nbsp;价值：<input value="" name="addworth" style="width:100px;"/>
         <input class="easyui" type="button" style=" background:#CFC;" value="添加" onclick="addrate()"/>
</div>         
</div>
<script type="text/javascript">
	function addtype(){
		var type=$('input[name="addtype"]').val();
		$('#main_panel').panel('refresh',"findtype/"+type);
	}
	function addrate(){
		var rate=$('input[name="addrate"]').val();
		var rates=rate.toUpperCase();
		alert(rates);
		var worth=$('input[name="addworth"]').val();
		var worths=Number(worth);
		if(worth==""|| rate==""){
			alert("请填完！");
		}else if(Object.prototype.toString.call(worths)=='[object Number]'){
		$('#main_panel').panel('refresh',"findrate/"+rates+"/"+worth);
		}else{
		alert("格式有误,请重新输入");
		}
	}
</script> 
</body>
</html>
