<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
#mes {
	width: 350px;
	height: 300px;
	border: 2px dashed #3385ff;
	margin: 20px 0;
}
</style>
</head>
<body>
	欢迎来到聊天室
	<br />

	<div id="mes"></div>
	<input id="text" type="text" />
	<button onclick="send()">发送消息</button>

	<button onclick="closeWebSocket()">关闭连接</button>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	var websocket = null;

	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://192.168.0.155:8080/chat/websocket");
	} else {
		alert('没有建立websocket连接')
	}

	//连接发生错误的回调方法
	websocket.onerror = function() {
		setMessage("错误");
	};

	//连接成功建立的回调方法
	websocket.onopen = function(event) {
		setMessage("建立连接");
	}

	//接收到消息的回调方法
	websocket.onmessage = function(event) {
		setMessage(event.data);
	}

	//连接关闭的回调方法
	websocket.onclose = function() {
		setMessage("close");
	}

	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口。
	window.onbeforeunload = function() {
		websocket.close();
	}

	//将消息显示在网页上
	function setMessage(text) {
		var message = $("#mes").html();
		$("#mes").html(message + text + "<br/>")
	}

	//关闭连接
	function closeWebSocket() {
		websocket.close();
	}

	//发送消息
	function send() {
		var message = $("#text").val();
		websocket.send(message);
	}
</script>
</html>