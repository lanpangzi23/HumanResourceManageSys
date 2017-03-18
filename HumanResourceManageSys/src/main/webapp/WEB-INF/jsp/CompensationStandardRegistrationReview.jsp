<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>无标题文档</title>
</head>
<body>
<p style="color:#00F">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记复核</p><br/>
	<input class="easyui" type="submit" onClick="updateSalaryStandard()" style="margin-left:874px;; background:#CFC;" value="复核通过"/>
    <input class="easyui" type="button" style="background:#F33;;" value="返回"/>
    <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">薪酬标准编号</td>
			<td id="standard_id" >${salaryStandard.standard_id }</td>
			<td style="text-align:center" class="backcolor">薪酬标准名称</td>
			<td>${salaryStandard.standard_name }</td>
			<td style="text-align:center" class="backcolor">薪酬总额</td>
			<td>${salaryStandard.salary_sum }</td>
		
		</tr>
        
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">制定人</td>
			<td>${salaryStandard.designer}</td>
			<td style="text-align:center" class="backcolor">复核人</td>
			<td>${ salaryStandard.checker}</td>
			<td style="text-align:center" class="backcolor">复核时间</td>
			<td>${ salaryStandard.check_time}</td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">复核意见</td>
			<td colspan="5" ><textarea id="check_comment" name="check_comment" cols="110" class="easyui"></textarea></td>
			
		
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">序号</td>
			
			<td  colspan="3" style="text-align:center" class="backcolor">项目名称</td>
			
			<td colspan="2" style="text-align:center" class="backcolor">金额</td>
		</tr>
		<c:forEach items="${salaryStandardDetails }" var="ssd" varStatus="sd">
		<tr style="height:35px;">
				<td class="backcolor" style="text-align:center" >
					<input type="text" name="item_idList" style="border: none;" value="${sd.index +1}"/>
				</td>
				<td  colspan="3" style="text-align:center" class="backcolor">
					<input type="text" name="item_nameList" style="border: none;" value="${ssd.item_name }"/>
				</td>
				<td colspan="2" style="text-align:center">${ssd.salary }</td>
			</tr>
		</c:forEach>
		</table>
<script>
function updateSalaryStandard(){
	var id=$('#standard_id').text();
	var comment=$('#check_comment').val();
	$.post("updateSalaryStandard/"+id+"/"+comment,function(data){
		alert("复核通过");
		$('#main_panel').panel('refresh',"admin/CompensationStandardRegistrationReview");
	},"text");
}
</script>      
</body>
</html>
