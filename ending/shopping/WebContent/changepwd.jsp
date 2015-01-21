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
<title>修改密码界面</title>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function pwdCheck()
      {
      	if(pwdform.oldpwd.value==""||pwdform.oldpwd.value.length<6)
      	{
      		alert("旧密码输入不合法,长度不得小于6!!!");
      		pwdform.oldpwd.focus();
      		return false;
      	}
      	if(pwdform.firpwd.value==""||pwdform.firpwd.value.length<6)
      	{
      		alert("新密码输入不合法,长度不得小于6!!!");
      		pwdform.firpwd.focus();
      		return false;
      	}
      	if(pwdform.secpwd.value==""||pwdform.secpwd.value.length<6)
      	{
      		alert("第二次新密码输入不合法,长度不得小于6!!!");
      		pwdform.secpwd.focus();
      		return false;
      	}
      	if(pwdform.firpwd.value!=pwdform.secpwd.value)
      	{
      		alert("新密码两次输入不相同!!!");
      		pwdform.secpwd.focus();
      		return false;
      	}
      	
      }
    </script>
</head>
<body bgcolor="#F5F9FE">

    <table width="100%" hight="100%" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td>
          <table>
            <form name="pwdform" action="AdminServlet" method="post">
              <tr>
              <% 
              	String name = (String)session.getAttribute("admin");
               %>
                <td><br/><br/><br/>用户名:</td>
                <td><br/><br/><br/><%= name %></td>
              </tr>
              <tr>
                <td><br/>请输入旧密码:</td>
                <td><br/><input type="password" name="oldpwd"/></td>
              </tr>
              <tr>
                <td><br/>请输入新密码:</td>
                <td><br/><input type="password" name="firpwd"/></td>
              </tr>
              <tr>
                <td><br/>请再次输入新密码:</td>
                <td><br/><input type="password" name="secpwd"/></td>
              </tr>
              <tr>
                <td align="right">
                  <br/><input type="submit" name="action" value="提交" onclick="return pwdCheck()"/>
                   
                </td>
                <td align="left"><br/><input type="reset" value="重置"/></td>
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