<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未经过复核的薪酬标准</title>
</head>
<body>
<table border="1">
	<input type="hidden" value="${salaryStandard.size}" class="size"/>
	<tr>
		<th>薪酬标准单编号</th>
		<th>薪酬标准单名称</th>
		<th>制定人名字</th>
		<th>登记人</th>
		<th>登记时间</th>
		<th>薪酬总额</th>
		<th></th>
	</tr>
	<c:forEach items="${salaryStandard }" var="ss">
	<tr>
		<td>${ss.standard_id }</td>
		<td>${ss.standard_name }</td>
		<td>${ss.designer }</td>
		<td>${ss.register }</td>
		<td>${ss.regist_time }</td>
		<td>${ss.salary_sum }</td>
		<td>查看详情</td>
	</tr>
	</c:forEach>
</table>
<div id="pp" style="background:#efefef;boder:1px solid #ccc;"></div>
<script type="text/javascript">
var size=$(".size").val();
$("#pp").pagination({
	total:size,
	pageSize:10
});
</script>
</body>
</html>