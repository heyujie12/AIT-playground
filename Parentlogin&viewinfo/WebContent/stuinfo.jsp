<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Parent Login Page</title>

<link href="style/parent-login.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
$(function(){
	//adjust pic width by window's width
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>

</head>

<body>

<div class="login-box">
	<h1>Parent Login</h1>
	<form method="post" action="allstudents" id="loginform">
		<div class="name">
			<label>Your Name:</label>
			<input type="text" name="username" id="" tabindex="1" autocomplete="off" />
		</div>
		<div class="email">
			<label>Email Address:</label>
			<input type="text" name="email" maxlength="16" id="" tabindex="2"/>
		</div>
		<div class="login">
			<button type="submit" tabindex="5">Login</button>
		</div>
	</form>
</div>

<div class="bottom">?2015 Copyright <a href="javascript:;" target="_blank">About us</a> <span>Agile Team A</span></div>

<div class="screenbg">
	<ul>
		<li><img src="images/0.jpg"></li>
	</ul>
</div>

</body>
</html>
