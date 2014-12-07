<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!Connection con = null;%>
<%!PreparedStatement ps = null;%>
<%!ResultSet rs = null;%>
<%
	String driverClass = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/xscj";
	String username = "root";
	String password = "";
	String sql = "select * from shop";
	Class.forName(driverClass); // 加载数据库驱动
	con = DriverManager.getConnection(url, username, password); //建立连接
	ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_READ_ONLY);
	rs = ps.executeQuery();
%>
<%
	int dipage = 1;//当前页码默认为1
	String pages = request.getParameter("dipage");
	
	if (pages == null) {
		pages = "1";
	}
	try {
		dipage = Integer.parseInt(pages);
	} catch (Exception e) {
		dipage = 1;
	}
	/* String page1 = request.getParameter("page");
	if (page1 == null) {
		pages = "1";
	}
	try {
		dipage = Integer.parseInt(page1);
	} catch (Exception e) {
		dipage = 1;
	} */
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
</head>
<body>
	<%
		int countRecord = 0;//记录条数
		int countpageRecord = 0;//每页记录条数
		int countpage = 0;//总页数
		countpageRecord = 5;//每页记录5条

		//获取总行数
		rs.last();
		countRecord = rs.getRow();
		if (countRecord / countpageRecord == 0) {
			countpage = countRecord / countpageRecord;
		} else
			countpage = countRecord / countpageRecord + 1;
		if ((dipage - 1) * countpageRecord == 0)
			rs.beforeFirst();
		else
			rs.absolute((dipage - 1) * countpageRecord);
		out.print("<table border style='font-size:10pt'");
		out.print("<tr><td colspan=8 align=center>你购买的商品信息</td></tr>");
		out.print("<tr>");
		out.print("<td width=60>" + "商品名</td> ");
		out.print("<td width=60>" + "商品价格</td> ");
		out.print("<td width=60>" + "商品数量</td> ");
		out.print("</tr>");
		int i = 0;
		while (rs.next()) {
			out.print("<tr>");
			out.print("<td>" + rs.getString("name") + "</td> ");
			out.print("<td>" + rs.getFloat("price") + "</td> ");
			out.print("<td>" + rs.getInt("num") + "</td> ");
			out.print("<tr>");
			i++;
			if (i > countpageRecord) {
				break;
			}
			
			
		}
		out.print("<tr><td colspan=8 align=center>");
		out.print("共" + countRecord + "条记录，共" + countpage + "页，当前第"
				+ dipage + "页，每页" + countpageRecord + "条记录，");
		if (dipage == 1)
			;
		else {
			out.print("<a href=fenye.jsp?dipage=1>首页</a>,");
			out.print("<a href=fenye.jsp?dipage=" + (dipage - 1)
					+ ">上一页</a>,");
		}
		
		if (dipage == countpage)
			;

		else {
			out.print("<a href=fenye.jsp?dipage=" + (dipage + 1)
					+ ">下一页</a>,");
			out.print("<a href=fenye.jsp?dipage=" + countpage + ">尾页</a>");
		}

		out.print("</td></tr>");
		out.print("</table>");
		rs.close();
		ps.close();
		con.close();
	%>
	
</body>
</html>