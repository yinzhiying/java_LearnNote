<%@ page contentType="text/html; charset=gb2312" language="java"
	errorPage=""%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>������</title>
</head>

<body bgcolor="#9556709">
	<center>
		<font size="6"> <%
 	request.setCharacterEncoding("gb2312");
 	String c1 = request.getParameter("s1");
 	session.setAttribute("sum1", c1);
 	String c2 = request.getParameter("s2");
 	session.setAttribute("sum2", c2);
 	out.println("һ��������" + c1 + "��");
 %> <br> <%
 	out.println("����������" + c2 + "��");
 %>
 <p>
				<a href="http://127.0.0.1/Hello/ch2/Rand.jsp" target=_blank>�������</a>
			</p> <a href="http://127.0.0.1/Hello/ch2/fencengchouyang.jsp" target=_blank>�ֲ����</a>
			
		</font>
	</center>
</body>
</html>
