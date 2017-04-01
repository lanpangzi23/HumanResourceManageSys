<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
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
<title>源辰信息科技有限公司-人力资源档案登记</title>
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
</head>
<body>
<form id="update_form" enctype="multipart/form-data"  method="post">
		<p>您正在做的业务是:人力资源--招聘管理--简历管理--简历筛选</p>
		<input class="update" type="button" value="提交修改" /><input type="button" value="清除" />
		<table border="1" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0">
			<tr>
				<td>职位分类</td>
				<td>
					<input name="human_major_kind_id" id="aa1"  class="easyui-combobox"
						data-options="   
			        			valueField: 'major_kind_id',
		        				textField: 'major_kind_name',
		        				url: 'findAllConfigMajorKind',
		        				onSelect: function(rec){
		        					$('#human_major_kind_name').val(rec.major_kind_name);
			            			var url = 'selectConfigMajorByKind?major_kind_id='+rec.major_kind_id;
			            			$('#aa2').combobox('reload', url);
		        		}" />
		        	<input type="hidden" value="${engageResume.human_major_kind_id }" id="human_major_kind_id"  />
		        	<input type="hidden" value="${engageResume.res_id }" name="res_id" />
					<input name="human_major_kind_name" type="hidden" value="${engageResume.human_major_kind_name }" id="human_major_kind_name"  />
				</td>
				<td>职位名称</td>
				<td>
					<input name="hunma_major_name" value="${engageResume.human_major_name }" id="human_major_name" type="hidden" />
					<input type="hidden" value="${engageResume.human_major_id }" id="human_major_id"  />
					<input name="human_major_id" id="aa2"  class="easyui-combobox"
						data-options="
 							valueField:'major_id', 
 							textField:'major_name',onSelect: function(rec){
		        				$('#human_major_name').val(rec.major_name);
		        		}" />
		        </td>
				<td>招聘类型</td>
				<td>
					<select id="cc" class="easyui-combobox" name="engage_type" style="width:100px;">  
			    		<option>社会招聘</option>  
			    		<option>校园招聘</option>  
					</select>
					<input type="hidden" value="${engageResume.engage_type }" id="engage_type"  />
				</td>
				<td rowspan="6" colspan="2" style="width: 120px">
					<div id="Imgdiv">
	     		  		 <img id="Img" src="${engageResume.human_picture}" width="200px" height="200px"/>
	   		 		</div>
       				<input class="easyui-filebox" style="width:300px" name="pic" data-options='onChange:change_photo'  id="file_upload" />
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input name="human_name" type="text" value="${engageResume.human_name }" style="width: 130px;"></td>
				<td>性别</td>
				<td>
					<select id="cc1" class="easyui-combobox" name="human_sex" style="width:100px;">  
			    		<option>男</option>  
			    		<option>女</option>  
					</select>
					<input id="human_sex" type="hidden" value="${engageResume.human_sex }" style="width: 130px;">
				</td>
				<td>EMAIL</td>
				<td><input name="human_email" type="text" value="${engageResume.human_email }" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input name="human_telephone" type="text" value="${engageResume.human_telephone }" style="width: 130px;"></td>
				<td>家庭电话</td>
				<td><input name="human_homephone" type="text" value="${engageResume.human_homephone }" style="width: 130px;"></td>
				<td>手机</td>
				<td><input name="human_mobilephone" type="text" value="${engageResume.human_mobilephone }" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>住址</td>
				<td colspan="3"><input name="human_address" value="${engageResume.human_address }" type="text" style="width: 300px;"></td>
				<td>邮编</td>
				<td><input name="human_postcode" value="${engageResume.human_postcode }" type="text" style="width: 130px;"></td>
			</tr>
			<tr>
				<td>国籍</td>
				<td>
					<select id="cc2" name="human_nationality" class="easyui-combobox">
					<c:forEach items="${nationalitys}" var="s" >
						<option value="${s.attribute_name }">${s.attribute_name }</option>
					</c:forEach>
					</select>
					<input id="human_nationality" type="hidden" value="${engageResume.human_nationality }" style="width: 130px;">
				</td>
				<td>出生地</td>
				<td><input name="human_birthplace" value="${engageResume.human_birthplace }" type="text" style="width: 130px;"></td>
				<td>生日</td>
				<td>
					<input id="dd" value="${engageResume.human_birthday }" class="easyui-datebox" style="width: 100px;"></input>
					<input id="human_birthday" name="human_birthday" type="hidden" value="${engageResume.human_birthday }" style="width: 130px;">
				</td>
			</tr>
			<tr>
				<td>民族</td>
				<td>
					<select id="cc3" class="easyui-combobox" name="human_race">
						<c:forEach items="${nations}" var="s">
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_race" type="hidden" value="${engageResume.human_race }" style="width: 130px;">
				</td>
				<td>宗教信仰</td>
				<td>
					<select id="cc5" class="easyui-combobox" name="human_religion">
						<c:forEach items="${religiousBeliefs}" var="s" varStatus="ss">
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_religion" type="hidden" value="${engageResume.human_religion }" style="width: 130px;">
				</td>
				<td>政治面貌</td>
				<td>
					<select id="cc4" class="easyui-combobox" name="human_party">
						<c:forEach items="${politicalStatus}" var="s" varStatus="ss">
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_party" type="hidden" value="${engageResume.human_party }" style="width: 130px;">
				</td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input name="human_idcard" value="${ engageResume.human_idcard}" type="text" style="width: 130px;"></td>
				<td>年龄</td>
				<td><input name="human_age" value="${ engageResume.human_age}" type="text" style="width: 130px;"></td>
				<td>毕业学校</td>
				<td><input name="human_college" value="${ engageResume.human_college}" type="text" style="width: 130px;"></td>
				<td>学历</td>
				<td>
					<select id="cc6" class="easyui-combobox" name="human_educated_degree">
						<c:forEach items="${schooling}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_educated_degree" type="hidden" value="${engageResume.human_educated_degree }" style="width: 130px;">
				</td>
			</tr>
			<tr>
				<td>教育年限</td>
				<td>
					<select id="cc7" class="easyui-combobox"  name="human_educated_years">
						<c:forEach items="${educationsYears}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_educated_years" type="hidden" value="${engageResume.human_educated_years }" style="width: 130px;">
				</td>
				<td>学历专业</td>
				<td>
					<select id="cc8" class="easyui-combobox" name="human_educated_major">
						<c:forEach items="${educations}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_educated_major" type="hidden" value="${engageResume.human_educated_major }" style="width: 130px;">
				</td>
				<td>薪酬要求</td>
				<td>
					<select id="cc9" class="easyui-combobox" name="demand_salary_standard" style="width:130px;">  
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
					<input id="demand_salary_standard" type="hidden" value="${engageResume.demand_salary_standard }" style="width: 130px;">
				</td>
				<td>登记时间</td>
				<td><input type="text" value="${ engageResume.regist_time}" name="regist_time" readonly="readonly" value="" style="width: 70px;"></td>
			</tr>
			<tr>
				<td>特长</td>
				<td>
					<select id="cc10" name="human_specility" class="easyui-combobox" id="tertiaryMechanism">
						<c:forEach items="${strongPoints}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_specility" type="hidden" value="${engageResume.human_specility }" style="width: 130px;">
				</td>
				<td>爱好</td>
				<td>
					<select id="cc11" name="human_hobby" class="easyui-combobox" type="text" id="tertiaryMechanism">
						<c:forEach items="${hobbys}" var="s" >
							<option value="${s.attribute_name }">${s.attribute_name }</option>
						</c:forEach>
					</select>
					<input id="human_hobby" type="hidden" value="${engageResume.human_hobby }" style="width: 130px;">
				</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>个人履历</td>
				<td colspan="7"><textarea name="human_history_records"  style="width: 600px; height: 80px;">${engageResume.human_history_records }</textarea></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="7"><textarea name="remark"  style="width: 600px; height: 80px;">${engageResume.remark }</textarea></td>
			</tr>
			<tr>
				<td>推荐意见</td>
				<td colspan="7"><textarea placeholder="填写推荐意见代表推荐面试" name="recomandation"  style="width: 600px; height: 80px;">${engageResume.recomandation}</textarea></td>
			</tr>
		</table>
		</form>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var human_major_kind_id=$('#human_major_kind_id').val();
	$('#aa1').combobox('select',human_major_kind_id);
	var human_major_id=$('#human_major_id').val();
	$('#aa2').combobox('select',human_major_id);
	var engage_type=$('#engage_type').val();
	$('#cc').combobox('select',engage_type);
	var human_sex=$('#human_sex').val();
	$('#cc1').combobox('select',human_sex);
	var human_nationality=$('#human_nationality').val();
	$('#cc2').combobox('select',human_nationality);
	var human_race=$('#human_race').val();
	$('#cc3').combobox('select',human_race);
	var human_party=$('#human_party').val();
	$('#cc4').combobox('select',human_party);
	var human_religion=$('#human_religion').val();
	$('#cc5').combobox('select',human_religion);
	var human_educated_degree=$('#human_educated_degree').val();
	$('#cc6').combobox('select',human_educated_degree);
	var human_educated_years=$('#human_educated_years').val();
	$('#cc7').combobox('select',human_educated_years);
	var human_educated_major=$('#human_educated_major').val();
	$('#cc8').combobox('select',human_educated_major);
	var demand_salary_standard=$('#demand_salary_standard').val();
	$('#cc9').combobox('select',demand_salary_standard);
	var human_specility=$('#human_specility').val();
	$('#cc10').combobox('select',human_specility);
	var human_hobby=$('#human_hobby').val();
	$('#cc11').combobox('select',human_hobby);
	$(".update").click(function () {
    	$("#update_form").ajaxSubmit({
             success: function (data) {
                 alert(data);
             },
             error: function (error) { alert('登记失败 ...'); },
                 url: 'updateEngageResume', /*设置post提交到的页面*/
                 type: "post", /*设置表单以post方法提交*/
                 dataType: "text" /*设置返回值类型为文本*/
         });
    });
})
function change_photo(){
	console.info('cdv');
    PreviewImage($("input[name='pic']")[0], 'Img', 'Imgdiv');
    console.info($("input[name='pic']"));
    $("input[name='pic']").attr("name","picUrl");
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
                	$('#'+imgPreviewId).attr("src",e.target.result);
                   // document.getElementById(imgPreviewId).attr("src",e.target.result);  
                }    
                reader.readAsDataURL(fileObj.files[0]); 
            }else if(browserVersion.indexOf("SAFARI")>-1){  
                alert("不支持Safari6.0以下浏览器的图片预览!");  
            }  
        }else if (browserVersion.indexOf("MSIE")>-1){  
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6  
            	$('#'+imgPreviewId).attr("src",fileObj.value);
               // document.getElementById(imgPreviewId).attr("src",fileObj.value);  
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
            	$('#'+imgPreviewId).attr("src",fileObj.files[0].getAsDataURL());
                //document.getElementById(imgPreviewId).attr("src",fileObj.files[0].getAsDataURL());  
            }else{//firefox7.0+       
            	$('#'+imgPreviewId).attr("src",window.URL.createObjectURL(fileObj.files[0]));
                //document.getElementById(imgPreviewId).attr("src",window.URL.createObjectURL(fileObj.files[0]));  
            }  
        }else{  
        	$('#'+imgPreviewId).attr("src",fileObj.value);
           // document.getElementById(imgPreviewId).attr("src",fileObj.value);  
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
</html>
