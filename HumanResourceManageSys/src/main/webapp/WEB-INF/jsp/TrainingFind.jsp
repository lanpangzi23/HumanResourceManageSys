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
<input class="easyui" type="button" style="margin-left:900px; background:#CFC;" value="查找" onClick="toFind()"/>
姓名：<input class="easyui" type="text" name="human_name" />
<table id="dg"></table>  
<script type="text/javascript">
$('#dg').datagrid({   
    url:'findPages',  
    pagination:true,
    pageSize:10,
    columns:[[   
        {field:'human_id',title:'档案编号',width:100},   
        {field:'human_name',title:'姓名',width:100},   
        {field:'first_kind_name',title:'一级机构',width:100} ,
        {field:'second_kind_name',title:'二级机构',width:100},   
        {field:'third_kind_name',title:'三级机构',width:150},   
        {field:'human_major_kind_name',title:'职位分类名称',width:100} ,
        {field:'salary_standard_name',title:'职位名称',width:100} ,
        {field:'cz',title:'操作', width:80,
        	formatter : function(value, row, index) {
				return "<a href='javascript:findByDetails(\""
						+ row.human_id +"\")'>培训分配</a>";
			}
        }
    ]]   
}); 
function findByDetails(id){
	$('#main_panel').panel('refresh',"toTraining/"+id);
	
    
}

function toFind(){
	var name=$('input[name="human_name"]').val();
	alert(name);
		$('#dg').datagrid({   
	    url:'tofindPages',  
	    pagination:true,
	    pageSize:10,
	    queryParams:{human_name:name },
	    columns:[[   
	        {field:'human_id',title:'档案编号',width:100},   
	        {field:'human_name',title:'姓名',width:100},   
	        {field:'first_kind_name',title:'一级机构',width:100} ,
	        {field:'second_kind_name',title:'二级机构',width:100},   
	        {field:'third_kind_name',title:'三级机构',width:150},   
	        {field:'human_major_kind_name',title:'职位分类名称',width:100} ,
	        {field:'salary_standard_name',title:'职位名称',width:100} ,
	        {field:'cz',title:'操作', width:80,
	        	formatter : function(value, row, index) {
					return "<a href='javascript:findByDetails(\""
							+ row.human_id +"\")'>培训分配</a>";
				}
	        }
	    ]]   
	}) ;
	
	
	
	
}
</script> 
</body>
</html>