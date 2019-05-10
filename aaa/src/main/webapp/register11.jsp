<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>红袖添香-用户注册</title>
<link rel="shortcut icon" href="/aaa/image/favicon.ico"
	type="image/x-icon">
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
		console.log(check_id);
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
</script>
<script type="text/javascript">
	function check_password(){
		var check = false;
		var check_password = document.getElementById("pwd").value;
		var span = document.getElementById("check_pwd_result");
		var check_password2 = document.getElementById("pwd2").value;
		console.log(check_password);
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
		console.log(check_password2);
		document.getElementById("pwd2").value= "";
	}
</script>
<script type="text/javascript">
	function check_pwd2(){
		var check = false;
		var check_pwd = document.getElementById("pwd").value;
		var check_pwd2 = document.getElementById("pwd2").value;
		var span = document.getElementById("check_pwd2_result");
		console.log(check_pwd);
		console.log(check_pwd2);
		if(check_pwd!=check_pwd2){
			document.getElementById("check_pwd2_result").innerHTML = "× 两次输入密码不一致！";
			span.className="error";
		}
		else{
			document.getElementById("check_pwd2_result").innerHTML = "√";
			span.className="ok";
		}
	}
</script>
</head>
<body
	style="background-image: url(/aaa/image/afternoon.jpg); background-size: 1600px 800px; background-repeat: no-repeat">
	<h1 align="center" style="color: pink">红袖添香</h1>
	<hr color="">
	<h2 align="center">新用户注册</h2>
	<form action="login/register" method="POST" id="register">
		<table align="center" cellspacing="10px" cellpadding="10px" border="0">
			<tr>
				<td><font class="jianju">账号</font></td>
				<td><input id="id" name="id" onchange="check_code()"></td>
				<td width="150px"><span id="check_id_result" lang="10" >4-10个字符</span></td>
			</tr>
			<tr>
				<td><font class="jianju">密码</font></td>
				<td><input id="pwd" type="password" name="pwd" onchange="check_password()"></td>
				<td width="150px"><span id="check_pwd_result" lang="10" >4-10个字符</span></td>
			</tr>
			<tr>
				<td>密码确认</td>
				<td><input id="pwd2" name="pwd2" type="password" onchange="check_pwd2()"></td>
				<td width="150px"><span id="check_pwd2_result" lang="10" >4-10个字符</span></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input id="realname" name="realname" type="text" ></td>
				<td width="150px"><span id="check_realname_result" lang="10" >1-3个字符</span></td>
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
				<td colspan="2" align="center"><input type="submit"
					name="button" value="Register"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="image"
					name="imaSub" value="imageSub" src="image/submit1.gif" alt="submit"
					height="20px" width="80"></td>
			</tr>
		</table>


	</form>

</body>
</html>