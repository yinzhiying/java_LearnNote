<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ShowPage.*"%>

<html>
	<head>

		<title>My JSP 'selectdb.jsp' starting page</title>


	</head>

	<body>
		<%
			String ps = request.getParameter("page");
			int p = 1;
			if (ps != null) {
				p = Integer.parseInt(ps);
			}
		%>
		<%@include file="header.jsp"%>
		<%=Page.scroll(p)%>
		<br>

	</body>
</html>
