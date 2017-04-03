<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>源辰信息科技有限公司-人力资源档案登记</title>
<style>
.header p{
	color:#09F;
	font-size:40px;
	font-weight:600;
	height:60px;
	line-height:130px;
	text-align:right;
	padding-right:300px;
	font-family:"Lucida Console", Monaco, monospace;
	margin-top:-20px;

</style>
</head>
<body class="easyui-layout">
    <p>数据库中已存在</p>
<input type="button" style="margin-left:900px; background:#CFC;" value="返回首页" onclick="javascript:history.go(0)"/>
</body>
<script>

</script>
</html>
