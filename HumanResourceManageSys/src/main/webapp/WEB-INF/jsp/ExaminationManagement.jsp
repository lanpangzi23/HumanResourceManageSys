<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<div id="tt" class="easyui-tabs">
	<div title="考试出题">
		<p>您正在做的业务是:人力资源--招聘管理--招聘考试管理--考试出题</p>
		<input type="button" onClick="chuTi()" value="出题">
		<table id="findByExam"></table>
	</div>
	<div title="考试答题">
		<p>您正在做的业务是:人力资源--招聘管理--招聘考试管理--考试答题</p>
		<form id="answareQuestion">
			<input type="button" onClick="addInfoPost()" value="提交"><input type="button" onClick="chuTi()" value="清除">
			<table>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="human_name"/></td>
					<td>身份证号码</td>
					<td><input type="text" name="human_idcard"/></td>
				</tr>
				<tr>
					<td>职位分类</td>
					<td>
						<input name="human_major_kind_id" id="aa1"  class="easyui-combobox"
							data-options="   
				        			valueField: 'major_kind_id',
			        				textField: 'major_kind_name',
			        				url: 'findAllConfigMajorKind',
			        				onSelect: function(rec){
			        					$('#human_major_kind_name').val(rec.major_kind_name);
				            			var url = 'selectConfigMajorByKind?major_kind_id='+rec.major_kind_id;
				            			$('#aa2').combobox('reload', url);
			        		}" />
					<input name="human_major_kind_name" type="hidden"  id="human_major_kind_name"  />
				</td>
				<td>职位名称</td>
				<td>
					<input name="human_major_name" id="human_major_name" type="hidden" />
					<input name="human_major_id" id="aa2"  class="easyui-combobox"
						data-options="
 							valueField:'major_id', 
 							textField:'major_name',onSelect: function(rec){
		        				$('#human_major_name').val(rec.major_name);
		        		}" />
		        </td>
				</tr>
			</table>
		</form>
	</div>
</div>
<script type="text/javascript">
function addInfoPost(){
	var id=$('input[name="human_idcard"]').val();
	var major_kind_id=$('input[name="human_major_kind_id"]').val();
	var major_id=$('input[name="human_major_id"]').val();
	var name=$('input[name="human_name"]').val();
	var tab = $('#tt').tabs('getSelected');  
	$('#tt').tabs('update', {
        tab: tab,
        options: {
        	content : '<iframe scrolling="auto" frameborder="0"  src="toAnswareQuestion?id='+id+
        					'&majorkindid='+major_kind_id+'&majorid='+major_id+
        					'&name='+name+'" style="width:1000px;height:400px;"></iframe>',
        }
   });
}
function chuTi(){
	var tab = $('#tt').tabs('getSelected');  
	$('#tt').tabs('update', {
		tab: tab,
		options: {
			content : '<iframe scrolling="auto" frameborder="0"  src="toAddEngageExam" style="width:1000px;height:400px;"></iframe>',
		}
	});
}
$('#findByExam').datagrid({   
	url:'findByExam',  
	pagination:true,
    columns:[[   
		{field:'major_kind_id',title:'职位分类编号',width:100}, 
		{field:'major_kind_name',title:'职位分类名称',width:100}, 
		{field:'major_id',title:'职位编号',width:100}, 
		{field:'major_name',title:'职位名称',width:100},   
		{field:'count',title:'套题数量',width:100}
	]]   
}); 
</script>
</body>
