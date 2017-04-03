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
<p style="color:#00F">您正在做的业务是：人力资源--激励管理--激励审核</p><br/>

<input class="easyui" type="button" style=" background:#CFC;" value="确认" onclick="bonus()"/>
<br/><br/>
   <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">档案编号</td>
			<td colspan="7" ><input type="text" id="human_id" name="human_id" value="${bonus.human_id} " readonly="true"/></td>
			
		</tr>
        <tr style="height:35px;">
            <td class="backcolor" style="text-align:center">姓名</td>
			<td ><input type="text" name="human_name" value=" ${bonus.human_name} " readonly="true"/></td>
			<td class="backcolor" style="text-align:center">激励项目名称</td>
			<td ><input type="text" name="human_name" value=" ${bonus.bonus_item} " readonly="true"/></td>
            <td class="backcolor" style="text-align:center">激励项目等级</td>
			<td ><input type="text" name="human_name" value=" ${bonus.bonus_degree} " readonly="true"/></td>
			<td class="backcolor" style="text-align:center">价值</td>
			<td ><input type="text" name="human_name" value=" ${bonus.bonus_worth} " readonly="true"/></td>
		</tr>
          
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">登记人</td>
			<td ><input class="easyui" type="text" id="I" name="register" value="${bonus.register} " readonly="true"></td>
            <td class="backcolor" style="text-align:center">登记时间</td>
			<td ><input class="easyui" type="text" id="I" name="regist_time" value="${bonus.regist_time }" readonly="true"></td>
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
			<td colspan="7" ><textarea style="width:800px;" name="remark" >${bonus.remark } </textarea></td>
        </table>
<script type="text/javascript">

function backCheck(){
	$('#main_panel').panel('refresh',"admin/bonusAuditFind");
}
function bonus(){
	var id=$('input[name="human_id"]').val();
	var checker=$('input[name="checker"]').val();
	alert(checker);
	var check_time=$('input[name="check_time"]').val();
	$('#main_panel').panel('refresh',"bonus/"+id+"/"+checker+"/"+check_time);
}
</script> 
</body>
</html>
