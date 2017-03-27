<%@page import="java.util.Date"%>
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
<form action="">
<input class="easyui" type="button" style="margin-left:900px;" value="提交"/>
<input class="easyui" type="button" value="返回"/><br/>
新酬单编号：<input style="border:none;" value="${map.id}" name="salary_grant_id"/><br/>
机构：${map.firstname }/${map.secondname }<br>
本机构总人数：<input style="border:none;" name="human_amount" value="${map.count }"/>基本薪酬总额：<input style="border:none;" name="salary_standard_sum" value="${map.sum }"/>      
登记人：<input name="register" class="easyui" type="text"> 登记时间：<input name="regist_time" style="border:none;" value="<%=new Date() %>"/><br/><br>
<table border="1" width="1000px" cellpadding="0" cellspacing="0">
	<tr style="height:35px;">
		<td class="backcolor" style="text-align:center">序号</td>
		<td class="backcolor" style="text-align:center">档案编号</td>
        <td class="backcolor" style="text-align:center">姓名</td>
        <c:forEach items="${humanFile }" var="hf" varStatus="h">
        <c:choose>
        	<c:when test="${h.index==0 }">
        		<c:forEach items="${hf.ssd }" var="ssd">
				<td>${ssd.item_name }</td>
				</c:forEach>
        	</c:when>
        </c:choose>
		</c:forEach> 
        <td >奖励金额</td>
        <td >销售绩效金额</td>
        <td>应扣金额</td>
	</tr>
	<c:forEach items="${humanFile }" var="hf" varStatus="h">
	<tr>
		<td>${h.index+1 }</td>
		<td>${hf.human_id }</td>
		<td>${hf.human_name }</td>
		<c:forEach items="${hf.ssd }" var="ssd">
		<td><input style="width: 50px;" type="text" value="${ssd.salary }"></td>
		</c:forEach>
		<td style="width: 50px;"><input type="text"/></td>
        <td style="width: 50px;"><input type="text" value="0.00"/></td>
        <td style="width: 50px;"><input type="text"/></td>
	</tr>
	</c:forEach>     
</table>
</form>
</body>
</html>
