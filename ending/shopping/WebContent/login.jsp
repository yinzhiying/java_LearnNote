<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="inc/reset.css" />
<link rel="stylesheet" type="text/css" href="inc/chen.css" />

</head>
<body bgcolor="#F5F9FE">
<div id="form">
			<div id="signup" class="Font">
				登录
			</div>

<form name="loginform" action="shopServlet" method="post">
<center>
     <div id="name" class="Font">
				用户名：
			</div>
         <div class="input1">
				<input type="text" id="uid" name="uid" size="12" class="pos" />
			</div>
<div id="password" class="Font">
				密码：
			</div>
<div class="input2">
				<input type="password" id="pwd" name="pwd" size="12" class="pos"/>
			</div>
			<div class="font">

            <input type="submit" id="submit" name="submit" value="登录" />
			</div>	
    
 
</center>
</form>
</body>
</html>