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
		Vector<String[]> vordergoods = 
					(Vector<String[]>)request.getAttribute("vordergoods");
		Vector<String[]> vorderinfo = 
					(Vector<String[]>)request.getAttribute("vorderinfo");
		String[] str = vorderinfo.get(0);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单修改界面</title>
</head>
<body>
 <table width="100%" cellpadding="0" cellspacing="0">
      
      <tr align="center">
        <td>
          <table width="60%">
            <tr>
	          <th>货物名称</td>
	          <th>货物数量</td>
	          <th>货物总价</td>          
            </tr>
          <% 
          	  int i=0;
          	  for(String[] temp:vordergoods)
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
              <td><%= temp[0] %></td>
              <td><%= temp[1] %></td>
              <td><%=  temp[2]%></td>
            </tr>
           <% 
           	   }
            %>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></hr></td>
      </tr>
      <tr align="center">
        <td>
          <table>
            <tr>
              <td>收货人姓名:<%= str[0] %></td>
            </tr>
            <tr>
              <td>收货人地址:<%= str[1] %></td>
            </tr>
            <tr>
              <td>收货人电话:<%= str[2] %></td>
            </tr>
            <tr>
              <td>订购日期:<%= str[3] %></td>
            </tr>
            <tr>
              <td>订单发送状态:<%= str[4] %></td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></hr></td>
      </tr>
      <tr align="center">
        <td>
          <a href="AdminServlet?action=orderEnsure&oid=<%= str[5]%>">订单发送</a>
          <a href="AdminServlet?action=orderDelete&oid=<%= str[5]%>">订单删除</a>
          <a href="javascript:history.back()">返回</a>
        </td>
      </tr>
    </table>
</body>
</html>
<%
	}
%>