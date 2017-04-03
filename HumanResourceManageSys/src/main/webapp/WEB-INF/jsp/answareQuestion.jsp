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
<div>
	<form id="add_form">
	<p>您正在做的业务是:人力资源--招聘管理--招聘考试管理--考试答题</p>
	<p class="p1">答题限定时间:<label id="timeover">${ee.limite_time }</label>分钟 &nbsp;&nbsp;&nbsp;&nbsp; 答题已用时间&nbsp;&nbsp;<input type="text" id="time"/></lable></p>
	<input name="choose" type="radio" value="jiaojuan"/>我要交卷<input name="choose" type="radio" value="jiancha"/>我要交卷<input type="button" value="确认"/ >
	<table border="1" bordercolor="#CCCCCC" width="700" cellpadding="0" cellspacing="0" >
		<tr >
	        <td align="center">试卷编号</td>
	        <td><input type="text" readonly="readonly" name="exam_number" value="${ee.exam_number }"></td>
	        <td align="center">试题数量</td>
	        <td><input type="text" readonly="readonly" value="${examTotal }"></td>
	   </tr>
	   <tr >
	        <td align="center">姓名</td>
	        <td>
	        	<input type="text" readonly="readonly" value="${er.human_name }">
	        	<input type="hidden" name="resume_id" value="${er.resume_id }">
	        </td>
	        <td align="center">身份证号码</td>
	        <td><input type="text" readonly="readonly" value="${er.human_idcard }"></td>
	   </tr>
	   <c:forEach items="${esList }" var="es">
	   <c:forEach items="${es }" var="s">
	   <tr><td colspan="4">${s.second_kind_name }</td></tr>
	   <tr><td colspan="4">${s.content }</td></tr>
	   <tr><td colspan="4"><input type="checkbox"/>${s.key_a }</td></tr>
	   <tr><td colspan="4"><input type="checkbox"/>${s.key_b }</td></tr>
	   <tr><td colspan="4"><input type="checkbox"/>${s.key_c }</td></tr>
	   <tr><td colspan="4"><input type="checkbox"/>${s.key_d }</td></tr>
	   <tr><td colspan="4"><input type="checkbox"/>${s.key_e }</td></tr>
	   </c:forEach>
	   </c:forEach>
    </table>
    </form>
</div>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript">
var m=0;
var s=0;
var timeover=$('#timeover').val();
var timeout=setInterval("getCount("+timeover+")",1000);
function getCount(timeover){
	if(timeover==m){
		clearInterval(timeout);
		$("#add_form").ajaxSubmit({
            success: function (data) {
                alert(data);
            },
            error: function (error) { alert('登记失败 ...'); },
                url: 'updateEngageResume', /*设置post提交到的页面*/
                type: "post", /*设置表单以post方法提交*/
                dataType: "text" /*设置返回值类型为文本*/
        });
	}
	s++;
	if(s==60){
		m++;
		s=0;
	}
	$('#time').val(m+":"+s);
}
</script>
</html>