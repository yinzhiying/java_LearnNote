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
		Vector<String[]> vgoods = (Vector<String[]>)request.getAttribute("vgoods");
		String[] str = vgoods.get(0);
 %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品修改/删除界面</title>
<script language="javascript" src="script/trim.js"></script>
     <script language="javascript">
       function modifyGoods()
       {
		// document.myform.action.value="modify";
         if(myform.gname.value=="")
         {
         	alert("商品名称不能为空!!!");
         	myform.gname.focus();
         	return false;
         }
         if(myform.gprice.value=="")
         {
         	alert("商品价格不能为空!!!");
         	myform.gprice.focus();
         	return false;
         }
         if(isNaN(myform.gprice.value*1))
         {
         	alert("商品价格只能是数字!!!");
         	myform.gprice.focus();
         	return false;
         }
         if(myform.gamount.value=="")
         {
         	alert("商品数量不能为空!!!");
         	myform.gamount.focus();
         	return false;
         }
         if(isNaN(myform.gamount.value*1))
         {
         	alert("商品数量只能是数字!!!");
         	myform.gamount.focus();
         	return false;
         }
         if(myform.gdate.value=="")
         {
         	alert("日期不能为空!!!");
         	myform.gdate.focus();
         	return false;
         }
         /* var reg = /^\d{4}-(0[1-9]|1[0-2])-([0-2][1-9]|3[0-1])$/;
         if(!reg.test(myform.gdate.value))
         {
         	alert("日期格式不对,只能为yyyy-mm-dd");
         	myform.gdate.focus();
         	return false;
         } */
         if(myform.gintro.value=="")
         {
         	alert("商品说明不能为空!!!");
         	myform.gintro.focus();
         	return false;
         }
         if(myform.gbrief.value=="")
         {
         	alert("商品简介不能为空!!!");
         	myform.gbrief.focus();
         	return false;
         }
        
       }
       function deleteGoods()
       {
       		document.myform.action.value="delete";
       		document.myform.submit();
       }
     </script>
</head>
<body>
<table width="100%" cellpadding="0" cellspacing="0">
       
       <tr>
         <td align="center">
           <form action="AdminServlet" method="post" name="myform">
             <table>
               <tr>
                 <td>商品名称:</td>
                 <td><input name="gname" size="30" value="<%=str[1] %>"/></td>
               </tr>
               <tr>
                 <td>商品价格:</td>
                 <td><input name="gprice" size="30" value="<%=str[2] %>"/></td>
               </tr>
               <tr>
                 <td>商品数量:</td>
                 <td><input name="gamount" size="30" value="<%=str[3] %>"/></td>
               </tr>
               <tr>
                 <td>商品类别:</td>
                 <td><input name="gclass" size="30" value="<%=str[4] %>"/></td>
               </tr>
               <tr>
                 <td>上架日期:</td>
                 <td><input name="gdate" size="30" value="<%=str[5] %>"/></td>
               </tr>
               <tr>
                 <td>图片URL:</td>
                 <td><input type="file" name="gurl" size="30" value="<%=str[6] %>"/></td>
               </tr>
               <tr>
                 <td>商品说明:</td>
               </tr>
               <tr>
                 <td colspan="2">
                   <textarea cols="60" rows="6" name="gintro"><%=str[7] %></textarea>
                 </td>
               </tr>
               <tr>
                 <td>商品简介:</td>
               </tr>
               <tr>
                 <td colspan="2">
                   <textarea cols="60" rows="6" name="gbrief"><%=str[8] %></textarea>
                 </td>
               </tr>
               <tr align="center">
                 <td colspan="2">
                  <input type="hidden" name="gid" value="<%= str[0] %>"/>
                   <input type="submit" name="action" value="修改" onclick="return modifyGoods()"/>
                   <input type="submit" name="action" value="删除" onclick="deleteGoods()"/>
                    <a href="javascript:history.back()">返回</a>
		            </td>
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