<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>查询待发放薪酬的员工</title>
</head>

<body>

<c:if test="${salaryGrant.totalCount }!=null">
	<label style="color:#00F">您正在做的业务是：人力资源--薪酬发放管理--薪酬发放登记（责任人控制）</label><br/>酬单编号：<label id="idd">${ salaryGrant.salaryGrantId}</label><br/>
	薪酬次数：${salaryGrant.totalCount }，总人数：<label id="people">2</label>，基本薪酬总额：<label id="sum">4100.00</label>   <label> 上次发薪时间：${salaryGrant.date }</label><br/>
</c:if>
	<label style="color:#00F">您正在做的业务是：人力资源--薪酬发放管理--薪酬发放登记（责任人控制）</label><br/>酬单编号：<label id="idd">${ salaryGrant.salaryGrantId}</label><br/>
	薪酬次数：1，总人数：<label id="people">2</label>，基本薪酬总额：<label id="sum">4100.00</label>  <label> 上次发薪时间：无</label><br/>
<table id="dg"></table>  
<script type="text/javascript">
var totalPeople=0;
var basicSalary=0;
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
        {field:'second_kind_name',title:'二级机构名称',width:100,} ,
        {field:'count',title:'人数',width:100,
        	formatter : function(value, row, index) {
        		getTotalPeople(row.count);
			return row.count;
		}},   
        {field:'salary_sum',title:'基本薪酬总和',width:150,
			formatter : function(value, row, index) {
				getSalary_sum(row.salary_sum);
			return row.salary_sum;
		}}, 
        {field:'cz',title:'登记', width:80,
        	formatter : function(value, row, index) {
				return '   <a href="javascript:register(\''
						+ row.first_kind_name + '\',\''+row.second_kind_name+'\','+row.count+')">登记</a>';
			}
        }
    ]]   
}); 
function getTotalPeople(people){
	totalPeople+=people;
	$("#people").text(totalPeople);
}
function getSalary_sum(sum){
	basicSalary+=sum;
	$("#sum").text(basicSalary);
}
function register(firstname,secondname,countt){
	var id=$("#idd").text();
	var sum=$("#sum").text();
	var count=countt+"";
	$('#main_panel').panel('refresh',"toPayOffPage/"+firstname+"/"+secondname+"/"+id+"/"+sum+"/"+count);
}
</script>
</body>
</html>
