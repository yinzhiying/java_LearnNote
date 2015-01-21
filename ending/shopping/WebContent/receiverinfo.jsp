<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,shop.*" %>
<jsp:useBean id="mycart" class="shop.cartBean" scope="session"/>
<% 
	if(session.getAttribute("user")==null)
	{
		String msg = "请你先登陆!!!";
		request.setAttribute("msg",msg);
		String url = "/error.jsp";
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(url); 
		rd.forward(request,response);
	}
	else
	{
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function checkMsg()
      {
      	if( mfrec.recname.value=="")
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
</head>
<body>
<center>
      <table width="100%" cellpadding="0" cellspacing="0">
      
        <tr>
          <td>
            <center>
            <table>
              <caption><b><br/>收货人信息</b></caption>
              <form action="shopServlet" method="post" name="mfrec">
                <tr>
                  <td><br/>收货人姓名:</td>
                  <td><br/><input name="recname"/></td>
                </tr>
                <tr>
                  <td><br/>收货人地址:</td>
                  <td><br/><input name="recadr"/></td>
                </tr>
                <tr>
                  <td><br/>收货人电话:</td>
                  <td><br/><input name="rectel"/></td>
                </tr>
                <tr>
                  <td align="center" colspan="2">
                    <font color="red" size="">
                      <br/>请你务必填写正确的信息,以保证你的货物能顺利收到.
                    </font>
                  </td>
                </tr>
                <tr>
                  <td colspan="2" align="right">
                  	<input type="hidden" name="submit" value="saveRec"/>
                    <br/><input type="submit" value="确认" onclick="return checkMsg()"/>
                  </td>
                </tr>
              </form>
            </table>            
            </center>
          </td>
        </tr>
      </table>
    </center>
</body>
</html>
<% 
	}
 %>