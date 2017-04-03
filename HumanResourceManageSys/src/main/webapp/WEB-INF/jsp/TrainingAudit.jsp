<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>   
<%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--激励管理--培训审核</p><br/>

   <input class="easyui" type="button" style=" background:#CFC;" value="确认" onclick="training()"/>
<input class="easyui" type="button" style=" background:#CFC;" value="返回" onclick="backCheck()"/>
<br/><br/>
   <table border="1" width="1000px" cellpadding="0" cellspacing="0" id="dg">

		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">档案编号</td>
			<td colspan="5" ><input type="text" id="human_id" name="human_id" value="${training.human_id} " readonly="true"/></td>
			<td class="backcolor" style="text-align:center">成绩等级</td>
			<td ><select id="training_degree" name="training_degree" style="width:100px"></select></td>
		</tr>
        <tr style="height:35px;">
            <td class="backcolor" style="text-align:center">姓名</td>
			<td ><input type="text" name="human_name" value=" ${training.human_name} " readonly="true"/></td>
			<td class="backcolor" style="text-align:center">培训项目</td>
			<td ><input type="text" name="human_name" value=" ${training.training_item} " readonly="true"/></td>
            <td class="backcolor" style="text-align:center">培训时间</td>
			<td ><input type="text" name="human_name" value=" ${training.training_time} " readonly="true"/></td>
			<td class="backcolor" style="text-align:center">培训课时</td>
			<td ><input type="text" name="human_name" value=" ${training.training_hour} " readonly="true"/></td>

		</tr>
          
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">登记人</td>
			<td ><input class="easyui" type="text" id="I" name="register" value="${training.register} " readonly="true"></td>
            <td class="backcolor" style="text-align:center">登记时间</td>
			<td ><input class="easyui" type="text" id="I" name="regist_time" value="${training.regist_time }" readonly="true"></td>
           <td class="backcolor" style="text-align:center">复核人</td>
			<td ><input class="easyui" type="text" id="I" name="checker" value="海绵宝宝" readonly="true"></td>
            <td class="backcolor" style="text-align:center">复核时间</td>
              <%SimpleDateFormat da=new SimpleDateFormat("YYYY-MM-dd HH:mm");
				String dd=da.format(new Date());
			%>
			<td ><input class="easyui" type="text" id="I" name="check_time" value="<%=dd %>" readonly="true"></td>
          </tr>
          
           <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">备注</td>
			<td colspan="7" ><textarea style="width:800px;" name="remark" >${training.remark } </textarea></td>
        </table>
<script type="text/javascript">
function backCheck(){
	$('#main_panel').panel('refresh',"admin/TrainingAuditFind");
}
function training(){
	var id=$('input[name="human_id"]').val();
	var checker=$('input[name="checker"]').val();
	var check_time=$('input[name="check_time"]').val();
	var degree= document.getElementById("training_degree").value;
	alert(degree);
	$('#main_panel').panel('refresh',"training/"+id+"/"+checker+"/"+check_time+"/"+degree);
}

$.ajax({
    type:"get",
    url:"finddegree", 
    success:function(data){
   	 var degree = data.data[0];
        $.each(data.data, function(i, item) {  
            var option = '<option code='+item.attribute_name+' value="'+item.attribute_name+'">'+item.attribute_name+'</option>';
            $('#training_degree').append(option);
        })
        $('#training_degree option[value='+degree.attribute_name+']').attr("selected","true"); //当前职位分类默认选中
             }
});

function toreturn(){
	$('#dg').datagrid({   
	    url:'findTrainingPages',  
	    pagination:true,
	    pageSize:10,
	    columns:[[   
	        {field:'human_id',title:'档案编号',width:100},   
	        {field:'human_name',title:'姓名',width:100},   
	        {field:'training_item',title:'培训项目',width:100} ,
	        {field:'training_time',title:'培训时间',width:150},   
	        {field:'training_hour',title:'培训课时',width:150},   
	        {field:'register',title:'登记人',width:100} ,
	        {field:'regist_time',title:'登记时间',width:150} ,
	        {field:'cz',title:'操作', width:80,
	        	formatter : function(value, row, index) {
					return "<a href='javascript:findByDetails(\""
							+ row.human_id +"\")'>培训成绩等级</a>";
				}
	        }
	    ]]   
	}); 

}
</script> 
</body>
</html>
