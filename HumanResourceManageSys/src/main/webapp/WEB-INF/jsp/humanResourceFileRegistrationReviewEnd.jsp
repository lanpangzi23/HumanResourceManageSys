<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记复核</p><br/>
<form id="check_form" enctype="multipart/form-data">
	<table border="1" width="1000px" cellpadding="0" cellspacing="0">
	<input class="easyui checkHumanFile" type="button" style="margin-left:805px;; background:#CFC;" value="复核通过"/>&nbsp;&nbsp;
    <input class="easyui" type="reset" style="background:#F33;"  value="清除"/>&nbsp;&nbsp;
    <input class="easyui" type="button" style="" onclick="backCheck()" value="返回"/>
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">档案编号</td>
			<td colspan="5" ><input class="easyui" type="text" id="FileNumber" value="${humanFileCheck.human_id}" name="human_id" style="border: none;" readonly="readonly"></td>
			
			<td rowspan="6" colspan="2">
			
			<center>
			<input class="easyui"  width="200px" height="200px"  type="image" src="${humanFileCheck.human_picture}"/><br/>
				 <input class="easyui" type="button"  onclick="changePhoto('${humanFileCheck.human_id}')" value="更改档案照片"/>	
			</center>
			
			</td>
		</tr>
        <td class="backcolor" style="text-align:center">I级机构</td>
			<td ><input class="easyui" type="text" id="I" name="first_kind_id" value="${humanFileCheck.first_kind_name}" style="border: none;" readonly="readonly"/></td>
			<td style="text-align:center" class="backcolor">II级机构</td>
			<td><input class="easyui" type="text" id="I" name="second_kind_id" value="${humanFileCheck.second_kind_name}" style="border: none;" readonly="readonly"/></td>
			<td style="text-align:center" class="backcolor" >III级机构</td>
			<td><input class="easyui" type="text" id="I" name="third_kind_id" value="${humanFileCheck.third_kind_name}" style="border: none;" readonly="readonly"/></td>
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">职位分类</td>
			<td>
				<input class="easyui" type="text" id="I" name="human_major_kind_id" value="${humanFileCheck.human_major_kind_name}" style="border: none;" readonly="readonly"/>
			</td>
			<td style="text-align:center" class="backcolor">职位名称</td>
			<td>
					<input class="easyui" type="text" id="I" name="human_major_id" value="${humanFileCheck.hunma_major_name}" style="border: none;" readonly="readonly"/>
			</td>
			<td style="text-align:center" class="backcolor">职称</td>
			<td>
				<select name="human_pro_designation" class="easyui-combobox"  data-option="${humanFileCheck.human_pro_designation}" type="text" id="tertiaryMechanism">
					<c:forEach items="${technicalTitles}" var="s" >
						<c:if test="${s.attribute_name ==humanFileCheck.human_pro_designation}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">姓名</td>
			<td><input class="easyui" type="text" id="I" name="human_name" value="${humanFileCheck.human_name}"/></td>
			<td style="text-align:center" class="backcolor">性别</td>
			<td><input class="easyui" type="text" id="I" name="human_sex" value="${humanFileCheck.human_sex}"/>
			</td>
			<td style="text-align:center" class="backcolor">EMAIL</td>
			<td><input class="easyui" type="email" id="I" name="human_email" value="${humanFileCheck.human_email}"/></td>
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">电话</td>
			<td><input class="easyui" type="number" id="I" name="human_telephone" value="${humanFileCheck.human_telephone}"/></td>
			<td style="text-align:center" class="backcolor">QQ</td>
			<td><input class="easyui" type="number" id="I" name="human_qq" value="${humanFileCheck.human_qq}"/></td>
			<td style="text-align:center" class="backcolor">手机</td>
			<td><input class="easyui" type="tel" id="I" name="human_mobilephone" value="${humanFileCheck.human_mobilephone}"/></td>
		</tr>
         <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">住址</td>
			<td colspan="3"><input class="easyui" type="text" id="I" name="human_address" value="${humanFileCheck.human_address}"/></td>
			<td style="text-align:center" class="backcolor">邮编</td>
			<td><input class="easyui" type="text" id="I" name="human_postcode" value="${humanFileCheck.human_postcode}"/></td>
			
		</tr>
		
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">国籍</td>
			<td>
				<select name="human_nationality" class="easyui-combobox" data-option="${humanFileCheck.human_nationality}">
					<c:forEach items="${nationalitys}" var="s" >
						<c:if test="${s.attribute_name ==humanFileCheck.human_nationality}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">出生地</td>
			<td><input name="human_birthplace" class="easyui" type="text"  value="${humanFileCheck.human_birthplace}"/></td>
			<td style="text-align:center" class="backcolor">生日</td>
			<td>
			<input class="easyui" value="格式需为HHH-DD-MM" type="hidden" id="dataTiShi"  style="background-color:#FF903C;font-weight:300; border-bottom-color: red;"/>
			<input id="human_birthday" name="human_birthday" class="easyui-datebox" onblur="todate()"  value="${humanFileCheck.human_birthday}"/>
			</td>
            <td style="text-align:center" class="backcolor">民族</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_race" data-option="${humanFileCheck.human_race}">
					<c:forEach items="${nations}" var="s">
						<c:if test="${s.attribute_name ==humanFileCheck.human_race}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">宗教信仰</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_religion" data-option="${humanFileCheck.human_religion}">
					<c:forEach items="${religiousBeliefs}" var="s" varStatus="ss">
						<c:if test="${s.attribute_name ==humanFileCheck.human_religion}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">政治面貌</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_party" data-option="${humanFileCheck.human_party}">
					<c:forEach items="${politicalStatus}" var="s" varStatus="ss">
						<c:if test="${s.attribute_name==humanFileCheck.human_party}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">身份证号码</td>
			<td><input name="human_id_card" class="easyui" type="text" id="I"  value="${humanFileCheck.human_id_card}"/></td>
            <td style="text-align:center" class="backcolor">社会保障号码</td>
			<td><input name="human_society_security_id" class="easyui" type="text" id="I"  value="${humanFileCheck.human_society_security_id}"/></td>
		</tr>
          </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">年龄</td>
			<td><input name="human_age" class="easyui" type="text" id="I" value="${humanFileCheck.human_age}"/></td>
			<td style="text-align:center" class="backcolor">学历</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_educated_degree" data-option="${humanFileCheck.human_educated_degree}">
					<c:forEach items="${schooling}" var="s" >
						<c:if test="${s.attribute_name ==humanFileCheck.human_educated_degree}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">教育年限</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_educated_years" data-option="${humanFileCheck.human_educated_years}">
					<c:forEach items="${educationsYears}" var="s" >
						<c:if test="${s.attribute_name ==humanFileCheck.human_educated_years}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
            <td style="text-align:center" class="backcolor">学历专业</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_educated_major" data-option="${humanFileCheck.human_educated_major}">
					<c:forEach items="${educations}" var="s" >
						<c:if test="${s.attribute_name ==humanFileCheck.human_educated_major}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">薪酬标准</td>
			<td>
				<select class="easyui-combobox" type="text" name="salary_standard_id" data-option="${humanFileCheck.salary_standard_id}">
					<c:forEach items="${salaryStandard}" var="s" >
						<c:if test="${s.standard_id==humanFileCheck.salary_standard_id }">
						<option value="${s.standard_id }" selected>${s.standard_name }</option>
					</c:if>
						<option value="${s.standard_id }">${s.standard_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">开户银行</td>
			<td><input name="human_bank" class="easyui" type="text" id="I"  value="${humanFileCheck.human_bank}"/></td>
			<td style="text-align:center" class="backcolor">账号</td>
			<td><input name="human_account" class="easyui" type="text" id="I"  value="${humanFileCheck.human_account}"/></td>
            <td style="text-align:center" class="backcolor">复核人</td>
			<td><input name="checker" class="easyui" type="text" id="I"  value="登录人"/></td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">复核时间</td>
			<td><input name="check_time" class="easyui" type="text" id="I" value="<%=new Date() %>"/></td>
			<td style="text-align:center" class="backcolor">特长</td>
			<td>
				<select name="human_speciality" class="easyui-combobox" type="text" id="tertiaryMechanism" data-option="${humanFileCheck.human_speciality}">
					<c:forEach items="${strongPoints}" var="s" >
					<c:if test="${s.attribute_name==humanFileCheck.human_speciality }">
						<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
					</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">爱好</td>
			<td>
				<select name="human_hobby" class="easyui-combobox" type="text" id="tertiaryMechanism" data-option="${humanFileCheck.human_hobby}">
					<c:forEach items="${hobbys}" var="s" >
						<c:if test="${s.attribute_name ==humanFileCheck.human_hobby}">
							<option value="${s.attribute_name }" selected>${s.attribute_name }</option>
						</c:if>
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
            <td style="text-align:center" class="backcolor"></td>
			<td><input class="easyui" type="text" id="I" ></td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">个人履历</td>
			<td colspan="7">
			<input class="easyui-textbox" name="human_histroy_records" data-options="multiline:true" style="height:100px;width:930px" value="${humanFileCheck.human_histroy_records}">
			</td>
			
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">家庭关系信息</td>
			<td colspan="7">
			<input class="easyui-textbox" name="human_family_membership" data-options="multiline:true" style="height:100px;width:930px" value="${humanFileCheck.human_family_membership}">
			</td>
			
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">备注</td>
			<td colspan="7">
			<input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:100px;width:930px" value="${humanFileCheck.remark}"/>
			</td>
			
		</tr>
		</table>
		</form>
<script type="text/javascript">
//更改照片 
function changePhoto(id){
	$('#main_panel').panel('refresh',"toChangePhoto/"+id);
}
//档案复核 
 $(function () {
            $(".checkHumanFile").click(function () {
            	 var birthday=$('input[name=human_birthday]').val();
            	 var date=new Date(birthday);
               	 $('input[name=human_birthday]').val(date);
                $("#check_form").ajaxSubmit({
                    success: function (data) {
                    	if(data==1){
                    		alert('复核成功')
                    		$('#main_panel').panel('refresh',"tohumanResourceFileRegistrationReview");
                    	}else{
                    		alert('复核失败')
                    	}
                    },
                    error: function (error) { alert('复核失败'); },
                    url: 'checkHumanFile', /*设置post提交到的页面*/
                    type: "post", /*设置表单以post方法提交*/
                    dataType: "text" /*设置返回值类型为文本*/
                });
            });
        });
//返回  
function backCheck(){
	$('#main_panel').panel('refresh',"tohumanResourceFileRegistrationReview");
}

	</script>
</body>
</html>