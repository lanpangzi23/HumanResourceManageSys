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
<p style="color:#00F">您正在做的业务是：人力资源--调动管理--调动审核</p><br/>

<input class="easyui" type="radio" name="status" value="0" style="margin-left:795px; background:#CFC;"/>未通过
<input class="easyui" type="radio" name="status" value="1" style=" background:#CFC;"/>通过
<input class="easyui" type="button" style=" background:#CFC;" value="确认" onclick="audit()"/>
<input class="easyui" type="button" style=" background:#CFC;" value="返回" onclick="backCheck()"/><br/>
 <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">档案编号</td>
			<td colspan="7" ><input type="text" id="human_id" name="human_id" value="${majorchange.human_id}" readonly="true"/></td>
		
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">原I级机构</td>
			<td ><input type="text" name="first_kind_name" value=" ${majorchange.first_kind_name}" readonly="true"/> </td>
            <td class="backcolor" style="text-align:center">原II级机构</td>
			<td ><input type="text" name="second_kind_name" value=" ${majorchange.second_kind_name}" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">原III级机构</td>
			<td ><input type="text" name="third_kind_name" value=" ${majorchange.third_kind_name}" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">姓名</td>
			<td ><input type="text" name="human_name" value=" ${majorchange.human_name }" readonly="true"/></td>
			
		</tr>
        
         <tr style="height:35px;">
        <td class="backcolor" style="text-align:center">原职位分类</td>
			<td >${majorchange.major_kind_name }</td>
            <td class="backcolor" style="text-align:center">原职位名称</td>
			<td >${majorchange.major_name}</td>
            <td class="backcolor" style="text-align:center">原薪酬标准</td>
			<td >${majorchange.salary_standard_name}</td>
            <td class="backcolor" style="text-align:center"></td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg"></td>
            </tr>
        
          <tr style="height:35px;">
        <td class="backcolor" style="text-align:center">新I级机构</td>
			<td ><input  type="text" id="I" name="Ijjg" value="${majorchange.new_first_kind_name } " readonly="true"/></td>
            <td class="backcolor" style="text-align:center">新II级机构</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.new_second_kind_name }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">新III级机构</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.new_third_kind_name }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center"></td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg"></td>
            </tr>
            
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">新职位分类</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.new_major_kind_name }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">新职位名称</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.new_major_name }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">新薪酬标准</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.new_salary_standard_name }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center"></td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg"></td>
          </tr>
          
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">登记人</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.register }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">登记时间</td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" value="${majorchange.regist_time }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">审核人</td>
			<td ><input id="check_name" class="easyui" type="text" id="I" name="check_name" value="周星驰" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">审核时间</td>
            <%SimpleDateFormat da=new SimpleDateFormat("YYYY-MM-dd HH:mm");
				String dd=da.format(new Date());
			%>
			<td  ><input class="easyui" type="text" id="check_time" name="check_time" value="<%=dd %>" readonly="true"/></td>
           
          </tr>
          
           <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">调动原因</td>
			<td colspan="7" ><textarea style="width:800px;" name="change_reason">${majorchange.change_reason}</textarea></td>
         
           
          </tr>
            <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">审核意见</td>
			<td colspan="7"  ><textarea  style="width:800px;" name="check_reason" id="check_reason"></textarea></td>
          </tr>
        </table>
<script type="text/javascript">
	function audit(){
		var val=$('input:radio[name="status"]:checked').val();
		 if(val==null){
			 alert("请选择通过或未通过！");
		 }else{
			 if(val=="0"){
				 if(check_reason==""){
					 alert("请输入审核通过理由！");
				 }else{
				var check_reason=$('textarea[name="check_reason"]').val();
				var id=$('input[name="human_id"]').val();//id
				 var check_name=$('input[name="check_name"]').val();
				 var check_time=$('input[name="check_time"]').val();
				$('#main_panel').panel('refresh',"toUpdateFail/"+check_reason+"/"+id+"/"+check_name+"/"+check_time);
				 }
			 
			 }else{
				 var check_reason=$('textarea[name="check_reason"]').val();
				 if(check_reason==""){
					 alert("请输入审核通过理由！");
				 }else{
				 var id=$('input[name="human_id"]').val();//id
				 var check_name=$('input[name="check_name"]').val();
				 var check_time=$('input[name="check_time"]').val();
				$('#main_panel').panel('refresh',"toUpdate/"+check_reason+"/"+id+"/"+check_name+"/"+check_time);
				 }
			}
		 }
	}	
	
	function backCheck(){
		$('#main_panel').panel('refresh',"admin/transferAuditFind");
	}
</script> 
</body>
</html>
