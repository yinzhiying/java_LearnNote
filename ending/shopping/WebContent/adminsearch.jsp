<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,shop.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script language="javascript" src="script/trim.js"></script>
<script language="javascript">
  function txtclear()
  {
   mfsearch.tsearch.value="";
  }
  function tijiao()
  {

    if(mfsearch.tsearch.value=="")
    {
      alert("关键字不能为空");
      mfsearch.tsearch.focus();
      return false;
    }
    
  }
</script>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品搜索界面</title>
</head>
<body bgcolor="#F5F9FE">
<center>
<form name="mfsearch" method="post" action="AdminServlet">
 	<table border="0"  width="100%" height="100">
	  <tr>
	    <td>
	      <input type="text" id="tsearch" name="tsearch" value="请输入要搜索的关键字" onfocus="txtclear()"/>
	    </td>
	  </tr>
	  <tr>
	  	<td align="center">
	  	   
	  	    <input type="submit" id="action" name="action" value="搜索" onclick="return tijiao()"/>
	  	  </a>
	  	</td>
	  </tr>
	</table>
</form>
</center>
</body>
</html>