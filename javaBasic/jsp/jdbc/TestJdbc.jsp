<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
	<head>	
	<%!String s1 = "";%>
		<base href="<%=basePath%>">
	<body bgcolor="#FF9999">
		<font size="6">
			<title>数据库操作</title>
			 <br> <br>
			<center>
				<font size="6"> 连接数据库操作 <br> </font>
			</center> -------->
			<center>
				<font face="黑体" size="5">
					<p>
						<a href="http://127.0.0.1/Hello/ch2/select.jsp" target=_blank>查询操作</a>
					</p> <a href="http://127.0.0.1/Hello/ch2/delete.jsp" target=_blank>删除操作</a>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/update.jsp" target=_blank>更新操作</a>
					</p>
					<p>
						<a href="http://127.0.0.1/Hello/ch2/insert.jsp" target=_blank>添加操作</a>
					</p>
			</center> 
			</font>
	</body>
</html>
