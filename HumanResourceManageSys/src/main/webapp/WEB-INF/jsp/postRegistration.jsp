<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<div id="tt" class="easyui-tabs" style="width:100%px;height:100%px;">  
    <div title="职位发布登记" style="padding:20px;display:none;" data-options="iconCls:'icon-reload'">  
    <form id="upload_form">
        <p>您正在做的业务是:人力资源--招聘管理--职位发布管理--职位发布登记</p>
		<input class="submit" type="button" value="提交" /><input type="button" value="返回" />
		<table border="1" bordercolor="#CCCCCC"  cellpadding="0" cellspacing="0">
		<tr>
			<td style="width: 80px;">I级机构</td>
			<td><input name="first_kind_id" id="cc1" class="easyui-combobox" style="width: 100px;"
				data-options="   
			        valueField: 'first_kind_id',
		        	textField: 'first_kind_name',
		        	url: 'findAllFirstKind',
		        	onSelect: function(rec){
		        		$('#first_kind_name').val(rec.first_kind_name);
			            var url = 'findSecondKindByFirst?first_kind_id='+rec.first_kind_id;
			            $('.cc2').combobox('reload', url);
		        }" />
		        <div style="display:none;"> <input name="first_kind_name" id="first_kind_name"/></div>
		       </td>
			<td style="width: 80px;">II级机构</td>
			<td><input name="second_kind_id" id="cc2" class="easyui-combobox cc2" style="width: 100px;"
					data-options="
 					valueField:'second_kind_id', 
 					textField:'second_kind_name',
 		        	onSelect: function(rec){ 
 		        		$('#second_kind_name').val(rec.second_kind_name);
 			            var url = 'findThirdKindBySecondKindId?second_kind_id='+rec.second_kind_id;
			            $('.cc3').combobox('reload', url); 
 				}" />
 				<div style="display:none;"> <input name="second_kind_name" id="second_kind_name"/></div>
 				 </td>
			<td style="width: 80px;">III级机构</td>
			<td><input  name="third_kind_id"  style="width: 100px;" id="cc3" class="easyui-combobox cc3" data-options="valueField:'third_kind_id',textField:'third_kind_name',
			onSelect: function(rec){ 
 		        		$('#third_kind_name').val(rec.third_kind_name);
 				}" />
			<div style="display:none;"> <input name="third_kind_name" id="third_kind_name"/></div>
			</td>
			<td style="width: 80px;">招聘类型</td>
			<td><select id="cc" class="easyui-combobox" name="engage_type" style="width:100px;">  
			    <option>社会招聘</option>  
			    <option>校园招聘</option>  
			</select></td>
		</tr>
		<tr>
			<td>职位分类</td>
			<td><input name="major_kind_id" id="aa1" class="easyui-combobox" style="width: 100px;"
				data-options="   
			        valueField: 'major_kind_id',
		        	textField: 'major_kind_name',
		        	url: 'findAllConfigMajorKind',
		        	onSelect: function(rec){
		        		$('#human_major_kind_name').val(rec.major_kind_name);
			            var url = 'selectConfigMajorByKind?major_kind_id='+rec.major_kind_id;
			            $('.aa2').combobox('reload', url);
		        }" /><div style="display:none;"> <input name="major_kind_name" id="human_major_kind_name"/></div></td>
			<td>职位名称</td>
			<td><input name="major_id" id="aa2" class="easyui-combobox aa2" style="width: 100px;"
					data-options="
 					valueField:'major_id', 
 					textField:'major_name',
 					onSelect: function(rec){ 
 		        		$('#human_major_name').val(rec.major_name);
 				}" />
 					<div style="display:none;"> <input name="major_name" id="human_major_name"/></div></td>
			<td>招聘人数</td>
			<td><input name="human_amount" type="text" style="width: 100px;"></td>
			<td>截止日期</td>
			<td><input id="dd" type="text" class="easyui-datebox" style="width: 100px;" required="required"></input>
			<input id="deadline" type="hidden" style="width: 100px;" name="deadline"></input></td>
		</tr>
		<tr>
			<td>登记人</td>
			<td><input type="text" name="register" style="width: 100px;"></td>
			<td>登记时间</td>
			<td><input type="text" name="regist_time" readonly="true" value="<%=new Date() %>" style="width: 100px;"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height: 100px;">
			<td>职位描述</td>
			<td colspan="7"><textarea name="major_describe" style="width: 700px; height: 80px;"></textarea></td>
		</tr>
		<tr style="height: 100px;">
			<td>招聘要求</td>
			<td colspan="7"><textarea name="engage_required" style="width: 700px; height: 80px;"></textarea></td>
		</tr>
	</table>
	</form>  
    </div>  
    <div title="职位发布变更" data-options="iconCls:'icon-reload'" style="padding:20px;display:none;">  
       <table id="dg"></table>
    </div>  
    <div title="职位发布查询" data-options="iconCls:'icon-reload'" style="padding:20px;display:none;">  
        tab3   
    </div>  
</div> 
<script type="text/javascript">
$('#dg').datagrid({   
    url:'findEngageMajor',  
    pagination:true,
    pageSize:10,
    columns:[[   
        {field:'major_name',title:'职位名称',width:100},   
        {field:'second_kind_name',title:'机构名称',width:100},   
        {field:'human_amount',title:'招聘人数',width:100} ,
        {field:'regist_time',title:'发布时间',width:100},   
        {field:'deadline',title:'截止时间',width:150},   
        {field:'cz1',title:'修改',width:100,
        	formatter : function(value, row, index) {
				return '   <a href="javascript:update(\''+ row.major_name + '\')">修改</a>';
			}} ,
        {field:'cz2',title:'删除',width:100,
				formatter : function(value, row, index) {
					return '   <a href="javascript:deleteMajorName(\''+ row.major_name + '\')">删除</a>';
				}} 
    ]]   
}); 
function update(name){
	var pp=$('#tt').tabs('getSelected');
	pp.panel('options').tab.href("");
}
function deleteMajorName(name){
	alert(name);
}
$(document).ready(function(){
	$("#dd").datebox({
		required:true,
		onSelect:function(date){
			$('#deadline').val(date);
		}
	});
})
$(".submit").click(function() {
	$("#upload_form").ajaxSubmit({
		success : function(data) {
			alert(data);
		},
		error : function(error) {
			alert(error);
		},
		url : 'addEngageMajor', /*设置post提交到的页面*/
		type : "post", /*设置表单以post方法提交*/
		dataType : "text" /*设置返回值类型为文本*/
	});
});
</script>
</body>
