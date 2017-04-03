<%@page import="java.util.Date"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<link type="text/css" rel="stylesheet" href="css/index.css">
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
<script type="text/javascript">
</script>
</head>

<body>
	<header>
		<div class="header1">
			<div class="header1_1">
				<ul>
					<li>欢迎您！</li>
				</ul>
				<ul>
					<li><a href="#">网站导航</a></li>
					<li><a href="#">帮助中心</a></li>
				</ul>
			</div>

		</div>
		<div class="header2">
		<img src="image/logo.png" style="margin-left: 180px; float: left;margin-top: 10px;">
		<p style="font-size: 44px;color:blue;font-weight: bolder;font-family: '华文行楷';margin-top: 35px;margin-left10px;float: left;">源辰信息科技招聘网</p>
			<div class="header2_1">
			</div>
		</div>
	</header>

	<article>
		<div class="article1_1">
			
			

			<!-- 隐藏块 -->
		</div>
		<!-- 首页广告图片 -->
<!-- 		<div class="article1_2"> -->
<!-- 			<img id="chaPic" src="images/banner3.jpg" /> -->
<!-- 			<div class="chaPic_span"><span></span><span></span><span></span><span></span></div>  -->
<!-- 		</div> -->
		<!-- 下方内容 -->
		<div id="immp">

			
        <div class="_title"><span>简历信息登记</span><a href="#">更多>></a></div>
        <div class="article1_3_3">
        	<div class="_long" style="">
        	<div style="width:100%;background-image: url('image/3.jpg');height:760px; ">
        	<div style="padding-top: 60px;">
				<form id="add_form" enctype="multipart/form-data" method="post">
		
		<table id="tt" border="0" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0" style="">
			<tr >
				<td>职位分类</td>
				<td>
					<input name="human_major_kind_name" id="human_major_kind_name" type="hidden" />
					<input name="human_major_kind_id" id="aa1" style="width:130px;" class="easyui"/>
				</td>
				<td>职位名称</td>
				<td>
					<input name="human_major_name" id="human_major_name" type="hidden" />
					<input name="human_major_id" id="aa2" class="easyui" style="width: 130px"/>
		        </td>
				<td>招聘类型</td>
				<td>
					<select id="cc" class="easyui-combobox" name="engage_type" style="width:130px;">  
			    		<option>社会招聘</option>  
			    		<option>校园招聘</option>  
					</select>
				</td>
				<td rowspan="6" colspan="2" style="width: 120px">
					<div id="Imgdiv">
     		  			 <center><img id="Img" width="200px" height="200px"/></center>
   		 			</div>
       				<input class="easyui-filebox" style="width:100px" data-options='onChange:change_photo' name="picUrl"  id="file_upload" />
				</td>
			</tr>
			<tr style="margin-top: 50px;">
				<td>姓名</td>
				<td><input  name="human_name" type="text" style="width: 130px;"></td>
				<td>性别</td>
				<td>
					<select id="cc" class="easyui-combobox" name="human_sex" style="width:130px; background:transparent;">  
			    		<option>男</option>  
			    		<option>女</option>  
					</select>
				</td>
				<td>EMAIL</td>
				<td><input name="human_email" type="text" style="width: 130px; background:transparent;"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input name="human_telephone" type="text" style="width: 130px; "></td>
				<td>家庭电话</td>
				<td><input name="human_homephone" type="text" style="width: 130px; "></td>
				<td>手机</td>
				<td><input name="human_mobilephone" type="text" style="width: 130px; "></td>
			</tr>
			<tr>
				<td>住址</td>
				<td colspan="3"><input name="human_address" type="text" style="width: 300px;"></td>
				<td>邮编</td>
				<td><input name="human_postcode" type="text" style="width: 130px; "></td>
			</tr>
			<tr>
				<td>国籍</td>
				<td>
				<select name="human_nationality" class="easyui-combobox">
<%-- 					<c:forEach items="${nationalitys}" var="s" > --%>
<%-- 						<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 					</c:forEach> --%>
<option>100000元/月以上</option>  
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
<%-- 						<c:forEach items="${nations}" var="s"> --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
					</select>
				</td>
				<td>宗教信仰</td>
				<td>
					<select class="easyui-combobox" name="human_religion">
<%-- 						<c:forEach items="${religiousBeliefs}" var="s" varStatus="ss"> --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
					</select>
				</td>
				<td>政治面貌</td>
				<td>
					<select class="easyui-combobox" name="human_party">
<%-- 						<c:forEach items="${politicalStatus}" var="s" varStatus="ss"> --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
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
<%-- 						<c:forEach items="${schooling}" var="s" > --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
					</select>
				</td>
			</tr>
			<tr>
				<td>教育年限</td>
				<td>
					<select class="easyui-combobox"  name="human_educated_years">
<%-- 						<c:forEach items="${educationsYears}" var="s" > --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
					</select>
				</td>
				<td>学历专业</td>
				<td>
					<select class="easyui-combobox" name="human_educated_major">
<%-- 						<c:forEach items="${educations}" var="s" > --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
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
<%-- 						<c:forEach items="${strongPoints}" var="s" > --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
					</select>
				</td>
				<td>爱好</td>
				<td>
					<select name="human_hobby" class="easyui-combobox" type="text" id="tertiaryMechanism">
<%-- 						<c:forEach items="${hobbys}" var="s" > --%>
<%-- 							<option value="${s.attribute_name }">${s.attribute_name }</option> --%>
<%-- 						</c:forEach> --%>
<option>100000元/月以上</option>  
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
        			
        	</div>
                
               </div> 
            
        </div>

			</div>

		
		<div id="rightButton" style="right: 0px;">
		    <ul id="right_ul">  
		     <li id="right_kf" onclick="openChatWindow('');"></li>
		         <li id="right_weixin" class="right_ico"></li>
		         <li id="right_tip" style="margin-top: 90px; top: -10px; display: none;" class="png">
		            <div class="con ovf  ">
		                <div class="fl arr" style="top:80px"><div class="fl arr_i"></div></div>
		                 <ul>
		                    <li>
		                    <p>
		                    <a href="#" target="_brank"><img style="width: 118px; height: 118px;" src="images/syewmsz_0.jpg"></a></p><p class="f14 fyh tec">
		                    <a href="#" target="_brank"><font color="#5B5B5B">山山商城微信</font></a>
		                    </p>
		                    </li>
		                </ul>
		            </div>
		        </li>
		        <li id="right_sc" onclick="addBookmark()"></li>
		        <li><div id="backToTop" style="display: block;"><a href="#" onfocus="this.blur();" class="backToTop_a png"></a></div></li>
		    </ul>
		</div>

	</article>

	<footer>
		<div class="footer1_1">
			<div class="footer2_1">
				<ul>
					<li><img src="images/footer1.png" /></li>
					<li>
						<ul>
							<li class="zi1">关于我们</li>
							<li><a class="zi2" href="#">公司简介</a></li>
							<li><a class="zi2" href="#">联系方式</a></li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="zi1">交易保障</li>
							<li><a class="zi2" href="#">网站协议</a></li>
							<li><a class="zi2" href="#">支付方式</a></li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="zi1">关注我们</li>
							<li><a class="zi2" href="#">用户意见反馈</a></li>
							<li><a class="zi2" href="#">分享给好友</a></li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="zi1">联系我们</li>
							<li style="color: #E75E08; font-weight: bold;">150-0895-9836</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="footer2_2">
				<ul>
					<li><a href="#">首页</a></li>
					<li><a href="#">关于我们</a></li>
					<li><a href="#">平台公告</a></li>
					<li><a href="#">支付方式</a></li>
					<li><a href="#">联系方式</a></li>
					<li><a href="#">客服中心</a></li>
					<li><a href="#">联系合作</a></li>
					<li><a href="#">网站导航</a></li>
					<li><a href="#">公司资质</a></li>
				</ul>
				<span>Copyright 2017 lsy 版权所有</span>
			</div>
		</div>
	</footer>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
	function findMaior(){
		var keyword=$('#findVal').val();
		$.post('selectEngageMajorReleaseByName',{keyword:keyword},function(data){
			$('#shopcar').empty('');
			var str='';
			for(var i=0;i<data.length;i++){
				var date=new Date(data[i].regist_time);
				str+='<tr>'+
				'<td style="text-align: center;" valign="middle" height="50"><a href="#">'+
				'<span style="color: #FF0215; font-weight: bold; class="title">'+data[i].major_name+'</span></a>'+
				'</td><td valign="middle" height="60" align="center">'+

				'<span class="price">'+data[i].human_amount+'</span>'+
				'</td><td valign="middle" height="60" align="center">'+
				'<span class="price">'+date.getYear()+date.getMonth()+'</span></td>'+
				'<td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" class="price">'+data[i].deadline+'</span>'+
				'</td>'+
				'<td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" style="font-size: 14px;font-weight: bold; class="price">'+data[i].major_describe+'</span>'+
				'</td><td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" style="font-size: 14px;font-weight: bold; class="price">'+data[i].engage_required+'</span>'+
				'</td><td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" style="font-size: 14px;color: #FF0215;font-weight: bold; class="price"><a style=" color:#FF0215;" href="javascript:resume('+data[i].mre_id+')">投简历</a></span>'+
				'</td></tr>';
			}
			$('#shopcar').append(str);
		},'json');
	}
	$(function(){
		$.post('findMaior',function(data){
			$('#shopcar').empty('');
			var str='';
			for(var i=0;i<data.length;i++){
				var date=new Date(data[i].regist_time);
				str+='<tr>'+
				'<td style="text-align: center;" valign="middle" height="50"><a href="#">'+
				'<span style="color: #FF0215; font-weight: bold; class="title">'+data[i].major_name+'</span></a>'+
				'</td><td valign="middle" height="60" align="center">'+

				'<span class="price">'+data[i].human_amount+'</span>'+
				'</td><td valign="middle" height="60" align="center">'+
				'<span class="price">'+date.getYear()+date.getMonth()+'</span></td>'+
				'<td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" class="price">'+data[i].deadline+'</span>'+
				'</td>'+
				'<td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" style="font-size: 14px;font-weight: bold; class="price">'+data[i].major_describe+'</span>'+
				'</td><td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" style="font-size: 14px;font-weight: bold; class="price">'+data[i].engage_required+'</span>'+
				'</td><td class="last1" valign="middle" height="60" align="center">'+
				'<span id="yprice" style="font-size: 14px; color:#FF0215;font-weight: bold; class="price"><a style=" color:#FF0215;" href="javascript:resume('+data[i].mre_id+')">投简历</a></span>'+
				'</td></tr>';
			}
			$('#shopcar').append(str);
		},'json');
	})
	
	//转到投简历
	function resume(id){
		
	}
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
</html>
