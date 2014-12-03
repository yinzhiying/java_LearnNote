<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<title>随机点名小程序</title>
</head>

<%!String st = "";
	String t1 = "";
	String t2 = "";
	String t3 = "";%>
<%!int i = 1;
	int m = 0;
	int n = 0;%>
<%!String s = "";%>
<%!String s1 = "";%>
<%
	if (t1 != null) {
		m = Integer.parseInt(session.getAttribute("sum1").toString());
	}

	if (t2 != null) {
		n = Integer.parseInt(session.getAttribute("sum2").toString());
	}
	int j = (int) (Math.random() * 2 + 1);
	if (j == 1) {
		i = (int) (Math.random() * m + 1);

	} else {
		i = (int) (Math.random() * n + 1);

	}

	s = "点到的学生：" + j + "班" + i + "号" + ";";
	
%>
<form action="" method="post">

	<input type="text" name="tes" size="25" value=<%=s%>> <input
		type="submit" value="随机点名" name=submit>

</form>

<body bgcolor="#9556709">

	<font face="Arial, Helvetica, sans-serif" size="5">&nbsp; 当前点名：</br>
	</font>
	<table border="1" width="300" border="6px" bgcolor="#cccc66">
		<font face="Arial, Helvetica, sans-serif" size="3">&nbsp; <%
 	out.println("<tr><td>" +s
 			+ "</td></tr>");
 %>
	</table>
	<br>
	<br>
	
	<font face="Arial, Helvetica, sans-serif" size="5">&nbsp;
		历史点名记录：</br>
	</font>

	<table border="1" width="300" border="6px" bgcolor="ccff66">
		<font face="Arial, Helvetica, sans-serif" size="3">&nbsp; <%
 	st += "<tr><td>" + s + "</td></tr>";
 	
 	out.print(st);
 %>
	</table>
	<br>
	<br>

	<%
		response.setHeader("Refresh", "2");
	%>

</body>
</html>