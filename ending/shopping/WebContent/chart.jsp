<%@ page language="java" pageEncoding="utf-8"%>

<%@ page import="org.jfree.chart.entity.StandardEntityCollection" %>
<%@ page import="org.jfree.chart.ChartRenderingInfo" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="shop.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

%>
<% 
ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
String fileName=ServletUtilities.saveChartAsPNG(shopServlet.creatChart(),400,270,info,session);
String url=request.getContextPath()+"/servlet/DisplayChart?filename="+fileName;
%>
<html>
  <head>
    <title>绘制条形图</title>
  </head>
  
  <body topmargin="0">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<img src="<%=url%>">
	</td>
  </tr>
</table>
  </body>
  
</html>