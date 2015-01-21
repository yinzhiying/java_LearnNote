<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="shop.*,java.util.*"%>
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
 <script language="javascript" src="script/trim.js"></script>
     <script language="javascript">
       function addCheck()
       {
         if(addform.gname.value=="")
         {
         	alert("商品名称不能为空!!!");
         	addform.gname.focus();
         	return false();
         }
         if(addform.gprice.value=="")
         {
         	alert("商品价格不能为空!!!");
         	addform.gprice.focus();
         	return false();
         	
         }
         if(isNaN(addform.gprice.value*1))
         {
         	alert("商品价格只能是数字!!!");
         	addform.gprice.focus();
         	return false;
         }
         if(addform.gamount.value=="")
         {
         	alert("商品数量不能为空!!!");
         	addform.gamount.focus();
         	return false;
         }
         if(isNaN(addform.gamount.value*1))
         {
         	alert("商品数量只能是数字!!!");
         	addform.gamount.focus();
         	return false;
         }
         if(addform.gintro.value=="")
         {
         	alert("商品说明不能为空!!!");
         	addform.gintro.focus();
         	return false;
         }
         if(addform.gbrief.value=="")
         {
         	alert("商品简介不能为空!!!");
         	addform.gbrief.focus();
         	return false;
         }
               
       }
     </script>
<title>添加商品界面</title>
</head>
<body>
<table width="100%">
      
       <tr>
         <td align="center">
           <form action="AdminServlet" method="post" name="addform">
             <table>
               <tr bgcolor="#E4EDFA">
                 <td>商品名称:</td>
                 <td><input name="gname"/></td>
               </tr>
               <tr>
                 <td>商品价格:</td>
                 <td><input name="gprice" /></td>
               </tr>
               <tr bgcolor="#E4EDFA">
                 <td>商品数量:</td>
                 <td><input name="gamount" /></td>
               </tr>
               <tr>
                 <td>商品类别:</td>
                 <td><input name="gclass" /></td>
               </tr>
               <tr bgcolor="#E4EDFA">
                 <td>图片URL:</td>
                 <td><input type="file"name="file" /></td>
               </tr>
               <tr>
                 <td>商品说明:</td>
               </tr>
               <tr>
                 <td colspan="2"><textarea cols="60" rows="6" name="gintro"></textarea></td>
               </tr>
               <tr>
                 <td>商品简介:</td>
               </tr>
               <tr>
                 <td colspan="2"><textarea cols="60" rows="6" name="gbrief"></textarea></td>
               </tr>
               <tr>
                 <td align="center" colspan="2">
                   <input type="submit" name="action" value="商品添加" onclick="return addCheck()"/>
                  
                   <input type="reset" value="重置"/>
                   <input type="button" value="返回" onClick="history.back()">
                 </td>
               </tr>
             </table>
           </form>
         </td>
       </tr>
     </table>
</body>
</html>
<% 
 	}
  %>