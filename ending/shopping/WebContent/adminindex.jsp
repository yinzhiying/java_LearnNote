<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,shop.*"%>
<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("adlogin.jsp");
	} else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员首页</title>
</head>
<body>
	<jsp:useBean id="adBean" class="shop.AdminBean" scope="session" />
	<center>
		<table border="0" width="100%" height="100%" cellpadding="0"
			cellspacing="0">
        <td width="100%"><%@ include file="goodsmanage.jsp" %></td>
		  </tr>
        </table>
        </center>
</body>
</html>
<%
	}
%>