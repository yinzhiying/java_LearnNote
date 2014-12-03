<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>

<html>
	<head>

	</head>
	<form action="insertdb.jsp" type="get">	
	<body bgcolor="#FF9999">
		<title>插入学生数据</title>

		<center>
			<font size="6"> <br>
				<br> 请输入插入学生的信息<br>
				<br>
				<br> </font> 学号
			<input type="text" name="s1">
			<br>
			姓名
			<input type="text" name="s2">
			<br>
			<br>
			<br>
			<input type="submit" value="插入">
			<input type="reset" value="重置">
		</center>
		<%
			String no = request.getParameter("s1");
			session.setAttribute("s4", no);
			String no1 = request.getParameter("s2");
			session.setAttribute("s5", no1);
		%>

		<%
			if (no != null && no1 != null) {
				String driverClass = "com.mysql.jdbc.Diver";
				String url = "jdbc:mysql://localhost:3306/xscj";
				String user = "root";
				String password = "";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, user,
						password);
				PreparedStatement pt = conn
						.prepareStatement("insert into person(id,name)values(?,?)");
				pt.setString(1, no);
				pt.setString(2, no1);
				int rs = pt.executeUpdate();
		%>
		<center>
		<table border="1" width="300" border="6px" bgcolor="#cccc66">
			<font face="Arial, Helvetica, sans-serif" size="3">&nbsp; 
			<tr>
				<td>
					学号
				</td>
				<td>
					姓名
				</td>
			</tr>
			<%
				out.println("<tr><td>" + no + "</td>" + "<td>" + no1
							+ "</td></tr>");
					pt.close();
					conn.close();
				}
			%>
		</table>
		</center>
	</body>
</html>
