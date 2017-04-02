<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<body>
<div id="tt" class="easyui-tabs">
	<div title="简历登记">
		<form id="add_form" enctype="multipart/form-data" method="post">
		<p>您正在做的业务是:人力资源--招聘管理--简历管理--简历登记</p>
		<input class="find" type="button" value="提交" /><input type="button" value="清除" />
		<table border="1" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0">
			<tr>
				<td>职位分类</td>
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
				<td>职位名称</td>
				<td>
					<input name="human_major_name" id="human_major_name" type="hidden" />
					<input name="human_major_id" id="aa2" class="easyui-combobox"
						data-options="
 							valueField:'major_id', 
 							textField:'major_name',
 							onSelect: function(rec){
		        					$('#human_major_name').val(rec.major_name);
		        		}" />
		        </td>
				<td>招聘类型</td>
				<td>
					<select id="cc" class="easyui-combobox" name="engage_type" style="width:100px;">  
			    		<option>社会招聘</option>  
			    		<option>校园招聘</option>  
					</select>
				</td>
				<td rowspan="6" colspan="2" style="width: 120px">
					<div id="Imgdiv">
     		  			 <img id="Img" width="200px" height="200px"/>
   		 			</div>
       				<input class="easyui-filebox" style="width:300px" data-options='onChange:change_photo' name="picUrl"  id="file_upload" />
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input name="human_name" type="text" style="width: 130px;"></td>
				<td>性别</td>
				<td>
					<select id="cc" class="easyui-combobox" name="human_sex" style="width:100px;">  
			    		<option>男</option>  
			    		<option>女</option>  
					</select>
				</td>
				<td>EMAIL</td>
				<td><input name="human_email" type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input name="human_telephone" type="text" style="width: 130px;"></td>
				<td>家庭电话</td>
				<td><input name="human_homephone" type="text" style="width: 130px;"></td>
				<td>手机</td>
				<td><input name="human_mobilephone" type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>住址</td>
				<td colspan="3"><input name="human_address" type="text" style="width: 300px;"></td>
				<td>邮编</td>
				<td><input name="human_postcode" type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>国籍</td>
				<td>
				<select name="human_nationality" class="easyui-combobox">
					<c:forEach items="${nationalitys}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
				</select>
				</td>
				<td>出生地</td>
				<td><input name="human_birthplace" type="text" style="width: 130px;"></td>
				<td>生日</td>
				<td>
					<input id="dd" type="text" class="easyui-datebox" style="width: 100px;" required="required"></input>
					<input id="deadline" type="hidden" style="width: 100px;" name="human_birthday"></input>
				</td>
			</tr>
			<tr>
				<td>民族</td>
				<td>
					<select class="easyui-combobox" name="human_race">
						<c:forEach items="${nations}" var="s">
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
				<td>宗教信仰</td>
				<td>
					<select class="easyui-combobox" name="human_religion">
						<c:forEach items="${religiousBeliefs}" var="s" varStatus="ss">
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
				<td>政治面貌</td>
				<td>
					<select class="easyui-combobox" name="human_party">
						<c:forEach items="${politicalStatus}" var="s" varStatus="ss">
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input name="human_idcard" type="text" style="width: 130px;"></td>
				<td>年龄</td>
				<td><input name="human_age" type="text" style="width: 130px;"></td>
				<td>毕业学校</td>
				<td><input name="human_college" type="text" style="width: 130px;"></td>
				<td>学历</td>
				<td>
					<select class="easyui-combobox" name="human_educated_degree">
						<c:forEach items="${schooling}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>教育年限</td>
				<td>
					<select class="easyui-combobox"  name="human_educated_years">
						<c:forEach items="${educationsYears}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
				<td>学历专业</td>
				<td>
					<select class="easyui-combobox" name="human_educated_major">
						<c:forEach items="${educations}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
				<td>薪酬要求</td>
				<td>
					<select id="cc" class="easyui-combobox" name="demand_salary_standard" style="width:130px;">  
			    		<option>1000元/月以下</option>  
			    		<option>1000-2000元/月</option>  
			    		<option>2001-4000元/月</option> 
			    		<option>4001-6000元/月</option> 
			    		<option>6001-8000元/月</option> 
			    		<option>10001-15000元/月</option> 
			    		<option>15000-25000元/月</option> 
			    		<option>25000-35000元/月</option> 
			    		<option>35000-50000元/月</option> 
			    		<option>50000-70000元/月</option> 
			    		<option>70000-100000元/月</option> 
			    		<option>100000元/月以上</option>  
			    		<option>面议</option>  
					</select>
				</td>
				<td>注册时间</td>
				<td><input type="text" name="regist_time" readonly="readonly" value="<%=new Date() %>" style="width: 70px;"></td>
			</tr>
			<tr>
				<td>特长</td>
				<td>
					<select name="human_speciality" class="easyui-combobox" id="tertiaryMechanism">
						<c:forEach items="${strongPoints}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
				<td>爱好</td>
				<td>
					<select name="human_hobby" class="easyui-combobox" type="text" id="tertiaryMechanism">
						<c:forEach items="${hobbys}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
				</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>个人履历</td>
				<td colspan="7"><textarea name="human_history_records" style="width: 600px; height: 80px;"></textarea></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="7"><textarea name="remark" style="width: 600px; height: 80px;"></textarea></td>
			</tr>
		</table>
		</form>
	</div>
	<div title="简历筛选">
		<p>您正在做的业务是:人力资源--招聘管理--简历管理--简历筛选</p>
		<input type="button" onClick="find()" value="查找">
		<table border="1" width="900px" cellpadding="0" cellspacing="0">
			<tr style="height:35px;">
				<td class="backcolor" style="text-align:center">请选择职位分类</td>
				<td >
					<input name="human_major_kind_id" id="id" class="easyui-combobox"
						data-options="   
			        			valueField: 'major_kind_id',
		        				textField: 'major_kind_name',
		        				url: 'findAllConfigMajorKind'" />
		    </td>
			</tr>
			<tr style="height:35px;">
				<td class="backcolor" style="text-align:center">请输入关键字</td>
				<td ><input name='keyword' /> </td>
			</tr>
        	<tr style="height:35px;">
				<td class="backcolor" style="text-align:center">请输入登记时间</td>
				<td >
					<input class="easyui-datebox" id="min">至<input class="easyui-datebox"  id="max">
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
function find(){
	var minDate=$('#min').val();
	var maxDate=$('#max').val();
	var keyword=$('input[name="keyword"]').val();
	var id=$('#id').combobox('getValues');
	var tab = $('#tt').tabs('getSelected');  // get selected panel
	$('#tt').tabs('update', {
		tab: tab,
		options: {
			content : '<iframe scrolling="auto" frameborder="0"  src="toFindEngageResume?minDate='+minDate+'&maxDate='+maxDate+
					'&keyword='+keyword+'&id='+id+'" style="width:1000px;height:400px;"></iframe>',
		}
	});
}
$(function () {
    $(".find").click(function () {
    	$("#add_form").ajaxSubmit({
             success: function (data) {
                 alert(data);
             },
             error: function (error) { alert('登记失败 ...'); },
                 url: 'addEngageResume', /*设置post提交到的页面*/
                 type: "post", /*设置表单以post方法提交*/
                 dataType: "text" /*设置返回值类型为文本*/
         });
    });
});
$(document).ready(function(){
	$("#dd").datebox({
		required:true,
		onSelect:function(date){
			$('#deadline').val(date);
		}
	});
})
function change_photo(){
    PreviewImage($("input[name='picUrl']")[0], 'Img', 'Imgdiv');
}
function PreviewImage(fileObj,imgPreviewId,divPreviewId){  
	console.info(fileObj);
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
