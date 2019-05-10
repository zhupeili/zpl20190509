<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf">
<title>红袖添香</title>
<link rel="shortcut icon" href="/aaa/image/favicon.ico" type="image/x-icon">
<script type="text/javascript">
	function check_id() {
		var id = document.getElementById("getName").value;
		var reg = /^.{1,10}$/;
		if(id==null||id==""){
			alert("账号为空！");
			
		}
		if(reg.test(id)){
		console.log(id);
		}
	}
</script>
<script type="text/javascript">
	function check_password() {
		var password = document.getElementById("password").value;
		var reg = /^.{1,10}$/;
		if(password==null||password==""){
			alert("password为空");
			return false;
		}
 		if(reg.test(password)){
			console.log(password);
			document.getElementById("login").submit();
		} 
	}
</script>
</head>
<!-- <body background="image/bg.jpg"> -->
<body style="background-image: url(/aaa/image/bg3.jpg); 
			background-size:1600px 800px;
			background-repeat:no-repeat">
<h1 align="center" style="color: pink">红袖添香</h1>
<hr color="">
<form action="/aaa/login/login" method="POST" id="login">
 		
 		<table align="center" height="500px">
 		<th>
          	  	账号  <input id="getName" name="userCount"/>
          	  	<span></span>
        
         <br>
       	 <br>
            	密码  <input id="password" name="pwd" type="password" onclick="check_id()" />
         <br>
         <br>
         <input align="right" id=1 type="button" name="button" value="Log in"  onclick="check_password()" />
 	    
 	     <a href="/aaa/register.jsp"> 
 	     <input align="right" id=1 type="button" name="register" value="Registr"/>
 	     </a> 
 		</th>
 		</table>
</form>

<p align="right">
<a href="http://www.baidu.com" > 超级链接！</a>
</body>
</html>