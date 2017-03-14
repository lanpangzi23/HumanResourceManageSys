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
<p style="color:#00F">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记</p><br/>
    <form method="post" action="admin/addSalaryStandard">
    <input class="easyui" type="submit" style="margin-left:899px;; background:#CFC;" value="提交"/>
    <input class="easyui" type="button" style="background:#F33;;" value="返回"/>
    <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">薪酬标准编号</td>
			<td ><input type="text" name="standard_id" style="border: none;" value="${salaryStandard.standard_id }"/></td>
			<td style="text-align:center" class="backcolor">薪酬标准名称</td>
			<td><input class="easyui" type="text" id="I" name="standard_name"></td>
			<td style="text-align:center" class="backcolor">薪酬总额</td>
			<td><input class="easyui" type="text" id="I" name="salary_sum"></td>
		
		</tr>
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">制定人</td>
			<td><input class="easyui" type="text" id="I" name="designer"></td>
			<td style="text-align:center" class="backcolor">登记人</td>
			<td><input type="text" name="register" style="border: none;" value="${salaryStandard.register }"/></td>
			<td style="text-align:center" class="backcolor">登记时间</td>
			<td><input type="text" name="regist_time" style="border: none;" value="${salaryStandard.regist_time }"/></td>
		</tr><tr style="height:35px;">
			<td style="text-align:center" class="backcolor">序号</td>
			
			<td  colspan="3" style="text-align:center" class="backcolor">项目名称</td>
			
			<td colspan="2" style="text-align:center" class="backcolor">金额</td>
			
		</tr>
		<c:forEach items="${configPublicChar }" varStatus="c" var="cpc">
			<tr style="height:35px;">
				<td style="text-align:center" class="backcolor">
					<input type="text" name="item_idList" style="border: none;" value="${c.index +1}"/>
				</td>
				<td  colspan="3" style="text-align:center" class="backcolor">
					<input type="text" name="item_nameList" style="border: none;" value="${cpc.attribute_name }"/>
				</td>
				<td colspan="2"><input class="easyui" onblur="getSum()" type="text" id="I" name="salaryList"></td>
			</tr>
		</c:forEach>
    </table>
</form>
<script type="text/javascript">
function getSum(){
	var sum=0;
	var obj=$("input[name='salaryList']");
	var click=obj.length;
	for(var i=0;i<click;i++){
		if(obj.eq(i).val()!=""){
			sum=parseFloat(obj.eq(i).val())+sum;
		}
	}
	$("input[name='salary_sum']").val(sum);
}
</script>
</body>
</html>
    