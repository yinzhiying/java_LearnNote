<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="shop.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品显示</title>
</head>
<table border="0" width="100%">
<body>
<%!
cartBean mycart=new cartBean();
%>
<%
	Vector<String[]> vgoods = (Vector<String[]>)request.getAttribute("vgoods");
	if(vgoods==null)
	{
		
		mycart.setCurPage(1);
		int nowpage = mycart.getCurPage();
        String gsql = "select Gimgurl,Gname,Gintro,Gclass,"+
        			"Gprice,Glook,Gid from goodsinfo";
        int totalpage = DataBase.getTotalPage("select count(*) from goodsinfo");
        mycart.setTotalPage(totalpage);
        mycart.setSql(gsql);
		vgoods = DataBase.getPageContent(nowpage,gsql);
	}
	for(int i=0;i<vgoods.size();i++)
	{
		String[] str = vgoods.get(i);
 %>
 <tr height="160">
    <td width="150" align="center">
      <a href="shopServlet?submit=getDetail&gid=<%= str[6] %>">
        <img src="<%= str[0] %>" height="150" border="1"/>      
      </a>
    </td>
    <td colspan="2">
      <table width="100%">
      </center>
        <tr>
          <td bgcolor="#E4EDFA">
            <a href="shopServlet?submit=getDetail&gid=<%= str[6] %>"><%= str[1] %></a>
          </td>
        </tr>
        <tr>
          <td><font><%= mycart.manageStr(str[2]) %></font></td>
        </tr>
        <tr>
          <td bgcolor="#E4EDFA"><font>所属分类:<%= str[3] %></font></td>
        </tr>
        <tr>
          <td><font>定价:￥<%= str[4] %></font></td>
        </tr>
        <tr>
          <td bgcolor="#E4EDFA"><font>浏览次数:<%= str[5] %></font></td>
        </tr>
        <tr>
          <td>
          <% 
          	String temp = "select Gamount from GoodsInfo where Gamount<1 and Gid="+str[6];
          boolean flag = DataBase.isLegal(temp);
          	if(!flag)
          	{
          %>
            <a href="shopServlet?submit=buy&flag=0&gid=<%= str[6] %>">
              <img src="img/other/buy.gif" border="0"/>
            </a>
          <%
          	}
          	else
          	{
           %>
           	<font>缺货</font>
		   <% 
		  	}
		   %>
          </td>
        </tr>
        </center>
      </table>
    </td>
  </tr>
  <% 
  	}
   %>
   <tr>
     <td colspan="3"><hr/></td>
   </tr>
   <tr align="center">
     <% 
    	int curPage = mycart.getCurPage();
    	int totalPage = mycart.getTotalPage();
     %>
      <td>
      <% 
      	if(curPage>1)
      	{
      %>
     
     	<a href="shopServlet?submit=跳转&curPage=<%= curPage-1%>"></a>
      
      <%
      	}
      %>
      </td>
      <form action="shopServlet" method="post">
      <td align="right" width="200">
      	  <select onchange="this.form.submit()" name="selPage">
      	   <% 
      	   		for(int i=1;i<=totalPage;i++)
      	   		{
      	   			String flag = "";
      	   			if(i==curPage)
      	   			{
      	   				flag = "selected";
      	   			}
      	    %>
      	    	<option value="<%=i%>" <%= flag %>>第<%= i %>页</option>
      	    <% 
      	    	}
      	     %>
      	  </select>
      	  <input type="submit" name="submit" value="跳转"/>
      	</td>
      	</form>
      <td align="left" width="40%">
      	<% 
      		if(curPage<totalPage)
      		{
      	 %>
      	 	<a href="shopServlet?submit=跳转&curPage=<%= curPage+1%>"></a>
      	 <% 
      	 	}
      	  %>
      </td>
    </tr>
</table>
</body>
</html>