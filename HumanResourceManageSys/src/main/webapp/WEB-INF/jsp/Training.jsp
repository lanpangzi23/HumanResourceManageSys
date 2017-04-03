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
<title>无标题文档</title>
</head>

<body>
<script type="text/javascript" src="js/jquery-form.js"></script>
<p style="color:#00F">您正在做的业务是：人力资源--激励管理--培训分配</p><br/>
<form name="bonuscommit" id="bonuscommit">
<input class="true" type="button"  name="true" style="background:#CFC;" value="确认"/>
<input type="button" style="margin-left:20px; background:#CFC;" value="返回" onclick="backCheck()"/>
<br/><br/>
 <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">档案编号</td>
			<td colspan="7" ><input type="text" id="human_id" name="human_id" value="${humanfile.human_id}" readonly="true"/></td>
		</tr>
        <tr style="height:35px;">
            <td class="backcolor" style="text-align:center">姓名</td>
			<td ><input type="text" name="human_name" value="${humanfile.human_name} " readonly="true"/></td>
			<td class="backcolor" style="text-align:center">培训项目</td>
			<td ><select name="training_item" id="training_item"></select></td>
            <td class="backcolor" style="text-align:center">培训时间</td>
			<td ><select name="training_time" id="training_time"></select></td>
			<td class="backcolor" style="text-align:center">培训课时</td>
			<td ><select id="training_hour" name="training_hour" ></select></td>
		</tr>
          
          <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">登记人</td>
			<td ><input class="easyui" type="text" id="I" name="register" value="屎壳螂" readonly="true"></td>
            <td class="backcolor" style="text-align:center">登记时间</td>
              <%SimpleDateFormat da=new SimpleDateFormat("YYYY-MM-dd HH:mm");
				String dd=da.format(new Date());
			%>
			<td ><input class="easyui" type="text" id="I" name="regist_time" value="<%=dd %>" readonly="true"></td>
           
          </tr>
          
           <tr style="height:35px;">
       		<td class="backcolor" style="text-align:center">备注</td>
			<td colspan="7" ><textarea style="width:800px;" name="remark"> </textarea></td>
        </table>
        </form>
<script type="text/javascript">
function backCheck(){
	$('#main_panel').panel('refresh',"admin/TrainingFind");
}

$.ajax({
    type:"get",
    url:"tofinditem", 
    success:function(data){
   	 var items= data.data[0];
        $.each(data.data, function(i, item) {  
            var option = '<option code='+item.attribute_name+' value="'+item.attribute_name+'">'+item.attribute_name+'</option>';
            $('#training_item').append(option);
        })
        $('#training_item option[value='+items.attribute_name+']').attr("selected","true"); //当前职位分类默认选中
    	var timeurl='tofindtime?attribute_name='+items.attribute_name;//请求价值
    	var hoururl='tofindhour?attribute_name='+items.attribute_name+'s';//请求价值
    	$.ajax({
            url:timeurl,
            success:function(data){
                var times=data.data[0];
                $.each(data.data,function(i,item){
                    var option = '<option code='+item.attribute_name+' value="'+item.attribute_name+'">'+item.attribute_name+'</option>';
                     $('#training_time').append(option);
                })
                $('#training_time option[value='+times.attribute_name+']').attr("selected","true"); //当前职位分类默认选中
                $('#training_time').attr('attribute_name',$('#training_time').find('option').eq(0).attr('code'));
            }
        }) 
        $.ajax({
            url:hoururl,
            success:function(data){
                var hour=data.data[0];
                $.each(data.data,function(i,item){
                    var option = '<option code='+item.attribute_name+' value="'+item.attribute_name+'">'+item.attribute_name+'</option>';
                     $('#training_hour').append(option);
                })
                $('#training_hour option[value='+hour.attribute_name+']').attr("selected","true"); //当前职位分类默认选中
                $('#training_hour').attr('attribute_name',$('#training_hour').find('option').eq(0).attr('code'));
            }
        }) 
    }
});
//填充方法
function masterAddr(url,select){
             $.ajax({
                 url:url,
                 success:function(data){
                     $('#'+select).html('');
                   $.each(data.data,function(i,item){
                          var option = '<option code='+item.attribute_name+' value="'+item.attribute_name+'">'+item.attribute_name+'</option>';
                        $('#'+select).append(option);
                   });
                    
                },
                error:function(){
                    console.log("fail");
                    return;
                }
            });
        }
$('#training_item').change(function(){
    var _this=$(this);
   var itemCode = _this.find('option:selected').attr('code');
   var itemCodes=itemCode+'s';
    var timeUrl = 'tofindtime?attribute_name='+itemCode;
    var hourUrl = 'tofindhour?attribute_name='+itemCodes;
    masterAddr(timeUrl,"training_time");
    masterAddr(hourUrl,"training_hour");
    setTimeout(function(){
        $('#training_item').attr('attribute_name',timeUrl);
        $('#training_item').attr('attribute_name',hourUrl);
        $('#training_time').attr('attribute_name',$('#training_time').find('option').eq(0).attr('code'));     
        $('#training_hour').attr('attribute_name',$('#training_hour').find('option').eq(0).attr('code'));     
    },100);
});


$(function () {
            $(".true").click(function () {
            			 $("#bonuscommit").ajaxSubmit({
                             success: function (data) {
                             	if(data==1){
                             		alert('提交成功...请尽快审核....')
                             	}else if(data==2){
                             		alert("不可重复提交....");
                             	}else{
                             		alert('提交失败 ...(可能原因:课时数不为整数等等。。。)');
                             	}
                             },
                             error: function (error) { alert('登记失败 ...'); },
                             url: 'trainingAudit', /*设置post提交到的页面*/
                             type: "post", /*设置表单以post方法提交*/
                             dataType: "text" /*设置返回值类型为文本*/
                         });
            });
});	
        

</script> 
</body>
</html>
