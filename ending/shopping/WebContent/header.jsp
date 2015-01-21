<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0037)http://2school.wygk.cn/admin/main.asp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>网上书店</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="images/style.css" type=text/css 
rel=stylesheet>
<STYLE>.main_left {
	TABLE-LAYOUT: auto; BACKGROUND: url(img/images/title.gif.gif)
}
.main_left_top {
	BACKGROUND: url(images/left_menu_bg.gif); PADDING-TOP: 5px
}
.main_left_title {
	PADDING-LEFT: 15px; FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #fff; TEXT-ALIGN: left
}
.left_iframe {
	BACKGROUND: none transparent scroll repeat 0% 0%; VISIBILITY: inherit; WIDTH: 180px; HEIGHT: 92%
}
.main_iframe {
	Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 92%
}
TABLE {
	FONT-SIZE: 12px; FONT-FAMILY: tahoma, 宋体, fantasy
}
TD {
	FONT-SIZE: 12px; FONT-FAMILY: tahoma, 宋体, fantasy
}
</STYLE>
 

 

<SCRIPT language=javaScript src="images/admin.js" 
type=text/javascript></SCRIPT>
 
<SCRIPT language=javascript 
src="images\Admin(1).js"></SCRIPT>
 
<SCRIPT> 
var status = 1;
var Menus = new DvMenuCls;
document.onclick=Menus.Clear;
function switchSysBar(){
     if (1 == window.status){
		  window.status = 0;
          switchPoint.innerHTML = '<img src="images/left.gif">';
          document.all("frmTitle").style.display="none"
     }
     else{
		  window.status = 1;
          switchPoint.innerHTML = '<img src="images/right.gif">';
          document.all("frmTitle").style.display=""
     }
}
</SCRIPT>
 
<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY style="MARGIN: 0px"><!--导航部分-->
<DIV class=top_table>
<DIV class=top_table_leftbg>
<DIV class=system_logo><IMG 
src="images/logo_up.gif"></DIV>
<DIV class=menu>
<UL>
  <LI id=menu_0 onmouseover=Menus.Show(this,0) onclick=getleftbar(this);><A 
  href="index.jsp" target="mainFrame">首页</A> 
  <DIV class=menu_div><IMG style="VERTICAL-ALIGN: bottom" 
  src="images/menu01_right.gif"></DIV></LI>
  <LI id=menu_1 onmouseover=Menus.Show(this,0) onclick=getleftbar(this);><A 
  href="cart.jsp" target="mainFrame">购物车</A> 
  
  <DIV class=menu_div><IMG style="VERTICAL-ALIGN: bottom" 
  src="images/menu01_right.gif"></DIV></LI>
  <LI id=menu_3 onmouseover=Menus.Show(this,0) onclick=getleftbar(this);><A 
  href="register.jsp"  target="mainFrame">新用户注册</A> 
  
  <DIV class=menu_div><IMG style="VERTICAL-ALIGN: bottom" 
  src="images/menu01_right.gif"></DIV></LI>
  <LI id=menu_4 onmouseover=Menus.Show(this,0) onclick=getleftbar(this);><A 
  href="login.jsp" target="mainFrame">登录</A> 
  <DIV class=menu_div><IMG style="VERTICAL-ALIGN: bottom" 
  src="images/menu01_right.gif"></DIV></LI>
  <LI id=menu_5 onmouseover=Menus.Show(this,0) onclick=getleftbar(this);><A 
  href="alteruser.jsp" target="mainFrame">查看/修改个人信息</A> 
  
  <DIV class=menu_div><IMG style="VERTICAL-ALIGN: bottom" 
  src="images/menu01_right.gif"></DIV></LI>
  <LI id=menu_7 onmouseover=Menus.Show(this,0) onclick=getleftbar(this);><A 
  href="shopServlet?submit=logout" target="mainFrame">注销</A> 
  <DIV class=menu_div><IMG style="VERTICAL-ALIGN: bottom" 
  src="images/menu01_right.gif"></DIV></LI></UL></DIV></DIV></DIV>
<DIV style="BACKGROUND: #337abb; HEIGHT: 24px"></DIV><!--导航部分结束-->

</BODY></HTML>

