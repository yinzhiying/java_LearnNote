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
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
    function check()
    {
    	if(addform.aname.value=="")
    	{
    		alert("用户名不能为空!!!");
    		addform.aname.focus();
    		return false;
    	}
    	if(addform.apwd.value.length<6)
    	{
    		alert("密码不合法,长度不得小于6!!!");
    		addform.apwd.focus();
    		return false;
    	}
    	if(addform.apwd.value!=addform.secpwd.value)
    	{
    		alert("两次密码输入不一至!!!");
    		addform.secpwd.focus();
    		return false;
    	}
    	
    }
  </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员界面</title>
</head>
<body bgcolor="#F5F9FE">
<table width="100%">
            <tr>
              <td align="center"><br/><br/><br/>
                <table width="50%">
                  <form action="AdminServlet" method="post" name="addform">
                    <tr>
                      <td>请输入管理员用户名:</td>
                      <td><input name="aname"/></td>
                    </tr>
                    <tr>
                      <td><br/>请输入管理员密码:</td>
                      <td><br/><input type="password" name="apwd"/></td>
                    </tr>
                    <tr>
                      <td><br/>请再次输入管理员密码:</td>
                      <td><br/><input type="password" name="secpwd"/></td>
                    </tr>
                    <tr>
                      <td align="right">
                       
                        <br/><input type="submit" name="action" value="添加" onClick="return check()"/>
                      </td>
                      <td><br/><input type="reset" value="重置"/></td>
                    </tr>
                  </form>
                </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
</body>
</html>
<% 
 	}
  %>