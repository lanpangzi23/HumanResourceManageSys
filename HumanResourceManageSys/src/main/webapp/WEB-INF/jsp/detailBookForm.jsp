<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
     <% 
    	String path =request.getContextPath();  //  /douban
    	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详情</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<center>
<div id="global">

<h1>源辰信息技术公司</h1>
<h2>豆瓣书屋</h2>

<fieldset>
	<legend>${book.title}</legend>
	<p>
		<div id="info"><label>类别：</label>${book.category.name}</div>
	</p>
	<p>
		<div id="info"><label>ISBN：</label>${book.isbn}</div>
	</p>
	<p>
		<div id="info"><label>作者：</label>${book.author}</div>
	</p>
	<p>
		<div id="info"><label>价格：</label>${book.price}</div>
	</p>
	<p id="buttons">
		<a href="javascript:history.go(-1)">返回上一级</a>
	</p>
</fieldset>

	
</div>
</center>
</body>
</html>