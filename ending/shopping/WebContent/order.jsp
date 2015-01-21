<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,shop.*" %>
<jsp:useBean id="mycart" class="shop.cartBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <% 
	String[] recMsg = (String[])session.getAttribute("recMsg");
	if(recMsg==null)
	{
		response.sendRedirect("index.jsp");
	}
	else
	{
 %>
<head>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
   
      function checkMsg()
      {
      	if(mfrec.recname.value=="")
      	{
      		alert("收货人不能为空!!!");
      		mfrec.recname.focus();
      		return false;
      	}
      	if(mfrec.recadr.value=="")
      	{
      		alert("收货人地址不能为空!!!");
      		mfrec.recadr.focus();
      		return false;
      	}
      	if(mfrec.rectel.value=="")
      	{
      		alert("电话号码不能为空!!!");
      		mfrec.rectel.focus();
      		return false;
      	}
      	
      }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单确认</title>
</head>
<body>
<center>
      <table width="100%">
        
        <tr>
          <td>
            <center>
            <table width="80%">
              <tr>
 	        	<th>商品名称</th>
	        	<th>商品价格</th>
	        	<th>商品数量</th>
              </tr>
              <% 
				Vector<String[]> vgoods = mycart.getCartContent();
				int i = 0;
				for(String[] arr:vgoods)
				{
					i++;
					if(i%2==0)
					{
						out.println("<tr align='center'>");
					}
					else
					{
						out.println("<tr align='center' bgcolor='#F5F9FE'>");
					}
			%>
				  <td><%= arr[0] %></td>
				  <td>￥<%= arr[1] %></td>
				  <td><%= arr[2] %></td>
				</tr>
			<% 
				}
			 %>
			  <tr>
			     <td colspan="3" align="right"><b>商品价格总计:￥<%= mycart.getAccount() %></b></td>
			   </tr>
            </table>
            </center>
          </td>
        </tr>
        <form action="shopServlet" method="post" name="mfrec">
        <tr align="center">
          <td><br/>收货人姓名:&nbsp;<input name="recname" value="<%= recMsg[0] %>"/></td>
        </tr>
        <tr align="center">
          <td><br/>收货人地址:&nbsp;<input name="recadr" value="<%= recMsg[1] %>"/></td>
        </tr>
        <tr align="center">
          <td><br/>收货人电话:&nbsp;<input name="rectel" value="<%= recMsg[2] %>"/></td>
        </tr>
        <tr align="center">
         <td>
          	
            <br/><input type="submit" name="submit"  value="收货人信息修改" onclick="return checkMsg()"/>&nbsp;&nbsp;&nbsp;
            <a href="shopServlet?submit=orderConfirm">订单确认</a>
          </td>
        </tr>     
        </form>
      </table>
    </center>
</body>
<% 
	}
 %>
</html>