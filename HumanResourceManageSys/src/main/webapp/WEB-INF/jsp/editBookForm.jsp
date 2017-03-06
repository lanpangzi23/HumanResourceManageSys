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
<title>书籍列表</title>

</head>
<body>
<div id="global">
	<form:form commandName="book" enctype="multipart/form-data" action="admin/updateBook" method="post">
		<fieldset>
			<legend>修改一本书</legend>
			<form:hidden path="bid"/>
			<p>
				<label for="category">类别：</label>																												
				<form:select id="category" 
							path="category.cid"
							items="${categories }"
							itemLabel="name" itemValue="cid"/>
			</p>
			<p>
				<label for="isbn">ISBN：</label>
				<form:input id="isbn" path="isbn" onkeydown="if(event.keyCode==13) return false;"/>
			</p>
			<p>
				<label for="title">书名：</label>
				<form:input id="title" path="title"/>
			</p>
			<p>
				<label for="author">作者：</label>
				<form:input id="author" path="author"/>
			</p>
			<p>
				<label for="price">价格：</label>
				<form:input id="price" path="price"/>
			</p>
			<p>
				<label for="description">详情：</label>
				<form:input id="description" path="description"/>
			</p>
			
			
			<p>
				<label for="pdfs">已上传的电子书：</label>
				<ul>
				<c:forEach items="${book.pdfsStringList}" var="pdfUrl">
					<li><a href="${pdfUrl }">下载电子书</a></li>
				</c:forEach>
				</ul>
				<div id="uploadFiles">
					重新上传电子书：<input type="file" name="pdfsUrl"/>
					<input type="file" name="pdfsUrl"/>
				</div>
			</p>
			
			
			<p id="buttons">
				<input id="reset" type="reset" tabindex="4">
				<input id="submit" type="submit" tabindex="5" value="确认修改">
			</p>
		</fieldset>
	
	
	</form:form>
</div>
</body>
</html>