<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
<title>源辰信息科技有限公司-人力资源档案登记</title>
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript">
$(function(){
	$(".update").click(function () {
		$("#update_form").ajaxSubmit({
	         success: function (data) {
	             alert(data);
	         },
	         error: function (error) { alert('登记失败 ...'); },
	             url: 'updateEngageInterview', /*设置post提交到的页面*/
	             type: "post", /*设置表单以post方法提交*/
	             dataType: "text" /*设置返回值类型为文本*/
	     });
	});
})
</script>
</head>
<body>
<body>
<form id="update_form">
	<p>您正在做的业务是:人力资源--招聘管理--面试管理--面试筛选</p>
	<input type="radio" name="result" value="建议面试">建议面试<input name="result" type="radio" value="建议笔试">建议笔试
	<input type="radio" name="result" value="建议录用">建议录用<input name="result" type="radio" value="删除简历">删除简历
	<input class="update" type="button" value="确认" /><input type="button" value="清除" />
	<input type="hidden" name="resume_id" value="${engageResume.res_id }" />
	<input type="hidden" name="checker" value="${uname }" />
	<table border="1" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0">
		<tr>
			<td>职位分类</td>
			<td><input type="text" value="${engageResume.human_major_kind_name }" readonly="readonly"/></td>
			<td>职位名称</td>
			<td><input type="text" value="${engageResume.human_major_name }" readonly="readonly"/></td>
			<td>招聘类型</td>
			<td>${engageResume.engage_type }</td>
			<td rowspan="6" colspan="2" style="width: 120px">
				<div id="Imgdiv">
			     	<img id="Img" src="${engageResume.human_picture}" width="200px" height="200px"/>
			   	</div>
		    </td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text"  value="${engageResume.human_name }" readonly="readonly"/></td>
			<td>性别</td>
			<td>${engageResume.human_sex }</td>
			<td>EMAIL</td>
			<td>${engageResume.human_email }</td>
		</tr>
		<tr>
			<td>电话</td>
			<td>${engageResume.human_telephone }</td>
			<td>家庭电话</td>
			<td>${engageResume.human_homephone }</td>
			<td>手机</td>
			<td>${engageResume.human_mobilephone }</td>
		</tr>
		<tr>
			<td>住址</td>
			<td colspan="3">${engageResume.human_address }</td>
			<td>邮编</td>
			<td>${engageResume.human_postcode }</td>
		</tr>
		<tr>
			<td>国籍</td>
			<td>${engageResume.human_nationality }</td>
			<td>出生地</td>
			<td>${engageResume.human_birthplace }</td>
			<td>生日</td>
			<td>${engageResume.human_birthday }</td>
		</tr>
		<tr>
			<td>民族</td>
			<td>${engageResume.human_race }</td>
			<td>宗教信仰</td>
			<td>${engageResume.human_religion }</td>
			<td>政治面貌</td>
			<td>${engageResume.human_party }</td>
		</tr>
		<tr>
			<td>身份证号码</td>
			<td>${ engageResume.human_idcard}</td>
			<td>年龄</td>
			<td>${ engageResume.human_age}</td>
			<td>毕业学校</td>
			<td>${ engageResume.human_college}</td>
			<td>学历</td>
			<td>${engageResume.human_educated_degree }</td>
		</tr>
		<tr>
			<td>教育年限</td>
			<td>${engageResume.human_educated_years }</td>
			<td>学历专业</td>
			<td>${engageResume.human_educated_major }</td>
			<td>薪酬要求</td>
			<td>${engageResume.demand_salary_standard }</td>
			<td>登记时间</td>
			<td>${ engageResume.regist_time}</tr>
		<tr>
			<td>特长</td>
			<td>${engageResume.human_specility }</td>
			<td>爱好</td>
			<td>${engageResume.human_hobby }</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>个人履历</td>
			<td colspan="7"><textarea  style="width: 600px; height: 80px;">${engageResume.human_history_records }</textarea></td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="7"><textarea  style="width: 600px; height: 80px;">${engageResume.remark }</textarea></td>
		</tr>
		<tr>
			<td>推荐意见</td>
			<td colspan="7"><textarea   style="width: 600px; height: 80px;">${engageResume.recomandation}</textarea></td>
		</tr>
		<tr>
			<td>筛选推荐意见</td>
			<td colspan="7"><textarea name="check_comment"  style="width: 600px; height: 80px;"></textarea></td>
		</tr>
	</table>
</form>	
</body>
</html>
