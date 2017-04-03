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
<script type="text/javascript" src="js/jquery-form.js"></script>
<form name="bonuscommit" id="bonuscommit">
<input class="easyui" type="button" style="margin-left:900px; background:#CFC;" value="查找" onClick="toFind()"/>
姓名：<input class="easyui" type="text" name="human_name" />
<table id="dg"></table> 
</form> 
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
						+ row.human_id +"\")'>激励</a>";
			}
        }
    ]]   
}); 
function findByDetails(id){
	$('#main_panel').panel('refresh',"tobonus/"+id);
	
    
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
							+ row.human_id +"\")'>奖励</a>";
				}
	        }
	    ]]   
	}) ;
	
}

  
$(function () {
    $(".true").click(function () {
    			 $("#bonuscommit").ajaxSubmit({
                     success: function (data) {
                     	if(data==1){
                     		alert('提交成功...请尽快审核....')
                     	}else if(data==2){
                     		alert("不可重复提交....");
                     	}else{
                     		alert('提交失败 ...');
                     	}
                         alert(data);
                     },
                     error: function (error) { alert('登记失败 ...'); },
                     url: 'Export', /*设置post提交到的页面*/
                     type: "post", /*设置表单以post方法提交*/
                     dataType: "text" /*设置返回值类型为文本*/
                 });
    });
});	
</script> 
</body>
</html>