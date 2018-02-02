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
<script src="./js/jquery.js"></script>
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
				      <input  class="btn btn-info" value="登录" id="login">
				    </div>
				  </div>
            </form>	
		</div>
		<script>
		       //用户名与用户密码
		       var username = null;
		       var password = null;
		       
		         $("#login").click(function(){
		        	   var username_login = document.getElementById("username");
			    	   var password_login = document.getElementById("password");
			    	   
			    	   //用户名验证
			    	   username = username_login.value;
			    	   if(username==""){
			    		   alert("用户名输入不得为空");
			    		   return ;
			    	   }
			    	   //密码验证
			    	   password = password_login.value;
			    	   if(password==""){
			    		   alert("密码输入不得为空");
			    		   return ;
			    	   }
			    	   /*
			    	   关于ajax跨域访问问题：
			    	   假设你有两个站点www.a.com和www.b.com
			    	   在a中用ajax向b发送请求，这就是跨域请求了 
			    	   请注意：localhost和127.0.0.1虽然都指向本机，但也属于跨域  
			    	   
			    	   */
			    	   
			    	   
			    	   $.ajax({
			    		    url:'http://192.168.0.112:8080/WebSocketTest/Login',  //原来问题出在了这里，把192.168.0.112换成localhost即可，跨域问题
			    		    type:'POST',
			    		    dataType:'json',
			    		    data:{
			    		    	username:username,
			    		    	password:password
			    		    	},
			    		    async:true,
			    		    success:function(data){
			    		    	console.log(data.result);
			    		    	alert("hello world");
			    		    	if(data.result=="yes"){
			    		    		window.location.href="./chat.jsp?username="+username;
			    		    	}else{
			    		    		alert("用户名或密码错误");
			    		    		return ;
			    		    	}
			    		    	
			    		    },
			    		    //在这里ajax回调执行时，总是出现问题，回调方法总是执行error里的函数,应该是数据类型的问题,数据类型非常严格
			    		    error:function(){
			    		    
			    		    	alert("数据回调出错");
			    		    	return ;
			    		    }
			    	   });//注意这里需要添加逗号   
		    	 });
		        
		</script>	
		
				
	</div>
</body>
</html>