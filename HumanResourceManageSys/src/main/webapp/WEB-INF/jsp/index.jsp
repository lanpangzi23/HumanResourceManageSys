<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>源辰信息科技有限公司-人力资源档案登记</title>
<link type="text/css" rel="stylesheet" href="css/icon.css"/>
<link type="text/css" rel="stylesheet" href="css/easyui.css"/>
<style>
.header p{
	color:#09F;
	font-size:40px;
	font-weight:600;
	height:60px;
	line-height:130px;
	text-align:right;
	padding-right:500px;
	font-family:"Lucida Console", Monaco, monospace;
	margin-top:-20px;
}
.header{
	height:100px;
}
#menu>div> li{
	list-style-type:none;}
#menu>div> li>a{
	width:190px;
	height:30px;
	}

</style>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:135px;">
    	<div class="header"><p>人力资源管理中心</p>
    	
    	<span style="float: right; margin-right: 100px;font-weight: bolder;">当前用户：<span style="font-weight: bolder;font-size:15px;color:blue;font-family:sans-serif;">${uname}</span><a href="javascript:logout()" style="margin-left: 60px;color: red;">退出登录</a></span>
    	</div>
    </div>  
    <div data-options="region:'west',title:'West',href:'',split:true" style="width:200px;">
    	<div id="menu" class="easyui-accordion" fit="true" border="false">
        	<div title="系统管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        	<c:if test="${role=='系统管理员'}">
        	<li><a class="easyui-linkbutton" href="admin/addAdmin" data-options="plain:true">后台管理员管理</a></li>
        	</c:if>
        	
        		<li><a class="easyui-linkbutton" href="admin/organization" data-options="plain:true">人力资源档案管理设置</a></li>
                <li><a class="easyui-linkbutton" href="admin/itemBankManagementSetting" data-options="plain:true">题库管理设置</a></li>
                <li><a class="easyui-linkbutton" href="admin/adminUserUpdate" data-options="plain:true">其他设置</a></li>
                 
        	</div>
            <div title="人力资源档案管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px; height:30px;">
        	<c:if test="${role=='人事专员'||role=='系统管理员'}">
        		<li><a class="easyui-linkbutton" href="admin/humanResourceRegistration" data-options="plain:true">人力资源档案登记</a></li>
        	</c:if>
        	<c:if test="${role=='系统管理员'||role=='人事经理'}">
        	    <li><a class="easyui-linkbutton" href="admin/humanResourceFileRegistrationReview" data-options="plain:true">人力资源档案登记复核</a></li>
        	</c:if>
        	<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}">
        	     <li><a class="easyui-linkbutton" href="admin/humanResourceFileQuery" data-options="plain:true">人力资源档案查询</a></li>
        	</c:if>
        	<c:if test="${role=='系统管理员'||role=='人事经理'}">
        	    <li><a class="easyui-linkbutton" href="admin/humanFileChangeReview" data-options="plain:true">人力资源档案变更复核</a></li>
        	</c:if>
        	<c:if test="${role=='系统管理员'||role=='人事经理'}">
        	     <li><a class="easyui-linkbutton" href="admin/humanResourceFileDelete" data-options="plain:true">人力资源档案恢复</a></li>
        	</c:if>
        		
            
           
            
           
            </div>
            <div title="薪酬管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        		<c:if test="${role=='系统管理员'||role=='薪酬专员'||role=='薪酬经理'}">
        			<li><a class="easyui-linkbutton" href="admin/StandardSalarySet" data-options="plain:true">薪酬标准登记</a></li>
        		</c:if>
        		<c:if test="${role=='系统管理员'||role=='薪酬经理'}">
        			 <li><a class="easyui-linkbutton" href="admin/CompensationStandardRegistrationReview" data-options="plain:true">薪酬标准登记复核</a></li>
        		</c:if>
        		<c:if test="${role=='系统管理员'||role=='薪酬专员'||role=='薪酬经理'}">
        			<li><a class="easyui-linkbutton" href="admin/salarySandardQuery" data-options="plain:true">薪酬标准查寻</a></li>
        		</c:if>
        		<c:if test="${role=='系统管理员'||role=='薪酬专员'||role=='薪酬经理'}">
        			<li><a class="easyui-linkbutton" href="admin/paymentRegistrationReview" data-options="plain:true">薪酬发放登记</a></li>
        		</c:if>
            </div>
            <div title="调动管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
            	<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}">
            		<li><a class="easyui-linkbutton" href="admin/transferFind" data-options="plain:true">调动登记</a></li>
            	</c:if>
            	<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}">
            		<li><a class="easyui-linkbutton" href="admin/transferAuditFind" data-options="plain:true">调动审核</a></li>
            	</c:if>
            	
        		
            </div>
              <div title="培训管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
            	<li><a class="easyui-linkbutton" href="admin/addtrain" data-options="plain:true">添加培训项目</a></li>
            	<li><a class="easyui-linkbutton" href="admin/TrainingFind" data-options="plain:true">培训安排</a></li>
            	<li><a class="easyui-linkbutton" href="admin/TrainingAuditFind" data-options="plain:true">安排审核</a></li>
            	
            </div>
             <div title="激励管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
            	 <li><a class="easyui-linkbutton" href="admin/addBonus" data-options="plain:true">添加激励项目</a></li>
            	 <li><a class="easyui-linkbutton" href="admin/bonusFind" data-options="plain:true">个人激励</a></li>
                 <li><a class="easyui-linkbutton" href="admin/bonusAuditFind" data-options="plain:true">激励审核</a></li>
            
            </div>
             <div title="招聘管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
<%--         		<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}"> --%>
        		
<%--         		</c:if> --%>
<%--         		<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}"> --%>
        		
<%--         		</c:if> --%>
<%--         		<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}"> --%>
        		
<%--         		</c:if> --%>
<%--         		<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}"> --%>
        		
<%--         		</c:if> --%>
<%--         		<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}"> --%>
        		
<%--         		</c:if> --%>
<%--         		<c:if test="${role=='系统管理员'||role=='人事专员'&&role=='人事经理'}"> --%>
        		
<%--         		</c:if> --%>
        		<li><a class="easyui-linkbutton" href="admin/toPostRegistration" data-options="plain:true">职位发布管理</a></li>
        		<li><a class="easyui-linkbutton" href="admin/toResumeManagement" data-options="plain:true">简历管理</a></li>
        		<li><a class="easyui-linkbutton" href="admin/toInterviewManagement" data-options="plain:true">面试管理</a></li>
        		<li><a class="easyui-linkbutton" href="admin/toItemBankManagement" data-options="plain:true">招聘考试题库管理</a></li>
        		<li><a class="easyui-linkbutton" href="admin/toExaminationManagement" data-options="plain:true">招聘考试管理</a></li>
        		<li><a class="easyui-linkbutton" href="admin/Hire" data-options="plain:true">录用管理</a></li>
            </div>
             <div title="标准化数据报" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        		<li><a class="easyui-linkbutton" href="transferAudit.html" data-options="plain:true">调动审核</a></li>
            </div>
        </div></div>
     <div data-options="region:'center'">
				<div id="main_panel" class="easyui-panel" title="主界面" data-options="fit:true,border:false"><div>
</div>
</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
<script>
	$('#menu>div>li>a').click(function(){
		var href=$(this).attr('href');
		$('#main_panel').panel('refresh',href);
		return false;
		});
//退出都登录 
function logout(){
	window.location.href="logout";
}
</script>
</html>
