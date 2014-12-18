<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body bgcolor="#FFFFFF">
	<a href="index1.jsp">返回首页</a>
	<a href="upload.jsp">文件上传</a>
	<P>
		<b><font SIZE=5>选择要上传的文件</font></b>
	</P>
	<form  name="index" method="POST" enctype="multipart/form-data" action="upload">
	
		选择需要上传的文件：
	<input type="file" name="file" value="浏览" > <br>
	<input type="submit" value="开始上传">
	<input type="reset" value="重置">
	</form>
</body>
</html>