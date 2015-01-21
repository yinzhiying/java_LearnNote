<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店首页</title>
</head>
<frameset rows="50,*" frameborder="no" border="0" framespacing="0">
    <frame src="header.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
<frameset rows="*" cols="180,*" frameborder="no" border="0" framespacing="0">
  <frame src="lefte.jsp" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" title="leftFrame" />
  
    <frame src="list.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
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
