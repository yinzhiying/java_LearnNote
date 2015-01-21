<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*,shop.*" %>
<html>
  <head>
    <title>注册</title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript"> 
      function mfSub(){
    	  if(regform.uname.value=="")
        	{
        		alert("用户名不能为空");
        		regform.uname.focus();
              return false;
        	}
    	  if(regform.fpwd.value==""||regform.fpwd.value.length<6||regform.fpwd.value.length>20||!regform.fpwd.value.match("[a-zA-Z0-9]+"))
        	{
        		alert("密码设置有误");
        		regform.fpwd.focus();
              return false;
        	}
    	  if(regform.fpwd.value!=regform.spwd.value){
    		 alert("两次密码不一致，请重新输入！");
      		regform.spwd.focus();
            return false;
    	  }
    	  if(regform.email.value==""){
    		  alert("请填写正确的邮箱！");
        		regform.spwd.focus();
              return false; 
    	  }
    	  
    	  
    	  
    	  
      }
    </script>
  </head>
  <body  bgcolor="#F5F9FE">
    <jsp:useBean id="mycart" class="shop.cartBean" scope="session"/>
    <center>
      <table width="100%">
		  
		  <tr height="15">
		    <td><hr color="#FF7F00" width="100%"/></hr></td>
		  </tr>
		  <tr align="center">
		    <td>
		      <table border="0">
		      <form action="shopServlet" method="post" name="regform">
		        <tr height="50">
		          <td>请填写你的用户名:</td>
		          <td><input type="text" name="uname" size="20" ></td>
		          <td id="uinfo">
		            <font size="2px">用户名可以由小写英文字母、中文、数字组成。</font>
		          </td>
		        </tr>
		        <tr height="50">
		          <td>设置你的密码:</td>
		          <td><input type="password" name="fpwd" size="20" ></td>
		          <td id="pfinfo">
		            <font size="2px">您的密码可以由大小写英文字母、数字组成，长度6－20位。</font>
		          </td>
		        </tr>
		        <tr height="50">
		          <td>请再次输入你的密码:</td>
		          <td><input type="password" name="spwd" size="20" ></td>
		          <td id="psinfo"></td>
		        </tr>
		        <tr height="50">
		          <td>请填写你的E-mail地址:</td>
		          <td><input type="text" name="email" size="20"></td>
		          <td id="einfo">
		            <font size="2">请填写有效的E-mail地址。</font>
		          </td>
		        </tr>
		        <tr align="center">
		          <td colspan="3">注:以上各项为必填项,请认真填写。</td>
		        </tr>
		        <tr align="center">
		          <td colspan="2" align="right">
		            <input type="submit" name="submit" value="注册" onclick="return mfSub()"/>
		            
		          </td>
		          <td><a href="javascript:history.back()">单击这里返回</a></td>
		        </tr>
		        </form>
		      </table>
		    </td>
		  </tr>
      </table>
    </center>
  </body>
</html>