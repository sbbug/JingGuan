<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<style>
  p{
   font-weight:bolder;
   color:lightblue;
  }

</style>
</head>
<body>
    <h1>聊天室</h1>
       
	<div class="main">
	    
	    <div class="signin-form profile">	 
	        <%
	          String username = request.getParameter("username");
	          PrintWriter output = response.getWriter();
	          output.write("<h3>当前用户:"+username+"</h3>");
            %>
	        <textarea id = "message" class="form-control" rows="3"></textarea>
            <button class="btn btn-info" type = "submit"  onclick="start()"/>发送消息</button>	
		</div>	
		<div class="signin-form profile">
              <div id="messages"></div>
			    <script type="text/javascript">
			    
			    //获取当前登录用户名
			    var username="<%=username%>";
			    
			    //alert(username);
			    //判断当前浏览器是否支持WebSocket
			    var websocket = null;
			    if('WebSocket' in window){
			    	webSocket = new WebSocket("ws://192.168.0.112:8080/WebSocketTest/websocket");
			    }else{
			    	alert("当前浏览器不支持websocket");
			    }
			    
			    var inputText = document.getElementById("message");
			    //定义错误显示方法
			    webSocket.onerror = function(event){
			    	onError(event);
			    }
			    //定义打开连接方法
			    webSocket.onopen = function(event){
			    	onOpen(event);
			    }
			    //定义消息发送方法
			    webSocket.onmessage = function(event){
			    	onMessage(event);
			    }
			    //具体方法的实现
			    function onMessage(event){
			    	document.getElementById("messages").innerHTML +='</br>'+event.data;
			    }
			    function onOpen(event){
			    	document.getElementById("messages").innerHTML = "建立连接";
			    }
			    function onError(event){
			    	alert(event.data);
			    }
			    function start(){
			    	
			    	var message = inputText.value;
			    	//判断输入是否为空
			    	if(message==""){
			    		alert("输入不得为空");
			    		inputText.focus();
			    		return ;
			    	 }else{
			    		 inputText.value="";
			    	 }
			    	message=username+":      "+message;
			    	//消息发送
			    	webSocket.send(message);
			    	return false;
			    }
			    </script>
		</div>	
				
	</div>
 		
</body>
</html>