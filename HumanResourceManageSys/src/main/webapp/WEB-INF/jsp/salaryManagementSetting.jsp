<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>薪酬项目设置</title>
</head>
<body>
<div id="tt" class="easyui-tabs" style="width:100%;height:100%;">  
    <div title="薪酬项目查询" style="padding:20px;display:none;"> 
    	<table id="salaryNameTable">
    		<tr>
    			<td>薪酬项目名称</td>
    		</tr>
    		<c:forEach items="${salaryName }" var="s">
    		<tr>
    			<td>${s.attribute_name}</td>
    			<td><a href="">删除</a>&nbsp;&nbsp;&nbsp;<a href="">重命名</a></td>
    		</tr>
    		</c:forEach>
    		<tr>
    			<td><input type="button" onClick="addSalaryName()" value="添加"></td>
    		</tr>
    	</table> 
    </div>   
</div>
</body>
<script type="text/javascript">
function addSalaryName(){
	alert("fcdv");
	$("#salaryNameTable").append("<tr><td><input type='text'/></td></tr>");
}
</script>
</html>