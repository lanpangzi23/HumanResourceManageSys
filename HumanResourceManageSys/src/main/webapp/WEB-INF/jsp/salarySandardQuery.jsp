<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<p style="color:#00F">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准查寻</p><br/>
<form>
	<input class="easyui" type="button" onClick="findByFuzzy()" style="margin-left:953px; background:#CFC;" value="查寻"/>
    <table border="1" width="1000px" cellpadding="0" cellspacing="0">
		<tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请输入薪酬标准编号</td>
			<td ><input class="easyui" style="width: 290px;" type="text" id="I" name="standard_id"></td>
		
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请输入关键数字</td>
			<td ><input class="easyui" style="width: 290px;" placeholder="可输入薪酬标准名称、制定人、变更人和复核人" type="text" id="I" name="keyword"></td>
			
		</tr>
        <tr style="height:35px;">
			<td class="backcolor" style="text-align:center">请输入登记时间</td>
			<td ><input id="dd" type="text" name="minDate" class="easyui-datebox" required="required"></input>  
至<input id="dd" type="text" name="maxDate" class="easyui-datebox" required="required"></input>  
（YYYY-MM-DD）</td>
		</tr>
    </table>
</form>
<script type="text/javascript">
function findByFuzzy(){
	var standard_id=$('input[name="standard_id"]').val();
	var keyword=$('input[name="keyword"]').val();
	var minDate=new Date($('input[name="minDate"]').val());
	var maxDate=new Date($('input[name="maxDate"]').val());
	$('#main_panel').panel('refresh',"toFindByFuzzy/"+standard_id+"/"+keyword+"/"+minDate+"/"+maxDate);
}
</script>
</body>
</html>
