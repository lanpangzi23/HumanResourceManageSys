<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<div id="tt" class="easyui-tabs">
	<div title="简历登记">
		<p>您正在做的业务是:人力资源--招聘管理--简历管理--简历登记</p>
		<input class="find" type="button" value="提交" /><input type="button" value="清除" />
		<table border="1" bordercolor="#CCCCCC" width="700" cellpadding="0" cellspacing="0">
			<tr>
				<td>职位分类</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>职位名称</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>招聘类型</td>
				<td><input class="easyui-combobox" style="width: 130px;"></td>
				<td rowspan="6" colspan="2" style="width: 120px"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" style="width: 70px;"></td>
				<td>性别</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>EMAIL</td>
				<td><input type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" style="width: 70px;"></td>
				<td>家庭电话</td>
				<td><input type="text" style="width: 70px;"></td>
				<td>手机</td>
				<td><input type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>住址</td>
				<td colspan="3"><input type="text" style="width: 300px;"></td>
				<td>邮编</td>
				<td><input type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>国籍</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>出生地</td>
				<td><input type="text" style="width: 70px;"></td>
				<td>生日</td>
				<td><input type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>民族</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>宗教信仰</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>政治面貌</td>
				<td><input class="easyui-combobox" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" style="width: 70px;"></td>
				<td>年龄</td>
				<td><input type="text" style="width: 70px;"></td>
				<td>毕业学校</td>
				<td><input type="text" style="width: 130px;"></td>
				<td>学历</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
			</tr>
			<tr>
				<td>教育年限</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>学历专业</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>薪酬要求</td>
				<td><input type="text" style="width: 130px;"></td>
				<td>注册时间</td>
				<td><input type="text" readonly="true" style="width: 70px;"></td>
			</tr>
			<tr>
				<td>特长</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td>爱好</td>
				<td><input class="easyui-combobox" style="width: 70px;"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>个人履历</td>
				<td colspan="7"><textarea style="width: 600px; height: 80px;"></textarea></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="7"><textarea style="width: 600px; height: 80px;"></textarea></td>
			</tr>
		</table>
	</div>
	<div title="简历筛选"></div>
	<div title="有效简历查询"></div>
</div>
</body>
