<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>源辰信息科技有限公司-人力资源档案登记</title>
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
</head>
<body>
<input type="hidden" id="minDate" value="${minDate }">
<input type="hidden" id="maxDate" value="${maxDate }">
<input type="hidden" name="keyword" value="${engageResume.keyword }">
<input type="hidden" id="id" value="${engageResume.human_major_kind_id }">
<table id="dg"></table>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var minDate=$('#minDate').val();
var maxDate=$('#maxDate').val();
var keyword=$('input[name="keyword"]').val();
var id=$('#id').val();
$('#dg').datagrid({   
    url:'findEngageResumeByPage',  
    pagination:true,
    queryParams: {
		minDate: minDate,
		maxDate: maxDate,
		keyword: keyword,
		id: id
	},
    columns:[[   
		{field:'res_id',title:'档案编号',width:100,hidden:true},       
        {field:'human_name',title:'姓名',width:100},   
        {field:'engage_type',title:'招聘类型',width:100},   
        {field:'human_major_kind_name',title:'职位分类名称',width:100,align:'right'}, 
        {field:'human_major_name',title:'职位名称',width:100,align:'right'}, 
        {field:'human_mobilephone',title:'手机号码',width:100},   
        {field:'cz',title:'修改',width:100,
        	formatter: function(value,row,index){
        		return '<a href="findEngageResumeById/'+row.res_id+'">修改</a>';
			}
		} 
    ]]   
}); 
</script>   
</html>


