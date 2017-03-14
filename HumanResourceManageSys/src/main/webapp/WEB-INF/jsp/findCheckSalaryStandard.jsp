<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未经过复核的薪酬标准</title>
</head>
<body>
<table id="dg"></table>  
<script type="text/javascript">
$('#dg').datagrid({   
    url:'findByPage',  
    pagination:true,
    pageSize:1,
    pageList:[1,3,6,9],
    columns:[[   
        {field:'standard_id',title:'薪酬标准单编号',width:100},   
        {field:'standard_name',title:'薪酬标准单名称',width:100},   
        {field:'designer',title:'制定人名字',width:100} ,
        {field:'register',title:'登记人',width:100},   
        {field:'regist_time',title:'登记时间',width:150},   
        {field:'salary_sum',title:'薪酬总额',width:100} ,
        {field:'userId',title:'User', width:80,
          	formatter: function(value,row,index){
          		
          		}
    	]]   
});  
</script> 
</body>
</html>