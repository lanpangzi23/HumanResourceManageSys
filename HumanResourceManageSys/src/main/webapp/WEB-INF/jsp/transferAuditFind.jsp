<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调动登记</title>
</head>
<body>
<table id="dg"></table>  
<script type="text/javascript">
$('#dg').datagrid({   
    url:'ChangefindByPages',  
    pagination:true,
    pageSize:10,
    columns:[[   
        {field:'human_id',title:'档案编号',width:100},   
        {field:'human_name',title:'姓名',width:100},   
        {field:'first_kind_name',title:'一级机构',width:100} ,
        {field:'second_kind_name',title:'二级机构',width:100},   
        {field:'third_kind_name',title:'三级机构',width:150},   
        {field:'major_kind_name',title:'职位分类名称',width:100} ,
        {field:'major_name',title:'职位名称',width:100} ,
        {field:'cz',title:'操作', width:80,
        	formatter : function(value, row, index) {
				return "<a href='javascript:findByDetails(\""
						+ row.human_id +"\")'>详情</a>";
			}
        }
    ]]   
}); 
function findByDetails(id){
	$('#main_panel').panel('refresh',"totransferAuditFind/"+id);
   
}
</script> 
</body>
</html>