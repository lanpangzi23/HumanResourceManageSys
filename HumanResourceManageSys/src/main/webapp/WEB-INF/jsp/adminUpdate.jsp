<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改</title>
<base href="<%=basePath%>">
</head>
<body><br/><br/><br/><br/>
<div style="margin-left:385px; background-color:#D6E3F7; width: 500px;height: 230px;">
	<input type="hidden" name="uid" value="${uid }">
		<p style="font-size: x-large;font-family: fantasy;font-weight: bolder;color: white;"></p>
		<br/><br/><center><div style="width: 364px;height: 50px;background-color: #D6F0F7;">用户名：<input placeholder="请输入用户名....." onblur="checkname()" name="uname" type="text" style="border: none;width: 298px;height: 48px;"></div>
		<div style="width: 364px;height: 50px;background-color:#D6E3F7; color: red;" id="checkname"></div>
		<div style="width: 363px;height: 50px;background-color: #D6F0F7;">密  &nbsp;  码：<input type="password" name="upwd" placeholder="请输入密码....." style="border: none;width: 298px;height: 48px;"></div></center>
		<div style="width: 304px;height: 50px;background-color:#D6E3F7; color: red; padding-left: 190px;" id="checkpwd"></div>
	</div>
	<div style="margin-left:385px;background-color:#009AFF; width: 500px;height: 50px;">
		<center><input  style="margin-top: 13px;width: 65px;background-color: blue;color: white;" onclick="login()" type="button" value="确认修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style="margin-top: 10px;width: 60px;background-color: blue;color: white;" type="reset" value="重置"/></center>
	</div>
<script>
	//登录
	function login(){
		var uname=$('input[name="uname"]').val();
		var upwd=$('input[name="upwd"]').val();
		var uid=$('input[name="uid"]').val();
		$.post('UserUpdate',{uname:uname,upwd:upwd,uid:uid},function(data){
			if(data==0){
				alert('修改失败')
			}else{
				alert('您已成功修改个人信息')
				window.location.href="admin/adminLogin";
			}
		},'text');
	}
function checkname(){
	var uname=$('input[name="uname"]').val();
	$.post('checkUserName',{uname:uname},function(data){
		if(data==0){
		}else{
			$('#checkname').html('该用户名已经被使用');
			$('input[name="uname"]').val('');
		}
	},'text');
}

</script>
</body>
</html>