<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% 
    	String path =request.getContextPath();  //  /douban
    	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>豆瓣用户登录界面</title>
<style type="text/css">@import url("<c:url value="/css/base.css"/>");</style>
<script>
//刷新验证码
function loadImage(){
	var img =document.getElementById("randImg");
	img.src="imageCode.jsp?r="+Math.random();
}
</script>
</head>

<body id="global">
<center>
	<div>
		<c:if test="${msgmsg!=''}">
			<font style="color: red"><c:out value="${errmsg }"></c:out></font>
		</c:if>
	</div></center>
	<br/>
	
	<form action="userLogin" method="post" id="myform">
		<fieldset>
			<h1>用户登录</h1>
				<p>用户名：<input type="text" name="uname"/></p>
				<p>密    &nbsp;&nbsp; 码:  <input type="password" name="password"/></p>
				<p>验证码：<input type="text" name="validateCode"/>
				<img id="randImg" border=0 src="imageCode.jsp">
				<a href="javascript:loadImage();">换一张</a></p>
				<p><input type="submit" value="登录"></p>
		</fieldset>
	</form>
</body>

</html>