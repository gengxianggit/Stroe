<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/PIE_IE678.js"></script>
<![endif]-->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style.css"/>       
<link href="assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/ace.min.css" />
      <link rel="stylesheet" href="Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link href="Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="Widget/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js"></script>   

<script type="text/javascript">
$().ready(function(){
 	$(".uploadBtn").click(function(){
 	  var formData=new FormData();
 	 for(var i=0;i<$("[name='photo']")[0].files.length;i++){
			formData.append("photo",$("[name='photo']")[0].files[i]);
		}
 	$.ajax({
 		url:"updateupload.do",
		type:"post",
		data:formData,
		cache:false,
	processData:false,
	contentType:false,
		dataType:"json",
		success:function(data){
			$.each(data,function(){
				
var str="<img  src='pic/"+this.path+"'style= 'width='50px' height='80px''/>";
				str+="<input type='text' name='order' value='"+this.order+"' data-id='"+this.path +" 'style=width:20px ;"+" />"
				$("#dndArea").append(str);	
				
			})
			
		}
 		
 		
 		
 	})
		
		
 	})
	
$(document).on("click","#dndArea img",function(){
	var path=$(this).next().data("id");
	var img=$(this);
	var order=$(this).next();
	$.ajax({
		url:"deleteFile.do",
		type:"post",
		data:{path:path},
		dataType:"text",
		success:function(data){
			if(data=="true"){
			img.remove();
			order.remove();
			}
		}
		
		
		
		
	})

	
	
	
	
})	
	
$(document).on("change","[name='order']",function(){
	var order=$(this).val();
	var path=$(this).data("id");
	$.ajax({
		url:"updateImg.do",
		type:"post",
		data:{path:path,order:order},
		dataType:"text",
		success:function(){
			
		}
		
		
	})
	
	
})
	
})

</script>

<title>新增图片</title>
</head>
<body>
<div class="clearfix" id="add_picture">
<div id="scrollsidebar" class="left_Treeview">
    <div class="show_btn" id="rightArrow"><span></span></div>
    <div class="widget-box side_content" >
    <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
     <div class="side_list">
      <div class="widget-header header-color-green2">
          <h4 class="lighter smaller">选择产品类型</h4>
      </div>
      <div class="widget-body">
          <div class="widget-main padding-8">
              <div  id="treeDemo" class="ztree"></div>
          </div>
  </div>
  </div>
  </div>  
  </div>
   <div class="page_right_style">
   <div class="type_title">添加商品</div>
	<form action="updateProduction.do" method="post" class="form form-horizontal" id="form-article-add">
      
<!-- 		<div class="clearfix cl"> -->
<!--          <label class="form-label col-2"><span class="c-red">*</span>图片标题：</label> -->
<!-- 		 <div class="formControls col-10"><input type="text" class="input-text" value="" placeholder="" id="" name=""></div> -->
<!-- 		</div> -->
<!-- 		<div class=" clearfix cl"> -->
<!--          <label class="form-label col-2">简略标题：</label> -->
<!-- 	     <div class="formControls col-10"><input type="text" class="input-text" value="" placeholder="" id="" name=""></div> -->
<!-- 		</div> -->
		<div class=" clearfix cl">
			
			<div class="Add_p_s">
            <label class="form-label col-2">产品编号：</label>
			<div class="formControls col-2"><input type="text" class="input-text" value="${pro.id }" placeholder="" id="" name="id"></div>
            </div>
			<div class="Add_p_s">
             <label class="form-label col-2">产 &nbsp;&nbsp;&nbsp;&nbsp;品：</label>	
			 <div class="formControls col-2"><input type="text" class="input-text" value="${pro.name }" placeholder="" id="" name="name"></div>
			</div>
            <div class="Add_p_s">
             <label class="form-label col-2">价&nbsp;&nbsp;&nbsp;&nbsp;格：</label>	
			 <div class="formControls col-2"><input type="text" class="input-text" value="${pro.price }" placeholder="" id="" name="price"></div>
			</div>
            <div class="Add_p_s">
             <label class="form-label col-2">数&nbsp;&nbsp;&nbsp;&nbsp;量：</label>	
			 <div class="formControls col-2"><input type="text" class="input-text" value="${pro.inventory}" placeholder="" id="" name="Inventory"></div>
			</div>
<!--              <div class="Add_p_s"> -->
<!--              <label class="form-label col-2">产品重量：</label>	 -->
<!-- 			 <div class="formControls col-2"><input type="text" class="input-text" value="" placeholder="" id="" name="" >kg</div> -->
<!-- 			</div> -->
<!--              <div class="Add_p_s"> -->
<!--              <label class="form-label col-2">单位：</label>	 -->
<!-- 			 <div class="formControls col-2"><span class="select-box"> -->
<!-- 				<select class="select"> -->
<!-- 					<option>请选择</option> -->
<!-- 					<option value="1">件</option> -->
<!-- 					<option value="2">斤</option> -->
<!-- 					<option value="3">KG</option> -->
<!-- 					<option value="4">吨</option> -->
<!-- 					<option value="5">套</option> -->
<!-- 				</select> -->
<!-- 				</span></div> -->
<!-- 			</div> -->
<!--             <div class="Add_p_s"> -->
<!--              <label class="form-label col-2">展示价格：</label>	 -->
<!-- 			 <div class="formControls col-2"><input type="text" class="input-text" value="" placeholder="" id="" name="" >元</div> -->
<!-- 			</div> -->
<!--             <div class="Add_p_s"> -->
<!--              <label class="form-label col-2">市场价格：</label>	 -->
<!-- 			 <div class="formControls col-2"><input type="text" class="input-text" value="" placeholder="" id="" name="" >元</div> -->
<!-- 			</div> -->
           
			
		</div>
		
		<div class="clearfix cl">
			<label class="form-label col-2">产品介绍：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${pro.intriduceproduction }" placeholder="" id="" name="intriduceproduction">
			</div>
		</div>
<!-- 		<div class="clearfix cl"> -->
<!-- 			<label class="form-label col-2">内容摘要：</label> -->
<!-- 			<div class="formControls col-10"> -->
<!-- 				<textarea name="" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"></textarea> -->
<!-- 				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div class="clearfix cl">
		
			<label class="form-label col-2">图片上传：</label>
			<div class="formControls col-10">
				<div class="uploader-list-container"> 
					<div class="queueList">
						<div id="dndArea" class="placeholder">
							<div id="filePicker-2"></div>
						<c:forEach items="${pro.pictures}"  var="pImg">
					
						<img  src="pic/${pImg.path}"   style= width='50px' height='80px' />;
				       <input type='text' name='order' value="${pImg.order}" data-id="${pImg.path }"  style= "width:20px;" />
						
						
						</c:forEach>
							
						</div>
					</div>
					
					<div class="statusBar" style="display:none;">
						<div class="progress"> <span class="text">0%</span> <span class="percentage"></span> </div>
						<div class="info"></div>
						<div class="btns">
							<div id="filePicker2"></div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<input type="file" name="photo" multiple/>
		<input type="button" class="uploadBtn" value="文件上传"  />
         <div class="clearfix cl">
         <label class="form-label col-2">详细内容：</label>
			<div class="formControls col-10">
				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 
             </div>
        </div>
        <div class="clearfix cl">
         <label class="form-label col-2">允许评论：</label>
			<div class="formControls col-2 skin-minimal">
			 <div class="check-box" style=" margin-top:9px"><input type="checkbox" id="checkbox-1"><label for="checkbox-1">&nbsp;</label></div>
             </div>
        </div>
		<div class="clearfix cl">
			<div class="Button_operation">
				<button id="saveProduction" class="btn btn-primary radius" type="submit"><i class="icon-save "></i>保存并提交审核</button>
				<button onClick="article_save();" class="btn btn-secondary  btn-warning" type="button"><i class="icon-save"></i>保存草稿</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
    </div>
</div>
</div>

<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/layer/layer.js" type="text/javascript" ></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="Widget/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="Widget/icheck/jquery.icheck.min.js"></script> 
 <script type="text/javascript" src="Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript" src="Widget/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="Widget/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="Widget/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="Widget/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="Widget/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script> 
<script src="js/lrtk.js" type="text/javascript" ></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 

</script>
</body>
</html>