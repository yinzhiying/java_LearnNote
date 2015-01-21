package shop;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;



import java.util.Map;
import java.util.Set;
import java.util.Vector;
public class shopServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 拿到session对象
		HttpSession session = request.getSession(true);
		// 拿到输出流对象
		PrintWriter out = response.getWriter();
		// 拿到请求的动作
		String action = request.getParameter("submit");

		if (action.equals("登录")) {
			//当动作为登录动作时
    		//获得用户名和密码
    		String uid = request.getParameter("uid").trim();
    		String pwd = request.getParameter("pwd").trim();
    		String uname = new String(uid.getBytes(),"ISO-8859-1");
    		String sql = "select Uid from UserInfo where Uname='"+uname+"' and Upwd='"+pwd+"'";
    		boolean flag = DataBase.isLegal(sql);
    		if(flag)
    		{//当该用户存在时
    			//将用户名存入session中
    			session.setAttribute("user",uid);
    			//页面重定向到首页
    			response.sendRedirect("index.jsp");
    		}
    		else
    		{
    			String msg = "对不起,登录失败,请重新登录!!!";
    	         pageForward(msg,request,response);
				
    		}
    	}

		else if (action.equals("注册")) {
			// 用户注册
			String uname = request.getParameter("uname").trim();
			String fpwd = request.getParameter("fpwd").trim();
			String email = request.getParameter("email").trim();
			String sql = "select Uid from userInfo where Uname='" + uname + "'";
			boolean flag = DataBase.select(sql);
			if (flag) {// 该用户名已经被注册时
				String msg = "对不起,该用户名已经存在,请重新注册!!!";
				pageForward(msg, request, response);
			} else {
				int uid = DataBase.getID("userinfo", "Uid");
				String sql1 = "insert into userinfo(Uid,Uname,Upwd,Uemail) "
						+ "values(" + uid + ",'" + uname + "','" + fpwd + "','"
						+ email + "')";
				int i = DataBase.addUser(sql1);
				if (i == 0) {// 没有插入数据库
					String msg = "对不起,注册失败,请重新注册!!!";
					pageForward(msg, request, response);
				} else {
					String msg = "恭喜您,注册成功!!!";
					pageForward(msg, request, response);
				}
			}
		}
		
		else if (action.equals("搜索")){
			//用户搜索商品时
    		//得到javaBean对象
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
    		if(mycart==null)
    		{
    			mycart = new cartBean();
    		}
    		mycart.setCurPage(1);
    		//得到要搜索的信息并转码
    		String tsearch = request.getParameter("tsearch");
    		//得到要搜索的类名
    		String cname = request.getParameter("cname");
    		System.out.println(cname);
    		String sql = "";
    		String sqlpage = "";
    		if(cname==null)
    		{
	    		//tsearch = new String(tsearch.trim().getBytes(),"ISO-8859-1");
	    		//得到搜索信息的sql和信息条数的sql
	    		sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,Glook,Gid "+
	    						"from goodsinfo where Gname like '%"+tsearch+"%'";
	    		sqlpage = "select count(*) from goodsinfo "+
	    									"where Gname like '%"+tsearch+"%'";    			
    		}
    		else
    		{
    			
    			//cname = new String(cname.getBytes(),"ISO-8859-1");
    			//得到搜索某类商品的sql和条数的sql
	    		 sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,Glook,Gid "+
	    						"from goodsinfo where Gclass=cname";
	    		//得到该类的总页数
	    		sqlpage = "select count(*) from goodsinfo where Gclass=cname";
    		}
    		mycart.setSql(sql);
    		//设置总页数
    		int totalpage = DataBase.getTotalPage(sqlpage);
    		mycart.setTotalPage(totalpage);
    		session.setAttribute("mycart",mycart);
    		//得到第一页的内容
    		Vector<String[]> vgoods = DataBase.getPageContent(1,sql);
    		if(vgoods.size()==0)
    		{//没有搜索到用户要找的商品
    			String msg = "对不起,没有搜到你要的商品!!!";
    			pageForward(msg,request,response);
    		}
    		else
    		{//搜索到信息并返回
    			request.setAttribute("vgoods",vgoods);
    			String url = "/index.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);  
    		}
		}
		
		else if(action.equals("跳转"))
    	{//用户换页时
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
	    	if(mycart==null)
	    	{
	    		mycart = new cartBean();
	    	}
	    	//得到请求的页面
    		String curPage = request.getParameter("curPage");
    		String selPage = request.getParameter("selPage");
    		if(curPage!=null)
    		{//用户通过点击上,下一页按钮时
    			int page = Integer.parseInt(curPage.trim());
    			//记住当前页
    			mycart.setCurPage(page);
    		}
    		else
    		{//当用户点击下拉列表框时
    			int page = Integer.parseInt(selPage.trim());
    			mycart.setCurPage(page);
    		}
    		//String sql = mycart.getSql(); 
    		String gsql="select Gimgurl,Gname,Gintro,Gclass,"+
        			"Gprice,Glook,Gid from goodsinfo";
    		//得到换页后页面的内容
    		Vector<String[]> vgoods = DataBase.getPageContent(mycart.getCurPage(),gsql);
			request.setAttribute("vgoods",vgoods);
    		session.setAttribute("mycart",mycart);
			//返回到主页
			String url = "/index.jsp";
    		ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);
    	}
		
		else if(action.equals("getDetail"))
    	{//用户请求得到某商品的详细信息时
	    	//得到商品ID
    		String gid = request.getParameter("gid").trim();
    		String sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,"+
    						"Glook,Gid,Gbrief from GoodsInfo where Gid="+gid;
    		//更新表中的浏览量
    		String updatesql = "update GoodsInfo set Glook=Glook+1 where Gid="+gid;
    		DataBase.updateTable(updatesql);
    		//得到该商品的详细信息
    		Vector<String[]> vgoods = DataBase.getPageContent(1,sql);
			request.setAttribute("vgoods",vgoods);
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher("/goodsdetail.jsp"); 
			rd.forward(request,response);
    	}
		
		else if(action.equals("修改"))
    	{//用户修改个人信息
    		//得到用户修改后的信息
    		String upwd = request.getParameter("upwd").trim();
    		String uemail = request.getParameter("uemail").trim();
    		String uname = (String)session.getAttribute("user");
    		//将汉字转码
    		//uname = new String(uname.getBytes(),"ISO-8859-1");
    		//更新数据库用户信息
    		String sql = "update UserInfo set upwd='"+upwd
    					+"',uemail='"+uemail+"' where uname='"+uname+"'";
    		int i = DataBase.updateTable(sql);
    		if(i==0)
    		{//更改信息失败
    			String msg = "对不起,信息修改失败!!!";
    			pageForward(msg,request,response);	
    		}
    		else
    		{//信息修改成功
    			String msg = "恭喜您,信息修改成功!!!";
    			pageForward(msg,request,response);    			
    		}
    	}
		
		else if(action.equals("logout"))
    	{//当用户注销登录时
    		//将session失效
			request.getSession(true).invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
    	//	request.getSession(true).invalidate();
    	//	response.sendRedirect("index.jsp");
	}
		
		else if(action.equals("buy"))
    	{//用户点击购买时
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
	    	if(mycart==null)
	    	{
	    		mycart = new cartBean();
	    	}
	    	//得到要购买东西的ID
    		String gid = request.getParameter("gid").trim();
    		//判断是在那儿点的购买,0-在缩略图中买,1-在详细信息中买的
    		String flag = request.getParameter("flag").trim();
    		mycart.buy(gid);
    		//得到搜索当前内容的sql
    		String sql = mycart.getSql();
    		int page = mycart.getCurPage();
    		session.setAttribute("mycart",mycart);
			String url = "";
			if(flag.equals("0"))
			{
				url = "/index.jsp";
				
			}
			else
			{
				url = "/goodsdetail.jsp";
				sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,"+
    						"Glook,Gid,Gbrief from GoodsInfo where Gid="+gid;
    			page = 1;
    			//返回后,得到页面内容
        		Vector<String[]> vgoods = DataBase.getPageContent(page,sql);   		
        		if(vgoods.size()==0)
        		{//没有搜索到用户要找的商品
        			String msg = "对不起,没有搜到你要的商品!!!";
        			pageForward(msg,request,response);
        		}
        		 		
    			request.setAttribute("vgoods",vgoods);
    			//forward到要去的页面
        		
			}
			
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);
    	}	
		
		else if(action.equals("clear")){
			//用户清空购物车
			cartBean mycart = (cartBean)session.getAttribute("mycart");
			mycart.clearCart();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		else if(action.equals("changeNum"))
    	{//用户修改购物车中商品数量时
    		//得到修改物品的ID和修改后的数量
    		String gnum = request.getParameter("gnum").trim();
    		String gid = request.getParameter("gid").trim();
    		int num = 0;
    		try
    		{
    			num = Integer.parseInt(gnum);
    		}
    		catch(Exception e)
    		{
    			//修改的数量不合法时
    			String msg = "对不起,数量修改错误!!!";
    			pageForward(msg,request,response); 
    		}
    		int id = Integer.parseInt(gid);
    		//得到库存数量
    		String sql = "select Gamount from GoodsInfo where Gid="+id;
			int count = DataBase.getSelectId(sql);
    		if(count<num)
    		{//当库存少于修改的值时
    			String msg = "对不起，库存不够，库存数量只有 "+count;
    			pageForward(msg,request,response);
    		}
    		else
    		{//当库存够时
	    		cartBean mycart = (cartBean)session.getAttribute("mycart");
	    		if(mycart==null)
	    		{
	    			mycart = new cartBean();
	    		}
	    		//得到用户的购物车
	    		Map<String,Integer> cart = mycart.getCart();
	    		//修改商品数量
	    		cart.put(gid,num);
	    		session.setAttribute("mycart",mycart);
	    		response.sendRedirect("cart.jsp");    			
    		}
    	}
    	else if(action.equals("balance"))
    	{//当点击结算时，判断各商品数量是否够
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
    		if(mycart==null)
    		{
    			mycart = new cartBean();
    		}
    		//得到用户的购物车
    		Map<String,Integer> cart = mycart.getCart();
    		Set<String> gid = cart.keySet();
    		String msg = "";
    		for(String str:gid)
    		{
    			//得到商品ID和数量
    			int id = Integer.parseInt(str);
    			int count = cart.get(str);
    			//得到库存里商品的数量
	    		String sql = "select Gamount from GoodsInfo where Gid="+id;
				int gamount = DataBase.getSelectId(sql);
    			if(gamount<count)
    			{
    				//得到该商品的名字
    				String temp = "select Gname from GoodsInfo where Gid="+id;
    				Vector<String> vname = DataBase.getInfo(temp);
    				String name = vname.get(0);
    				msg += "对不起，"+name+"的库存只有"+gamount+"<br/>";
    			}
    		}
    		if(msg.equals(""))
    		{//当msg为空时，代表库存够
    			response.sendRedirect("receiverinfo.jsp");
    		}
    		else
    		{//提示用户库存不够
    			pageForward(msg,request,response);
    		}
    	}
    	else if(action.equals("delete"))
    	{//用户删除购物车中的商品时
    		//得到删除商品的ID
    		String gid = request.getParameter("gid").trim();
    		//得到javaBean对象
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
    		if(mycart==null)
    		{
    			mycart  = new cartBean();
    		}
    		mycart.removeItem(gid);
    		session.setAttribute("mycart",mycart);
    		response.sendRedirect("cart.jsp");
    	}
		
    	else if(action.equals("收货人信息修改"))
    	{//用户修改收货人信息时
    		String recname = request.getParameter("recname").trim();
    		String recadr = request.getParameter("recadr").trim();
    		String rectel = request.getParameter("rectel").trim();
    		String[] recMsg = (String[])session.getAttribute("recMsg");
    		//当收货人信息为空时
    		if(recMsg==null)
    		{
    			//重定向到首页
    			response.sendRedirect("index.jsp");
    		}
    		else
    		{
    			//修改session里面收货人的信息
	    		recMsg[0] = recname;
	    		recMsg[1] = recadr;
	    		recMsg[2] = rectel;
	    		session.setAttribute("recMsg",recMsg);
	    		response.sendRedirect("order.jsp");    			
    		}

    	}
		
    	else if(action.equals("orderConfirm"))
    	{//当用户确认订单动作时
       		cartBean mycart = (cartBean)session.getAttribute("mycart");
       		//该对象为空,则返回首页
	    	if(mycart==null)
	    	{
	    		request.getRequestDispatcher("index.jsp").forward(request, response);
	    	}
	    	else
	    	{
		    	//得到向订单基本信息表中插入数据的sql
	    		String[] recMsg = (String[])session.getAttribute("recMsg");
	    		double oprice = mycart.getAccount();
	    		int oid = DataBase.getID("OrderInfo","Oid");
	    		String uname = (String)session.getAttribute("user");
	    		String sql = "select Uid from UserInfo where Uname='"+uname+"'";
	    		int uid = DataBase.getSelectId(sql);
	    		String upsql = "insert into OrderInfo(Oid,Odate,Ostate,Orecname,"+
	    					"Orecadr,Orectel,Uid,Ototalprice) values("+oid+
	    					",now(),'未发货','"+recMsg[0]+"','"+recMsg[1]+"','"+
	    					recMsg[2]+"',"+uid+","+oprice+")";			
	    		//得到向订单货物表中插入数据的sql
	    		Vector<String[]> vgoods = mycart.getCartContent();
	    		int ogid = DataBase.getID("OrderGoods","OGid");    		
	    		String[] sqlarr = new String[vgoods.size()+1];
	    		for(int i=0;i<vgoods.size();i++)
	    		{
	    			String[] ginfo = vgoods.get(i);
	    			int gid = Integer.parseInt(ginfo[3]);
	    			int gamount = Integer.parseInt(ginfo[2]);
	    			double gprice = Double.parseDouble(ginfo[1]);
	    			double totalprice = gprice*gamount;
	    			String temp = "insert into OrderGoods(OGid,Oid,Uid,Gid,OGamount,"+
	    						"OGtotalprice) values("+ogid+","+oid+","+uid+","+gid+
	    						","+gamount+","+totalprice+")";
	    			sqlarr[i] = temp;
	    			ogid++;
	    		}
	    		sqlarr[vgoods.size()] = upsql;
	    		//执行该事务
	    		boolean flag = DataBase.batchSql(sqlarr);
	    		String msg = "";
	    		if(!flag)
	    		{
	    			msg = "对不起,订单提交失败";
	    		}
	    		else
	    		{
	    			msg = "恭喜你,订单提交成功";
	    		}
	    		//将收货人信息和javaBean对象设为空
	    		session.setAttribute("recMsg",null);
	    		session.setAttribute("mycart",null);
	    		pageForward(msg,request,response);
	    	}
    	}	
		
    	else if(action.equals("saveRec"))
    	{//保存收货人信息放入session
    		//收到各参数
    		String recname = request.getParameter("recname");
    		String recadr = request.getParameter("recadr");
    		String rectel = request.getParameter("rectel");
    		String[] recMsg = new String[3];
    		recMsg[0] = recname.trim();
    		recMsg[1] = recadr.trim();
    		recMsg[2] = rectel.trim();
    		//放入session并重定向到订单页
    		session.setAttribute("recMsg",recMsg);
    		request.getRequestDispatcher("order.jsp").forward(request, response);
    	}
		
    	else if(action.equals("orderSearch"))
    	{//订单搜索
    		//得到javaBean对象
    		String uname= (String) session.getAttribute("user");
    		String sql1 = "select Uid from userInfo where Uname='" + uname + "'";
			int flag = DataBase.selectid(sql1);//登录者的编号
			int flag1=0;
			System.out.println(flag);
    		AdminBean adBean = (AdminBean)session.getAttribute("adBean");
    		if(adBean==null)
    		{
    			adBean = new AdminBean();
    		}
    		String txtsearch = request.getParameter("txtsearch");
    		String type = request.getParameter("type");
    		String sql = "";
    		//将每页记录数定为10
    		DataBase.setSpan(10);
    		adBean.setCurPage(1);
    		if(txtsearch!=null)
    		{//用户在文本框中输入内容搜索
	    		int oid = Integer.parseInt(txtsearch.trim());
	    		String s="select Uid from OrderInfo where Oid="+oid ;
	    		//flag1=DataBase.selectid(s);//下订单的用户对应的用户编号
	    		//System.out.println(flag1);
	  			sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
	  					" where Oid="+oid+" and OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
	  	adBean.setSql(sql);
	  			adBean.setTotalPage(1); 
	    	
	    		//设置总页数
	    		   			
    		}
    		else
    		{
    			String sqlpage = "";
    			if(type.trim().equals("all"))
    			{//查询所有定单
  					sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
  						" where OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
  					sqlpage = "select count(*) from OrderInfo";
    			}
    			else if(type.trim().equals("yes"))
    			{//查询所有已发货定单
			  		sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
			  				" where Ostate='已发货' and OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
			  		sqlpage = "select count(*) from OrderInfo where Ostate='已发货'";
    			}
    			else if(type.trim().equals("no"))
    			{//查询所有未发货定单
			  		sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
			  				" where Ostate='未发货' and OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
			  		sqlpage = "select count(*) from OrderInfo where Ostate='未发货'";
    			}
    			//转码
		  	//	sqlpage = new String(sqlpage.getBytes(),"ISO-8859-1");
		  	//	sql = new String(sql.getBytes(),"ISO-8859-1");
		  		int totalpage = DataBase.getTotalPage(sqlpage);
		  		adBean.setSql(sql);
		  		//记住当前总页数
		  		adBean.setTotalPage(totalpage);
    		}
    		session.setAttribute("adBean",adBean);
    		//得到第一页的内容
    		Vector<String[]> vorder = DataBase.getPageContent(1,sql);
    		DataBase.setSpan(2);
    		if(vorder.size()==0)
    		{//没有搜索到用户要找的商品
    			String msg = "对不起,没有搜到你要查询的定单!!!";
    			String url = "/error.jsp";
    			pageForward(msg,request,response);
    		}
    		else
    		{//搜索到信息并返回
    			request.setAttribute("vorder",vorder);
    			String url = "/meordermanage.jsp";
	    		ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
    		}
    	}
		
    	else if(action.equals("orderPageChange"))
    	{//订单换页时
    		//得到javaBean对象
    		AdminBean adBean = (AdminBean)session.getAttribute("adBean");
    		if(adBean==null)
    		{
    			adBean = new AdminBean();
    		}
    		//接受参数
    		String curPage = request.getParameter("curPage");
    		String selPage = request.getParameter("selPage");
    		//设置当前页记录条数为10
    		DataBase.setSpan(10);
    		if(curPage!=null)
    		{//用户通过点击上,下一页按钮时
    			int page = Integer.parseInt(curPage.trim());
    			//记住当前页
    			adBean.setCurPage(page);
    		}
    		else
    		{//当用户点击下拉列表框时
    			int page = Integer.parseInt(selPage.trim());
    			adBean.setCurPage(page);
    		}
    		//得到当前换页所执行的sql
    		String sql = adBean.getSql();
    		//得到换页后页面的内容
    		Vector<String[]> vorder = DataBase.getPageContent(adBean.getCurPage(),sql);
			request.setAttribute("vorder",vorder);
    		session.setAttribute("adBean",adBean);
    		//恢复记录跨度为2
    		DataBase.setSpan(2);
    		//forward到修改的主页面
			String url = "/meordermanage.jsp";
    		ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);
    	}
    	
    	else if(action.equals("ordermanage"))
    	{//点击查看/管理时
    		String oid = request.getParameter("oid").trim();
    		int id = Integer.parseInt(oid);
    		//得到订单的基本信息
    		String osql = "select Orecname,Orecadr,Orectel,Odate,Ostate,Oid from OrderInfo"+
    							" where Oid="+id;
    		Vector<String[]> vorderinfo = DataBase.getInfoArr(osql);
    		//得到订单中货物信息
    		String ogsql = "select Gname,OGamount,OGtotalprice from GoodsInfo,"+
    							"OrderGoods where GoodsInfo.Gid=OrderGoods.Gid"+
    							" and Oid="+id;
    		Vector<String[]> vordergoods = DataBase.getInfoArr(ogsql);
			request.setAttribute("vorderinfo",vorderinfo);
			request.setAttribute("vordergoods",vordergoods);
			String url = "/meordermodify.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);
    	}
		
    
	}
	public void pageForward(String msg, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", msg);
		String url = "/error.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	public static JFreeChart creatChart() {
		DataBase cz = new DataBase();
		// cz.select();
		JFreeChart chart = ChartFactory.createPieChart("商品人气指数比例图", // 图表标题
				
				 cz.selectAll1(), // 数据集	
				true, // 是否包含图例
				false, // 是否包含图例说明
				false // 是否包含连接
				);
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN"); // 创建主题样式
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20)); // 设置标题字体
		standardChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 15)); // 设置图例的字体
		standardChartTheme.setLargeFont(new Font("微软雅黑", Font.PLAIN, 15)); // 设置轴向的字体
		ChartFactory.setChartTheme(standardChartTheme);
		return chart;

		
	}
}
