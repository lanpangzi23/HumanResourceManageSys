<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>查询待发放薪酬的员工</title>
</head>

<body>
<label style="color:#00F">您正在做的业务是：人力资源--薪酬发放管理--薪酬发放登记（责任人控制）</label><br/>酬单编号：HS00<br/>
<label> 薪酬次数：3，总人数：2，基本薪酬总额：4100.00</label>   <label> 上次发薪时间：2017-04-18 09:03:35.0</label><br/>
<table id="dg"></table>  
<script type="text/javascript">
$('#dg').datagrid({   
    url:'findPayoff',  
    pagination:true,
    pageSize:10,
    columns:[[  
		{field:'xh',title:'序号', width:80,
			formatter : function(value, row, index) {
				return index+1;
			}
		},
        {field:'first_kind_name',title:'一级机构名称',width:100},   
        {field:'second_kind_name',title:'二级机构名称',width:100} ,
        {field:'count',title:'人数',width:100},   
        {field:'salary_sum',title:'基本薪酬总和',width:150}, 
        {field:'cz',title:'登记', width:80,
        	formatter : function(value, row, index) {
				return '   <a href="javascript:findByDetails('
						+ row.standard_id + ')">查看详情</a>';
			}
        }
    ]]   
}); 
function findByDetails(id){
	$('#main_panel').panel('refresh',"toCompensationStandardRegistrationReview/"+id);
}
</script>
</body>
</html>
