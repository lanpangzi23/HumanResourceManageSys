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
<title>源辰信息技术公司-豆瓣书屋</title>
<style type="text/css">@import url("<c:url value="/css/base.css"/>");</style>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(
		function(){
			$("#category").change(
				function(){
					$.post("findBookByCategory/"+$(this).val(),function(json){
						var obj=$.parseJSON(json);
						$("#bookList").html("");
						for(var i=0;i<obj.length;i++){
							var o=obj[i];
							$("#bookList").append(
									"<tr><td>"+o.category.name
									+"</td><td>"+o.title
									+"</td><td>"+o.isbn
									+"</td><td>"+o.author
									+"</td><td>"+o.price
									+"</td><td><a href='toDetailBookForm/"+o.bid+
									"'>查看详情</a>&nbsp;&nbsp;<a href='toRankBookForm/"+o.bid+"'>投票</a>"
								)
						}
						
					});
				});
		});
</script>

</head>
<body>
<center>
<div id="global">

<h1>源辰信息技术公司</h1>
<h2>豆瓣书屋</h2>


筛选：<select id="category" name="category.cid">
		<option value="-1">所有类别</option>
		<c:forEach items="${categories }" var="ca">
			<option value="${ca.cid }">${ca.name}</option>
		</c:forEach>
	</select>
	<br/><br/>
	<table>
	<thead>
		<tr>
			<th>类别</th>
			<th>书名</th>
			<th>ISBN</th>
			<th>作者</th>
			<th>价格</th>
			<th>操作</th>
		
		</tr>
		</thead>
		<tbody id="bookList">
	<c:forEach items="${bookList }" var="book">
	
		<tr>
			<td>${book.category.name }</td>
			<td>${book.title }</td>
			<td>${book.isbn }</td>
			<td>${book.author }</td>
			<td>${book.price }</td>
		<td><a href="toDetailBookForm/${book.bid }">详情</a><a href="toRankBookForm/${book.bid }">投票</a></td>
		
		
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</center>
</body>
</html>