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
    		<c:forEach items="${salaryName }" var="s" varStatus="ss">
    		<tr>
    			<td><input type="text" name="attribute_name" value="${s.attribute_name }"/></td>
    			<td><a href="javascript:delName(${s.pbc_id })">删除</a>&nbsp;&nbsp;&nbsp;<a href="javascript:reName(${s.pbc_id },${ss.index })">重命名</a></td>
    		</tr>
    		</c:forEach>
    		<tr id="addSalaryName">
    			<td><input type="button" onClick="addSalaryName()" value="+"></td>
    		</tr>
    	</table> 
    </div>   
</div>
<script type="text/javascript">
var j=0
function delName(id){
	$.post("deleteSalaryProjectName/"+ id,function(data){
		$("#salaryNameTable").load();
	})
}
function reName(id,i){
	var name=$('input[name="attribute_name"]').eq(i).val();
	$.post("updateSalaryProjectName/"+id+"/"+name,function(data){
		if(data=="error"){
			alert("修改失敗");
		}else{
			alert("修改成功");
		}
	},"text");
}
function addSalaryName(){
	$("#addSalaryName").before("<tr><td><input name='name' type='text'/></td><td><a class='commit' href='javascript:addName("+j+")'>未提交</a></td></tr>");
	j++;
}
function addName(j){
	var name=$('input[name="name"]').eq(j).val();
	$.post("addSalaryProjectName/"+name,function(data){
		if(data=="error"){
			alert("添加失敗");
		}else{
			alert("添加成功");
			$('.commit').eq(j).text("已提交");
		}
	},"text");
}
</script>
</body>
</html>