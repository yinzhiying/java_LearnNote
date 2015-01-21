<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示界面</title>
 <link href="css/generalstyle.css" type="text/css" rel="stylesheet">
</head>
<body bgcolor="#F5F9FE">
<%
 		String msg = (String)request.getAttribute("msg");
     %>
      <table width="100%">
		  
		  <tr height="15">
		    <td><hr color="#FF7F00" width="100%"/></hr></td>
		  </tr>
	 </table>
	 <center>
	 <script type="text/javascript" language="javascript">
	 alert("<%= msg %>");
	 window.location='javascript:history.back()';
	 </script>
	 </center>
</body>
</html>