<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<body>
<div id="tt" class="easyui-tabs" style="width: 100%; height: 100%;">
	<div title="试题一级分类设置" style="padding: 20px; display: none;">
		<a id="add" href="javascript:addInfo()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a><br>
		<table id="questionfirstInfo"></table>
		<div id="win1" style="display: none">
			<br><br><label style="margin-left: 50px;">一级机构试题名字：<input type="text" name="first_kind_name1"/></label><br><br>
			<input style="margin-left: 150px;" type="button" onClick="addPost()" value="添加">
		</div>
		<div id="win2" style="display: none">
			<br><label style="margin-left: 50px;">一级机构试题名字：<input type="text" id="first_kind_name"/><input type="hidden" id="first_kind_id"/></label><br>
			<input style="margin-left: 150px;" type="button" onClick="updatePost()" value="添加">
		</div>
	</div>
	<div title="试题二级分类设置" style="padding: 20px; display: none;">
		<a id="add" href="javascript:addInfoSecond()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a><br>
		<table id="questionsecondInfo"></table>
		<div id="win3" style="display: none">
			<form id="add_form">
				<br><br><label style="margin-left: 50px;">一级机构试题名字：
					<input type="hidden" name="first_kind_name" class="first_kind_name"/>
					<input style="width: 100px;" name="first_kind_id" id="aa1"  class="easyui-combobox"
						data-options="   
			        			valueField: 'first_kind_id',
		        				textField: 'first_kind_name',
		        				url: 'ConfigQuestionFirstKind',
		        				onSelect: function(rec){
		        					$('.first_kind_name').val(rec.first_kind_name);
		        		}" />
				</label><br><br>
				<label style="margin-left: 50px;">二级机构试题名字：<input type="text" name="second_kind_name"/></label><br><br>
				<input style="margin-left: 150px;" type="button" onClick="addPostSecond()" value="添加">
			</form>
		</div>
		<div id="win2" style="display: none">
			<br><label style="margin-left: 50px;">一级机构试题名字：<input type="text" id="first_kind_name"/><input type="hidden" id="first_kind_id"/></label><br>
			<input style="margin-left: 150px;" type="button" onClick="updatePost()" value="添加">
		</div>
	</div>
</div>
<script type="text/javascript">
function addPost(){
	var name=$('input[name="first_kind_name1"]').val();
	$.post('addFirstQuestion',{name:name},function(data){
		$('#win1').window('close');
		$('#questionfirstInfo').datagrid('reload');
	})
}
function addPostSecond(){
	$("#add_form").ajaxSubmit({
        success: function (data) {
            alert(data);
            $('#win3').window('close');
    		$('#questionsecondInfo').datagrid('reload');
        },
        error: function (error) { alert('登记失败 ...'); },
            url: 'addSecondQuestion', /*设置post提交到的页面*/
            type: "post", /*设置表单以post方法提交*/
            dataType: "text" /*设置返回值类型为文本*/
    });
}
function updatePost(){
	var id=$('#first_kind_id').val();
	var name=$('#first_kind_name').val();
	$.post('updateFirstQuestion',{name:name,id:id},function(data){
		alert(data);
		$('#win2').window('close');
		$('#questionfirstInfo').datagrid('reload');
	})
}
function addInfo(){
	$('#win1').window({
		title:'一级试题添加',
		width:400,
		height:200
	});
}
function addInfoSecond(){
	$('#win3').window({
		title:'一级试题添加',
		width:400,
		height:200
	});
}
function update(id,name){
	$('#win2').window({
		title:'一级试题修改',
		width:400,
		height:200
	});
	$('#first_kind_id').val(id);
	$('#first_kind_name').val(name);
}
function remove(id){
	$.post('deleteFirstQuestion',{id:id},function(data){
		alert(data);
		$('#questionfirstInfo').datagrid('reload');
	})
}
$('#questionfirstInfo').datagrid({   
	pageSize:5,
	pageList:[5,10,15,20],
    url:'findConfigQuestionFirstKind',  
    pagination:true,
    columns:[[   
        {field:'first_kind_id',title:'试题一级分类编号',width:100},   
        {field:'first_kind_name',title:'试题一级分类名称',width:100},
        {field:'cz1',title:'删除',width:100,formatter:function(value,row,index){
        	return '<a href="javascript:remove(\''+row.first_kind_id+'\')" ">删除</a>';
        }},
        {field:'cz2',title:'修改',width:100,formatter:function(value,row,index){
        	return '<a id="update" href="javascript:update(\''+row.first_kind_id+'\',\''+row.first_kind_name+'\')">修改</a>';
        }}
    ]]   
}); 
$('#questionsecondInfo').datagrid({   
	pageSize:5,
	pageList:[5,10,15,20],
    url:'findConfigQuestionSecondKind',  
    pagination:true,
    columns:[[   
        {field:'first_kind_id',title:'试题一级分类编号',width:100},   
        {field:'first_kind_name',title:'试题一级分类名称',width:100},
        {field:'second_kind_id',title:'试题二级分类编号',width:100},   
        {field:'second_kind_name',title:'试题二级分类名称',width:100},
        {field:'cz1',title:'删除',width:100,formatter:function(value,row,index){
        	return '<a href="javascript:remove(\''+row.first_kind_id+'\')" ">删除</a>';
        }},
        {field:'cz2',title:'修改',width:100,formatter:function(value,row,index){
        	return '<a id="update" href="javascript:update(\''+row.first_kind_id+'\',\''+row.first_kind_name+'\')">修改</a>';
        }}
    ]]   
}); 
</script>
</body>
