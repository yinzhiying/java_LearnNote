<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<body>
	文件上传成功！！！！
	<br>

	<%
		//String file = (String) request.getAttribute("file");
		String file = request.getParameter("fileName");
		System.out.println("fileName");
	%>
	<img alt="" src="<%=file%>">

	<a href="index.jsp">返回首页</a>
</body>
</html>
