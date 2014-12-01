<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>
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
	<body bgcolor="#FF9999">
		<title>插入显示</title>
		<center>
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
							.prepareStatement("insert into test_copy(sno,sname)values(?,?)");
					pt.setString(1, no);
					pt.setString(2, no1);
					int rs = pt.executeUpdate();%>
 <table border="1" width="300" border="6px" bgcolor="#cccc66">
			<font face="Arial, Helvetica, sans-serif" size="3">&nbsp;
				<tr>
					<td>学号</td>
					<td>姓名</td>
				</tr> <%
					out.println("<tr><td>" + no +"</td>"+ "<td>" + no1 + "</td></tr>");
					pt.close();
					conn.close();
				}
			%>
			<p>
				<a href="http://127.0.0.1/Hello/ch2/TestJdbc.jsp" target=_blank>返回主界面</a>
			</p>
			<a href="http://127.0.0.1/Hello/ch2/update.jsp" target=_blank>更新操作</a>
			<p>
				<a href="http://127.0.0.1/Hello/ch2/select.jsp" target=_blank>查询操作</a>
			</p>
			<p>
				<a href="http://127.0.0.1/Hello/ch2/delete.jsp" target=_blank>删除操作</a>
			</p>
		</center>
	<body>
		<br>
	</body>
</html>
