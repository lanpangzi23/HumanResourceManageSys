<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
</head>
<body>
<input name="first_kind_id" value="${fid }" type="hidden"/>
<input name="second_kind_id" value="${sid }" type="hidden"/>
<input name="keyword" value="${keyword }" type="hidden"/>
<input id="date1" value="${minDate }" type="hidden"/>
<input id="date2" value="${maxDate }" type="hidden"/>
<p>您正在做的业务是:人力资源--招聘管理--招聘考试管理--试题查询</p>
<p>符合条件的试题总数：<label id="count"></label>例</p>
<table id="find"></table>
<script type="text/javascript">
var minDate=$('#date1').val();
var maxDate=$('#date2').val();
var keyword=$('input[name="keyword"]').val();
var fid=$('input[name="first_kind_id"]').val();
var sid=$('input[name="second_kind_id"]').val();
$('#find').datagrid({   
    url:'findEngageSubjectsByPage',  
    pagination:true,
    queryParams: {
    	minDate:minDate,
    	maxDate:maxDate,
    	keyword:keyword,
    	fid:fid,
    	sid:sid
	},
	onLoadSuccess:function(data){
		$('#count').text(data.total);
	},
    columns:[[   
		{field:'content',title:'题干'},       
        {field:'first_kind_name',title:'试题I级分类',width:100},   
        {field:'second_kind_name',title:'试题II级分类',width:100},   
        {field:'register',title:'登记人',width:100,align:'right'}, 
        {field:'regist_time',title:'登记时间',width:100,align:'right'}, 
        {field:'derivation',title:'出处',width:100},   
        {field:'correct_key',title:'正确答案',width:100
		} 
    ]]
}); 
</script>
</body>
</html>