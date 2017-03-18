<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模糊查询的结果页面</title>
</head>
<body>
<table id="dg"></table>  
<input type="hidden" value="${ss.standard_id }" name="standard_id"/>
<input type="hidden" value="${ss.keyword }" name="keyword"/>
<input type="hidden" value="${ss.minDate }" name="minDate"/>
<input type="hidden" value="${ss.maxDate }" name="maxDate"/>
<script type="text/javascript">
var standard_id=$('input[name="standard_id"]').val();
var keyword=$('input[name="keyword"]').val();
var minDate=new Date($('input[name="minDate"]').val());
var maxDate=new Date($('input[name="maxDate"]').val());
$('#dg').datagrid({   
    url:'findByFuzzy',  
    pagination:true,
    pageSize:10,
    queryParams:{standard_id:standard_id,keyword:keyword,minDate:minDate,maxDate:maxDate},
    columns:[[   
        {field:'standard_id',title:'薪酬标准单编号',width:100},   
        {field:'standard_name',title:'薪酬标准单名称',width:100},   
        {field:'designer',title:'制定人名字',width:100} ,
        {field:'register',title:'登记人',width:100},   
        {field:'regist_time',title:'登记时间',width:150},   
        {field:'salary_sum',title:'薪酬总额',width:100} 
    ]]   
}); 
</script> 
</body>
</html>