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
    			<td><input type="text" class="firstKindName" value=""></td>
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
    		<tr>
    			<td colspan="2"><input type="button" onclick="addFindKind()" value="添加" style="float: right;"></td>
    		</tr>
    	</table> 
    	</form>
    	</center>
    		<div id="showFirstKind"></div>
    		<div id="add_gb"></div>
    </div> 
    
    
    <div title="二级机构设置" style="padding:20px;display:none;"> 
    	<table id="salaryNameTable">
    		<tr>
    			<td>薪酬项目名称</td>
    		</tr>
    		<c:forEach items="${salaryName }" var="s" varStatus="ss">
    		<tr>
    			<td><input type="text" name="attribute_name" value="${s.attribute_name }"/></td>
    			<td>
    				<a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" href="javascript:delName(${s.pbc_id })">Remove</a>&nbsp;&nbsp;&nbsp;
    				<a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" href="javascript:reName(${s.pbc_id },${ss.index })">Rename</a>
    			</td>
    		</tr>
    		</c:forEach>
    		<tr id="addSalaryName">
    			<td><a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-add'" href="javascript:addSalaryName()">Add</a></td>
    		</tr>
    	</table> 
    		<div id="showMainmenu"></div>
    </div>   
    
    
     <div title="三级机构设置" style="padding:20px;display:none;"> 
    	<table id="salaryNameTable">
    		<tr>
    			<td>薪酬项目名称</td>
    		</tr>
    		<c:forEach items="${salaryName }" var="s" varStatus="ss">
    		<tr>
    			<td><input type="text" name="attribute_name" value="${s.attribute_name }"/></td>
    			<td>
    				<a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" href="javascript:delName(${s.pbc_id })">Remove</a>&nbsp;&nbsp;&nbsp;
    				<a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" href="javascript:reName(${s.pbc_id },${ss.index })">Rename</a>
    			</td>
    		</tr>
    		</c:forEach>
    		<tr id="addSalaryName">
    			<td><a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-add'" href="javascript:addSalaryName()">Add</a></td>
    		</tr>
    	</table> 
    		<div id="showMainmenu"></div>
    </div>   
</div>
<script type="text/javascript">
$('#showFirstKind').datagrid({
	url:'findFirstKind',//goodinfo.action----
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
	        	  return '<a href="javascript:deleteFirstKind('+row.ffk_id+')">删除</a> <a href="javascript:updateFirstKind('+row.ffk_id+')">修改</a>';
	          }}
	     ]]
});
$('#showSecondKind').datagrid({
	url:'../GoodTypeServlet.action',//goodinfo.action----
	queryParams:{op:'findMenuByPage'},
	pagination:true,//显示分页工具栏
	pageSize:2,
	pageList:[2,4,6],
	columns:[[
	          {field:'ck',checkbox:true,width:100},
	          {field:'t_id',title:'二级机构编号',width:100},
	          {field:'t_name',title:'二级机构名称',width:100},
	          {field:'t_parent',title:'二级机构薪酬发放责任人编号',width:100},
	          {field:'t_disc',title:'二级机构销售责任人编号',width:100},
	     ]]
});
$('#showThirdKind').datagrid({
	url:'../GoodTypeServlet.action',//goodinfo.action----
	queryParams:{op:'findMenuByPage'},
	pagination:true,//显示分页工具栏
	pageSize:2,
	pageList:[2,4,6],
	columns:[[
	          {field:'ck',checkbox:true,width:100},
	          {field:'t_id',title:'三级机构编号',width:100},
	          {field:'t_name',title:'三级机构名称',width:100},
	          {field:'t_parent',title:'三级机构薪酬发放责任人编号',width:100},
	          {field:'t_disc',title:'三级机构销售责任人编号',width:100},
	     ]]
});
////修改 
function updateFirstKind(id){
		alert(id)
		$('#add_gb').dialog({
			title:'一级机构信息修改',
			width:600,
			height:500,
			closed:false,
			cache:false,
			href:'updateFirstKind',
			modal:true,
			queryParams:{first_kind_id:id}
		});
		
	};

//删除 
function deleteFirstKind(id){
	alert(id)
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
				alert('菜单已存在，请勿重复添加！');var Mainmenu=$('.Mainmeu').val();
				$('.Mainmeu').val('');
				$('.Child').val('');
				$('.dis').val('');
			}
		},'text');
}
	

</script>
</body>
</html>
    