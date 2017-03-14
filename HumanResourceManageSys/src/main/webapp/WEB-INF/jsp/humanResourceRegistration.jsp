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
	
	<input class="easyui" type="button" id="login" style="margin-left:899px; background:#CFC;" value="提交"/>
    <input class="easyui" type="reset" style="background:#F33;"  value="删除"/>
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">I级机构</td>
			<td ><select class="easyui-combobox" type="text" id="primaryMechanism">
					<c:forEach items="${configFileFirstKinds}" var="s" varStatus="ss">
						<option value="${s.first_kind_id }">${s.first_kind_name }</option>
					</c:forEach>
			</select></td>
			<td style="text-align:center" class="backcolor">II级机构</td>
			<td><select class="easyui-combobox" type="text" id="secondaryInstitutions">
					<c:forEach items="${configFileSecondKind}" var="s" varStatus="ss">
						<option value="${s.second_kind_id }">${s.second_kind_name }</option>
					</c:forEach>
			</select></td>
			<td style="text-align:center" class="backcolor">III级机构</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${configFileThirdKind}" var="s" varStatus="ss">
						<option value="${s.second_kind_id }">${s.third_kind_name }</option>
					</c:forEach>
				</select>
			</td>
			<td rowspan="5" colspan="2"><center>
					<div id="Imgdiv">
     		  			 <img id="Img" width="200px" height="200px"/>
   		 			</div>
				
       				 <input class="easyui-filebox" style="width:300px" data-options='onChange:change_photo' id="file_upload" name="file_upload2"/><br/> 
   			
    	
    </center></td>
		</tr>
		<tr style="height:35px;">
			<td style="text-align:center" class="backcolor">职位分类</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${configMajorKind}" var="s" varStatus="ss">
						<option value="${s.major_kind_id }">${s.major_kind_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">职位名称</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${configMajor}" var="s" varStatus="ss">
						<option value="${s.major_id }">${s.major_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">职称</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${technicalTitles}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
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
			<td colspan="3"><input class="easyui" type="text" id="I" name="human_address"></td>
			<td style="text-align:center" class="backcolor">邮编</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			
		</tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">国籍</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${nationalitys}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">出生地</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
			<td style="text-align:center" class="backcolor">生日</td>
			<td><input class="easyui" type="text" id="I" name="Ijjg"></td>
            <td style="text-align:center" class="backcolor">民族</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${nations}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
        </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">宗教信仰</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${religiousBeliefs}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">政治面貌</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${politicalStatus}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
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
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${schooling}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">教育年限</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${educationsYears}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
            <td style="text-align:center" class="backcolor">学历专业</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${educations}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
         </tr>
           <tr style="height:35px;">
			<td style="text-align:center" class="backcolor">薪酬标准</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${configFileThirdKind}" var="s" varStatus="ss">
						<option value="${s.second_kind_id }">${s.third_kind_name }</option>
					</c:forEach>
				</select>
			</td>
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
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${strongPoints}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="text-align:center" class="backcolor">爱好</td>
			<td>
				<select class="easyui-combobox" type="text" id="tertiaryMechanism">
					<c:forEach items="${hobbys}" var="s" varStatus="ss">
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
			</td>
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

 
</table></form>
<script>
$('#login').click(function(){
	alert(1)
	$('form').submit();
})

function change_photo(){
    PreviewImage($("input[name='file_upload2']")[0], 'Img', 'Imgdiv');
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
    