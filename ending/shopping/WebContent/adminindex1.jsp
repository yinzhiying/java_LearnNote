<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("adlogin.jsp");
	} else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书店管理系统</title>
</head>
<frameset rows="*" cols="180,*" frameborder="no" border="0" framespacing="0">
  <frame src="adminleft.jsp" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" title="leftFrame" />
  <frameset rows="50,*" frameborder="no" border="0" framespacing="0">
    <frame src="adminhead.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frame src="goodsmanage.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes>

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