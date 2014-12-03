<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'rand.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body bgcolor="#9556709">
	<center>
		<font size="6"> 输入学生人数</font>
	</center>
<br>
<br>
	<%!String lishi = "";
	String dianming = "";
	String s1 = "";
	String s2 = "";%>

	<form action="login_deal.jsp">
		<center>
			输入一班人数： <input type="text" name="s1">
			<br> 输入二班人数： <input type="text" name="s2">
			<br> <br> <input type="submit" value="提交"> <input
				type="reset" value="重置">
		</center>
</body>
</html>
