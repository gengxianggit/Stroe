<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style.css"/>       
        <link href="assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/ace.min.css" />
        <link rel="stylesheet" href="font/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="js/jquery-1.9.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script> 
        <script type="text/javascript" src="js/H-ui.js"></script>      	
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
        <script src="assets/js/jquery.easy-pie-chart.min.js"></script>
        <script src="js/lrtk.js" type="text/javascript" ></script>
<title>订单详细</title>
</head>

<body>
<div class="margin clearfix">
<div class="Order_Details_style">
<div class="Numbering">订单编号:<b>${order.orderName }</b></div></div>
 <div class="detailed_style">
 <!--收件人信息-->
    <div class="Receiver_style">
     <div class="title_name">收件人信息</div>
     <div class="Info_style clearfix">
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件人姓名： </label>
         <div class="o_content">${order.ad.name }</div>
        </div>
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件人电话： </label>
         <div class="o_content">${order.ad.phone }</div>
        </div>
         <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件地邮编： </label>
         <div class="o_content">${order.ad.postcode }</div>
        </div>
         <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件地址： </label>
         <div class="o_content">${order.ad.pro } ${order.ad.city } ${order.ad.con } ${order.ad.street }</div>
        </div>
     </div>
    </div>
    <!--订单信息-->
    <div class="product_style">
    <div class="title_name">产品信息</div>
    <div class="Info_style clearfix">
    
    
    <c:forEach items="${order.odlist }" var="oo">
      <div class="product_info clearfix">
      <a href="#" class="img_link"><img src="pic/${oo.pro.pictures.get(0).path }"  width="200" height="200"/></a>
      <span>
      <a href="#" class="name_link">${oo.pro.name }</a>
      <b>${oo.pro.intriduceproduction }</b>
      </br>
      <p>数量：${oo.num }</p>
      <p>数量：1kg</p>
      <p>价格：<b class="price"><i>￥</i>${oo.pro.price }</b></p>  
      <p>状态：<i class="label label-success radius">有货</i></p>   
      </span>
      </div>
     </c:forEach>
      
      
      
    </div>
    </div>
    <!--总价-->
    <div class="Total_style">
     <div class="Info_style clearfix">
      <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 支付方式： </label>
         <div class="o_content">在线支付</div>
        </div>
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 支付状态： </label>
         <div class="o_content">等待付款</div>
        </div>
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 订单生成日期： </label>
         <div class="o_content">${order.date }</div>
        </div>
        </div>
      <div class="Total_m_style"><span class="Total">总数：<b></b></span><span class="Total_price">总价：<b>${order.orderprice }</b>元</span></div>
    </div>
<div class="Button_operation">
				<button onclick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="icon-save "></i><a href="showorder.do">返回上一步</a></button>
				
				<button onclick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
 </div>
</div>
</body>
</html>
