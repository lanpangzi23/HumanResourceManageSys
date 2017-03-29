<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
    <form id="upload_form">
        <p>您正在做的业务是:人力资源--招聘管理--职位发布管理--职位发布变更</p>
		<input class="submit1" type="button" value="重新提交" /><input type="button" value="返回" />
		<table border="1" bordercolor="#CCCCCC"  cellpadding="0" cellspacing="0">
		<tr>
			<td style="width: 80px;">I级机构</td>
			<td>${engageMajor.first_kind_name } </td>
			<td style="width: 80px;">II级机构</td>
			<td>${engageMajor.second_kind_name }</td>
			<td style="width: 80px;">III级机构</td>
			<td>${engageMajor.third_kind_name }</td>
			<td style="width: 80px;">招聘类型</td>
			<td><select id="cc" class="easyui-combobox" name="engage_type" style="width:100px;">  
			    <option>社会招聘</option>  
			    <option>校园招聘</option>  
			</select></td>
		</tr>
		<tr>
			<td>职位分类</td>
			<td>${engageMajor.major_kind_name }<input value="${engageMajor.mre_id}" name="mre_id" type="hidden"/></td>
			<td>职位名称</td>
			<td><input value="${engageMajor.major_name }" name="major_name" readonly="readonly"/></td>
			<td>招聘人数</td>
			<td><input name="human_amount" value="${engageMajor.human_amount }" type="text" style="width: 100px;"></td>
			<td>截止日期</td>
			<td><input id="dd"  type="text" value="${engageMajor.deadline }" class="easyui-datebox" style="width: 100px;" required="required"/>
			<input type="hidden" id="deadline" value="${engageMajor.deadline }" name="deadline">
			</td>
		</tr>
		<tr>
			<td>变更人</td>
			<td><input type="text" name="changer"  style="width: 100px;"></td>
			<td>变更时间</td>
			<td><input type="text" name="change_time" readonly="true" value="<%=new Date() %>" style="width: 100px;"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height: 100px;">
			<td>职位描述</td>
			<td colspan="7"><textarea name="major_describe" style="width: 700px; height: 80px;"></textarea></td>
		</tr>
		<tr style="height: 100px;">
			<td>招聘要求</td>
			<td colspan="7"><textarea name="engage_required" style="width: 700px; height: 80px;"></textarea></td>
		</tr>
	</table>
	</form>  
<script type="text/javascript">
$(document).ready(function(){
	$("#dd").datebox({
		required:true,
		onSelect:function(date){
			$('#deadline').val(date);
		}
	});
})
$(".submit1").click(function() {
	$("#upload_form").ajaxSubmit({
		success : function(data) {
			alert(data);
		},
		error : function(error) {
			alert(error);
		},
		url : 'updateEngageMajor', /*设置post提交到的页面*/
		type : "post", /*设置表单以post方法提交*/
		dataType : "text" /*设置返回值类型为文本*/
	});
});
</script>
</body>
