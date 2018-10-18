<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	
<link rel="stylesheet" href="css/listview.css" />
	
	<script type="text/javascript" src="js/jquery.js" ></script>
		<script>
			    $().ready(function(){
				var index=0;
			    var length=$("#image li").length;
			    
				$("#image li").hide();
				$("#image li").eq(0).show();
				
				function show(){
					$("#image li").hide();
					$("#image li").eq(index).show();
                  $("#btn li").removeClass("select");
               $("#btn li").eq(index).addClass("select");
				}
				   
				   function change(){
					if(index<length-1){
			    	index++;
			    }else{
			    	index=0;
			    }
					show();
				}
			
				$("#box").hover(function(){
					$("#next,#prev").show();
					clearInterval(timer);
				},function(){
					$("#next,#prev").hide();
					 clearInterval(timer);
				  timer=setInterval(change,2000);
				})
				
				$("#btn li").click(function(){
					 index=$(this).index();
					show();
				})
				
				$("#next").click(function(){
					change();
				})
				$("#prev").click(function(){
					index--;
					if(index<0){
					index=length-1;
					}
					show();
					
					
				})
				
				
			var timer=setInterval(change,2000);
				
				
				$("#sbt").click(function(){
					
					var searchName=$("st").val();
					location.href="class.do?searchName="+searchName;
					
				})
				
			})
			    
		</script>
	</head>
	<body>
	<div id="main">
	<div id="base">
		
		<ul id="u1">
	    <li> <i class="iconfont">&#xe657;</i>
		<label >首页</label></li> 
		<li id="location"><i class="iconfont" id="location">&#xe65d; </i> 
		位置</li>
		</ul>
	    <ul id="u2">
          <li>|<label>手机京东</label></li>
	       <li>|<label>网站导航</label><i class="iconfont">&#xe685;</i></li>
	       <li>|<label>客户服务</label><i class="iconfont">&#xe685;</i></li>
	       <li>|<label>企业采购</label><i class="iconfont">&#xe685;</i></li>
	       <li>|<a>京东会员</a></li>
	       <li>|<label>我的京东</label><i class="iconfont">&#xe685;</i></li>
	      <li>  <a>我的订单</a></li>
	      <li> 
	      <c:if test="${ empty userNameSession}"><a href="login.do" target="_blank">请登录</a> <a href="register.do" target="_blank"> 免费注册</a></c:if>
	      </li>
	</ul>
      
	</div>
	<div><a><img src="img/5b72cdabN20f2d1bc.jpg"/></a></div>
	
	<div id="a">
		
		
		<div id="a1">
	<div id="fl"> <img src="img/捕获.PNG"/></div>	
	<div id="fl" class="ft">手机</div>
	<div id="fs" class="fs"><a href="class.do">手机分类</a><i class="iconfont">&#xe685;</i></div>

	</div>
	
	
	
		<div id="dc">
			<div>
		<input type="text" id="st"/>
		<input type="button" value="搜索" id="sbt"/>
		
		</div>
		
		
		<div id="typ">
		          <ul id="tyt">
			           <li> 小米</li>
						<li>华为</li>
						<li>苹果</li>
						<li>vivo</li>
						<li>三星</li>
				     </ul>
				     </div>
				     </div>
				     
			
		
		<div id=fl class="d1">
		 <i class="iconfont" id="big">&#xe896;</i><label id="co"><a href="cart.do" target="_blank" >我的购物车</a><em>${commNum }</em></label>
			</div>
			
			<div id=fl class="d2">
				<i class="iconfont" id="mbig">&#xe7f1;</i>
				<label>扫码优惠</label>
				</div>
				
				
				</div>
				<div id="cp">
				<div  id="cp1">
					手机分类
					</div>	
					<div id="cp2">
						<ul id="bns">
							
							<li>京东之家</li>
							
							<li>社区</li>
							
							<li>玩3G</li>
							
							<li>以旧换新</li>
							
							<li>企业购</li>
							<li>营业厅</li>
							<li>配件</li>
							<li>游戏手机</li>
							<li>手机好店</li>
							<li>有新机</li>
							
						</ul>
						
						
					</div>
					<div id="care">
						<i class="iconfont" id="care1">&#xe70c;
							<label>关注频道</label></i>
					
						
				</div>
					
		</div>
		
		<div id="bc">
		<div id="classfty">
		<ul id="classfty1">
			<li><div><div>热门推荐<div>
				<div id="tdistance">
				<div id="distance">
						<a>小米</a>
						<a>华为</a>
						<a>魅族</a>
					</div>
					<div id="distance">
						<a>iphoe</a>
						<a>三星</a>
						<a>vivo</a>
					</div>
				</div>
			</div></li>
			<li><div>热门分类</div>
				<div id="tdistance">
				<div id="distance1">
						<a>全部手机</a>
						<a>游戏手机</a>
						<a>老人机</a>
					</div>
					
					<div id="distance1">
						<a>拍照神器</a>
						<a>全面屏</a>
						<a>女性手机</a>
					</div>
			</li>
			<li><div>运营商</div>
				<div id="tdistance">
				<div id="distance">
						<a>营业厅</a>
						<a>选号码</a>
						<a>4G套餐</a>
					</div>
					<div id="distance">
						<a>买手机</a>
						<a>装宽带</a>
						<a>充话费</a>
					</div>
			</li>
			<li><div>手机配件</div>
				<div id="tdistance">
				<div id="distance">
						<a>充电宝</a>
						<a>数据线</a>
						<a>手机壳</a>
					</div>
					<div id="distance1">
						<a>手机膜</a>
						<a>手机支架</a>
						<a>浪玩周边</a>
					</div>
			</li>
			
		</ul>
		<div>
			<ul id="d3">
				<li><div> <i class="iconfont">&#xe620;</i></div><a>充值中心 </a></li>
				<li><div><i class="iconfont"> &#xe6dc;</i></div><a>手机维修 </a></li>
				<li><div> <i class="iconfont">&#xe93e;</i></div><a>二手回收 </a> </li>
			
			
			
			</ul>
			
		</div>
		</div>	
           <div id="si">
      <div id="box">
		<ul id="image">
			<li><a href="hello.html"><img src="img/5b72cdd6N33c7b79e.jpg!q90.jpg" /></a></li>
			<li><img  src="img/5b73c4e1Ndbe4d00f.jpg!q90.jpg"/></li>
			<li><img  src="img/5b73dd95N2e77ab88.jpg!q90.jpg"/></li>
			<li><img  src="img/5b74c670N643c3436.jpg!q90.jpg"/></li>
		    <li><img  src="img/5b74cc17Nc5c2220c.jpg!q90.jpg"/></li>
		    <li><img  src="img/5b74cc17Nc5c2220c.jpg!q90.jpg"/></li>
		</ul>
		<ul id="btn">
			<li class="select">1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
			<li>5</li>
			
		
		</ul>
		<div id="prev"> &lt;</div>
		<div id="next"> &gt;</div>
		</div >
           	
           	
           	
           </div>
			
		</div>
		<div id="phonelist">
			
			<div class="p1">
			<div id="p11"> 热门推荐</div>
			<div id="p11"> 新品首发</div>
			<div class="p2">
			<div id="p21">
				
				<ul id="p211">
					<li><img src="img/5ad87390N086a3c91.jpg!q95.jpg"/ id="p2111"><div id="p2112">小米8柔光双射</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b0fc15aNa92ad79a.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b5fbad7N7bb3f7d4.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					
				</ul>	
					
				
			</div>
			<div id="p21">
				
				<ul id="p211">
					<li><img src="img/5ad87390N086a3c91.jpg!q95.jpg"/ id="p2111"><div id="p2112">小米8柔光双射</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b0fc15aNa92ad79a.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b5fbad7N7bb3f7d4.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					
				</ul>	
					
				
			</div>
			</div>
			<div class="p3">
			<div id="p21">
				
				<ul id="p211">
					<li><img src="img/5ad87390N086a3c91.jpg!q95.jpg"/ id="p2111"><div id="p2112">小米8柔光双射</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b0fc15aNa92ad79a.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b5fbad7N7bb3f7d4.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					
				</ul>	
					
				
			</div>
			<div id="p21">
				
				<ul id="p211">
					<li><img src="img/5ad87390N086a3c91.jpg!q95.jpg"/ id="p2111"><div id="p2112">小米8柔光双射</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b0fc15aNa92ad79a.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					<li><img src="img/5b5fbad7N7bb3f7d4.jpg!q95.jpg"/id="p2111"><div id="p2112">小米</div><div id="p2113">￥2999</div></li>
					
				</ul>	
					
				
			</div>
			</div>
			
			
			
			
			
			
		</div>
		
		</div>
	
	</body>
</html>
