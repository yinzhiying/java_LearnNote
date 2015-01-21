<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,shop.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("admin")==null||session.getAttribute("level")==null)
	{
		response.sendRedirect("adlogin.jsp");
	}
	else
	{
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理界面</title>
</head>
<body >
<center>
 <table width="100%" cellspacing="0" cellpadding="0">
     
      <tr>
        <td align="center"><br/><br/><br/>
          <table width="100%">
              <td>
                <table width="70%" hight="100%">
                  <tr>
      			    <th>管理员ID</th>
				    <th>用户名</th>
				    <th>管理员级别</th>
				    <th>管理员删除</th>           
                  </tr>
                  <% 
                  	String sql = "select Aid,Aname,Alevel from AdminInfo";
                  	Vector<String[]> vadmin = DataBase.getInfoArr(sql);
                  	int i=0;
					for(String[] str:vadmin)
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
                   		<td><%= str[0] %></td>
                   		<td><%= str[1] %></td>
                   		<td><%= str[2] %></td>
                   		<td><a href="AdminServlet?action=adminDelete&aid=<%= str[0] %>">删除</a></td>
                   <% 
                   	} 
                    %>
          		</table>
          		 </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    </center>
</body>
</html>
<% 
 	}
  %>