<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案查询</p><br/>
	<input class="easyui" type="button" style="margin-left:709px;; background:#CFC;" value="EXCEL列表"/>
    <input class="easyui" type="button" style="background:#F33;;" src="humanResourceFileQueryEnd.html" value="查询"/>
    <input class="easyui" type="button" style="background:#F33;;" value="搜索"/>
    <table border="1" width="900px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择员工所在的I级机构</td>
			<td ><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			
		</tr>
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择员工所在的II级机构</td>
			<td ><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择员工所在的III级机构</td>
			<td ><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择职位分类</td>
			<td ><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr><tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择职位名称</td>
			<td ><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请输入建档时间</td>
			<td ><input class="easyui" type="data" id="I" name="Ijjg">至<input class="easyui" type="data" id="I" name="Ijjg">（YYYY-MM-DD）</td>
		</tr>
</body>
</html>

