<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案查寻</p><br/>


当前等待复核的人力资源档案总数：  ${size} 例

<input class="easyui" value="${mindate}" name="mindate" type="hidden"/>
<input class="easyui" value="${maxdate}" name="maxdate" type="hidden"/>
<input class="easyui" value="${firstKindId}" name="firstKindId" type="hidden"/>
<input class="easyui" value="${secondKindId}" name="secondKindId" type="hidden"/>
<input class="easyui" value="${thirdKindId}" name="thirdKindId" type="hidden"/>
<input class="easyui" value="${human_major_kind_id}" name="human_major_kind_id" type="hidden"/>
<input class="easyui" value="${human_major_id}" name="human_major_id" type="hidden"/>
<br/><br/><br/>
<div id="showHumanFile"></div>
<script type="text/javascript">
			//公共字段显示 
			var mindate=$('input[name="mindate"]').val();
			var maxdate=$('input[name="maxdate"]').val();
			var firstKindId=$('input[name="firstKindId"]').val();
			var secondKindId=$('input[name="secondKindId"]').val();
			var thirdKindId=$('input[name="thirdKindId"]').val();
			var human_major_kind_id=$('input[name="human_major_kind_id"]').val();
			var human_major_id=$('input[name="human_major_id"]').val();
			$('#showHumanFile')
					.datagrid(
							{
								url : 'findtHumanFileBy',//goodinfo.action----
								queryParams : {
									mindate : mindate,
									maxdate : maxdate,
									firstKindId : firstKindId,
									secondKindId : secondKindId,
									thirdKindId : thirdKindId,
									human_major_kind_id : human_major_kind_id,
									human_major_id : human_major_id,
								},
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
														return '<a href="javascript:selectDetails('
																+ row.human_id + ')">查看详情</a> &nbsp;&nbsp;<a href="javascript:update('
																+ row.human_id + ')">变更</a>&nbsp;&nbsp; <a href="javascript:deleteHumanFile('
																+ row.human_id + ')">删除</a>';
													}
												} ] ]
									});
//查看详情 
function selectDetails(id){
	$('#main_panel').panel('refresh',"tohumanFileDetails/"+id);
}
//变更 
function update(id){
	$('#main_panel').panel('refresh',"tohumanResourceFileUpdate/"+id);
}
//删除
function deleteHumanFile(id){
	$.messager.confirm('温馨提示','你确定要删除这条记录吗?',function(r){
	    if (r){
	    	$.post('deleteHumanFile', {
				humanid : id
			}, function(data) {
				if (data == 1) {
					alert('您已成功删除该档案');
					$('#main_panel').panel('refresh',"tohumanFileDelete");
				} else if (data = 0) {
					alert('删除失败')
				}
			});
	    }
	})
		
}
	</script>
</body>
</html>