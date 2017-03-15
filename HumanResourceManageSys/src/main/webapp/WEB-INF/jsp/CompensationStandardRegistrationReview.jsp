<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>
<body>
<p style="color:#00F">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记复核</p><br/>
	<input class="easyui" type="button" style="margin-left:874px;; background:#CFC;" value="复核通过"/>
    <input class="easyui" type="button" style="background:#F33;;" value="返回"/>
    <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">薪酬标准编号</td>
			<td >${salaryStandard.standard_id }</td>
			<td style="text-align:center" class="backcolor">薪酬标准名称</td>
			<td>${salaryStandard.standard_name }</td>
			<td style="text-align:center" class="backcolor">薪酬总额</td>
			<td>${salaryStandard.standard_id }</td>
		
		</tr>
        
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">制定人</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">复核人</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">复核时间</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">复核意见</td>
			<td colspan="5" ><textarea class="easyui"></textarea></td>
			
		
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">序号</td>
			
			<td  colspan="3" style="text-align:center" class="backcolor">项目名称</td>
			
			<td colspan="2" style="text-align:center" class="backcolor">金额</td>
		</tr>
       
</body>
</html>
