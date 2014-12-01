<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>

<html>
	<body bgcolor="#FF9999">
	
<title>数据库操作</title>
		<form action="show.jsp" type="get">
			<center>
			<font size="6">
		<br><br>	请输入要查找的学号<br><br><br>
			</font>
				学号
				<input type="text" name="s1">
				<br>
				<br>
				<br>
				<input type="submit" value="查询">
				<input type="reset" value="重置">
				
			</center>
		</form>
	

	</body>
</html>
