<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>薪酬标准登记</title>
</head>

<body>
	<div id="tt" class="easyui-tabs" style="width: 100%; height: 100%;">
		<div title="一级机构设置" style="padding: 20px; display: none;">
			<center>
				<form>
					<table id="salaryNameTable">
						<tr>
							<td>一级机构名称:</td>
							<td><input type="text" class="firstKindffkId" value=""
								hidden="hidden" /> <input type="text" class="firstKindName"
								value=""></td>
						</tr>
						<tr>
							<td>一级机构薪酬发放责任人:</td>
							<td><select type="text" class="firstKindSalaryId"
								style="width: 150px;">
									<option value="1001">薪酬经理</option>
									<option value="1002">薪酬专员</option>
							</select></td>
						</tr>
						<tr>
							<td>一级机构销售责任人:</td>
							<td><select type="text" class="firstKindSaleId"
								style="width: 150px;">
									<option value="10001">销售经理</option>
									<option value="10002">销售专员</option>
							</select></td>
						</tr>
						<br />
						<br />
						<br />
					</table>
				</form>
			</center>
			<br /> <br /> <input type="button" onclick="updateFirstKind()"
				value="确认修改" style="float: right;"> <input type="button"
				onclick="addFirstKind()" value="添加" style="float: right;"> <br />
			<br />
			<div id="showFirstKind"></div>
		</div>


		<div title="二级机构设置" style="padding: 20px; display: none;">
			<center>
				<form>
					<table id="salaryNameTable">
						<tr>
							<td>一级机构名称:</td>
							<td><select type="text" class="firstKindIdSencond"
								style="width: 150px;">
									<c:forEach items="${configFileFirstKinds}" var="s">
										<option value="${s.first_kind_id }">${s.first_kind_name }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>二级机构名称:</td>
							<td><input type="text" class="secondKindfskId" value=""
								hidden="hidden" /> <input type="text" class="secondKindName"
								value=""></td>
						</tr>
						<tr>
							<td>二级机构薪酬发放责任人:</td>
							<td><select type="text" class="secondKindSalaryId"
								style="width: 150px;">
									<option value="1001">薪酬经理</option>
									<option value="1002">薪酬专员</option>
							</select></td>
						</tr>
						<tr>
							<td>二级机构销售责任人:</td>
							<td><select type="text" class="secondKindSaleId"
								style="width: 150px;">
									<option value="10001">销售经理</option>
									<option value="10002">销售专员</option>
							</select></td>
						</tr>
						<br />
						<br />
						<br />
					</table>
				</form>
			</center>
			<br /> <br /> <input type="button" onclick="updateSecondKind()"
				value="确认修改" style="float: right;"> <input type="button"
				onclick="addSecondKind()" value="添加" style="float: right;">
			<br /> <br />


			<div id="showSecondKind"></div>
		</div>


		<div title="三级机构设置" style="padding: 20px; display: none;">
			<center>
				<table id="salaryNameTable">
					<tr>
						<td>一级机构名称：</td>
						<td><input style="width: 150px;" id="cc3"
							class="easyui-combobox"
							data-options=" 
			valueField:'first_kind_id',
			textField:'first_kind_name',
			url:'findAllFirstKind',
			onSelect:function(rec){
				var url='findSecondKindByFirst?first_kind_id='+rec.first_kind_id;
				 $('#cc4').combobox('reload', url); 
			}" />
						</td>
					<tr>
						<td>二级机构名称：</td>
						<td><input style="width: 150px;" id="cc4"
							class="easyui-combobox"
							data-options="valueField:'second_kind_id',textField:'second_kind_name'" />
						</td>
					</tr>
					<tr>
						<td>三级机构名称:</td>
						<td><input type="text" class="thirdKindftkId" value=""
							hidden="hidden" /> <input type="text" class="thirdKindName"
							value=""></td>
					</tr>
					<tr>
						<td>三级机构销售责任人:</td>
						<td><select type="text" class="thirdKindSaleId"
							style="width: 150px;">
								<option value="1001">薪酬经理</option>
								<option value="1002">薪酬专员</option>
						</select></td>
					</tr>
					<tr>
						<td>是否为零售店:</td>
						<td><select type="text" class="thirdKindIsRetail"
							style="width: 150px;">
								<option value="是">是</option>
								<option value="否">否</option>
						</select></td>
					</tr>
					<br />

				</table>
			</center>
			<br /> <br /> <input type="button" onclick="updateThirdKind()"
				value="确认修改" style="float: right;"> <input type="button"
				onclick="addThirdKind()" value="添加" style="float: right;"> <br />
			<br />


			<div id="showThirdKind"></div>
		</div>

		<div title="公共字段设置" style="padding: 20px; display: none;">
			<center>
				<form>
					<table id="salaryNameTable">
						<tr>
							<td>公共字段名称:</td>
							<td><select type="text" class="attribute_kind"
								style="width: 150px;">
									<c:forEach items="${configPublicChar}" var="s">
										<option value="${s.attribute_kind }">${s.attribute_kind }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>公共字段属性:</td>
							<td><input type="text" class="attribute_name" value=""></td>
						</tr>

						<br />
						<br />
						<br />
					</table>
				</form>
			</center>
			<br /> <br /> <input type="button" onclick="addConfigPublicChar()"
				value="添加" style="float: right;"> <br />
			<div id="mm" style="width: 200px">
				<div data-options="name:'attribute_kind'">属性的种类</div>
				<div data-options="name:'attribute_name'">属性的名称</div>
			</div>
			<input id="ss" class="easyui-searchbox" style="width: 300px"
				data-options="searcher:qq,prompt:'请输入属性的种类...',menu:'#mm'"></input>
			<br />
			<br />
			<br />
			<br />
			<div id="showConfigPublicChar"></div>
		</div>
	</div>
	<script type="text/javascript">
		//搜索框 根据条件查寻 
		function qq(value, name) {
			if (name == 'attribute_kind') {
				$('#showConfigPublicChar')
						.datagrid(
								{
									url : 'findConfigPublicCharByKind',//goodinfo.action----
									queryParams : {
										attribute_kind : value
									},
									pagination : true,//显示分页工具栏
									pageSize : 2,
									pageList : [ 2, 4, 6 ],
									columns : [ [
											{
												field : 'pbc_id',
												width : 0
											},
											{
												field : 'attribute_kind',
												title : '所属一级机构名称',
												width : 100
											},
											{
												field : 'attribute_name',
												title : '所属二级机构名称',
												width : 200
											},
											{
												field : 'cz',
												title : '操作',
												width : 100,
												formatter : function(value,
														row, index) {
													return '<a href="javascript:deleteConfigPublicChar('
															+ row.pbc_id
															+ ')">删除</a>';
												}
											} ] ]
								});
			}
			if (name == 'attribute_name') {
				$('#showConfigPublicChar')
						.datagrid(
								{
									url : 'findConfigPublicCharByKindByName',//goodinfo.action----
									queryParams : {
										attribute_name : value
									},
									pagination : true,//显示分页工具栏
									pageSize : 2,
									pageList : [ 2, 4, 6 ],
									columns : [ [
											{
												field : 'pbc_id',
												width : 0
											},
											{
												field : 'attribute_kind',
												title : '所属一级机构名称',
												width : 100
											},
											{
												field : 'attribute_name',
												title : '所属二级机构名称',
												width : 200
											},
											{
												field : 'cz',
												title : '操作',
												width : 100,
												formatter : function(value,
														row, index) {
													return '<a href="javascript:deleteConfigPublicChar('
															+ row.pbc_id
															+ ')">删除</a>';
												}
											} ] ]
								});
			}
		}

		//公共字段的tianjia
		function addConfigPublicChar() {
			var attribute_kind = $('.attribute_kind').val();
			var attribute_name = $('.attribute_name').val();
			$.post('addConfigPublicChar', {
				attribute_kind : attribute_kind,
				attribute_name : attribute_name
			}, function(data) {
				if (data == 1) {
					alert('添加成功');
					$('.attribute_name').val('');
					$('#showConfigPublicChar').datagrid('reload');//刷新
				} else if (data == 0) {
					alert('添加失败');
				} else if (data == 2) {
					alert('名称已存在，请勿重复添加！');
					var Mainmenu = $('.Mainmeu').val();
					$('.attribute_name').val('');
				}
			}, 'text');
		}
		//1.添加 
		function addFirstKind() {//菜单添加  
			var firstKindName = $('.firstKindName').val();
			var firstKindSalaryId = $('.firstKindSalaryId').val();
			var firstKindSaleId = $('.firstKindSaleId').val();
			$.post('addFirstKind', {
				firstKindName : firstKindName,
				firstKindSalaryId : firstKindSalaryId,
				firstKindSaleId : firstKindSaleId
			}, function(data) {
				if (data == 1) {
					alert('添加成功');
					$('.firstKindName').val('');
					$('.firstKindSalaryId').val('');
					$('.firstKindSaleId').val('');
					$('#showFirstKind').datagrid('reload');//刷新
				} else if (data == 0) {
					alert('添加失败');
				} else if (data == 2) {
					alert('一级机构名称已存在，请勿重复添加！');
					var Mainmenu = $('.Mainmeu').val();
					$('.firstKindName').val('');
					$('.firstKindSalaryId').val('');
					$('.firstKindSaleId').val('');
				}
			}, 'text');
		}
		//2.添加 
		function addSecondKind() {//菜单添加  
			var firstKindName = $(".firstKindIdSencond")
					.find("option:selected").text();
			var firstKindId = $(".firstKindIdSencond").val();
			var secondKindName = $('.secondKindName').val();
			var secondKindSalaryId = $('.secondKindSalaryId').val();
			var secondKindSaleId = $('.secondKindSaleId').val();
			$.post('addSecondKind', {
				secondKindName : secondKindName,
				secondKindSalaryId : secondKindSalaryId,
				firstKindName : firstKindName,
				firstKindId : firstKindId,
				secondKindSaleId : secondKindSaleId
			}, function(data) {
				if (data == 1) {
					alert('添加成功');
					$('.secondKindName').val('');
					$('#showSecondKind').datagrid('reload');//刷新
				} else if (data == 0) {
					alert('添加失败');
				} else if (data == 2) {
					alert('二级机构名称已存在，请勿重复添加！');
					var Mainmenu = $('.Mainmeu').val();
					$('.secondKindName').val('');
				}
			}, 'text');
		}
		//3.添加 
		function addThirdKind() {//菜单添加  
			var firstKindName = $('#cc3').combobox('getText');
			var firstKindId = $('#cc3').combobox('getValue');
			var secondKindName = $('#cc4').combobox('getText');
			var secondKindId = $('#cc4').combobox('getValue');
			var thirdKindName = $('.thirdKindName').val();
			var thirdKindSaleId = $('.thirdKindSaleId').val();
			var thirdKindIsRetail = $('.thirdKindIsRetail').val();
			$.post('addThirdKind', {
				thirdKindIsRetail : thirdKindIsRetail,
				secondKindId : secondKindId,
				secondKindName : secondKindName,
				thirdKindName : thirdKindName,
				firstKindName : firstKindName,
				firstKindId : firstKindId,
				thirdKindSaleId : thirdKindSaleId
			}, function(data) {
				if (data == 1) {
					alert('添加成功');
					$('.thirdKindName').val('');
					$('#showThirdKind').datagrid('reload');//刷新
				} else if (data == 0) {
					alert('添加失败');
				} else if (data == 2) {
					alert('三级机构名称已存在，请勿重复添加！');
					var Mainmenu = $('.Mainmeu').val();
					$('.thirdKindName').val('');
				}
			}, 'text');
		}

		////1.修改前显示 
		function alertFirstKind(first_kind_name) {
			$.post('findFirstKindByName', {
				first_kind_name : first_kind_name
			}, function(data) {
				$('.firstKindffkId').val(data[0].ffk_id);
				$('.firstKindName').val(data[0].first_kind_name);
				$('.firstKindSalaryId').val(data[0].first_kind_salary_id);
				$('.firstKindSaleId').val(data[0].first_kind_sale_id);
			}, 'json');

		};
		////2.修改前显示 
		function alertSecondKind(fsk_id) {
			$.post('findSecondKindByName', {
				fsk_id : fsk_id
			}, function(data) {
				$('.secondKindfskId').val(data[0].fsk_id);
				$('.firstKindIdSencond').val(data[0].first_kind_id);
				$('.secondKindName').val(data[0].second_kind_name);
				$('.secondKindSaleId').val(data[0].second_salary_id);
				$('.secondKindSaleId').val(data[0].second_sale_id);
			}, 'json');

		};////3.修改前显示 
		function alertThirdKind(ftk_id) {
			$.post('alertThirdKind', {
				ftk_id : ftk_id
			}, function(data) {
				$('.thirdKindftkId').val(data[0].ftk_id);
				$('#cc3').combobox('select', data[0].first_kind_id);
				$('#cc4').combobox('select', data[0].second_kind_id);
				$('.thirdKindName').val(data[0].third_kind_name);
				$('.thirdKindSaleId').val(data[0].third_kind_sale_id);
				$('.thirdKindIsRetail').val(data[0].third_kind_is_retail);
			}, 'json');
		};
		////1.修改
		function updateFirstKind() {
			var fkkid = $('.firstKindffkId').val();
			var firstKindName = $('.firstKindName').val();
			var firstKindSalaryId = $('.firstKindSalaryId').val();
			var firstKindSaleId = $('.firstKindSaleId').val();
			$.post('updateFirstKind', {
				fkkid : fkkid,
				firstKindName : firstKindName,
				firstKindSalaryId : firstKindSalaryId,
				firstKindSaleId : firstKindSaleId
			}, function(data) {
				if (data == 0) {
					alert('修改失败')
				} else {
					alert('修改成功')
					$('#showFirstKind').datagrid('reload');//刷新
				}
			}, 'text');

		};
		////2.修改
		function updateSecondKind() {
			var fskid = $(".secondKindfskId").val();
			var firstKindName = $(".firstKindIdSencond")
					.find("option:selected").text();
			var firstKindId = $(".firstKindIdSencond").val();
			var secondKindName = $('.secondKindName').val();
			var secondKindSalaryId = $('.secondKindSalaryId').val();
			var secondKindSaleId = $('.secondKindSaleId').val();
			$.post('updateSecondKind', {
				fskid : fskid,
				secondKindName : secondKindName,
				secondKindSalaryId : secondKindSalaryId,
				firstKindName : firstKindName,
				firstKindId : firstKindId,
				secondKindSaleId : secondKindSaleId
			}, function(data) {
				if (data == 0) {
					alert('修改失败')
				} else {
					alert('修改成功')
					$('#showSecondKind').datagrid('reload');//刷新
				}
			}, 'text');

		};
		////3.修改
		function updateThirdKind() {
			var ftkid = $('.thirdKindftkId').val();
			var firstKindName = $('#cc3').combobox('getText');
			var firstKindId = $('#cc3').combobox('getValue');
			var secondKindName = $('#cc4').combobox('getText');
			var secondKindId = $('#cc4').combobox('getValue');
			var thirdKindName = $('.thirdKindName').val();
			var thirdKindSaleId = $('.thirdKindSaleId').val();
			var thirdKindIsRetail = $('.thirdKindIsRetail').val();
			$.post('updateThirdKind', {
				ftkid : ftkid,
				firstKindName : firstKindName,
				firstKindId : firstKindId,
				secondKindName : secondKindName,
				secondKindId : secondKindId,
				thirdKindSaleId : thirdKindSaleId,
				thirdKindIsRetail : thirdKindIsRetail,
				thirdKindName : thirdKindName
			}, function(data) {
				if (data == 0) {
					alert('修改失败')
				} else {
					alert('修改成功')
					$('#showThirdKind').datagrid('reload');//刷新
				}
			}, 'text');

		};

		//1.删除 
		function deleteFirstKind(id) {
			$.post('deleteFirstKind', {
				ffk_id : id
			}, function(data) {
				if (data == 1) {
					alert('删除成功');
					$('#showFirstKind').datagrid('reload');//刷新
				} else if (data = 0) {
					alert('删除失败')
				}
			});
		}
		//2.删除 
		function deleteSecondKind(id) {
			$.post('deleteSecondKind', {
				fsk_id : id
			}, function(data) {
				if (data == 1) {
					alert('删除成功');
					$('#showSecondKind').datagrid('reload');//刷新
				} else if (data = 0) {
					alert('删除失败')
				}
			});
		}

		//3.删除 
		function deleteThirdKind(id) {
			$.post('deleteThirdKind', {
				ftk_id : id
			}, function(data) {
				if (data == 1) {
					alert('删除成功');
					$('#showThirdKind').datagrid('reload');//刷新
				} else if (data = 0) {
					alert('删除失败')
				}
			});
		}
		///1
		$('#showFirstKind')
				.datagrid(
						{
							url : 'findFirstKindByPage',//goodinfo.action----
							pagination : true,//显示分页工具栏
							pageSize : 2,
							pageList : [ 2, 4, 6 ],
							columns : [ [
									{
										field : 'ffk_id',
										width : 0
									},
									{
										field : 'first_kind_id',
										title : '一级机构编号',
										width : 100
									},
									{
										field : 'first_kind_name',
										title : '一级机构名称',
										width : 100
									},
									{
										field : 'first_kind_salary_id',
										title : '一级机构薪酬发放责任人编号',
										width : 300
									},
									{
										field : 'first_kind_sale_id',
										title : '一级机构销售责任人编号',
										width : 300
									},
									{
										field : 'cz',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											return '<a href="javascript:deleteFirstKind('
													+ row.ffk_id
													+ ')">删除</a> <a href="javascript:alertFirstKind(\''
													+ row.first_kind_name
													+ '\')">修改</a>';
										}
									} ] ]
						});
		//2
		$('#showSecondKind')
				.datagrid(
						{
							url : 'findSecondKindByPage',//goodinfo.action----
							pagination : true,//显示分页工具栏
							pageSize : 2,
							pageList : [ 2, 4, 6 ],
							columns : [ [
									{
										field : 'fsk_id',
										width : 0
									},
									{
										field : 'first_kind_name',
										title : '所属一级机构名称',
										width : 100
									},
									{
										field : 'second_kind_name',
										title : '二级机构名称',
										width : 100
									},
									{
										field : 'second_salary_id',
										title : '二级机构薪酬发放责任人编号',
										width : 200
									},
									{
										field : 'second_sale_id',
										title : '二级机构销售责任人编号',
										width : 200
									},
									{
										field : 'cz',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											return '<a href="javascript:deleteSecondKind('
													+ row.fsk_id
													+ ')">删除</a> <a href="javascript:alertSecondKind('
													+ row.fsk_id + ')">修改</a>';
										}
									} ] ]
						});
		//3
		$('#showThirdKind')
				.datagrid(
						{
							url : 'findThirdKindByPage',//goodinfo.action----
							pagination : true,//显示分页工具栏
							pageSize : 2,
							pageList : [ 2, 4, 6 ],
							columns : [ [
									{
										field : 'ftk_id',
										width : 0
									},
									{
										field : 'first_kind_name',
										title : '所属一级机构名称',
										width : 100
									},
									{
										field : 'second_kind_name',
										title : '所属二级机构名称',
										width : 200
									},
									{
										field : 'third_kind_name',
										title : '三级机构名称',
										width : 100
									},
									{
										field : 'third_kind_sale_id',
										title : '三级机构销售责任人编号',
										width : 200
									},
									{
										field : 'third_kind_is_retail',
										title : '是否为零售店',
										width : 100
									},
									{
										field : 'cz',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											return '<a href="javascript:deleteThirdKind('
													+ row.ftk_id
													+ ')">删除</a> <a href="javascript:alertThirdKind('
													+ row.ftk_id + ')">修改</a>';
										}
									} ] ]
						});
		//公共字段显示 
		$('#showConfigPublicChar')
				.datagrid(
						{
							url : 'findConfigPublicCharsByPage',//goodinfo.action----
							pagination : true,//显示分页工具栏
							pageSize : 2,
							pageList : [ 2, 4, 6 ],
							columns : [ [
									{
										field : 'pbc_id',
										width : 0
									},
									{
										field : 'attribute_kind',
										title : '所属一级机构名称',
										width : 100
									},
									{
										field : 'attribute_name',
										title : '所属二级机构名称',
										width : 200
									},
									{
										field : 'cz',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											return '<a href="javascript:deleteConfigPublicChar('
													+ row.pbc_id + ')">删除</a>';
										}
									} ] ]
						});
		//公共字段删除 
		function deleteConfigPublicChar(id) {
			$.post('deleteConfigPublicChar', {
				pbc_id : id
			}, function(data) {
				if (data == 1) {
					alert('删除成功');
					$('#showConfigPublicChar').datagrid('reload');//刷新
				} else if (data = 0) {
					alert('删除失败')
				}
			});
		}
	</script>
</body>
</html>
