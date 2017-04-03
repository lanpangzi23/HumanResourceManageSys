<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<div class="easyui-tabs" id="tt">
<p style="color:#00F">您正在做的业务是：人力资源--激励管理--添加培训项目</p>
<div title="添加培训项目">
<input style="width:100px; background-color:#CCC"" value="培训项目:" readonly="true"/>
<input style="width:100px" name="additem" />
         &nbsp;培训时间(年-月-日)：<input class="easyui-datebox" value="" name="addtime" style="width:100px;"/>
   		 &nbsp;培训课时(请输入整数)：<input value="" name="addhour" style="width:100px;"/>
   		 <input class="easyui" type="button" style=" background:#CFC;" value="添加"  onclick="addItem()"/>
  </div> 		
<br/><br/>
<div title="添加培训等级">
   <input style="width:100px; background-color:#CCC " value="培训成绩等级:" readonly="true"/>
<input style="width:100px" name="adddegree" />
<input class="easyui" type="button" style=" background:#CFC;" value="添加" onclick="adddegree()"/>
  </div>    
</div>
<script type="text/javascript">
	function adddegree(){
		var degree=$('input[name="adddegree"]').val();
		var degrees=degree.tolocaleUpperCase
		$('#main_panel').panel('refresh',"adddegree/"+degrees);
	}
	function addItem(){
		var item=$('input[name="additem"]').val();
		var time=$('input[name="addtime"]').val();
		var hour=$('input[name="addhour"]').val();
		var hours=hour;
		hours=parseInt(hour);
		if(item==""|| time==""||hour==""){
			alert("请填完！");
		}else if(Object.prototype.toString.call(hours)=='[object Number]'){
			$('#main_panel').panel('refresh',"additem/"+item+"/"+time+"/"+hour);
		}else{
			alert("格式不对请重新输入");
	 }
	}
</script> 
</body>
</html>
