<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<body>
<div id="tt" class="easyui-tabs">
	<div title="推荐面试简历查询">
		<table id="find"></table>
	</div>
	<div title="面试筛选">
		<table id="find1"></table>
	</div>
</div>
<script type="text/javascript">
$('#find').datagrid({   
    url:'findEngageResumeByPageUseful',  
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
$('#find1').datagrid({   
    url:'findEngageInterviewByPage',  
    pagination:true,
    queryParams: {
		op:"op"
	},
    columns:[[   
		{field:'resume_id',title:'档案编号',width:100,hidden:true},       
        {field:'human_name',title:'姓名',width:100},   
        {field:'human_major_kind_name',title:'职位分类名称',width:100,align:'right'}, 
        {field:'human_major_name',title:'职位名称',width:100,align:'right'}, 
        {field:'image_degree',title:'形象等级',width:100},   
        {field:'native_language_degree',title:'口才等级',width:100,align:'right'}, 
        {field:'foreign_language_degree',title:'外语水平等级',width:100,align:'right'}, 
        {field:'response_speed_degree',title:'应变能力',width:100},
        {field:'EQ_degree',title:'EQ等级',width:100},   
        {field:'IQ_degree',title:'IQ_等级',width:100,align:'right'}, 
        {field:'multi_quality_degree',title:'综合素质',width:100,align:'right'}, 
        {field:'interview_comment',title:'面试评价',width:100},  
        {field:'cz',title:'面试筛选',width:100,
        	formatter: function(value,row,index){
        		return '<a href="javascript:findByResumeId('+row.resume_id+')">筛选</a>';
			}
		} 
    ]]   
}); 
function findByResumeId(id){
	var tab = $('#tt').tabs('getSelected');  // get selected panel
	$('#tt').tabs('update', {
		tab: tab,
		options: {
			content : '<iframe scrolling="auto" frameborder="0"  src="toInterviewScreening/'+id+'" style="width:1400px;height:400px;"></iframe>',
		}
	});
}
function findById(id){
	var tab = $('#tt').tabs('getSelected');  // get selected panel
	$('#tt').tabs('update', {
		tab: tab,
		options: {
			content : '<iframe scrolling="auto" frameborder="0"  src="toInterviewRegistration/'+id+'" style="width:1400px;height:400px;"></iframe>',
		}
	});
}
</script>
</body>
