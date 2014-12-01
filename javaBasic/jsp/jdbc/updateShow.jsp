<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>


<html>
	<head>

		<title>更新结果</title>
	<body bgcolor="#FF9999">
		<center>
			<form action="updateShow.jsp" type="get">
				<center>
					<body bgcolor="#FF9999">
						<%!String driverClass = "com.mysql.jdbc.Diver";%>
						<%!String url = "jdbc:mysql://localhost:3306/xscj";%>
						<%!String user = "root";
	String password = "";%>
						<%!Connection conn = null;%>


						<%
							String no = request.getParameter("s1");
							session.setAttribute("s2", no);
							//out.println(no0);

							//System.out.println(no);
							if (no != null) {

								conn = DriverManager.getConnection(url, user, password);
								Class.forName("com.mysql.jdbc.Driver");

								PreparedStatement pt = conn
										.prepareStatement("select * from test_copy where sno=?");
								pt.setString(1, no);
								ResultSet rs = pt.executeQuery();
								while (rs.next()) {
									out.println("<br>学号：" + rs.getString(1) + " <br>姓名："
											+ rs.getString(2));
								}

							}
						%>
					
				</center>

				<br>
				<br>
				请修改姓名或学号
				<br>
				姓名
				<input type="text" name="s4">
				<br>
				&nbsp&nbsp学号
				<input type="text" name="s5">
				<input type="submit" value="修改">
				<input type="reset" value="重置">
				<br>
				<br>
				<%
					String no1 = request.getParameter("s5");
					String sname = request.getParameter("s4");
					session.setAttribute("s6", sname);
					//Object no2 = session.getAttribute("s6");

					//System.out.println("no1");
					//	System.out.println("no2");
					//out.print(no1);
					if (sname != null) {

						conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pt = conn
								.prepareStatement("update test_copy set sname=? where sno=?");
						pt.setString(1, sname);
						pt.setString(2, no1);
						int rs = pt.executeUpdate();
				%>
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
						out.println("<br><br>更新后的&nbsp<br>" + " <tr><td>" + sname
									+ " </td>" + "<td>" + no1 + "</td><tr>");

							pt.close();
							conn.close();
						}
					%>


					<br>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/TestJdbc.jsp" target=_blank>返回主界面</a>
					</p>
					<a href="http://127.0.0.1/Hello/ch2/delete.jsp" target=_blank>删除操作</a>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/insert.jsp" target=_blank>插入操作</a>
					</p>
					<p>
					</p>
					<br>
	</body>
</html>
