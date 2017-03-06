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
<title>书籍列表</title>

</head>
<body>
<div id="global">
<h1>书籍列表</h1>
<a href="<c:url value="/admin/toAddBookForm"/>">添加书</a>
	<table>
		<tr>
			<th>类别</th>
			<th>书名</th>
			<th>ISBN</th>
			<th>作者</th>
			<th>价格</th>
			<th>&nbsp;</th>
		
		</tr>
	<c:forEach items="${bookList }" var="book">
	
		<tr>
			<td>${book.category.name }</td>
			<td>${book.title }</td>
			<td>${book.isbn }</td>
			<td>${book.author }</td>
			<td>${book.price }</td>
		<td><a href="admin/toEditBookForm/${book.bid }">编辑</a><a href="toRankBookForm/${book.bid }">投票</a></td>
		
		
		</tr>
	</c:forEach>
	</table>
</div>
</body>
</html>