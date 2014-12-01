<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>

<html>
	<body bgcolor="#FF9999">
		<%!String s = "";%>
<title>删除</title>
<form action="delShow.jsp" type="get">
		<center>
		<br>
			<br>
			<br>
			<font size="6" style="宋体">
			输入删除学生的学号
			<br>
			<br>
			</font>
			学号
			<input type="text" name="s">
			<br>
			<br>
			<br>
			<input type="submit" value="删除">
			<input type="reset" value="重置">
		
		</center>



	</body>
</html>
