<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>注册</title>
<link rel="shortcut icon" href="/aaa/image/favicon.ico"
	type="image/x-icon">
    <style>
body {
		margin: 0;
  overflow: hidden;
	}
	#myCanvas {
		display: block;
	}

	#button {
		font-family: "Gill Sans", "Gill Sans MT", Calibri, sans-serif;
		position: absolute;
		font-size: 1.0em;
		text-transform: uppercase;
		padding: 7px 10px;
		left: 50%;
		width: 100px;
		margin-left: -100px;
		top: 77%;
		border-radius: 10px;
		color: white;
		text-shadow: -1px -1px 1px rgba(0,0,0,0.8);
		border: 5px solid transparent;
		border-bottom-color: rgba(0,0,0,0.35);
		background: hsla(260, 100%, 50%, 1);
		cursor: pointer;

		animation: pulse 1s infinite alternate;
		transition: background 0.4s, border 0.2s, margin 0.2s;
	}
	#button:hover {
		background: hsla(220, 100%, 60%, 1);
	

		animation: none;
	}
	#button:active {
		border-bottom-width: 0;
		margin-top: 5px;
	}
	@keyframes pulse {
		0% {
			margin-top: 0px;
		}
		100% {
			margin-top: 6px; 
		} 
	}
</style>
  <script src="js/prefixfree.min.js"></script>
 <style type="text/css">
.jianju {
	letter-spacing: 13px
}
</style>
<style type="text/css">


.ok{
	color:green;
}
.error{
	color:red;
}

</style>
<script type="text/javascript">
	function check_code(){
		var check = false;
		var check_id = document.getElementById("id").value;
		var span = document.getElementById("check_id_result");
		if(check_id.length>10){
			document.getElementById("check_id_result").innerHTML = "× 不要多于10位";
			span.className="error";
		}
		else if(check_id.length<4){
			document.getElementById("check_id_result").innerHTML = "× 不要小于4位";
			span.className="error";
		}
		else{
			document.getElementById("check_id_result").innerHTML = "√";
			span.className="ok";
		}
	}
	function check_password(){
		var check = false;
		var check_password = document.getElementById("pwd").value;
		var span = document.getElementById("check_pwd_result");
		var check_password2 = document.getElementById("pwd2").value;
		if(check_password.length>16){
			document.getElementById("check_pwd_result").innerHTML = "× 不要多于16位";
			span.className="error";
		}
		else if(check_password.length<4){
			document.getElementById("check_pwd_result").innerHTML = "× 不要小于4位";
			span.className="error";
		}
		else{
			document.getElementById("check_pwd_result").innerHTML = "√";
			span.className="ok";
		}
		document.getElementById("pwd2").value= "";
	}
	function check_pwd2(){
		var check = false;
		var check_pwd = document.getElementById("pwd").value;
		var check_pwd2 = document.getElementById("pwd2").value;
		var span = document.getElementById("check_pwd2_result");
		if(check_pwd==""||check_pwd!=check_pwd2){
			document.getElementById("check_pwd2_result").innerHTML = "× 两次输入密码不一致！";
			span.className="error";
		}
		else{
			document.getElementById("check_pwd2_result").innerHTML = "√";
			span.className="ok";
		}
	}
	function check_realName(){
		var check_realName = document.getElementById("realName").value;
		var span = document.getElementById("check_realname_result");
		if(check_realName.length>0){
			document.getElementById("check_realname_result").innerHTML = "√";
			span.className="ok";
		}
		else{
			document.getElementById("check_realname_result").innerHTML = "× 请检查输入的真实姓名";
			span.className="error";
		}
		
	}
	function register_submit(){
		var form = document.getElementById("register");
		var span = document.getElementById("id").value; 
		var span1 = document.getElementById("check_id_result").className; 
		var span2 = document.getElementById("check_pwd_result").className; 
		var span3 = document.getElementById("check_pwd2_result").className; 
		check_realName();
		check_pwd2();
		check_code();
		if(span==""){
			alert("用户名不能为空！");
		}
		else if(span1==span2&&span2==span3&&span1=="ok"){
			form.submit(); 
		}
		else{
			alert("请检查用户名和密码！");
		}
	}
</script>
</head>
<!-- <body>
	
  <button id="button">click me</button>
</body> -->
<body
	style="background-image: url(/aaa/image/afternoon.jpg); background-size: 1600px 800px; background-repeat: no-repeat">
	<h1 align="center" style="color: pink">红袖添香</h1>
	<hr color="">
	<h2 align="center">新用户注册</h2>
	<form action="login/register" method="POST" id="register">
		<table align="center" cellspacing="10px" cellpadding="10px" border="0">
			<tr>
				<td><font class="jianju">账号</font></td>
				<td><input id="id" name="userCount" onchange="check_code()"></td>
				<td width="150px"><span id="check_id_result" lang="10" >4-10个字符</span></td>
			</tr>
			<tr>
				<td><font class="jianju">密码</font></td>
				<td><input id="pwd" type="password" name="pwd" onchange="check_password()"></td>
				<td width="150px"><span id="check_pwd_result" lang="10" >4-10个字符</span></td>
			</tr>
			<tr>
				<td>密码确认</td>
				<td><input id="pwd2" type="password" name="pwd2" onchange="check_pwd2()"></td>
				<td width="180px"><span id="check_pwd2_result" lang="10" >4-10个字符</span></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input id="realName" name="realName" type="text" onchange="check_realName()" ></td>
				<td width="150px"><span id="check_realname_result" lang="10" ></span></td>
			</tr>
			<tr>
				<td><font class="jianju">性别</font></td>
				<td><input id="sex" name="sex" type="radio" value="male">Male
					<input id="sex2" name="sex" type="radio" value="female">female
				</td>
			</tr>
			<tr>
				<td><font class="jianju">QQ</font></td>
				<td><input id="qq" name="qq" type="text"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input id="e_mail" name="e_mail" type="text"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="button" onclick="register_submit()"
					name="button" value="Register" height="20px" width="80"></td>
			</tr>
<!-- 			<tr>
				<td colspan="2" align="center"><input type="image"
					name="imaSub" value="imageSub" src="image/submit1.gif" alt="submit"
					height="20px" width="80"></td>
			</tr> -->
		</table>
	</form>
</body>

</html>
