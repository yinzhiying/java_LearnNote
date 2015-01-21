<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="shop.*,java.util.*"%>
    <% 
	Vector<String[]> vgoods = (Vector<String[]>)request.getAttribute("vgoods");
	String[] str = vgoods.get(0);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详细信息</title>
</head>
<body>
<jsp:useBean id="mycart" class="shop.cartBean" scope="session"/>
<table width="100%">
     
      <tr>
        <td>
          <center>
          <table width="80%">
          	<tr>
              <td><img src="<%= str[0] %>" height="150" border="1"/></td>
              <td>
                <table width="100%">
                  <tr>
                    <td bgcolor="#E4EDFA"><%= str[1] %></td>
                  </tr>
                  <tr>
			        <td><font><%= mycart.manageStr(str[2]) %></font></td>
			      </tr>
			      <tr>
			        <td bgcolor="#E4EDFA"><font>所属分类:<%= str[3] %></font></td>
			      </tr>
			      <tr>
			        <td><font>定价:￥<%= str[4] %></font></td>
			      </tr>
			      <tr>
			        <td bgcolor="#E4EDFA"><font>浏览次数:<%= str[5] %></font></td>
			      </tr>
			      <tr>
                    <td>
                      <a href="shopServlet?submit=buy&flag=1&gid=<%= str[6] %>">
                        <img src="img/other/buy.gif" border="0"/>
                      </a>
                    </td>
                  </tr>
                </table>
              </td>        	
          	</tr>
          	<tr>
          	  <td><b><br/>商品简述:</b></td>
          	</tr>
          	<tr>
          	  <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;<%= str[7] %></td>
          	</tr>
          </table>
          </center>
        </td>
      </tr>
    </table>

</body>
</html>