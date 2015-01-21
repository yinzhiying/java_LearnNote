<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,shop.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单搜索界面</title>
</head>
<body>
<script language="javascript" src="script/trim.js"></script>
<script language="javascript">
function txtclear()
{
 mfsearch1.txtsearch.value="";
}
function check()
{
  if(mfsearch1.txtsearch.value=="")
  {
    alert("关键字不能为空!!!");
    mfsearch1.txtsearch.focus();
    return false;
  }
  var reg = /^\d+$/;
  if(!reg.test(mfsearch1.txtsearch.value))
  {
    alert("定单号只能为整数!!!");
    mfsearch1.txtsearch.focus();
    return false;
  }
  
}
</script>
<table>
<form name="mfsearch1" action="shopServlet" method="post">
  <tr>
    <td>
      <input name="txtsearch" value="请输入要查询的定单号" onfocus="txtclear()"/>
    </td>
  </tr>
  <tr>
    <td align="right">
      <input type="submit" value="搜索" onclick="return check()"/>
      <input type="hidden" name="submit" value="orderSearch"/>
    </td>
  </tr>
</form>
</table>
</body>
</html>