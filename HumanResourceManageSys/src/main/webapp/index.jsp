<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<link type="text/css" rel="stylesheet" href="css/index.css">
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
				<p>
					<input id="findVal" placeholder="请输入关键词..." /><a href="javascript:findMaior()">搜索</a>
				</p>
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

			
        <div class="_title"><span>职位招聘信息</span><a href="#">更多>></a></div>
        <div class="article1_3_3">
        	<div class="_long" style="">
        	<div style="width:100%;background-image: url('image/3.jpg');height:760px; ">
        	<div style="padding-top: 60px;">
        	<form id="orderform" method="post" action="">
				<table width="918" cellspacing="0" cellpadding="0" border="0">
                    <thead>
                        <tr>
                            <th class="first2" width="50" valign="middle">职位</th>
                            <th width="40" valign="middle">招聘人数</th>
                            <th width="100" valign="middle">发布日期</th>
                            <th width="100" valign="middle">截止日期</th>
                            <th width="100" valign="middle">职位描述</th>
                            <th width="100" valign="middle">招聘要求</th>
                            <th width="30" valign="middle"></th>
                        </tr>
                    </thead>
					<tbody id="shopcar">
					</tbody>
				</table>
			</form>
        			<ul id="enr">
        			</ul>
        	</div>
        			
        	</div>
                <dl class="div1">
                	<dt>
                    </dt>
                    <dd>
                    </dd>
                </dl>
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
	</script>
</body>
</html>
