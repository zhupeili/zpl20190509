<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <meta content="3;URL=http://www.baidu.com" http-equiv="refresh"> -->
<title>注册成功！</title>
<script type="text/javascript">
	function time(){
		setTimeout("window.location.href='/aaa/login.jsp';",3000);
	}
	function refresh(){
		setInterval(go,1000);
	}
	var time =3
	function go(){
		time--;
		if(time>0){
			document.getElementById("sp").innerHTML=time;
		}else{
			location.href='/aaa/login.jsp';
		}
	}

</script>
</head>
<body onload="refresh()" bgcolor="#00ffff" background="/aaa/image/myCat.jpg">
<p align="center"><font size="5">注册成功！ </font>
<span id="sp">3</span>秒后返回登录界面
<img alt="" src="/aaa/image/feiWen.gif" >
如页面未自动跳转，请点击按钮
<input id="button" type="button" onclick="time()" value="跳转" />
</body>
</html>