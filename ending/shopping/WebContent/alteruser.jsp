<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="shop.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mycart1" class="shop.cartBean" scope="session"/>
<% 
	if(session.getAttribute("user")==null)
	{
		String msg = "请你先登陆!!!";
		request.setAttribute("msg",msg);
		String url = "/login.jsp";
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(url); 
		rd.forward(request,response);
	}
	else
	{
 %>
<html>

<head>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function check()
      {
      	var email = document.mfmodify.uemail.value;
      	if(mfmodify.upwd.value=="")
      	{
      		alert("密码不可以为空!!!");
      		mfmodify.upwd.focus();
      		return false;
      	}
      	else if(mfmodify.upwd.value.length<6)
      	{
      		alert("密码长度不得少于6!!!");
      		mfmodify.upwd.focus();
      		return false;
      	}
      	else if(mfmodify.uemail.value=="")
      	{
      		alert("E-mail不得为空!!!");
      		mfmodify.uemail.focus();
      		return false;
      	}
      	
      }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
</head>
<body>
<jsp:useBean id="mycart" class="shop.cartBean" scope="session"/>
     <table width="100%">
		  <tr align="center">
		    <td>
		      <table>
		        <form action="shopServlet" method="post" name="mfmodify">
		          <% 
		              String uname = (String)session.getAttribute("user");
		             // uname = new String(uname.getBytes(),"ISO-8859-1");
		          	  String sql = "select Uname,Upwd,Uemail from UserInfo where Uname='"+uname+"'";
		          	Vector<String[]> vuser = DataBase.getInfoArr(sql);
		          	  String[] str = vuser.get(0);
		           %>
		           <tr align="center">
		            <td><br/><br/>用户名:</td>
		            <td align="left"><br/><br/><%=str[0] %></td>
		          </tr>
		          <tr>
		            <td><br/><br/>密&nbsp;码:</td>
		            <td><br/><br/><input type="password" name="upwd" value="<%=str[1] %>"/></td>
		          </tr>
		          <tr>
		            <td><br/><br/>E-mail:</td>
		            <td><br/><br/><input name="uemail" value="<%=str[2] %>"/></td>
		          </tr>
		          <tr>
		            <td align="right">
		              <br/><br/><input type="submit" name="submit" value="修改" onclick="return check()"/>
		              
		            </td>
		            <td align="right"><br/><br/>
		              <a href="javascript:history.back()">单击这里返回</a>
		            </td>
		          </tr>
		        </form>
		      </table>
		    </td>
		  </tr>
	</table>
</body>
</html>
<%
	}
%>