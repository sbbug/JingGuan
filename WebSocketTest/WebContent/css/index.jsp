<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<script src="./js/jquery-1.11.1.min.js"></script>
<style>
  p{
   font-weight:bolder;
   color:lightblue;
  }

</style>
</head>
<body>
     <h1>聊天室登录</h1>
	<div class="main">
	
	    <div class="signin-form profile">	 
	        
           <form class="form-horizontal" id="formData">
				  <div class="form-group">
				    
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="username" placeholder="用户名">
				    </div>
				  </div>
				  <div class="form-group">
				    
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="password" placeholder="密码">
				    </div>
				  </div>
				  <div class="form-group">
				     <div class="col-sm-10">
				      <input  class="btn btn-info" value="登录" onclick="login()">
				    </div>
				  </div>
            </form>	
		</div>
		<script>
		       var username = null;
		       var password = null;
		       var xmlhttp = null;
		       var formdata = null;
		       var sendData=null;
		       var sendResult=null;
		       function login(){
		    	   
		    	   var username_login = document.getElementById("username");
		    	   var password_login = document.getElementById("password");
		    	   
		    	   //用户名验证
		    	   username = username_login.value;
		    	   if(username==""){
		    		   alert("用户名输入不得为空");
		    		   username.focus();
		    		   return ;
		    	   }
		    	   //密码验证
		    	   password = password_login.value;
		    	   if(password==""){
		    		   alert("密码输入不得为空");
		    		   password.focus();
		    		   return ;
		    	   }
		    	   
		    	   //生成ajax对象
		    	   if(window.XMLHttpRequest){
		    		   xmlhttp = new XMLHttpRequest();
		    		  // alert(xmlhttp);
		    	   }else{
		    		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		    	   }
		    	   //拼接成一个json字符串
		    	   sendData="username="+username+"&"+"password="+password
		    	   //回调响应
		    	   xmlhttp.onreadystatechange=function () {
		    		   
		    		   // if(xmlhttp.readyState==4 && xmlhttp.status==200) {
		    		        console.log(xmlhttp.responseText);
		    		        sendResult = xmlhttp.responseText;
		    		        alert(sendResult);
		    		        if(sendResult=="yes"){
		    		        	window.location.href="./chat.jsp";
		    		        }else if(sendResult=="no"){
		    		        	alert("用户名或密码错误");
		    		        }
		    		  //  }else{
		    		    //	alert("出现错误");
		    		   // }
		    	   }
		    	   
		    	   //发送post提交数据
		    	   xmlhttp.open("POST","http://192.168.0.112:8080/WebSocketTest/Login",true);
		    	  
		    	   xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		    	   
		    	   //发送数据,此处需要将表单数据序列化
		    	   xmlhttp.send(sendData);   
		    	   
		    	  
		    	   
		       }
		</script>	
		
				
	</div>
</body>
</html>