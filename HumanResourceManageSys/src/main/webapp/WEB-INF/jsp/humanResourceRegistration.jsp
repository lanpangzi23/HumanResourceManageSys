<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
	
<form id="upload_form" enctype="multipart/form-data" action="humanResourceRegistration" method="post">
	<table border="1" width="1000px" cellpadding="0" cellspacing="0">
	<input class="easyui submit" type="button"  style="margin-left:899px; background:#CFC;" value="提交"/>
    <input class="easyui" type="reset" style="background:#F33;"  value="清除"/>
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">I级机构</td>

		<td>
			<input name="first_kind_name" id="first_kind_name" type="hidden" />
			<input name="first_kind_id" id="cc1" class="easyui-combobox"
				data-options="   
			        valueField: 'first_kind_id',
		        	textField: 'first_kind_name',
		        	url: 'findAllFirstKind',
		        	onSelect: function(rec){
		        		$('#first_kind_name').val(rec.first_kind_name);
			            var url = 'findSecondKindByFirst?first_kind_id='+rec.first_kind_id;
			            $('#cc2').combobox('reload', url);
		        }" />

		</td>
			<td style="text-align:center" class="backcolor">II级机构</td>
			<td>
			<input name="second_kind_name" id="second_kind_name" type="hidden" />
			<input name="second_kind_id" id="cc2" class="easyui-combobox"
					data-options="
 					valueField:'second_kind_id', 
 					textField:'second_kind_name',
 		        	onSelect: function(rec){ 
 		        		$('#second_kind_name').val(rec.second_kind_name);
 			            var url = 'findThirdKindBySecondKindId?second_kind_id='+rec.second_kind_id;
			            $('#cc3').combobox('reload', url); 
 				}" /> 

			</td>
			<td style="text-align:center" class="backcolor">III级机构</td>
			<td>
			<input name="third_kind_name" id="third_kind_name" type="hidden" />
				<input  name="third_kind_id"  id="cc3" class="easyui-combobox" data-options="valueField:'third_kind_id',textField:'third_kind_name',
				onSelect: function(rec){ 
 		        		$('#third_kind_name').val(rec.third_kind_name);
 				}"/>

			</td>
			<td rowspan="5" colspan="2"><center>
					<div id="Imgdiv">
     		  			 <img id="Img" width="200px" height="200px"/>
   		 			</div>
       				 <input class="easyui-filebox" style="width:300px" data-options='onChange:change_photo' id="file_upload" name="picUrl"/>
       				 <br/> 
</td>
		</tr>
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">职位分类</td>
			<td>
			<input name="human_major_kind_name" id="human_major_kind_name" type="hidden" />
				<input name="human_major_kind_id" id="aa1" class="easyui-combobox"
				data-options="   
			        valueField: 'major_kind_id',
		        	textField: 'major_kind_name',
		        	url: 'findAllConfigMajorKind',
		        	onSelect: function(rec){
		        	$('#human_major_kind_name').val(rec.major_kind_name);
			            var url = 'selectConfigMajorByKind?major_kind_id='+rec.major_kind_id;
			            $('#aa2').combobox('reload', url);
		        }" />
			</td>
			<td style="text-align:center" class="backcolor">职位名称</td>
			<td>
			<input name="hunma_major_name" id="human_major_name" type="hidden" />
				<input name="human_major_id" id="aa2" class="easyui-combobox"
					data-options="
 					valueField:'major_id', 
 					textField:'major_name',onSelect: function(rec){
		        	$('#human_major_name').val(rec.major_name);
		        }" />
			</td>
			<td style="text-align:center" class="backcolor">职称</td>
			<td>
				<select name="human_pro_designation" class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${technicalTitles}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">姓名</td>
			<td><input class="easyui" type="text" id="I" name="human_name"></td>
			<td style="text-align:center" class="backcolor">性别</td>
			<td><select name="human_sex" class="easyui-combobox" type="text" id="tertiaryMechanism">
						<option value="男">男</option>
						<option value="女">女</option>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">EMAIL</td>
			<td><input class="easyui" type="email" id="I" name="human_email"></td>
		</tr>
        <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">电话</td>
			<td><input class="easyui" type="number" id="I" name="human_telephone"></td>
			<td style="text-align:center" class="backcolor">QQ</td>
			<td><input class="easyui" type="number" id="I" name="human_qq"></td>
			<td style="text-align:center" class="backcolor">手机</td>
			<td><input class="easyui" type="tel" id="I" name="human_mobilephone"></td>
		</tr>
         <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">住址</td>
			<td colspan="3"><input class="easyui" type="text" id="I" name="human_address"></td>
			<td style="text-align:center" class="backcolor">邮编</td>
			<td><input class="easyui" type="text" id="I" name="human_postcode"></td>
			
		</tr>
		
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">国籍</td>
			<td>
				<select name="human_nationality" class="easyui-combobox" type="text" >
					<c:forEach items="${nationalitys}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">出生地</td>
			<td><input name="human_birthplace" class="easyui" type="text"></td>
			<td style="text-align:center" class="backcolor">生日</td>
			<td>
			<input id="human_birthday" name="human_birthday" class="easyui-datebox" />
			</td>
			
          
            <td style="text-align:center" class="backcolor">民族</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_race">
					<c:forEach items="${nations}" var="s">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">宗教信仰</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_religion">
					<c:forEach items="${religiousBeliefs}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">政治面貌</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_party">
					<c:forEach items="${politicalStatus}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">身份证号码</td>
			<td><input name="human_id_card" class="easyui" type="text" id="I" onblur="checkCardId()"></td>
            <td style="text-align:center" class="backcolor">社会保障号码</td>
			<td><input name="human_society_security_id" class="easyui" type="text" id="I" ></td>
		</tr>
          </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">年龄</td>
			<td><input name="human_age" class="easyui" type="text" id="I" ></td>
			<td style="text-align:center" class="backcolor">学历</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_educated_degree">
					<c:forEach items="${schooling}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">教育年限</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_educated_years">
					<c:forEach items="${educationsYears}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
            <td style="text-align:center" class="backcolor">学历专业</td>
			<td>
				<select class="easyui-combobox" type="text" name="human_educated_major">
					<c:forEach items="${educations}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">薪酬标准</td>
			<td>
				<select class="easyui-combobox" type="text" name="salary_standard_id">
					<c:forEach items="${salaryStandard}" var="s" >
						<option value="${s.standard_id }">${s.standard_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">开户银行</td>
			<td><input name="human_bank" class="easyui" type="text" id="I" ></td>
			<td style="text-align:center" class="backcolor">账号</td>
			<td><input name="human_account" class="easyui" type="text" id="I" ></td>
            <td style="text-align:center" class="backcolor">登记人</td>
			<td><input name="register" class="easyui" type="text" id="I" value="${uname}" ></td>
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">建档时间</td>
			<td><input name="regist_time" class="easyui" type="text" id="I" value="<%=new Date() %>" ></td>
			<td style="text-align:center" class="backcolor">特长</td>
			<td>
				<select name="human_speciality" class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${strongPoints}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">爱好</td>
			<td>
				<select name="human_hobby" class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${hobbys}" var="s" >
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
			<input class="easyui-textbox" name="human_histroy_records" data-options="multiline:true" style="height:100px;width:930px">
			</td>
			
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">家庭关系信息</td>
			<td colspan="7">
			<input class="easyui-textbox" name="human_family_membership" data-options="multiline:true" style="height:100px;width:930px">
			</td>
			
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">备注</td>
			<td colspan="7">
			<input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:100px;width:930px">
			</td>
			
		</tr>
</table></form>
<script>
$(function () {
    $(".submit").click(function () {
    	checkId();
    	checkBirhtday();
    	checkPic();
    	checkName();
    	if(checkId()==true&&checkBirhtday()==true&&checkPic()==true&&checkName()==true){
    			 $("#upload_form").ajaxSubmit({
                     success: function (data) {
                     	if(data==1){
                     		alert('登记成功...请尽快审核....')
                     	}else{
                     		alert('登记失败 ...');
                     	}
                     },
                     error: function (error) { alert('登记失败 ...'); },
                     url: 'humanResourceRegistration', /*设置post提交到的页面*/
                     type: "post", /*设置表单以post方法提交*/
                     dataType: "text" /*设置返回值类型为文本*/
                 });
    	}else{
    		alert('请完善信息')
    	}
    });
});
//身份证号检查 
function checkCardId(){
	var human_id_card=$('input[name="human_id_card"]').val();
	if(human_id_card==''){
		alert('身份证号不能为空！！')
	}else{
	$.post('checkHumanCardId',{human_id_card:human_id_card},function(data){
		if(data==1){
			alert('该人员档案已经存在.....请勿重复登记!!!!');
			$('input[name="human_id_card"]').val('');
		}
	},'text')}
}
//图片上传  及数据保存  
function checkId(){
	var human_id_card=$('input[name="human_id_card"]').val();
	 if(human_id_card==''){
		 alert('身份证号不能为空....')
		 return false;
	 }else{
		 return true;
	 }
}
 function checkBirhtday(){
	var birthday=$('input[name=human_birthday]').val();
	 if(birthday==''){
		 alert('请输入生日！');
		 return false;
	 }else{
		 var date=new Date(birthday);
		 $('input[name=human_birthday]').val(date);
		 return true;
	 }
}
	 function checkPic(){
		 if($('input[name=picUrl]').val()==''){
			 alert('请上传头像');
			 return false;
		 }else{
			 return true;
		 }
	 }
	function checkName(){
		 if($('input[name=human_name]').val()==''){
			 alert('姓名不能为空');
			 return false;
		 }else{
			 return true;
		 }
	}

$('#human_birthday').bind('input propertychange',function(){
	$('#dataTiShi').attr('type','text');
	
})
function change_photo(){
    PreviewImage($("input[name='picUrl']")[0], 'Img', 'Imgdiv');
}
function PreviewImage(fileObj,imgPreviewId,divPreviewId){  
    var allowExtention=".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;  
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();              
    var browserVersion= window.navigator.userAgent.toUpperCase();  
    if(allowExtention.indexOf(extention)>-1){   
        if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等  
            if(window.FileReader){  
                var reader = new FileReader();   
                reader.onload = function(e){  
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);  
                }    
                reader.readAsDataURL(fileObj.files[0]);  
            }else if(browserVersion.indexOf("SAFARI")>-1){  
                alert("不支持Safari6.0以下浏览器的图片预览!");  
            }  
        }else if (browserVersion.indexOf("MSIE")>-1){  
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6  
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
            }else{//ie[7-9]  
                fileObj.select();  
                if(browserVersion.indexOf("MSIE 9")>-1)  
                    fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问  
                var newPreview =document.getElementById(divPreviewId+"New");  
                if(newPreview==null){  
                    newPreview =document.createElement("div");  
                    newPreview.setAttribute("id",divPreviewId+"New");  
                    newPreview.style.width = document.getElementById(imgPreviewId).width+"px";  
                    newPreview.style.height = document.getElementById(imgPreviewId).height+"px";  
                    newPreview.style.border="solid 1px #d2e2e2";  
                }  
                newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";                              
                var tempDivPreview=document.getElementById(divPreviewId);  
                tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);  
                tempDivPreview.style.display="none";                      
            }  
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox  
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);  
            if(firefoxVersion<7){//firefox7以下版本  
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());  
            }else{//firefox7.0+                      
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));  
            }  
        }else{  
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
        }           
    }else{  
        alert("仅支持"+allowExtention+"为后缀名的文件!");  
        fileObj.value="";//清空选中文件  
        if(browserVersion.indexOf("MSIE")>-1){                          
            fileObj.select();  
            document.selection.clear();  
        }                  
        fileObj.outerHTML=fileObj.outerHTML;  
    }  
}
</script>
</body>
</html>
    