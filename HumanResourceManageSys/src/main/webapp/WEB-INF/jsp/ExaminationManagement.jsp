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
			<table id="find1"></table>
		</form>
	</div>
</div>
<script type="text/javascript">
$('#find1').datagrid({   
    url:'findEngageInterviewByPage',  
    pagination:true,
    columns:[[   
		{field:'resume_id',title:'档案编号',width:100,hidden:true},       
        {field:'human_name',title:'姓名',width:100},   
        {field:'human_major_kind_name',title:'职位分类名称',width:100,align:'right'}, 
        {field:'human_major_kind_id',title:'职位分类名称',width:100,align:'right',hidden:true}, 
        {field:'human_major_id',title:'职位分类名称',width:100,align:'right',hidden:true}, 
        {field:'human_major_name',title:'职位名称',width:100,align:'right',hidden:true}, 
        {field:'cz',title:'答题',width:100,
        	formatter: function(value,row,index){
        		return '<a href="javascript:addInfoPost('+row.resume_id+','+row.human_major_kind_id+','+
        			human_major_id+')">答题</a>';
			}
		} 
    ]]   
}); 
function addInfoPost(id,fid,sid){
	var tab = $('#tt').tabs('getSelected');  
	$('#tt').tabs('update', {
        tab: tab,
        options: {
        	content : '<iframe scrolling="auto" frameborder="0"  src="toAnswareQuestion?id='+id+
        					'&majorkindid='+fid+'&majorid='+sid+'" style="width:1000px;height:400px;"></iframe>',
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
