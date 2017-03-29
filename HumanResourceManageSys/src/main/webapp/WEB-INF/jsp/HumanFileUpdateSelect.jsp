<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:#00F">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案变更</p><br/>
	<input class="easyui" type="button" style="margin-left:761px; background:#CFC;" value="EXCEL列表"/>
    <input class="easyui" type="button" id="sss" style="background:#F33;"  value="查询"/>
    <table border="1" width="900px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择员工所在的I级机构</td>
			<td ><input name="first_kind_id" id="cc1" class="easyui-combobox"
				data-options="   
			        valueField: 'first_kind_id',
		        	textField: 'first_kind_name',
		        	url: 'findAllFirstKind',
		        	onSelect: function(rec){
			            var url = 'findSecondKindByFirst?first_kind_id='+rec.first_kind_id;
			            $('#cc2').combobox('reload', url);
		        }" /></td>
			
		</tr>
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择员工所在的II级机构</td>
			<td ><input name="second_kind_id" id="cc2" class="easyui-combobox"
					data-options="
 					valueField:'second_kind_id', 
 					textField:'second_kind_name',
 		        	onSelect: function(rec){ 
 			            var url = 'findThirdKindBySecondKindId?second_kind_id='+rec.second_kind_id;
			            $('#cc3').combobox('reload', url); 
 				}" /> </td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择员工所在的III级机构</td>
			<td ><input  name="third_kind_id"  id="cc3" class="easyui-combobox" data-options="valueField:'third_kind_id',textField:'third_kind_name'" /></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择职位分类</td>
			<td ><input name="human_major_kind_id" id="aa1" class="easyui-combobox"
				data-options="   
			        valueField: 'major_kind_id',
		        	textField: 'major_kind_name',
		        	url: 'findAllConfigMajorKind',
		        	onSelect: function(rec){
			            var url = 'selectConfigMajorByKind?major_kind_id='+rec.major_kind_id;
			            $('#aa2').combobox('reload', url);
		        }" /></td>
		</tr><tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请选择职位名称</td>
			<td ><input name="human_major_id" id="aa2" class="easyui-combobox"
					data-options="
 					valueField:'major_id', 
 					textField:'major_name'" /></td>
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请输入建档时间</td>
			<td ><input class="easyui-datebox" name="mindate">至<input class="easyui-datebox"  name="maxdate"></td>
		</tr>
<script>
$(function () {
    $("#sss").click(function () {
    	
   	 var mindate=$('input[name=mindate]').val();
   	 var maxdate=$('input[name=maxdate]').val();
   	 var ndate=new Date(mindate);
   	 var xdate=new Date(maxdate);
   	 var firstKindId=$('input[name=first_kind_id]').val();
   	 var secondKindId=$('input[name=second_kind_id]').val();
     var thirdKindId=$('input[name=third_kind_id]').val();
     var human_major_kind_id=$('input[name=human_major_kind_id]').val();
     var human_major_id=$('input[name=human_major_id]').val();
   	 if(ndate<xdate){
   		$('#main_panel').panel('refresh',"selectHumanFileUpdateBy?mindate="+mindate+"&maxdate="+maxdate+"&firstKindId="+firstKindId+"&secondKindId="+secondKindId+"&thirdKindId="+thirdKindId+"&human_major_kind_id="+human_major_kind_id+"&human_major_id="+human_major_id);
   	 }else{
   		 alert('请重新选择时间...') 
   	 	 }
	})
});
</script>
</body>
</html>