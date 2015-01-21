<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,shop.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车界面</title>
<script language="javascript" src="script/trim.js"></script>
<script language="javascript">
    	function checkNum(num)
    	{
    		var reg = /^[1-9][0-9]*$/;
    		if(reg.test(num.trim()))
    		{
    			return true;
    		}
    		else
    		{
    			alert("商品数量只能为数字且不能为0！！！");
    			return false;
    		}
    	}
    </script>
</head>
<body bgcolor="#F5F9FE">
	<jsp:useBean id="mycart" class="shop.cartBean" scope="session" />
	<center>
		<table width="100%">
			
			<tr align="center">
				<td>
					<%
						if(mycart.getCart().size()==0)
					    	{
					    		out.println("<b>你还没有购买商品</b>");
					    	}
					    	else
					    	{
					%>
					<table border="0" width="100%">
						<tr>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>商品数量</th>
							<th>删除</th>
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
						<td align="left"><%=arr[0]%></td>
						<td>￥<%=arr[1]%></td>
						<form action="shopServlet" method="post"
							onsubmit="return checkNum(document.all.gnum<%=arr[3]%>.value);">
							<td><input type="text" id="gnum<%=arr[3]%>" name="gnum"
								value="<%=arr[2]%>" size="10" /> <input type="submit"
								value="修改" /> <input type="hidden" name="gid"
								value="<%=arr[3]%>" /> <input type="hidden" name="submit"
								value="changeNum" /></td>
						</form>
						<td><a href="shopServlet?submit=delete&gid=<%=arr[3]%>">删除</a></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="2"></td>
							<td align="center"><b>商品价格总计:￥<%=mycart.getAccount()%></b></td>
							<td align="center">
								<%
									if(session.getAttribute("recMsg")==null)
									     	{
								%> <a href="shopServlet?submit=balance"> <img
									src="img/other/balance.gif" border="0" />
							</a> <%
 	}
 	      	else
 	      	{
 %> <a href="order.jsp"> <img src="img/other/balance.gif"
									border="0" />
							</a> <%
 	}
 %>
							</td>
						</tr>
					</table> <%
 	}
 %>
				</td>
			</tr>
		</table>
	</center>

</body>
</html>