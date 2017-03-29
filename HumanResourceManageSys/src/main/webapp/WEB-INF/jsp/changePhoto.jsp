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
<center>
<h1>档案照片修改</h1>
<br/><br/><br/><br/>
<form id="photo_form" enctype="multipart/form-data" action="changePhoto" method="post">
					<div id="Imgdiv">
     		  			 <img id="Img" width="200px" height="200px"  src="${humanFileCheck.human_picture}"/>
   		 			</div>
       				 <input class="easyui-filebox" style="width:300px" data-options='onChange:change_photo' id="file_upload" name="picUrl"/>
       				 <input class="easyui" type="hidden" id="humanid" name="human_id" value="${humanFileCheck.human_id}"/>
       				 <br/><br/>
       				 <input class="easyui" type="button" id="changePicture"  value="确认修改"/>
       				 <input class="easyui submit" type="button" onclick="back()" value="返回"/>
</center>
<script>
$(function () {
    $("#changePicture").click(function () {
        $("#photo_form").ajaxSubmit({
            success: function (data) {
            	if(data==1){
            		alert('修改成功')
            		$('#main_panel').panel('refresh',"tohumanResourceFileRegistrationReviewEnd/"+$('#humanid').val());
            	}else{
            		alert('修改失败')
            	}
            },
            error: function (error) { alert('修改失败'); },
            url: 'changePicture', /*设置post提交到的页面*/
            type: "post", /*设置表单以post方法提交*/
            dataType: "text" /*设置返回值类型为文本*/
        });
    });
});

function back(){
	var id=$('#humanid').val();
	$('#main_panel').panel('refresh',"tohumanResourceFileRegistrationReviewEnd/"+id);
}
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