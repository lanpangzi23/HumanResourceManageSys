<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:#00F">您正在做的业务是：人力资源--招聘管理--录用管理</p><br/>


<br/>
<br/>
<center>录用申请意见：
	<input class="easyui-textbox"  name="proposal" data-options="multiline:true" style="height:80px;width:630px">
	</center><br/><br/><br/>
	
<div id="ShowEngage"></div>
<script type="text/javascript">
			//公共字段显示 
			$('#ShowEngage')
					.datagrid(
							{
								url : 'ShowEngage',//goodinfo.action----
								pagination : true,//显示分页工具栏
								pageSize : 2,
								pageList : [ 2, 4, 6 ],
								columns : [ [
										{
											field : 'ein_id',
										},
										{
											field : 'human_name',
											title : '姓名',
											width : 100
										},
										{
											field : 'human_major_name',
											title : '职位',
											width : 50
										},
										{
											field : 'image_degree',
											title : '形象等级',
											width : 100
										},
										{
											field : 'native_language_degree',
											title : '口才等级',
											width : 100
										},
										{
											field : 'multi_quality_degree',
											title : '综合素质',
											width :100
										},
										{
											field : 'interview_comment',
											title : '面试评价',
											width : 200
										},
										{
											field : 'check_comment',
											title : '筛选评价',
											width : 200
										},
										{
											field : 'cz',
											title : '操作',
											width : 100,
											formatter : function(value, row, index) {
												return '<a href="javascript:Eap('
														+ row.resume_id + ')">录用申请</a>';
											}
										} ] ]
							});
//复核 
function Eap(id){
	var proposal=$('input[name="proposal"]').val();
	$.post('EmploymentApplication',{id:id,proposal:proposal},function(data){
		
	})
}
	</script>
</body>
</html>