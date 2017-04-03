<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
</head>
<body>
<form action="addEngageExam" method="post">
	<input type="submit" value="提交">
	<table border="1" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0">
		<tr>
			<td> 职位分类</td>
			<td>
				<input name="major_kind_id" id="aa1"  class="easyui-combobox" data-options="   
			        		valueField: 'major_kind_id',
		        			textField: 'major_kind_name',
		        			url: 'findAllConfigMajorKind',
		        			onSelect: function(rec){
		        				$('#human_major_kind_name').val(rec.major_kind_name);
			            		var url = 'selectConfigMajorByKind?major_kind_id='+rec.major_kind_id;
			            		$('#aa2').combobox('reload', url);}" />
		        <input type="hidden" name="major_kind_name" id="human_major_kind_name"  />
			</td>
		</tr>
		<tr>
			<td>职位名称</td>
			<td>
				<input name="major_id" id="aa2"  class="easyui-combobox"
						data-options="
 							valueField:'major_id', 
 							textField:'major_name',onSelect: function(rec){
		        				$('#human_major_name').val(rec.major_name);}" />
		        <input name="major_name"  id="human_major_name" type="hidden" />
			</td>
			<td>登记人</td>
			<td><input name="register" value="${uname }" readonly="readonly"/></td>
			<td>登记时间</td>
			<td><input name="regist_time" value="<%=new Date() %>" readonly="readonly"/></td>
			<td>答题限时(分钟)</td>
			<td><input name="limite_time"/></td>
		</tr>
		<c:forEach items="${esList }" var="es" varStatus="ee">
		<tr>
			<td rowspan="${es.esList.size()+1 }">
				<input name="fname" value="${es.first_kind_name }" readonly="readonly"/>
				<input name="fid" value="${es.first_kind_id }" type="hidden" readonly="readonly"/>
			</td>
			<td colspan="3">试题二级分类名称</td>
			<td colspan="2">可用试题数量</td>
			<td colspan="2">出题数量</td>
		</tr>
		<c:forEach items="${es.esList }" var="e" >
		<tr>
			<td colspan="3">
				<input value="${e.second_kind_name}" readonly="readonly"/>
				<input name="sname" value="${e.second_kind_name}" type="hidden" readonly="readonly"/>
				<input name="sid" value="${e.second_kind_id},${es.first_kind_id },${es.first_kind_name }" type="hidden" readonly="readonly"/>
			</td>
			<td colspan="2">${e.total }</td>
			<td colspan="2">
				<input type="text" class="amount" onblur="setValue(${ee.index})"/>
				<input type="hidden" id="amount1" name="total"/>
			</td>
		</tr>
		</c:forEach>
		</c:forEach>
	</table>
</form>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript">
function setValue(index){
	var total=$('.amount').eq(index).val();
	var fid=$('input[name="fid"]').eq(index).val();
	$('input[name="total"]').eq(index).val(total+","+fid);
}
</script>
</html>