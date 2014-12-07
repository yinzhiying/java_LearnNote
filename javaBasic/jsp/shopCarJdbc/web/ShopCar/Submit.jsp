<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="myCar" class="JavaBean.ShopCar" scope="session" />
<%@ page import="JavaBean.*"%>

<%
	IDUS idus = new IDUS();
	List<GoodsSingle> buylist = myCar.getBuylist(); //获取实例中用来存储购买的商品的集合
	for (int i = 0; i < buylist.size(); i++) {
		idus.insert(buylist.get(i));
	}
%>
<br>已提交订单
<td align="center" colspan="3"><a href="select.jsp">查看订单</a></td>
<td align="center" colspan="3"><a href="shopcar.jsp">返回购物车</a></td>
<td align="center" colspan="3"><a href="show.jsp">继续购物</a>