<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>红袖添香</title>
<link rel="shortcut icon" href="/aaa/image/favicon.ico" type="image/x-icon">
<script type="text/javascript" >
	function home(){
		location.href='/aaa';
	}
	
</script>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	function send_http(){
		console.log("aaaaaaaaaaaaaa");
			$.ajax({
			type:"POST",
			dataType:"json",
			url:"/aaa/myWorld/sss",
			success:function(result){
				console.log(result);
				document.getElementById("hang1").innerHTML = result.data[0];
			}
		}); 
	}
</script>
<style type="text/css">
	div ul,div ul li{
		height:30px;
		list-style-type:none;
		text-align:center;
		color: "white";
		}
	div ul li{
		width:100px;
		float:left;
		}
</style>
</head>
<body style="background-image: url(/aaa/image/afternoon.jpg); 
			background-size:1600px 800px;
			background-repeat:no-repeat">
<div style="float: left;">

<div style="height:100px; width: 1000px; float: left; " >
<h1 align="center" style="color: pink" onclick="home()">红袖添香</h1>
</div>

<div style="height:100px; width: 350px; right: 50px;  float: right;" >
<h3 align="right">用户：${user.realName} <a href="/aaa" >退出</a></h3>
<h4 align="right">登录状态：success</h4>
</div>

</div>
<hr>
<input type="button" value="ajax" onclick="send_http()"  />
<div style="width: 800; height: 100; background-color: gray;" >
<ul>
				<li style="background-color: gerrn;"><a href="/aaa/" style="color: white">首页</a>
                <li style="background-color: gerrn;"><a href="/modules/article/bookcase.php">我的书架</a></li>
				<li><a href="https://www.biqiuge.com/xuanhuanxiaoshuo/">玄幻小说</a></li>
				<li><a href="/xiuzhenxiaoshuo/">修真小说</a></li>
				<li><a href="/dushixiaoshuo/">都市小说</a></li>
				<li><a href="/chuanyuexiaoshuo/">穿越小说</a></li>
				<li><a href="/wangyouxiaoshuo/">网游小说</a></li>
				<li><a href="/kehuanxiaoshuo/">科幻小说</a></li>
				<li><a href="/qitaxiaoshuo/">其他小说</a></li>
				<li><a href="/paihangbang/">排行榜单</a></li>
				<li><a href="/wanben/">完本小说</a></li>

</ul>
</div>
<div>
<table style="border-spacing: 50px 20px;" id="table">
<thead>
<tr>
<th>用户名</th>				
<th>角色</th>
<th>状态</th>
<th>是否激活</th>
<th>创建时间</th>
<th>最后登录时间</th>
</tr>
</thead>
<tbody>
</tbody>
</table>
</div>
</body>
</html>