<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<meta name="renderer" content="webkit">
<title>我的购物车-云购物商城</title>
<link rel="shortcut icon" type="image/x-icon"
	href="img/icon/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/modernizr-custom-v2.7.1.min.js"></script>
<script>
	$().ready(function() {

		$(".subtotal").each(function(){
			var num=$(this).prev().find("input").val();
			var price=$(this).prev().prev().find(".red").html();
			$(this).html(num*price)
			
			
		})
		
		
		$(".checkBox").click(function(){
			
		
				allprice();
				
		
		
		})
		
	
		
		function allprice() { 
			var price1 = 0;
			
			$(".subtotal").each(function(element, index) {
				var money=$(this);
			if($(this).parent().find(".checkBox").prop("checked")==true)
				{
				price1 += parseInt(money.html());
				
				}

			})

			$(".sumCount").html(price1)
			

		}

		$(".jia").click(function() {

			var id = $(this).prev().data("id");
			var num = parseInt($(this).prev().val()) + 1;
			$(this).prev().val(num);
			var subtotal = $(this).parent().next();
			var price = parseInt($(this).parent().prev().find(".red").html());

			$.ajax({
				url : "addButton.do",
				type : "post",
				data : {
					num : num,
					id : id,
					subtotal : num *( price-10),
					
					
				},
				dataType : "text",

				success : function(data) {
					if (data = "true") {
						subtotal.html(num * (price-10));

						allprice();
						

					}

				}

			})
		})

		$(".jian").click(function() {

			var id = $(this).next().data("id");

			var num = parseInt($(this).next().val()) - 1;
			if (num < 1) {
				num = 1;
			}

			$(this).next().val(num);
			var subtotal = $(this).parent().next();
			var price = parseInt($(this).parent().prev().find(".red").html());
			$.ajax({
				url : "addButton.do",
				type : "post",
				data : {
					num : num,
					id : id,
					subtotal : num * (price-10)
				},
				dataType : "text",

				success : function(data) {
					if (data = "ture") {

						subtotal.html(num * (price-10));
						allprice();
					}

				}

			})

		})

		$(".commNum").change(function() {
			var id = $(this).data("id");
			var num = $(this).val();
			var subtotal = $(this).parent().next();
			var price = parseInt($(this).parent().prev().find(".red").html());
			$.ajax({
				url : "addButton.do",
				type : "get",
				data : {
					num : num,
					id : id,
					subtotal : num * (price-10)
				},
				dataType : "text",

				success : function(data) {
					if (data = "true") {
						subtotal.html(num * (price-10));
						allprice();
					}

					
				}

			})

		})
		
		
		
		$("#order").click(function(){
		 var ids="";
		 var orderPrice=0;
		 var num=0;
		 
		 $(".checkBox").each(function(element,index){
			  var ordermoney=$(this);
			 if($(this).prop("checked")==true){
				 var id=$(this).data("id");
				  ids+=id+",";
				  orderPrice+=parseInt(ordermoney.parent().parent().find(".subtotal").html());
				 num+=parseInt($(this).parent().parent().find(".commNum").val())
			 }
			 
			 
		 })
		  if(ids.length==0){
			  alert("请选中")
			  
		  }else{
			  
			  
			  
			   ids=ids.substring(0,ids.length-1);
				location.href="order.do?&ids="+ids+"&num="+num;
				
		  }
			
			
			
		})
		
		$(".checkBox").click(function(){
			var flag=true;
			$(".checkBox").each(function(){
				if($(this).prop("checked")==false){
					
					flag=false;
					return false;
				}
				
				
				
			})
			
			if(flag){
				
				$("#allCheck").prop("checked",true);
				
			}else{
				

				$("#allCheck").prop("checked",false);
				
				
			}
			
			
		})
	
	$("#allCheck").click(function(){
		if($(this).prop("checked")==true){
			$(".checkBox").each(function(){
				$(this).prop("checked",true);
		})
		allprice();
		}else{
			$(".checkBox").each(function(){
				$(this).prop("checked",false);
		})
		allprice();
		}
			
		
		
		
	})

	
	
	
	
	
	$(".alldelete").click(function(){
		var ids="";
		 $(".checkBox").each(function(element,index){
			  var ordermoney=$(this);
			 if($(this).prop("checked")==true){
				 var id=$(this).data("id");
				  ids+=id+",";
	

		 }
		 })
		 ids=ids.substring(0,ids.length-1);
		 location.href="deletecartAll.do?&ids="+ids;
		 
		 })
	
	
	
	
	})
</script>

</head>
<body>

	<header id="pc-header">
	<div class="pc-header-nav">
		<div class="pc-header-con">
			<div class="fl pc-header-link">
				您好！，欢迎来云购物
				<c:if test="${ empty userNameSession }">
					<a href="login.do" target="_blank">请登录</a>
					<a href="register.do" target="_blank"> 免费注册</a>
				</c:if>
			</div>
			<div class="fr pc-header-list top-nav">
				<ul>
					<li>
						<div class="nav">
							<i class="pc-top-icon"></i><a href="#">我的订单</a>
						</div>
						<div class="con">
							<dl>
								<dt>
									<a href="">批发进货</a>
								</dt>
								<dd>
									<a href="">已买到货品</a>
								</dd>
								<dd>
									<a href="">优惠券</a>
								</dd>
								<dd>
									<a href="">店铺动态</a>
								</dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="nav">
							<i class="pc-top-icon"></i><a href="#">我的商城</a>
						</div>
						<div class="con">
							<dl>
								<dt>
									<a href="">批发进货</a>
								</dt>
								<dd>
									<a href="">已买到货品</a>
								</dd>
								<dd>
									<a href="">优惠券</a>
								</dd>
								<dd>
									<a href="">店铺动态</a>
								</dd>
							</dl>
						</div>
					</li>
					<li><a href="#">我的云购</a></li>
					<li><a href="#">我的收藏</a></li>
					<li><a href="#">会员中心</a></li>
					<li><a href="#">客户服务</a></li>
					<li><a href="#">帮助中心</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="pc-header-logo clearfix">
		<div class="pc-fl-logo fl">
			<h1>
				<a href="index.do"></a>
			</h1>
		</div>
		<div class="head-form fl">
			<form class="clearfix">
				<input class="search-text" accesskey="" id="key" autocomplete="off"
					placeholder="洗衣机" type="text">
				<button class="button" onclick="search('key');return false;">搜索</button>
			</form>
			<div class="words-text clearfix">
				<a href="#" class="red">1元秒爆</a> <a href="#">低至五折</a> <a href="#">农用物资</a>
				<a href="#">佳能相机</a> <a href="#">服装城</a> <a href="#">买4免1</a> <a
					href="#">家电秒杀</a> <a href="#">农耕机械</a> <a href="#">手机新品季</a>
			</div>
		</div>
		<div class="fr pc-head-car">
			<i class="icon-car"></i> <a href="#">我的购物车</a>
		</div>
	</div>
	<!--  顶部    start-->
	<div class="yHeader">
		<!-- 导航   start  -->
		<div class="yNavIndex">
			<ul class="yMenuIndex" style="margin-left: 0">
				<li style="background: #d1201e"><a href="" target="_blank">云购首页</a></li>
				<li><a href="" target="_blank">女士护肤 </a></li>
				<li><a href="" target="_blank">男士护肤</a></li>
				<li><a href="" target="_blank">洗护染发</a></li>
				<li><a href="" target="_blank">染发</a></li>
				<li><a href="" target="_blank">彩妆</a></li>
				<li><a href="" target="_blank">品牌故事</a></li>
			</ul>
		</div>
		<!-- 导航   end  -->
	</div>

	</header>

	<section id="pc-jie">
	<div class="center ">
		<ul class="pc-shopping-title clearfix">
			<li><a href="#" class="cu">全部商品(10)</a></li>
			<li><a href="#">限时优惠(7)</a></li>
			<li><a href="#">库存紧张(0)</a></li>
		</ul>
	</div>
	<div class="pc-shopping-cart center">
		<div class="pc-shopping-tab">
			<table>
				<thead>
					<tr class="tab-0">
						<th class="tab-1"><input type="checkbox" name="s_all"
							class="s_all tr_checkmr" id="s_all_h"><label for="">
								全选</label></th>
						<th class="tab-2">商品</th>
						<th class="tab-3">商品信息</th>
						<th class="tab-4">单价</th>
						<th class="tab-5">数量</th>
						<th class="tab-6">小计</th>
						<th class="tab-7">操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="7" style="padding-left: 10px; background: #eee">
							<input type="checkbox" checked> <label for="">云购物自营</label>
							<a href="#" style="position: relative; padding-left: 50px"><i
								class="icon-kefu"></i>联系客服</a>
							<ul class="clearfix fr" style="padding-right: 20px">
								<li><i class="pc-shop-car-yun"></i>满109元减10</li>
								<li><i class="pc-shop-car-yun"></i>领取3种优惠券, 最高省30元</li>
							</ul>
						</td>
					</tr>



					<c:forEach items="${cart.scdList}" var="cd">
						<tr>
							<th> <input type="checkbox"
								style="margin-left: 10px; float: left" class="checkBox" data-id="${cd.comm.id }"/></th>
							<th class="tab-th-1"><a href="#"><img
									src="img/${cd.comm.pictures.get(0).path}" width="100%" alt=""></a>
								<a href="detail.do?id=${cd.comm.id}" class="tab-title">${cd.comm.name}
							</a></th>
							<th>
								<p>颜色：黑色</p>
								<p>规格：落地款</p>
							</th>
							<th>
								<p>${cd.comm.price}</p>
								<p class="red">${cd.comm.price-10 }</p>
							</th>
							<th class="tab-th-2"><span class="jian">-</span> <input
								type="text" value="${cd.num }" data-id="${cd.id}" maxlength="3"
								placeholder="" class="shul commNum" /> <span class="jia">+</span>
							</th>
							<th class="red subtotal">${cd.subtotal }</th>
							<th><a href="deletecart.do?id=${cd.comm.id}">删除</a></th>
						</tr>
					</c:forEach>


				</tbody>
			</table>

		</div>
	</div>
	<div style="height: 10px"></div>
	<div class="center">
		<div class="clearfix pc-shop-go">
			<div class="fl pc-shop-fl">
				<input type="checkbox" placeholder="" id="allCheck"> <label for="">全选</label>
				<a  class="alldelete">删除</a> <a href="#">清楚失效商品</a>
			</div>
			<div class="fr pc-shop-fr">
				<p>
					共有 <em class="red pc-shop-shu">${commNum }</em> 款商品，总计（不含运费）
				</p>
				<span class="sumCount"> 0</span> <a id="order">去付款</a>
			</div>
		</div>
	</div>
	</section>



	<div style="height: 100px"></div>

	<footer>
	<div class="pc-footer-top">
		<div class="center">
			<ul class="clearfix">
				<li><span>关于我们</span> <a href="#">关于我们</a> <a href="#">诚聘英才</a>
					<a href="#">用户服务协议</a> <a href="#">网站服务条款</a> <a href="#">联系我们</a>
				</li>
				<li class="lw"><span>购物指南</span> <a href="#">新手上路</a> <a
					href="#">订单查询</a> <a href="#">会员介绍</a> <a href="#">网站服务条款</a> <a
					href="#">帮助中心</a></li>
				<li class="lw"><span>消费者保障</span> <a href="#">人工验货</a> <a
					href="#">退货退款政策</a> <a href="#">运费补贴卡</a> <a href="#">无忧售后</a> <a
					href="#">先行赔付</a></li>
				<li class="lw"><span>商务合作</span> <a href="#">人工验货</a> <a
					href="#">退货退款政策</a> <a href="#">运费补贴卡</a> <a href="#">无忧售后</a> <a
					href="#">先行赔付</a></li>
				<li class="lss"><span>下载手机版</span>
					<div class="clearfix lss-pa">
						<div class="fl lss-img">
							<img src="img/icon/code.png" alt="">
						</div>
						<div class="fl" style="padding-left: 20px">
							<h4>扫描下载云购APP</h4>
							<p>把优惠握在手心</p>
							<P>把潮流带在身边</P>
							<P></P>
						</div>
					</div></li>
			</ul>
		</div>
		<div class="pc-footer-lin">
			<div class="center">
				<p>友情链接： 卡宝宝信用卡 梦芭莎网上购物 手游交易平台 法律咨询 深圳地图 P2P网贷导航 名鞋库 万表网 叮当音乐网
					114票务网 儿歌视频大全</p>
				<p>京ICP证1900075号 京ICP备20051110号-5 京公网安备110104734773474323
					统一社会信用代码 91113443434371298269B 食品流通许可证SP1101435445645645640352397</p>
				<p style="padding-bottom: 30px">版物经营许可证 新出发京零字第朝160018号
					Copyright©2011-2015 版权所有 ZHE800.COM</p>
			</div>
		</div>
	</div>
	</footer>
	<script type="text/javascript">
		//hover 触发两个事件，鼠标移上去和移走
		//mousehover 只触发移上去事件
		$(".top-nav ul li").hover(function() {
			$(this).addClass("hover").siblings().removeClass("hover");
			$(this).find("li .nav a").addClass("hover");
			$(this).find(".con").show();
		}, function() {
			//$(this).css("background-color","#f5f5f5");
			$(this).find(".con").hide();
			//$(this).find(".nav a").removeClass("hover");
			$(this).removeClass("hover");
			$(this).find(".nav a").removeClass("hover");
		})
	</script>
</body>
</html>