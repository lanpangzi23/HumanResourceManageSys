<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改</title>
</head>
<body><br/><br/><br/><br/>
<div style="width: 500px;height: 300px;margin-left:425px; background-color:#D6E3F7;">
<input type="hidden" name="uid" value="${uid}">
<div style="width: 364px;height: 50px;background-color: #D6F0F7;">用户名：<input placeholder="请输入用户名....." onblur="checkname()" name="uname" type="text" style="border: none;width: 298px;height: 48px;"></div>
		<div style="width: 363px;height: 50px;background-color: #D6F0F7;">密  &nbsp;  码：<input type="password" name="upwd" placeholder="请输入密码....." style="border: none;width: 298px;height: 48px;"></div></center>
</div>
<input  style="margin-top: 13px;width: 60px;" onclick="updateUser()" type="button" value="确认修改"/>
</body>
</html>