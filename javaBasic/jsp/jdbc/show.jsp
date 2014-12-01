<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>查询结果显示</title>

		

	</head>

<center>
	<body bgcolor="#FF9999">
		<%
			String no = request.getParameter("s1");
			session.setAttribute("s2", no);
		%>
		
		<%
					if (no != null) {
						String driverClass = "com.mysql.jdbc.Diver";
						String url = "jdbc:mysql://localhost:3306/xscj";
						String user = "root";
						String password = "";
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection(url, user,
								password);
						PreparedStatement pt = conn
								.prepareStatement("select * from test_copy where sno=?");
						pt.setString(1, no);
						ResultSet rs = pt.executeQuery();%>
						<table border="1" width="300" border="6px" bgcolor="#cccc66">
			<font face="Arial, Helvetica, sans-serif" size="3">&nbsp;
				<tr>
					<td align="center">学号</td>
					<td align="center">姓名</td>
					<% 	while (rs.next()) {
							out.println("<tr><td>" + rs.getString(1) + " </td>"+
									"<td>"+ rs.getString(2)+"</td><tr>");
						}
					
						rs.close();
						pt.close();
						conn.close();
					}
				%>
<br><p>
						<a href="http://127.0.0.1/Hello/ch2/TestJdbc.jsp" target=_blank>返回主界面</a>
					</p> <a href="http://127.0.0.1/Hello/ch2/delete.jsp" target=_blank>删除操作</a>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/update.jsp" target=_blank>更新操作</a>
					</p>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/insert.jsp" target=_blank>添加操作</a>
					</p>
</center>

</html>
