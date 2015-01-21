<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	if(session.getAttribute("admin")!=null)
	{
		response.sendRedirect("adminindex1.jsp");
	}
	else
	{
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="inc/reset.css" />
<link rel="stylesheet" type="text/css" href="inc/chen.css" />
<title>管理员登陆界面</title>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function check()
      {
         // var aname = adform.aname.value.trim();
         // var apwd = adform.apwd.value.trim();
          if(adform.aname.value=="")
          {
          	alert("用户名不能为空!!!");
          	adform.aname.focus();
          	return false;
          }
          if(adform.apwd.value=="")
          {
            alert("密码不能为空!!!");
            adform.apwd.focus();
            return false;
          }
                }
      
		
    </script>
    
</head>
<body bgcolor="#F5F9FE">

      <div id="form">
			<div id="signup" class="Font">
			管理员登录
			</div>
      <form action="AdminServlet" method="post" name="adform">
  
     <div id="name" class="Font">
				用户名：
			</div>
         <div class="input1">
				<input type="text" id="uid" name="aname" size="14" class="pos" />
			</div>
<div id="password" class="Font">
				密码：
			</div>
          <div class="input2">
				<input type="password" id="pwd" name="apwd" size="14" class="pos"/></div>
		
          <div  class="font">
            <input type="submit" id="submit" name="action" value="登录" onclick="return check()"/>
			</div>
      </form>
 
</body>
</html>
<% 
	}
 %>