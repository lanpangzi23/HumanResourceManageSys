<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" %>
<body>
<div class="easyui-tabs" id="tt">
	<div title="试题登记">
		<form id="add_form">
			<p>您正在做的业务是:人力资源--招聘管理--招聘考试管理--试题登记</p>
			<table border="1" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0">
				<tr>
                	<td >试题I级分类</td>
                    <td>
                    	<input type="hidden" name="first_kind_name" class="first_kind_name"/>
                    	<input style="width: 100px;" type="text" name="first_kind_id" id="aa1"  class="easyui-combobox"
						data-options="   
			        			valueField: 'first_kind_id',
		        				textField: 'first_kind_name',
		        				url: 'ConfigQuestionFirstKind',
		        				onSelect: function(rec){
		        					$('.first_kind_name').val(rec.first_kind_name);
		        					var url = 'ConfigQuestionSecondKind?first_kind_id='+rec.first_kind_id;
			            			$('#aa2').combobox('reload', url);
		        			}" />
                    </td>
                    <td >试题II级分类</td>
                    <td>
                    	<input name="second_kind_name" class="second_kind_name" type="hidden" />
						<input name="second_kind_id" type="text" id="aa2" class="easyui-combobox"
						data-options="
 							valueField:'second_kind_id', 
 							textField:'second_kind_name',
 							onSelect: function(rec){
		        					$('.second_kind_name').val(rec.second_kind_name);
		        			}" />
		        	</td>
                    <td >登记人</td>
                    <td><input type="text" name="register" value="${uname }" readonly="true" style="width:100px;"></td>
                    <td >登记时间</td>
                    <td><input type="text" name="regist_time" value="<%=new Date() %>" readonly="true" style="width:100px;"></td>
                </tr>
                <tr>
                	<td>提干</td>
                    <td colspan="7" style="height:50px;"><textarea name="content" style="width:650px;"></textarea></td>
                </tr>
                 <tr>
                	<td>答案a</td>
                    <td colspan="7" style="height:50px;"><textarea name="key_a" style="width:650px;"></textarea></td>
                </tr>
                 <tr>
                	<td>答案b</td>
                    <td colspan="7" style="height:50px;"><textarea name="key_b" style="width:650px;"></textarea></td>
                </tr>
                 <tr>
                	<td>答案c</td>
                    <td colspan="7" style="height:50px;"><textarea name="key_c" style="width:650px;"></textarea></td>
                </tr>
                 <tr>
                	<td>答案d</td>
                    <td colspan="7" style="height:50px;"><textarea name="key_d" style="width:650px;"></textarea></td>
                </tr>
                 <tr>
                	<td>答案e</td>
                    <td colspan="7" style="height:50px;"><textarea name="key_e" style="width:650px;"></textarea></td>
                </tr>
                <tr>
                	<td>正确答案</td>
                    <td><input width="80px;" name="correct_key"/></td>
                    <td>试题出处</td>
                    <td><input width="80px;" name="derivation"/></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <input type="button" onClick="addPost()" value="登记">
		</form>
	</div>
	<div title="试题查询">
		<p>您正在做的业务是:人力资源--招聘管理--招聘考试管理--试题查询</p>
            <input class="find" onClick="findByChoose()" type="button" value="查询"/>
        	<table border="1" bordercolor="#CCCCCC" width="600" cellpadding="0" cellspacing="0" >
            	<tr>
                	<td >试题I级分类</td>
                    <td>
                    	<input style="width: 100px;" type="text" name="fid" id="aa1"  class="easyui-combobox"
							data-options="   
				        			valueField: 'first_kind_id',
			        				textField: 'first_kind_name',
			        				url: 'ConfigQuestionFirstKind',
			        				onSelect: function(rec){
			        					var url = 'ConfigQuestionSecondKind?first_kind_id='+rec.first_kind_id;
				            			$('#aa3').combobox('reload', url);
		        			}" />
                    </td>
                </tr>
                <tr>
                    <td >试题II级分类</td>
                    <td>
						<input name="sid" id="aa3" type="text" class="easyui-combobox"
							data-options="
	 							valueField:'second_kind_id', 
	 							textField:'second_kind_name',
 						" />
		        	</td>
                </tr>
                <tr>
                	<td>请输入关键字</td>
                    <td><input name="keyword"/></td>
                </tr>
               <tr>
                	<td>请输入登记时间</td>
                    <td>
                    	<input id="date1" class="easyui-datebox"/>至
                    	<input id="date2" class="easyui-datebox"/>
                    </td>
                </tr>
            </table>
	</div>
</div>
<script type="text/javascript">
function findByChoose(){
	var minDate=$('#date1').val();
	var maxDate=$('#date2').val();
	var keyword=$('input[name="keyword"]').val();
	var fid=$('input[name="fid"]').val();
	var sid=$('input[name="sid"]').val();
	var tab = $('#tt').tabs('getSelected');  
	$('#tt').tabs('update', {
		tab: tab,
		options: {
			content : '<iframe scrolling="auto" frameborder="0"  src="toFindByChoose?minDate='+minDate+'&maxDate='+maxDate+
					'&keyword='+keyword+'&fid='+fid+'&sid='+sid+'" style="width:1000px;height:400px;"></iframe>',
		}
	});
}
function addPost(){
	$('#add_form').ajaxSubmit({
		 success: function (data) {
	         alert("登记成功");
	     },
	     url: 'addEngageSubjects', /*设置post提交到的页面*/
         type: "post", /*设置表单以post方法提交*/
         dataType: "text" /*设置返回值类型为文本*/
	});
}
</script>
</body>
