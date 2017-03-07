<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	padding-right:300px;
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

    <div data-options="region:'north',title:'North Title',split:true" style="height:130px;">
    	<div class="header"><p>人力资源管理中心</p></div>
    
    </div>  
  
    
    <div data-options="region:'west',title:'West',href:'',split:true" style="width:200px;">
    	<div id="menu" class="easyui-accordion" fit="true" border="false">
        	<div title="系统管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        	</div>
            <div title="人力资源档案管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px; height:30px;">
        		<li><a class="easyui-linkbutton" href="admin/humanResourceRegistration" data-options="plain:true">人力资源档案登记</a></li>
                 <li><a class="easyui-linkbutton" href="admin/humanResourceFileRegistrationReview" data-options="plain:true">人力资源档案登记复核</a></li>
                 <li><a class="easyui-linkbutton" href="admin/humanResourceFileQuery" data-options="plain:true">人力资源档案查询</a></li>
                 <li><a class="easyui-linkbutton" href="admin/humanResourceFileUpdate" data-options="plain:true">人力资源档案变更</a></li>
                 <li><a class="easyui-linkbutton" href="admin/humanResourceFileDelete" data-options="plain:true">人力资源档案删除</a></li>
                        
            </div>
            <div title="薪酬管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        		<li><a class="easyui-linkbutton" href="StandardSalarySet.html" data-options="plain:true">薪酬标准登记</a></li>
                <li><a class="easyui-linkbutton" href="CompensationStandardRegistrationReview.html" data-options="plain:true">薪酬标准登记复核</a></li>
                <li><a class="easyui-linkbutton" href="salarySandardQuery.html" data-options="plain:true">薪酬标准查寻</a></li>
           
        		<li><a class="easyui-linkbutton" href="paymentRegistrationReview.html" data-options="plain:true">薪酬发放登记</a></li>
           
                

            </div>
            <div title="调动管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
            	<li><a class="easyui-linkbutton" href="transferRegistration.html" data-options="plain:true">调动登记</a></li>
        		<li><a class="easyui-linkbutton" href="transferAudit.html" data-options="plain:true">调动审核</a></li>
            </div>
             <div title="培训管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        		<li><a class="easyui-linkbutton" href="transferAudit.html" data-options="plain:true">调动审核</a></li>
            </div>
             <div title="激励管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        		<li><a class="easyui-linkbutton" href="transferAudit.html" data-options="plain:true">调动审核</a></li>
            </div>
             <div title="招聘管理" data-options="iconCls:'icon-folder',selected:true" style="overflow:auto; padding:10px;">
        		<li><a class="easyui-linkbutton" href="transferAudit.html" data-options="plain:true">职位发布管理</a></li>
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
<script>
	$('#menu>div>li>a').click(function(){
		var href=$(this).attr('href');
		$('#main_panel').panel('refresh',href);
		return false;
		});

</script>
</html>
