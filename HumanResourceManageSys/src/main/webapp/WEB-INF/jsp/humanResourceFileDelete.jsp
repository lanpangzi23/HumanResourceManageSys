<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案恢复</p><br/>
    <br/><br/><br/>
    <div id="showDeleteHumanFile"></div>
    <script type="text/javascript">
			$('#showDeleteHumanFile')
					.datagrid(
							{
								url : 'findDeleteHumanFile',//goodinfo.action----
								pagination : true,//显示分页工具栏
								pageSize : 2,
								pageList : [ 2, 4, 6 ],
								columns : [ [
												{
													field : 'human_id',
													title : '档案编号',
													width : 200
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
													field : 'human_major_kind_name',
													title : '职位分类',
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
													width : 200,
													formatter : function(value, row, index) {
														return ' <a href="javascript:deleteHumanFile('
																+ row.human_id + ')">恢复</a>';
													}
												} ] ]
									});
//删除
function deleteHumanFile(id){
	$('#main_panel').panel('refresh',"torecoveryHumanFile/"+id);
}
	</script>
</body>
</html>
    