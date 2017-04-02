<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理员的添加</title>
</head>
<body>
	<div id="tt" class="easyui-tabs" style="width: 100%; height: 100%;">
		<div title="后台管理员添加" style="padding: 20px; display: none;">
			<input name="aa" type="hidden">
			<div id="mm" style="width: 200px">
				<div data-options="name:'attribute_kind'">职位名称</div>
			</div>
			<input id="ss" class="easyui-searchbox" style="width: 300px"
				data-options="searcher:qq,prompt:'请输入职位名称...',menu:'#mm'"></input> <br />
			<br /> <br /> <br />
			<div id="showHumanFile"></div>
		</div>
		<div title="后台管理员删除" style="padding: 20px; display: none;">

			<div id="showAdminUser"></div>
		</div>
	</div>
	<script type="text/javascript">
	$('#showAdminUser')
	.datagrid(
			{
				url : 'findtAdminUser',//goodinfo.action----
				pagination : true,//显示分页工具栏
				pageSize : 2,
				pageList : [ 2, 4, 6 ],
				columns : [ [
{
	field : 'u_id',
},
						{
							field : 'u_name',
							title : '用户名',
							width : 200
						},
						{
							field : 'u_true_name',
							title : '真实姓名',
							width : 100
						},
						{
							field : 'u_role',
							title : '职位',
							width : 100
						},
						{
							field : 'cz',
							title : '操作',
							width : 100,
							formatter : function(value, row, index) {
								return '<a href="javascript:deleteAdmin('
										+ row.u_id + ')">删除</a>';
							}
						} ] ]
			});
		//公共字段显示 
		var mindate = $('input[name="aa"]').val();
		var human_major_id = $('input[name="aa"]').val();
		$('#showHumanFile')
				.datagrid(
						{
							url : 'findtHumanFileByMaior',//goodinfo.action----
							queryParams : {
								human_pro_designation : human_major_id,
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
										width : 100
									},
									{
										field : 'human_major_kind_name',
										title : '职位分类',
										width : 100
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
											return '<a href="javascript:addBackAdmin('
													+ row.human_id + ')">添加</a>';
										}
									} ] ]
						});
		//搜索框 根据条件查寻 
		function qq(value, name) {
			if(name=='attribute_kind'){
			$('#showHumanFile')
					.datagrid(
							{
								url : 'findtHumanFileByMaior',//goodinfo.action----
								queryParams : {
									human_pro_designation : value
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
											width : 100
										},
										{
											field : 'human_major_kind_name',
											title : '职位分类',
											width : 100
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
											formatter : function(value, row,
													index) {
												return '<a href="javascript:addBackAdmin('
														+ row.human_id
														+ ')">添加</a>';
											}
										} ] ]
							});}
		}

		//3.删除 
		function deleteAdmin(id) {
			$.post('deleteAdmin', {
				u_id : id
			}, function(data) {
				if (data == 1) {
					alert('删除成功');
					$('#showAdminUser').datagrid('reload');//刷新
				} else if (data == 0) {
					alert('删除失败')
				}
			},'text');
		}
		
		//3.添加 
		function addBackAdmin(id) {
			$.post('addBackAdmin', {
				humanid : id
			}, function(data) {
				if (data == 1) {
					alert('添加成功');
				} else if (data == 0) {
					alert('添加失败')
				}else if(data==2){
					alert('该人员已为系统管理员，请勿重复添加')
				}
			},'text');
		}
	</script>
</body>
</html>