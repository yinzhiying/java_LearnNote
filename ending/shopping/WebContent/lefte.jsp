<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!--#include file="inc/Conn.asp"-->
<!--#include file="inc/AllFunction.asp" -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左边界面</title>
<STYLE type=text/css>BODY {
	BACKGROUND: #799ae1; MARGIN: 0px; FONT: 9pt 宋体
}
TABLE {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
TD {
	FONT: 12px 宋体
}
IMG {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; VERTICAL-ALIGN: bottom; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
A {
	FONT: 12px 宋体; COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
	COLOR: #428eff; TEXT-DECORATION: underline
}
.sec_menu {
	BORDER-RIGHT: white 1px solid; BACKGROUND: #d6dff7; OVERFLOW: hidden; BORDER-LEFT: white 1px solid; BORDER-BOTTOM: white 1px solid
}
.menu_title {
	
}
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 7px; COLOR: #215dc6; POSITION: relative; TOP: 2px
}
.menu_title2 {
	
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 8px; COLOR: #428eff; POSITION: relative; TOP: 2px
}
</STYLE>
 <META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.2180" name=GENERATOR></HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
 
 <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
 <TBODY>
        <TR>
          <TD class=menu_title onMouseOver="this.className='menu_title2';" 
          onmouseout="this.className='menu_title';" background="" 
            height=25><SPAN>
 
			| <A 
            href="AdminServlet?action=denglu" 
            target=_parent><B>管理员登录</B></A></SPAN></TD>
        </TR>
       
        <TR>
          <TD class=menu_title onMouseOver="this.className='menu_title2';" 
          onmouseout="this.className='menu_title';" background="" 
            height=25>&nbsp;</TD>
</TR>
        </TBODY></TABLE>

 <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
          <TR>
            <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(2) 
          onmouseout="this.className='menu_title';" 
          background=img/images/admin_left_2.gif height=25><SPAN>常用网站</SPAN> </TD>
          </TR>
          <TR>
            <TD id=submenu2><DIV class=sec_menu style="WIDTH: 158px">
                <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
                  <TBODY>
                    <TR>
                      <TD height=20><a href="http://www.baidu.com" target="mainFrame">百度</a></TD>
                    </TR>
                    <TR>
                      <TD height=20><a href="http://www.google.com" target="mainFrame">谷歌</a></TD>
                    </TR>
                  </TBODY>
                </TABLE>
            </DIV>
                <DIV style="WIDTH: 158px">
                  <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
                    <TBODY>
                      <TR>
                        <TD 
      height=20></TD>
                      </TR>
                    </TBODY>
                  </TABLE>
                </DIV></TD>
          </TR>
        </TBODY>
      </TABLE>
	  
	  <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
          <TR>
            <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(30) 
          onmouseout="this.className='menu_title';" 
          background=img/images/admin_left_2.gif height=25><SPAN>我的订单</SPAN> </TD>
          </TR>
          <TR>
            <TD id=submenu30>
			 <DIV class=sec_menu style="WIDTH: 158px">
			   <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
                 <TBODY>
                   <TR>
                     <TD height=20><a href="shopServlet?submit=orderSearch&type=all" target=mainFrame>查看所有订单</a></TD>
                   </TR>
				    <TR>
                     <TD height=20><a href="shopServlet?submit=orderSearch&type=yes" target=mainFrame>查看已发货定单</a></TD>
                   </TR>
                   <TR>
                     <TD height=20><a href="shopServlet?submit=orderSearch&type=no" target=mainFrame>查看未发货定单</a></TD>
                   </TR>
                   <TR>
                     <TD height=20><A 
                  href="meordersearch.jsp" 
                  target=mainFrame>订单查询</A></TD>
                   </TR>
                 </TBODY>
			     </TABLE>
			 </DIV><DIV style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD 
      height=20></TD></TR></TBODY></TABLE></DIV>
			
			</TD>
          </TR>
        </TBODY>
      </TABLE>
	  
 	  <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(1) 
          onmouseout="this.className='menu_title';" 
          background=img/images/admin_left_2.gif height=25><SPAN>商品信息</SPAN> 
          </TD>
        </TR>
        <TR>
          <TD id=submenu1>
            <DIV class=sec_menu style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                     <TD height=20><a href="search.jsp" target=mainFrame>商品搜索</a></TD>
                   </TR>
              <TR>
                <TD height=20><a href="chart.jsp" target="mainFrame">商品点击率</a></TD>
              </TR>
              </TBODY></TABLE>
            </DIV>
            <DIV style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD 
      height=20></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE>
      
      
 
      <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" 
          onmouseout="this.className='menu_title';" 
          background=img/images/admin_left_9.gif 
          height=25><SPAN>网上书店版权信息</SPAN></TD>
        </TR>
        <TR>
          <TD>
            <DIV class=sec_menu style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD height=20 bgcolor="#D6DFF7" style="LINE-HEIGHT: 150%">
                <marquee direction="left" behavior="scroll"scrollamount=5>版权:信息121程亚如尹志莹</marquee>
                 </TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE></TR></TBODY></TABLE>
 

</head>

</body>
</html>