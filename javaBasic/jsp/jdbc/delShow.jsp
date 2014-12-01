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
		<title>删除显示</title>
		<base href="<%=basePath%>">
	<body bgcolor="#FF9999">
		<center>
			<font size="6" style=""> <br> <br> <br> <%
 	String no = request.getParameter("s");
 	session.setAttribute("s3", no);

 	if (no != null) {
 		String driverClass = "com.mysql.jdbc.Diver";
 		String url = "jdbc:mysql://localhost:3306/xscj";
 		String user = "root";
 		String password = "";
 		Class.forName("com.mysql.jdbc.Driver");
 		Connection conn = DriverManager.getConnection(url, user,
 				password);
 		PreparedStatement pt = conn
 				.prepareStatement("delete from test_copy where sno=?");
 		pt.setString(1, no);
 		int rtn = pt.executeUpdate();

 		out.println("删除了" + rtn + "个用户");

 		pt.close();
 		conn.close();
 	}
 %></font>
 <p>
						<a href="http://127.0.0.1/Hello/ch2/TestJdbc.jsp" target=_blank>返回主界面</a>
					</p> <a href="http://127.0.0.1/Hello/ch2/update.jsp" target=_blank>更新操作</a>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/select.jsp" target=_blank>查询操作</a>
					</p>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/insert.jsp" target=_blank>添加操作</a>
					</p>
		</center>
</html>
