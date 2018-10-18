<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>

<style>
#emp {
	width: 900px;
	margin: 20px auto;
}

#emp .select {
	background: #337ab7
}

#emp .select1 {
	background: red;
}

td {
	width: 30px;
	height: 20px;
}
td img{
width: 60px;
height: 30px;
}
#bigPic{
width: 300px;
height: 200px;
position:absolute;
display:none;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
	$()
			.ready(
					function() {
						var selectId = -1;

						$("#showadd").click(function() {
							location.href = "showAdd3.do";

						})
						
						$("#showadd2").click(function() {
							location.href = "showAdd1.do";

						})
						
						$("#showupdate")
								.click(
										function() {
											
											if (selectId > -1) {
												location.href = "showupdate.do?id="+ selectId;
											} else {
												alert("请选中");
											}

										})

						$(".abc").click(function() {

							$(this).toggleClass("select");
							selectId = $(this).data("id");
						})
						$("#delete").click(
								function() {
									if (selectId > -1) {
										location.href = "emp?type=delete&&id="
												+ selectId;
									} else {
										alert("请选中");
									}
								})

						$("#deletebatch")
								.click(
										function() {
											var length = ($("#emp .select").length);
											var ids = "";
											if (length > 0) {
												$("#emp .select")
														.each(
																function(index,
																		element) {
																	ids += $(
																			this)
																			.data(
																					"id")
																			+ ",";

																})
												ids = ids.substring(0,
														ids.length - 1);

												location.href = "delete.do?ids="
														+ ids;

											} else {
												alert("plese select");
											}

										})
						$("#updatebatch1")
								.click(
										function() {
											var length = ($("#emp .select").length);
											var ids = "";
											if (length > 0) {
												$("#emp .select")
														.each(
																function(index,
																		element) {
																	ids += $(
																			this)
																			.data(
																					"id")
																			+ ",";
																})
												ids = ids.substring(0,
														ids.length - 1);
												location.href = "emp?type=showupdatabatch1&&ids="
														+ ids;

											} else {
												alert("plese select");
											}

										})
						$("#updatebatch2")
								.click(
										function() {
											var length = ($("#emp .select").length);
											var ids = "";
											if (length > 0) {
												$("#emp .select")
														.each(
																function(index,
																		element) {
																	ids += $(
																			this)
																			.data(
																					"id")
																			+ ",";
																})
												ids = ids.substring(0,
														ids.length - 1);
												location.href = "emp?type=showupdatabatch2&&ids="
														+ ids;

											} else {
												alert("plese select");
											}

										})

						$(".abc")
								.dblclick(
										function() {
											$(this).unbind("dblclick");
											$(this).unbind("click");
											var name = $(this).find(
													"[name=name1]").text();
											var sex = $(this)
													.find("[name=sex1]").text()
											var age = $(this)
													.find("[name=age1]").text()

											$(this).addClass("select1");

											$(this)
													.children()
													.eq(0)
													.html(
															"<input type='text' name=name2  value="+name+" />")

											if (sex == "男") {
												$(this)
														.children()
														.eq(1)
														.html(
																"<select name='sex2'><option value='男' selected>男</option><option  value='女'>女</option></select>")
											} else {
												$(this)
														.children()
														.eq(1)
														.html(
																"<select name='sex2'><option value='男'>男</option><option  value='女' selected >女</option></select>")
											}

											$(this)
													.children()
													.eq(2)
													.html(
															"<input type='text' name=age2  value="+age+">")

											/*	alert(!($(this).css("background")=="red"));
												if($(this).css("background")!="red"){
												
													
													
												$(this).addClass("select1");
												 var name=$(this).find("[name=name]").html()
											   var sex=$(this).find("[name=sex]").html()
												var age=$(this).find("[name=age]").html()
												alert(name)
												$(this).find("[name=name]").html("<input type='text' name=name1  value="+name+" />")
												$(this).find("[name=sex]").html(("<input type='text' name=sex1  value="+sex+" />"))
												$(this).find("[name=age]").html("<input type='text' name=age1   value="+age+" />")
											  
												}*/
										})
										
										
										
										

						$("#updatebatch3")
								.click(
										function() {
											var length = ($("#emp .select1").length);
											var array = new Array();
											if (length > 0) {
												$("#emp .select1")
														.each(
																function(index,
																		element) {
																	var id = $(
																			this)
																			.data(
																					"id");
																	var name = $(
																			this)
																			.find(
																					"[name=name2]")
																			.val();

																	var sex = $(
																			this)
																			.find(
																					"[name=sex2]")
																			.val();

																	var age = $(
																			this)
																			.find(
																					"[name=age2]")
																			.val();
																	var emp = {
																		id:id,
																		name:name,
																		sex:sex,
																		age:age
																		
																	}
																	array
																		.push(emp);

																})

											 
											
												$.ajax({
													url:"updatebatch.do",
													type:"post",
													contentType:"application/json",
													data:JSON.stringify(array),
													dataType:"json",
													success:function(data){
														
														$.each(data,function(index,element){
															$("#emp .select1").eq(index).find("[name='name1']").html(this.name);
															$("#emp .select1").eq(index).find("[name='sex1']").html(this.sex);
															$("#emp .select1").eq(index).find("[name='age1']").html(this.age);
															
															})
															$("#emp .select1").removeClass("select1");
														
														
														
										                     $(".abc").bind("dblclick",function() {
																
																var name = $(this).find(
																		"[name=name1]").text();
																var sex = $(this)
																		.find("[name=sex1]").text()
																var age = $(this)
																		.find("[name=age1]").text()

																$(this).addClass("select1");

																$(this)
																		.children()
																		.eq(0)
																		.html(
																				"<input type='text' name=name2  value="+name+" />")

																if (sex == "男") {
																	$(this)
																			.children()
																			.eq(1)
																			.html(
																					"<select name='sex2'><option value='男' selected>男</option><option  value='女'>女</option></select>")
																} else {
																	$(this)
																			.children()
																			.eq(1)
																			.html(
																					"<select name='sex2'><option value='男'>男</option><option  value='女' selected >女</option></select>")
																}

																$(this)
																		.children()
																		.eq(2)
																		.html(
																				"<input type='text' name=age2  value="+age+">")
										                   })
														
													}
										        
													
													
													
													}) 
												
													
											} else {
												alert("请选中");
											}

										})
										
					
							if(${p.ye}<=1){
					 			$("#pre").addClass("disabled");
								$("#pre").find("a").attr("oncilk","return false")
								
							}
			 				 
				 	
							if(${p.ye}>=${p.maxYe}){
								$("#next").addClass("disabled");
								$("#next").find("a").attr("oncilk","return false")
							}
							
			 				

							$("td img").hover(function(event){
								
								var img=$(this).attr("src");
								$("#bigPic").attr("src",img);
								$("#bigPic").show();
								$("#bigPic").css({left:event.pageX+10,top:event.pageY+10})
							},function(){
								
								$("#bigPic").hide();
								
							})	
									
     
					})
</script>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<div id="emp">
<div>
   <form class="form-inline" role="form" action="search.do" method="post">
  <label >名称:</label>
    <input type="text" class="form-control" name="name" value="${c.name }" placeholder="请输入名称">
    <label>性别:</label>
   <select class="form-control" name="sex"> 
    <option value=''>请选择性别</option>
   <option value='男'<c:if test="${c.sex=='男'}">selected</c:if>> 男 </option>
    <option value='女'<c:if test="${c.sex=='女'}">selected</c:if>> 女 </option>
    
   </select>
<label>年龄:</label>
  <input type="text" class="form-control" name="age" placeholder="请输入年龄" value="${c.age!=-1?c.age:"" }"/>
  <label>部门:</label>
   <select class="form-control" name="dep.id"> 
    <option value=''>请选择部门</option>
  <c:forEach items="${depList}" var="dep">
   <option value="${dep.id}" <c:if test="${dep.id == c.dep.id}"> selected </c:if>> ${dep.name} </option>
    
  </c:forEach>
   </select>
  <input type="submit" value="搜索"/>
  
</form>
<br/>
<br/>
</div>


	
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
			<thead>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>部门 </th>
			  <th>图片 </th>
			</thead>
			</tr>
			<c:forEach items="${list}" var="emp">
			<tr data-id=${emp.id} class="abc">
				<td name="name1">${emp.name}</td>
				<td name="sex1">${emp.sex}</td>
				<td name="age1">${emp.age}</td>
			 	<td name="depName1">${emp.dep.name}</td>
	      <td name="img"><c:if test="${ not empty emp.img }"><img src="/img/${emp.img}"/></c:if></td>
			</tr>
		 </c:forEach>
		</table>
		
		<ul class="pagination">
			<li><a href="search.do?ye=1&name=${c.name }&sex=${c.sex }&age=${c.age!=-1?c.age:""}&dep.id=${c.dep.id }">首页</a></li>
		
	<li id="pre"><a href="search.do?ye=${p.ye-1}&name=${c.name }&sex=${c.sex }&age=${c.age!=-1?c.age:"" }&dep.id=${c.dep.id }">上一页</a></li>
     <c:forEach begin="${p.beginYe}" end="${p.endYe}" varStatus="status">
	<li <c:if test="${p.ye==status.index}"> class="active" </c:if>><a
	 href="search.do?ye=${status.index}&name=${c.name }&sex=${c.sex }&age=${c.age!=-1?c.age:"" }&dep.id=${c.dep.id }"> ${status.index}</a></li>
	</c:forEach>
	<li id="next"><a href="search.do?ye=${p.ye+1}&name=${c.name }&sex=${c.sex }&age=${c.age!=-1?c.age:""}&dep.id=${c.dep.id }">下一页</a></li>
	<li><a href="search.do?ye=${p.maxYe}&name=${c.name }&sex=${c.sex }&age=${c.age!=-1?c.age:""}&dep.id=${c.dep.id }">尾页</a></li>
</ul>
		
		
		<div>
		<button id="showadd" type="button" class="btn btn-primary">添加</button>
		<button id="showadd2" type="button" class="btn btn-primary">高等体验度添加</button>
	  
		<button id="showupdate" type="button" class="btn btn-primary">修改</button>
		<button id="updatebatch3" type="button" class="btn btn-primary">原表修改</button>
		
		<button id="deletebatch" type="button" class="btn btn-primary">删除</button>
	
	


</div>
<img id="bigPic"/>
	</div>









</body>
</html>