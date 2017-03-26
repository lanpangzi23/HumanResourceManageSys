<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>薪酬发放登记</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--薪酬发放管理--薪酬发放登记</p><br/>
<input class="easyui" type="button" style="margin-left:900px; background:#CFC;" value="提交"/>
<input class="easyui" type="button" background:#CFC;" value="返回"/><br/>
新酬单编号：${map.id}<br/>
机构：${map.first }/${map.second }<br>
本机构总人数：${map.count }，基本薪酬总额：${map.sum }       登记人：<input class="easyui" type="text"> 登记时间：<%=new Date() %><br/>
<table border="1" width="1000px" cellpadding="0" cellspacing="0">
	<tr style="height:35px;">
		<td class="backcolor" style="text-align:center">序号</td>
		<td class="backcolor" style="text-align:center">档案编号</td>
        <td class="backcolor" style="text-align:center">姓名</td>
	</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">1</td>
			<td class="backcolor" style="text-align:center">ASDFG</td>
            <td class="backcolor" style="text-align:center">admin</td>
            <td class="backcolor" style="text-align:center">800</td>
            <td class="backcolor" style="text-align:center">200</td>
            <td class="backcolor" style="text-align:center">200</td>
            <td class="backcolor" style="text-align:center">200</td>
            <td class="backcolor" style="text-align:center">200</td>
            <td class="backcolor" style="text-align:center">200</td> 
            <td class="backcolor" style="text-align:center">20</td>
            <td class="backcolor" style="text-align:center">2</td>
            <td class="backcolor" style="text-align:center"><input style="width:50px;" class="easyui" type="text" id="I" name="Ijjg"></td>
            <td class="backcolor" style="text-align:center">2</td>
            <td class="backcolor" style="text-align:center"><input style="width:50px;" class="easyui" type="text" id="I" name="Ijjg"></td>
			
		</tr>
       
</table>
</body>
</html>
