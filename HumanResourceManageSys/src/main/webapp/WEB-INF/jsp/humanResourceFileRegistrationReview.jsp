<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记复核</p><br/>


当前等待复核的人力资源档案总数：  ${humanFileSize } 例
<br/>
<br/>
<div id="HumanFileByCheck"></div>
<script type="text/javascript">
			//公共字段显示 
			$('#HumanFileByCheck')
					.datagrid(
							{
								url : 'findtHumanFileByCheck',//goodinfo.action----
								pagination : true,//显示分页工具栏
								pageSize : 2,
								pageList : [ 2, 4, 6 ],
								columns : [ [
										{
											field : 'human_id',
											title : '档案编号',
											width : 100
										},
										{
											field : 'human_name',
											title : '姓名',
											width : 100
										},
										{
											field : 'human_sex',
											title : '性别',
											width : 50
										},
										{
											field : 'first_kind_name',
											title : '一级机构',
											width : 100
										},
										{
											field : 'second_kind_name',
											title : '二级机构',
											width : 100
										},
										{
											field : 'third_kind_name',
											title : '三级机构',
											width :100
										},
										{
											field : 'human_pro_designation',
											title : '职称',
											width : 200
										},
										{
											field : 'cz',
											title : '操作',
											width : 100,
											formatter : function(value, row, index) {
												return '<a href="javascript:check('
														+ row.human_id + ')">复核</a>';
											}
										} ] ]
							});
//复核 
function check(id){
	$('#main_panel').panel('refresh',"tohumanResourceFileRegistrationReviewEnd/"+id);
}
	</script>
</body>
</html>
