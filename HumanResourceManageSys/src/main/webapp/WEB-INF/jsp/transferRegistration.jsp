<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<title>调动登记</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--调动管理--调动登记</p><br/>
<script type="text/javascript" src="js/jquery-form.js"></script>
<form name="bonuscommit" id="bonuscommit">
<input class="true" type="button"  name="true" style="background:#CFC;" value="确认"/>
<input type="button" style="margin-left:20px; background:#CFC;" value="返回" onclick="backCheck()"/>
 <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">档案编号</td>
			<td colspan="7" id="huf_id"><input type="text" name="human_id" value="${humanfile.human_id}" readonly="true"/></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">原I级机构</td>
			<td id="first_kind_name" ><input type="text" name="first_kind_name" value="${humanfile.first_kind_name}" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">原II级机构</td>
			<td id="second_kind_name" ><input type="text" name="second_kind_name" value="${humanfile.second_kind_name}" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">原III级机构</td>
			<td id="third_kind_name" ><input type="text" name="third_kind_name" value="${humanfile.third_kind_name }" readonly="true"/></td>
            <td class="backcolor" style="text-align:center">姓名</td>
			<td id="human_name" ><input type="text" name="human_name" value="${humanfile.human_name}" readonly="true"/></td>
			
		</tr>
        
         <tr style="height:35px;">
        <td class="backcolor" style="text-align:center">原职位分类</td>
			<td id="human_major_kind_name" ><input type="text" name="major_kind_name" value="${humanfile.human_major_kind_name }"/></td>
            <td class="backcolor" style="text-align:center">原职位名称</td>
			<td id="human_major_name" ><input type="text" name="major_name" value=" ${humanfile.hunma_major_name}"/></td>
            <td class="backcolor" style="text-align:center">原薪酬标准</td>
			<td id="salary_standard_name" ><input type="text" name="salary_standard_name" value="${humanfile.salary_standard_name}"/></td>
            <td class="backcolor" style="text-align:center"></td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg"></td>
            </tr>
        
          <tr style="height:35px;">
        <td class="backcolor" style="text-align:center">新I级机构</td>	
			<td ><select name="new_first_kind_name" class="first_kind_id"  id="first_kind_id" >
				</select>
			</td>
            <td class="backcolor" style="text-align:center">新II级机构</td>
			<td ><select name="new_second_kind_name" class="second_kind_id"  id="second_kind_id">
				</select>
			</td>
            <td class="backcolor" style="text-align:center">新III级机构</td>
			<td ><select name="new_third_kind_name" class="third_kind_id"  id="third_kind_id">
				</select>
			</td>
            <td class="backcolor" style="text-align:center"></td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg" readonly="true"></td>
            </tr>
            
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">新职位分类</td>
			<td ><select name="new_major_kind_name"  id="human_major_kind">
				</select></td>
            <td class="backcolor" style="text-align:center">新职位名称</td>
			<td ><select name="new_major_name" id="human_major">
				</select></td>
            <td class="backcolor" style="text-align:center">新薪酬标准</td>
			<td ><select name="new_salary_standard_name" id="salary_standard">
				</select></td>
            <td class="backcolor" style="text-align:center"></td>
			<td ><input class="easyui" type="text" id="I" name="Ijjg"></td>
          </tr>
          
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">登记人</td>
			<td colspan="3" id="register" ><input type="text" name="register" value=" 比尔盖茨" readonly="true"/></td>
            <td class="backcolor" style="text-align:center" >登记时间</td>
            <%SimpleDateFormat da=new SimpleDateFormat("YYYY-MM-dd HH:mm");
				String dd=da.format(new Date());
			%>
			<td colspan="3" id="date" ><input type="text" name="regist_time" value="<%=dd%>" readonly="true"/></td>
          </tr>
          
           <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">调动原因</td>
			<td colspan="7"><textarea cols="80"  id="reason" name="change_reason" ></textarea></td>
          </tr>
        </table>
</form>
<script type="text/javascript">
function backCheck(){
	$('#main_panel').panel('refresh',"admin/transferFind");
}
//三级连表
	$.ajax({
	     type:"get",
	     url:"findfirstKind", 
	     success:function(data){
	         var selFirstKind = data.data[0];
	         var first_kind_name=selFirstKind.first_kind_name;
	         $.each(data.data, function(i, item) {  
	             var option = '<option code='+item.first_kind_id+' value="'+item.first_kind_id+'/'+item.first_kind_name+'">'+item.first_kind_id+'/'+item.first_kind_name+'</option>';
	             $('#first_kind_id').append(option);
	         })
	         $('#first_kind_id option[value='+first_kind_name+']').attr("selected","true"); //当前省份默认选中
	          var secondKindUrl ='findsecondKind?first_kind_id='+selFirstKind.first_kind_id;//请求二级列表
	         $.ajax({
	             url:secondKindUrl,
	             success:function(data){
	                 var selSecond=data.data[0];
	                 $.each(data.data,function(i,item){
	                     var option = '<option code='+item.second_kind_id+' value="'+item.second_kind_id+'/'+item.second_kind_name+'">'+item.second_kind_id+'/'+item.second_kind_name+'</option>';
	                      $('#second_kind_id').append(option);
	                 })
	                 $('#second_kind_id option[value='+selSecond.second_kind_name+']').attr("selected","true"); //当前城市默认选中
	                  var thirdUrl ='findthirdKind?second_kind_id='+selSecond.second_kind_id; //请求三级列表
	                 $.ajax({
	                     url:thirdUrl,
	                     success:function(data){
	                         $.each(data.data,function(i,item){
	                             var option = '<option code='+item.third_kind_id+' value="'+item.third_kind_id+'/'+item.third_kind_name+'">'+item.third_kind_id+'/'+item.third_kind_name+'</option>';
	                              $('#third_kind_id').append(option);
	                         })
	                         $('#third_kind_id').attr('third_kind_id',$('#third_kind_id').find('option').eq(0).attr('code'));
	                     }
	                 })
	             }
	         })              }


	});
	
	//职位分类和职位
	$.ajax({
	     type:"get",
	     url:"findMajorKind", 
	     success:function(data){
	         var majorKind = data.data[0];
	        
	         var major_kind_name=majorKind.major_kind_name;
	         $.each(data.data, function(i, item) {  
	             var option = '<option code='+item.major_kind_id+' value="'+item.major_kind_id+'/'+item.major_kind_name+'">'+item.major_kind_id+'/'+item.major_kind_name+'</option>';
	             $('#human_major_kind').append(option);
	         })
	         $('#human_major_kind option[value='+major_kind_name+']').attr("selected","true"); //当前职位分类默认选中
	          var majorUrl ='findMajor?id='+majorKind.major_kind_id;//请求职位名称
	         $.ajax({
	             url:majorUrl,
	             success:function(data){
	                 var major=data.data[0];
	                 
	                 $.each(data.data,function(i,item){
	                     var option = '<option code='+item.major_id+' value="'+item.major_id+'/'+item.major_name+'">'+item.major_id+'/'+item.major_name+'</option>';
	                      $('#human_major').append(option);
	                 })
	                 $('#human_major option[value='+major.major_name+']').attr("selected","true"); //当前职位分类默认选中
	                 $('#human_major').attr('human_major',$('#human_major').find('option').eq(0).attr('code'));
	             }
	         })              }


	});

//填充方法
 function masterAddrC(url,select){
              $.ajax({
                  url:url,
                  success:function(data){
                      $('#'+select).html('');
                    $.each(data.data,function(i,item){
                           var option = '<option code='+item.second_kind_id+' value="'+item.second_kind_id+'/'+item.second_kind_name+'">'+item.second_kind_id+'/'+item.second_kind_name+'</option>';
                         $('#'+select).append(option);
                    });
                     
                 },
                 error:function(){
                     console.log("fail");
                     return;
                 }
             });
         }
//填充方法
 function masterAdd(url,select){
              $.ajax({
                  url:url,
                  success:function(data){
                      $('#'+select).html('');
                    $.each(data.data,function(i,item){
                           var option = '<option code='+item.third_kind_id+' value="'+item.third_kind_id+'/'+item.third_kind_name+'">'+item.third_kind_id+'/'+item.third_kind_name+'</option>';
                         $('#'+select).append(option);
                    });
                     
                 },
                 error:function(){
                     console.log("fail");
                     return;
                 }
             });
         }
//点击选择一级机构
$('#first_kind_id').change(function(){
    var _this=$(this);
    var firstCode = _this.find('option:selected').attr('code');
    var secondUrl ='findsecondKind?first_kind_id='+firstCode;
    masterAddrC(secondUrl,'second_kind_id');
   setTimeout(function(){
        var secondCode = $('#second_kind_id').find('option').eq(0).attr('code');
        var thirdUrl = 'findthirdKind?second_kind_id='+secondCode;
        masterAdd(thirdUrl,'third_kind_id');
        setTimeout(function(){
            $('#first_kind_id').attr('first_kind_id',firstCode);
            $('#second_kind_id').attr('second_kind_id',$('#second_kind_id').find('option').eq(0).attr('code'));
             $('#third_kind_id').attr('third_kind_id',$('#third_kind_id').find('option').eq(0).attr('code'));    
        },300);
    },300);
});
//点击选择二级机构
$('#second_kind_id').change(function(){
    var _this=$(this);
   var secondCode = _this.find('option:selected').attr('code');
    var thirdUrl = 'findthirdKind?second_kind_id='+secondCode;
    masterAdd(thirdUrl,'third_kind_id');
    setTimeout(function(){
        $('#second_kind_id').attr('second_kind_id',secondCode);
        $('#third_kind_id').attr('third_kind_id',$('#third_kind_id').find('option').eq(0).attr('code'));
    },100);
});
//点击选择三级机构
$('#third_kind_id').change(function(){
    var _this=$(this);
    var thirdCode = _this.find('option:selected').attr('code');
    setTimeout(function(){
        $('#third_kind_id').attr('third_kind_id',thirdCode);
    },100);
});


//填充方法
function masterAddr(url,select){
             $.ajax({
                 url:url,
                 success:function(data){
                     $('#'+select).html('');
                   $.each(data.data,function(i,item){
                          var option = '<option code='+item.major_id+' value="'+item.major_id+'/'+item.major_name+'">'+item.major_id+'/'+item.major_name+'</option>';
                        $('#'+select).append(option);
                   });
                    
                },
                error:function(){
                    console.log("fail");
                    return;
                }
            });
        }
//点击选择职位分类
$('#human_major_kind').change(function(){
    var _this=$(this);
   var majorCode = _this.find('option:selected').attr('code');
    var majorUrl = 'findMajor?id='+majorCode;
    masterAddr(majorUrl,"human_major");
    setTimeout(function(){
        $('#human_major_kind').attr('major_kind_id',majorCode);
        $('#human_major').attr('major_id',$('#human_major').find('option').eq(0).attr('code'));     
    },100);
});

//点击选择职位
$('#human_major').change(function(){
    var _this=$(this);
    var Code = _this.find('option:selected').attr('code');
    setTimeout(function(){
        $('#human_major').attr('major_id',Code);
    },100);
});
//选择薪酬标准
$.ajax({
	     type:"get",
	     url:"findSalary", 
	     success:function(data){
	         var salaryKind = data.data[0];
	         var salary=salaryKind.standard_name;
	         $.each(data.data, function(i, item) {  
	             var option = '<option code='+item.standard_id+' value="'+item.standard_id+'/'+item.standard_name+'">'+item.standard_id+'/'+item.standard_name+'</option>';
	             $('#salary_standard').append(option);
	         })
	         $('#salary_standard option[value='+salary+']').attr("selected","true"); //当前职位分类默认选中
	         ('#salary_standard').attr('salary_standard',$('#salary_standard').find('option').eq(0).attr('code'));
	     }
	     });
//提交
function toCommit(){
	//var huf_id=$('#huf_id').Text;
	//var huf_id=document.getElementById('huf_id').innerHTML;//编号
	//var first=document.getElementById("first").innerHTML;//原一级机构
	//var second=document.getElementById("second").innerHTML;//原二级机构
	//var third=document.getElementById("third").innerHTML;//原三级机构
	//var name=document.getElementById("name").innerHTML;//姓名
	//var major_kind=document.getElementById("major_kind").innerHTML;//职位分类
	//var major_name=document.getElementById("major_name").innerHTML;//职位名称
	//var salary=document.getElementById("salary").innerHTML;//原薪酬标准
	//var first_kind_id=document.getElementById("first_kind_id").innerHTML;//新一级机构
	//var second_kind_id=document.getElementById("second_kind_id").innerHTML;//新二级机构
	//var third_kind_id=document.getElementById("third_kind_id").innerHTML;//新三级机构
	//var human_major_kind=document.getElementById("human_major_kind").innerHTML;//新职位分类
	//var human_major=document.getElementById("human_major").innerHTML;//职位名称
	//var salary_standard=document.getElementById("salary_standard").innerHTML;//新薪酬标准
	//var register=document.getElementById("register").innerHTML;//登记者名称
	//var date=document.getElementById("date").innerHTML;//登记日期
	//var reason=document.getElementById("reason").value;//调动原因	
}

$(function () {
    $(".true").click(function () {
    			 $("#bonuscommit").ajaxSubmit({
                     success: function (data) {
                     	if(data==1){
                     		alert('提交成功...请尽快审核....')
                     	}else if(data==2){
                     		alert("不可重复提交....");
                     	}else{
                     		alert('提交失败 ...');
                     	}
                         alert(data);
                     },
                     error: function (error) { alert('登记失败 ...'); },
                     url: 'personnelTransferAudit', /*设置post提交到的页面*/
                     type: "post", /*设置表单以post方法提交*/
                     dataType: "text" /*设置返回值类型为文本*/
                 });
    });
});	
</script> 
</body>
</html>
