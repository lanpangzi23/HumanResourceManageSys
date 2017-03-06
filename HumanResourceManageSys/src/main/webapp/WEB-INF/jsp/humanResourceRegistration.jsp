<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();//项目名
						//http					localhost						8080
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<base href="<%=basePath%>">
<style>


</style>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记</p><br/>
	<input class="easyui" type="button" style="margin-left:899px;; background:#CFC;" value="提交"/>
    <input class="easyui" type="button" style="background:#F33;;" value="删除"/>

	<table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">I级机构</td>
			<td ><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">II级机构</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">III级机构</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td rowspan="5" colspan="2"><input class="easyui"  type="image" ><input class="easyui"  type="file" ></td>
		</tr>
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">职位分类</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">职位名称</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">职称</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">姓名</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">性别</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">EMAIL</td>
			<td><input class="easyui" type="email" id="I" name="Ijjg"></td>
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">电话</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">QQ</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">手机</td>
			<td><input class="easyui" type="tel" id="I" name="Ijjg"></td>
		</tr>
         <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">住址</td>
			<td colspan="3"><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">邮编</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">国籍</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">出生地</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">生日</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
            <td style="text-align:center" class="backcolor">民族</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr>
        </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">宗教信仰</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">政治面貌</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">身份证号码</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
            <td style="text-align:center" class="backcolor">社会保障号码</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
		</tr>
          </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">年龄</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">学历</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">教育年限</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
            <td style="text-align:center" class="backcolor">学历专业</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
		</tr>
         </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">薪酬标准</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">开户银行</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">账号</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
            <td style="text-align:center" class="backcolor">登记人</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
		</tr>
         </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">建档时间</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">特长</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">爱好</td>
			<td><input class="easyui-combobox" type="text" id="I" name="Ijjg"></td>
            <td style="text-align:center" class="backcolor"></td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
		</tr>
         </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">个人履历</td>
			<td colspan="7"><textarea class="easyui-validatebox" style="height:100px; width:930px;"></textarea></td>
			
		</tr>
          </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">家庭关系信息</td>
			<td colspan="7"><textarea class="easyui-validatebox" style="height:100px; width:930px;"></textarea></td>
			
		</tr>
          </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">备注</td>
			<td colspan="7"><textarea class="easyui-validatebox" style="height:100px; width:930px;"></textarea></td>
			
		</tr>


</table>



</body>
</html>
    