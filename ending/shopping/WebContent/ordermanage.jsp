<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,shop.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("admin")==null)
	{
		response.sendRedirect("adlogin.jsp");
	}
	else
	{
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理界面</title>
</head>
<body>
<jsp:useBean id="adBean" class="shop.AdminBean" scope="session"/>
 <table width="100%" cellpadding="0" cellspacing="0">
  <center>
                  <tr>
              <td align="center" width="100%"><%@ include file="orderlist.jsp" %></td>
            </tr>
    </center>     
</table>

</body>
</html>
<% 
	}
 %>