<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>薪酬发放登记</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--薪酬发放管理--薪酬发放登记</p><br/>
<form action="addToSalaryGrant">
<input class="easyui" type="submit" style="margin-left:900px;" value="提交"/>
<input class="easyui" type="button" value="返回"/><br/>
新酬单编号：<input style="border:none;" value="${map.id}" name="salary_grant_id"/><br/>
机构：<input style="border:none;width: 30px;" value="${map.firstname }" name="first_kind_name"/>/<input style="border:none;" value="${map.secondname }" name="second_kind_name"/><br>
本机构总人数：<input style="border:none;" name="human_amount" value="${map.count }"/>基本薪酬总额：<input style="border:none;" name="salary_standard_sum" value="${map.sum }"/>      
登记人：<input name="register" class="easyui" type="text"> 登记时间：<input name="regist_time" style="border:none;" value="<%=new Date() %>"/><br/><br>
<input type="hidden" value="0" name="salary_paid_sum"/>
<table border="1" width="1000px" cellpadding="0" cellspacing="0">
	<tr style="height:35px;">
		<td class="backcolor" style="text-align:center">序号</td>
		<td class="backcolor" style="text-align:center">档案编号</td>
        <td class="backcolor" style="text-align:center">姓名</td>
        <c:forEach items="${humanFile }" var="hf" varStatus="h">
        <c:choose>
        	<c:when test="${h.index==0 }">
        		<input type="hidden" value="${hf.first_kind_id }" name="first_kind_id"/>
        		<input type="hidden" value="${hf.second_kind_id }" name="second_kind_id"/>
        		<c:forEach items="${hf.ssd }" var="ssd">
				<td>${ssd.item_name }</td>
				<input type="hidden" value="${ssd.standard_id }" name="salary_standard_id"/>
				</c:forEach>
        	</c:when>
        </c:choose>
		</c:forEach> 
        <td >奖励金额</td>
        <td >销售绩效金额</td>
        <td>应扣金额</td>
	</tr>
	<c:forEach items="${humanFile }" var="hf" varStatus="h">
	<tr>
		<td class="td">${h.index+1 }</td>
		<td><input style="border:none;" value="${hf.human_id }" name="human_id"/></td>
		<td><input style="border:none;" value="${hf.human_name }" name="human_name"/></td>
		<c:forEach items="${hf.ssd }" var="ssd">
		<td><input style="width: 50px;" type="text" class="salary${h.index+1 }" value="${ssd.salary }"></td>
		</c:forEach>
		<td style="display: none"><input type="hidden" class="sum${h.index+1 }"  name="sum" /></td>
		<td style="display: none"><input type="hidden" class="paidsum${h.index+1 }"  name="paidsum"/></td>
		<td style="width: 50px;"><input onblur="getSum()" class="paid${h.index+1 }"  name="bouns_sum"  type="text"/></td>
        <td style="width: 50px;"><input onblur="getSum()" class="paid${h.index+1 }"  name="sale_sum" type="text" value="0.00"/></td>
        <td style="width: 50px;"><input onblur="getSum()" class="paid${h.index+1 }"  name="deduct_sum" type="text"/></td>
	</tr>
	</c:forEach>     
</table>
</form>
<script type="text/javascript">
var sum=0;
var size=$('.td').length;
for(var i=0;i<size;i++){
	var obj=$('.salary'+(i+1));
	for(var j=0;j<obj.length;j++){
		if(obj.eq(j).val()!=""){
			sum=parseFloat(obj.eq(j).val())+sum;
		}
	}
	$(".sum"+(i+1)).val(sum);
	sum=0;
}
function getSum(){
	var sum2=0;
	for(var i=0;i<size;i++){
		var obj4=$('.paid'+(i+1));
		for(var j=0;j<obj4.length;j++){
			if(obj4.eq(j).val()!=""){
				sum2=parseFloat(obj4.eq(j).val())+sum2;
			}
		}
		$(".paidsum"+(i+1)).val(sum2);
		sum2=0;
	}
	var sum1=0;
	var obj1=$("input[name='bouns_sum']");
	var obj2=$("input[name='sale_sum']");
	var obj3=$("input[name='deduct_sum']");
	var click=obj1.length;
	for(var i=0;i<click;i++){
		if(obj1.eq(i).val()!=""){
			sum1=parseFloat(obj1.eq(i).val())+sum1;
		}
	}
	for(var i=0;i<obj2.length;i++){
		if(obj2.eq(i).val()!=""){
			sum1=parseFloat(obj2.eq(i).val())+sum1;
		}
	}
	for(var i=0;i<obj3.length;i++){
		if(obj3.eq(i).val()!=""){
			sum1=parseFloat(obj3.eq(i).val())+sum1;
		}
	}
	$("input[name='salary_paid_sum']").val(sum1);
}
</script>
</body>
</html>
