<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body style="background-color:#EFF3FF"><br/><br/><br/>
<form>
	<center>
	<div style="background-color:#009AFF; width: 500px;height: 50px;">
	<p style="font-size: x-large;font-family: fantasy;font-weight: bolder;color: white;">后&nbsp;&nbsp;&nbsp;&nbsp;台&nbsp;&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;&nbsp;员&nbsp;&nbsp;&nbsp;&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录</p>
	</div>
		</center>
	<div style="margin-left:425px; background-color:#D6E3F7; width: 500px;height: 220px;margin-right: 200px;">
	<p style="font-size: x-large;font-family: fantasy;font-weight: bolder;color: white;"></p>
	<br/><br/><center><div style="width: 364px;height: 50px;background-color: #D6F0F7;">用户名：<input placeholder="请输入用户名....." onblur="checkname()" name="uname" type="text" style="border: none;width: 298px;height: 48px;"></div>
	<div style="width: 364px;height: 50px;background-color:#D6E3F7; color: red;" id="checkname"></div>
	<div style="width: 363px;height: 50px;background-color: #D6F0F7;">密  &nbsp;  码：<input type="password" name="upwd" placeholder="请输入密码....." style="border: none;width: 298px;height: 48px;"></div></center>
	<div style="width: 364px;height: 50px;background-color:#D6E3F7; color: red; padding-left: 190px;" id="checkpwd"></div>
	</div>
	<center>
	<div style="background-color:#009AFF; width: 500px;height: 50px;">
	<input  style="margin-top: 10px;width: 60px;background-color: blue;color: white;" onclick="login()" type="button" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style="margin-top: 10px;width: 60px;background-color: blue;color: white;" type="reset" value="重置"/>
	</div>
	</center></form>
<script>
	//登录
	function login(){
		var uname=$('input[name="uname"]').val();
		var upwd=$('input[name="upwd"]').val();
		$.post('UserLogin',{uname:uname,upwd:upwd},function(data){
			if(data==0){
				$('#checkpwd').html('密码不正确，请重新输入');
				$('input[name="upwd"]').val('');
			}else{
				window.location.href="admin/index";
			}
		},'text');
	}
function checkname(){
	var uname=$('input[name="uname"]').val();
	$.post('checkUserName',{uname:uname},function(data){
		if(data==0){
			$('#checkname').html('该账号不存在');
			$('input[name="uname"]').val('');
		}else{
			$('#checkname').html('');
		}
	},'text');
}

</script>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>

</html>