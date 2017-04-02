<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<body>
<div id="tt" class="easyui-tabs" style="width: 100%; height: 100%;">
	<div title="试题一级分类设置" style="padding: 20px; display: none;">
		<table id="questionfirstInfo"></table>
	</div>
</div>
<script type="text/javascript">
$('#questionfirstInfo').datagrid({   
    url:'findConfigQuestionFirstKind',  
    pagination:true,
    queryParams: {
		op:"op"
	},
    columns:[[   
		{field:'res_id',title:'档案编号',width:100,hidden:true},       
        {field:'human_name',title:'姓名',width:100},   
        {field:'engage_type',title:'招聘类型',width:100},   
        {field:'human_major_kind_name',title:'职位分类名称',width:100,align:'right'}, 
        {field:'human_major_name',title:'职位名称',width:100,align:'right'}, 
        {field:'human_mobilephone',title:'手机号码',width:100},   
        {field:'cz',title:'面试登记',width:100,
        	formatter: function(value,row,index){
        		return '<a href="javascript:findById('+row.res_id+')">登记</a>';
			}
		} 
    ]]   
}); 
</script>
</body>
