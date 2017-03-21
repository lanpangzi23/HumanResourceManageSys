<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>薪酬标准登记</title>
</head>

<body>
<div id="tt" class="easyui-tabs" style="width:100%;height:100%;">  
    <div title="一级机构设置" style="padding:20px;display:none;"> 
    <center>
    <form>
    	<table id="salaryNameTable">
    		<tr>
    			<td>一级机构名称:</td>
    			<td>
    			<input type="text" class="firstKindffkId" value="" hidden="hidden"/>
    			<input type="text" class="firstKindName" value=""></td>
    		</tr>
    		<tr>
    			<td>一级机构薪酬发放责任人:</td>
    			<td><select type="text" class="firstKindSalaryId" style="width: 150px;" >
    				<option value="1001">薪酬经理</option>
    				<option value="1002">薪酬专员</option>
    			</select></td>
    		</tr>
    		<tr>
    			<td>一级机构销售责任人:</td>
    			<td><select type="text" class="firstKindSaleId"  style="width: 150px;">
    				<option value="10001">销售经理</option>
    				<option value="10002">销售专员</option>
    			</select></td>
    		</tr>
    		<br/><br/><br/>
    	</table> 
    	</form>
    	</center>
    	<br/>
    		<br/>
    		<input type="button" onclick="updateFirstKind()" value="确认修改" style="float: right;">
    		<input type="button" onclick="addFindKind()" value="添加" style="float: right;">
    		<br/><br/>
    		<div id="showFirstKind"></div>
    		<div id="alertFirstKind"></div>
    </div> 
    
    
    <div title="二级机构设置" style="padding:20px;display:none;"> 
    	 <center>
    <form>
    	<table id="salaryNameTable">
    		<tr>
    			<td>一级机构名称:</td>
    			<td><select type="text" class="firstKindSaleId"  style="width: 150px;">
    				<option value="10001">销售经理</option>
    				<option value="10002">销售专员</option>
    			</select>
    			</td>
    			
    		</tr>
    		<tr>
    			<td>二级机构名称:</td>
    			<td>
    			<input type="text" class="firstKindffkId" value="" hidden="hidden"/>
    			<input type="text" class="firstKindName" value=""></td>
    		</tr>
    		<tr>
    			<td>一级机构薪酬发放责任人:</td>
    			<td><select type="text" class="firstKindSalaryId" style="width: 150px;" >
    				<option value="1001">薪酬经理</option>
    				<option value="1002">薪酬专员</option>
    			</select></td>
    		</tr>
    		<tr>
    			<td>一级机构销售责任人:</td>
    			<td><select type="text" class="firstKindSaleId"  style="width: 150px;">
    				<option value="10001">销售经理</option>
    				<option value="10002">销售专员</option>
    			</select></td>
    		</tr>
    		<br/>
    		<br/>
    		<br/>
    		
    	</table> 
    	</form>
    	</center>
    	<br/>
    		<br/>
    		<input type="button" onclick="updateFirstKind()" value="确认修改" style="float: right;">
    		<input type="button" onclick="addFindKind()" value="添加" style="float: right;">
    		<br/>
    		<br/>
    		
    		
    		<div id="showSecondKind"></div>
    		<div id="alertSecondKind"></div>
    </div>   
    
    
     <div title="三级机构设置" style="padding:20px;display:none;"> 
    	 <center>
    <form>
    	<table id="salaryNameTable">
    		<tr>
    			<td>一级机构名称:</td>
    			<td>
    			<input type="text" class="firstKindffkId" value="" hidden="hidden"/>
    			<input type="text" class="firstKindName" value=""></td>
    		</tr>
    		<tr>
    			<td>一级机构薪酬发放责任人:</td>
    			<td><select type="text" class="firstKindSalaryId" style="width: 150px;" >
    				<option value="1001">薪酬经理</option>
    				<option value="1002">薪酬专员</option>
    			</select></td>
    		</tr>
    		<tr>
    			<td>一级机构销售责任人:</td>
    			<td><select type="text" class="firstKindSaleId"  style="width: 150px;">
    				<option value="10001">销售经理</option>
    				<option value="10002">销售专员</option>
    			</select></td>
    		</tr>
    		<br/>
    		<br/>
    		<br/>
    		
    	</table> 
    	</form>
    	</center>
    	<br/>
    		<br/>
    		<input type="button" onclick="updateFirstKind()" value="确认修改" style="float: right;">
    		<input type="button" onclick="addFindKind()" value="添加" style="float: right;">
    		<br/>
    		<br/>
    		
    		
    		<div id="showThirdKind"></div>
    		<div id="alertThirdKind"></div>
    </div>   
</div>
<script type="text/javascript">
$('#showFirstKind').datagrid({
	url:'findFirstKindByPage',//goodinfo.action----
	pagination:true,//显示分页工具栏
	pageSize:2,
	pageList:[2,4,6],
	columns:[[
	          {field:'ffk_id',width:0},
	          {field:'first_kind_id',title:'一级机构编号',width:100},
	          {field:'first_kind_name',title:'一级机构名称',width:100},
	          {field:'first_kind_salary_id',title:'一级机构薪酬发放责任人编号',width:300},
	          {field:'first_kind_sale_id',title:'一级机构销售责任人编号',width:300},
	          {field:'cz',title:'操作',width:100,formatter:function(value,row,index){
	        	  return '<a href="javascript:deleteFirstKind('+row.ffk_id+')">删除</a> <a href="javascript:alertFirstKind(\''+row.first_kind_name+'\')">修改</a>';
	          }}
	     ]]
});
$('#showSecondKind').datagrid({
	url:'findSecondKindByPage',//goodinfo.action----
	pagination:true,//显示分页工具栏
	pageSize:2,
	pageList:[2,4,6],
	columns:[[
			  {field:'fsk_id',width:0},
	          {field:'first_kind_name',title:'所属一级机构名称',width:100},
	          {field:'second_kind_name',title:'二级机构名称',width:100},
	          {field:'second_salary_id',title:'二级机构薪酬发放责任人编号',width:200},
	          {field:'second_sale_id',title:'二级机构销售责任人编号',width:200}
	     ]]
});
$('#showThirdKind').datagrid({
	url:'findThirdKindByPage',//goodinfo.action----
	pagination:true,//显示分页工具栏
	pageSize:2,
	pageList:[2,4,6],
	columns:[[
				{field:'ftk_id',width:0},
				{field:'first_kind_name',title:'所属一级机构名称',width:100},
				{field:'second_kind_name',title:'所属二级机构名称',width:200},
				{field:'third_kind_name',title:'三级机构名称',width:100},
				{field:'third_kind_sale_id',title:'三级机构销售责任人编号',width:200},
				{field:'third_kind_is_retail',title:'是否为零售店',width:100}
	     ]]
});
////修改前显示 
function alertFirstKind(first_kind_name){
	$.post('findFirstKindByName',{first_kind_name:first_kind_name},function(data){
		$('.firstKindffkId').val(data[0].ffk_id);
		$('.firstKindName').val(data[0].first_kind_name);
		$('.firstKindSalaryId').val(data[0].first_kind_salary_id);
		$('.firstKindSaleId').val(data[0].first_kind_sale_id);
	},'json');
		
};

////修改
function updateFirstKind(){
	var fkkid=$('.firstKindffkId').val();
	var firstKindName =$('.firstKindName').val();
	var firstKindSalaryId=$('.firstKindSalaryId').val();
	var firstKindSaleId=$('.firstKindSaleId').val();
	$.post('updateFirstKind',{fkkid:fkkid,firstKindName:firstKindName,firstKindSalaryId:firstKindSalaryId,firstKindSaleId:firstKindSaleId},function(data){
		if(data==0){
			alert('修改失败')
		}else{
			alert('修改成功')
			$('#showFirstKind').datagrid('reload');//刷新
		}
	},'text');
		
};

	

//删除 
function deleteFirstKind(id){
	$.post('deleteFirstKind',{ffk_id:id},function(data){
		if(data==1){
			alert('删除成功');
			$('#showFirstKind').datagrid('reload');//刷新
		}else if(data=0){
			alert('删除失败')
		}
	});
}

//添加 
function addFindKind(){//菜单添加  
	var firstKindName=$('.firstKindName').val();
	var firstKindSalaryId=$('.firstKindSalaryId').val();
	var firstKindSaleId=$('.firstKindSaleId').val();
		$.post('addFirstKind',{firstKindName:firstKindName,firstKindSalaryId:firstKindSalaryId,firstKindSaleId:firstKindSaleId},function(data){
			if(data==1){
				alert('添加成功');
				$('.firstKindName').val('');
				$('.firstKindSalaryId').val('');
				$('.firstKindSaleId').val('');
				$('#showFirstKind').datagrid('reload');//刷新
			}else if(data==0){
				alert('添加失败');
			}else if(data==2){
				alert('一级机构名称已存在，请勿重复添加！');var Mainmenu=$('.Mainmeu').val();
				$('.firstKindName').val('');
				$('.firstKindSalaryId').val('');
				$('.firstKindSaleId').val('');
			}
		},'text');
}
	

</script>
</body>
</html>
    