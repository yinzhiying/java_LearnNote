<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>更新操作
    </title>
  </head>
  <body>
  <br><form action="updateShow.jsp" type="get">
			<center>
			<font size="6">
		<br><br>	请输入要更新的学号<br><br><br>
			</font>
				学号
				<input type="text" name="s1">
				<br>
				<br>
				<br>
				<input type="submit" value="查询">
				<input type="reset" value="重置">
				<center>
	<body bgcolor="#FF9999">
		
				<%
				String no = request.getParameter("s1");
				session.setAttribute("s",no);
			
				 %>
		
			</center>
		</form>
		
  </body>
</html>
