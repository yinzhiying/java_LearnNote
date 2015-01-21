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
		// �õ�session����
		HttpSession session = request.getSession(true);
		// �õ����������
		PrintWriter out = response.getWriter();
		// �õ�����Ķ���
		String action = request.getParameter("submit");

		if (action.equals("��¼")) {
			//������Ϊ��¼����ʱ
    		//����û���������
    		String uid = request.getParameter("uid").trim();
    		String pwd = request.getParameter("pwd").trim();
    		String uname = new String(uid.getBytes(),"ISO-8859-1");
    		String sql = "select Uid from UserInfo where Uname='"+uname+"' and Upwd='"+pwd+"'";
    		boolean flag = DataBase.isLegal(sql);
    		if(flag)
    		{//�����û�����ʱ
    			//���û�������session��
    			session.setAttribute("user",uid);
    			//ҳ���ض�����ҳ
    			response.sendRedirect("index.jsp");
    		}
    		else
    		{
    			String msg = "�Բ���,��¼ʧ��,�����µ�¼!!!";
    	         pageForward(msg,request,response);
				
    		}
    	}

		else if (action.equals("ע��")) {
			// �û�ע��
			String uname = request.getParameter("uname").trim();
			String fpwd = request.getParameter("fpwd").trim();
			String email = request.getParameter("email").trim();
			String sql = "select Uid from userInfo where Uname='" + uname + "'";
			boolean flag = DataBase.select(sql);
			if (flag) {// ���û����Ѿ���ע��ʱ
				String msg = "�Բ���,���û����Ѿ�����,������ע��!!!";
				pageForward(msg, request, response);
			} else {
				int uid = DataBase.getID("userinfo", "Uid");
				String sql1 = "insert into userinfo(Uid,Uname,Upwd,Uemail) "
						+ "values(" + uid + ",'" + uname + "','" + fpwd + "','"
						+ email + "')";
				int i = DataBase.addUser(sql1);
				if (i == 0) {// û�в������ݿ�
					String msg = "�Բ���,ע��ʧ��,������ע��!!!";
					pageForward(msg, request, response);
				} else {
					String msg = "��ϲ��,ע��ɹ�!!!";
					pageForward(msg, request, response);
				}
			}
		}
		
		else if (action.equals("����")){
			//�û�������Ʒʱ
    		//�õ�javaBean����
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
    		if(mycart==null)
    		{
    			mycart = new cartBean();
    		}
    		mycart.setCurPage(1);
    		//�õ�Ҫ��������Ϣ��ת��
    		String tsearch = request.getParameter("tsearch");
    		//�õ�Ҫ����������
    		String cname = request.getParameter("cname");
    		System.out.println(cname);
    		String sql = "";
    		String sqlpage = "";
    		if(cname==null)
    		{
	    		//tsearch = new String(tsearch.trim().getBytes(),"ISO-8859-1");
	    		//�õ�������Ϣ��sql����Ϣ������sql
	    		sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,Glook,Gid "+
	    						"from goodsinfo where Gname like '%"+tsearch+"%'";
	    		sqlpage = "select count(*) from goodsinfo "+
	    									"where Gname like '%"+tsearch+"%'";    			
    		}
    		else
    		{
    			
    			//cname = new String(cname.getBytes(),"ISO-8859-1");
    			//�õ�����ĳ����Ʒ��sql��������sql
	    		 sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,Glook,Gid "+
	    						"from goodsinfo where Gclass=cname";
	    		//�õ��������ҳ��
	    		sqlpage = "select count(*) from goodsinfo where Gclass=cname";
    		}
    		mycart.setSql(sql);
    		//������ҳ��
    		int totalpage = DataBase.getTotalPage(sqlpage);
    		mycart.setTotalPage(totalpage);
    		session.setAttribute("mycart",mycart);
    		//�õ���һҳ������
    		Vector<String[]> vgoods = DataBase.getPageContent(1,sql);
    		if(vgoods.size()==0)
    		{//û���������û�Ҫ�ҵ���Ʒ
    			String msg = "�Բ���,û���ѵ���Ҫ����Ʒ!!!";
    			pageForward(msg,request,response);
    		}
    		else
    		{//��������Ϣ������
    			request.setAttribute("vgoods",vgoods);
    			String url = "/index.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);  
    		}
		}
		
		else if(action.equals("��ת"))
    	{//�û���ҳʱ
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
	    	if(mycart==null)
	    	{
	    		mycart = new cartBean();
	    	}
	    	//�õ������ҳ��
    		String curPage = request.getParameter("curPage");
    		String selPage = request.getParameter("selPage");
    		if(curPage!=null)
    		{//�û�ͨ�������,��һҳ��ťʱ
    			int page = Integer.parseInt(curPage.trim());
    			//��ס��ǰҳ
    			mycart.setCurPage(page);
    		}
    		else
    		{//���û���������б��ʱ
    			int page = Integer.parseInt(selPage.trim());
    			mycart.setCurPage(page);
    		}
    		//String sql = mycart.getSql(); 
    		String gsql="select Gimgurl,Gname,Gintro,Gclass,"+
        			"Gprice,Glook,Gid from goodsinfo";
    		//�õ���ҳ��ҳ�������
    		Vector<String[]> vgoods = DataBase.getPageContent(mycart.getCurPage(),gsql);
			request.setAttribute("vgoods",vgoods);
    		session.setAttribute("mycart",mycart);
			//���ص���ҳ
			String url = "/index.jsp";
    		ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);
    	}
		
		else if(action.equals("getDetail"))
    	{//�û�����õ�ĳ��Ʒ����ϸ��Ϣʱ
	    	//�õ���ƷID
    		String gid = request.getParameter("gid").trim();
    		String sql = "select Gimgurl,Gname,Gintro,Gclass,Gprice,"+
    						"Glook,Gid,Gbrief from GoodsInfo where Gid="+gid;
    		//���±��е������
    		String updatesql = "update GoodsInfo set Glook=Glook+1 where Gid="+gid;
    		DataBase.updateTable(updatesql);
    		//�õ�����Ʒ����ϸ��Ϣ
    		Vector<String[]> vgoods = DataBase.getPageContent(1,sql);
			request.setAttribute("vgoods",vgoods);
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher("/goodsdetail.jsp"); 
			rd.forward(request,response);
    	}
		
		else if(action.equals("�޸�"))
    	{//�û��޸ĸ�����Ϣ
    		//�õ��û��޸ĺ����Ϣ
    		String upwd = request.getParameter("upwd").trim();
    		String uemail = request.getParameter("uemail").trim();
    		String uname = (String)session.getAttribute("user");
    		//������ת��
    		//uname = new String(uname.getBytes(),"ISO-8859-1");
    		//�������ݿ��û���Ϣ
    		String sql = "update UserInfo set upwd='"+upwd
    					+"',uemail='"+uemail+"' where uname='"+uname+"'";
    		int i = DataBase.updateTable(sql);
    		if(i==0)
    		{//������Ϣʧ��
    			String msg = "�Բ���,��Ϣ�޸�ʧ��!!!";
    			pageForward(msg,request,response);	
    		}
    		else
    		{//��Ϣ�޸ĳɹ�
    			String msg = "��ϲ��,��Ϣ�޸ĳɹ�!!!";
    			pageForward(msg,request,response);    			
    		}
    	}
		
		else if(action.equals("logout"))
    	{//���û�ע����¼ʱ
    		//��sessionʧЧ
			request.getSession(true).invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
    	//	request.getSession(true).invalidate();
    	//	response.sendRedirect("index.jsp");
	}
		
		else if(action.equals("buy"))
    	{//�û��������ʱ
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
	    	if(mycart==null)
	    	{
	    		mycart = new cartBean();
	    	}
	    	//�õ�Ҫ��������ID
    		String gid = request.getParameter("gid").trim();
    		//�ж������Ƕ���Ĺ���,0-������ͼ����,1-����ϸ��Ϣ�����
    		String flag = request.getParameter("flag").trim();
    		mycart.buy(gid);
    		//�õ�������ǰ���ݵ�sql
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
    			//���غ�,�õ�ҳ������
        		Vector<String[]> vgoods = DataBase.getPageContent(page,sql);   		
        		if(vgoods.size()==0)
        		{//û���������û�Ҫ�ҵ���Ʒ
        			String msg = "�Բ���,û���ѵ���Ҫ����Ʒ!!!";
        			pageForward(msg,request,response);
        		}
        		 		
    			request.setAttribute("vgoods",vgoods);
    			//forward��Ҫȥ��ҳ��
        		
			}
			
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);
    	}	
		
		else if(action.equals("clear")){
			//�û���չ��ﳵ
			cartBean mycart = (cartBean)session.getAttribute("mycart");
			mycart.clearCart();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		else if(action.equals("changeNum"))
    	{//�û��޸Ĺ��ﳵ����Ʒ����ʱ
    		//�õ��޸���Ʒ��ID���޸ĺ������
    		String gnum = request.getParameter("gnum").trim();
    		String gid = request.getParameter("gid").trim();
    		int num = 0;
    		try
    		{
    			num = Integer.parseInt(gnum);
    		}
    		catch(Exception e)
    		{
    			//�޸ĵ��������Ϸ�ʱ
    			String msg = "�Բ���,�����޸Ĵ���!!!";
    			pageForward(msg,request,response); 
    		}
    		int id = Integer.parseInt(gid);
    		//�õ��������
    		String sql = "select Gamount from GoodsInfo where Gid="+id;
			int count = DataBase.getSelectId(sql);
    		if(count<num)
    		{//����������޸ĵ�ֵʱ
    			String msg = "�Բ��𣬿�治�����������ֻ�� "+count;
    			pageForward(msg,request,response);
    		}
    		else
    		{//����湻ʱ
	    		cartBean mycart = (cartBean)session.getAttribute("mycart");
	    		if(mycart==null)
	    		{
	    			mycart = new cartBean();
	    		}
	    		//�õ��û��Ĺ��ﳵ
	    		Map<String,Integer> cart = mycart.getCart();
	    		//�޸���Ʒ����
	    		cart.put(gid,num);
	    		session.setAttribute("mycart",mycart);
	    		response.sendRedirect("cart.jsp");    			
    		}
    	}
    	else if(action.equals("balance"))
    	{//���������ʱ���жϸ���Ʒ�����Ƿ�
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
    		if(mycart==null)
    		{
    			mycart = new cartBean();
    		}
    		//�õ��û��Ĺ��ﳵ
    		Map<String,Integer> cart = mycart.getCart();
    		Set<String> gid = cart.keySet();
    		String msg = "";
    		for(String str:gid)
    		{
    			//�õ���ƷID������
    			int id = Integer.parseInt(str);
    			int count = cart.get(str);
    			//�õ��������Ʒ������
	    		String sql = "select Gamount from GoodsInfo where Gid="+id;
				int gamount = DataBase.getSelectId(sql);
    			if(gamount<count)
    			{
    				//�õ�����Ʒ������
    				String temp = "select Gname from GoodsInfo where Gid="+id;
    				Vector<String> vname = DataBase.getInfo(temp);
    				String name = vname.get(0);
    				msg += "�Բ���"+name+"�Ŀ��ֻ��"+gamount+"<br/>";
    			}
    		}
    		if(msg.equals(""))
    		{//��msgΪ��ʱ�������湻
    			response.sendRedirect("receiverinfo.jsp");
    		}
    		else
    		{//��ʾ�û���治��
    			pageForward(msg,request,response);
    		}
    	}
    	else if(action.equals("delete"))
    	{//�û�ɾ�����ﳵ�е���Ʒʱ
    		//�õ�ɾ����Ʒ��ID
    		String gid = request.getParameter("gid").trim();
    		//�õ�javaBean����
    		cartBean mycart = (cartBean)session.getAttribute("mycart");
    		if(mycart==null)
    		{
    			mycart  = new cartBean();
    		}
    		mycart.removeItem(gid);
    		session.setAttribute("mycart",mycart);
    		response.sendRedirect("cart.jsp");
    	}
		
    	else if(action.equals("�ջ�����Ϣ�޸�"))
    	{//�û��޸��ջ�����Ϣʱ
    		String recname = request.getParameter("recname").trim();
    		String recadr = request.getParameter("recadr").trim();
    		String rectel = request.getParameter("rectel").trim();
    		String[] recMsg = (String[])session.getAttribute("recMsg");
    		//���ջ�����ϢΪ��ʱ
    		if(recMsg==null)
    		{
    			//�ض�����ҳ
    			response.sendRedirect("index.jsp");
    		}
    		else
    		{
    			//�޸�session�����ջ��˵���Ϣ
	    		recMsg[0] = recname;
	    		recMsg[1] = recadr;
	    		recMsg[2] = rectel;
	    		session.setAttribute("recMsg",recMsg);
	    		response.sendRedirect("order.jsp");    			
    		}

    	}
		
    	else if(action.equals("orderConfirm"))
    	{//���û�ȷ�϶�������ʱ
       		cartBean mycart = (cartBean)session.getAttribute("mycart");
       		//�ö���Ϊ��,�򷵻���ҳ
	    	if(mycart==null)
	    	{
	    		request.getRequestDispatcher("index.jsp").forward(request, response);
	    	}
	    	else
	    	{
		    	//�õ��򶩵�������Ϣ���в������ݵ�sql
	    		String[] recMsg = (String[])session.getAttribute("recMsg");
	    		double oprice = mycart.getAccount();
	    		int oid = DataBase.getID("OrderInfo","Oid");
	    		String uname = (String)session.getAttribute("user");
	    		String sql = "select Uid from UserInfo where Uname='"+uname+"'";
	    		int uid = DataBase.getSelectId(sql);
	    		String upsql = "insert into OrderInfo(Oid,Odate,Ostate,Orecname,"+
	    					"Orecadr,Orectel,Uid,Ototalprice) values("+oid+
	    					",now(),'δ����','"+recMsg[0]+"','"+recMsg[1]+"','"+
	    					recMsg[2]+"',"+uid+","+oprice+")";			
	    		//�õ��򶩵�������в������ݵ�sql
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
	    		//ִ�и�����
	    		boolean flag = DataBase.batchSql(sqlarr);
	    		String msg = "";
	    		if(!flag)
	    		{
	    			msg = "�Բ���,�����ύʧ��";
	    		}
	    		else
	    		{
	    			msg = "��ϲ��,�����ύ�ɹ�";
	    		}
	    		//���ջ�����Ϣ��javaBean������Ϊ��
	    		session.setAttribute("recMsg",null);
	    		session.setAttribute("mycart",null);
	    		pageForward(msg,request,response);
	    	}
    	}	
		
    	else if(action.equals("saveRec"))
    	{//�����ջ�����Ϣ����session
    		//�յ�������
    		String recname = request.getParameter("recname");
    		String recadr = request.getParameter("recadr");
    		String rectel = request.getParameter("rectel");
    		String[] recMsg = new String[3];
    		recMsg[0] = recname.trim();
    		recMsg[1] = recadr.trim();
    		recMsg[2] = rectel.trim();
    		//����session���ض��򵽶���ҳ
    		session.setAttribute("recMsg",recMsg);
    		request.getRequestDispatcher("order.jsp").forward(request, response);
    	}
		
    	else if(action.equals("orderSearch"))
    	{//��������
    		//�õ�javaBean����
    		String uname= (String) session.getAttribute("user");
    		String sql1 = "select Uid from userInfo where Uname='" + uname + "'";
			int flag = DataBase.selectid(sql1);//��¼�ߵı��
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
    		//��ÿҳ��¼����Ϊ10
    		DataBase.setSpan(10);
    		adBean.setCurPage(1);
    		if(txtsearch!=null)
    		{//�û����ı�����������������
	    		int oid = Integer.parseInt(txtsearch.trim());
	    		String s="select Uid from OrderInfo where Oid="+oid ;
	    		//flag1=DataBase.selectid(s);//�¶������û���Ӧ���û����
	    		//System.out.println(flag1);
	  			sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
	  					" where Oid="+oid+" and OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
	  	adBean.setSql(sql);
	  			adBean.setTotalPage(1); 
	    	
	    		//������ҳ��
	    		   			
    		}
    		else
    		{
    			String sqlpage = "";
    			if(type.trim().equals("all"))
    			{//��ѯ���ж���
  					sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
  						" where OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
  					sqlpage = "select count(*) from OrderInfo";
    			}
    			else if(type.trim().equals("yes"))
    			{//��ѯ�����ѷ�������
			  		sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
			  				" where Ostate='�ѷ���' and OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
			  		sqlpage = "select count(*) from OrderInfo where Ostate='�ѷ���'";
    			}
    			else if(type.trim().equals("no"))
    			{//��ѯ����δ��������
			  		sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
			  				" where Ostate='δ����' and OrderInfo.Uid=UserInfo.Uid and OrderInfo.Uid="+flag;
			  		sqlpage = "select count(*) from OrderInfo where Ostate='δ����'";
    			}
    			//ת��
		  	//	sqlpage = new String(sqlpage.getBytes(),"ISO-8859-1");
		  	//	sql = new String(sql.getBytes(),"ISO-8859-1");
		  		int totalpage = DataBase.getTotalPage(sqlpage);
		  		adBean.setSql(sql);
		  		//��ס��ǰ��ҳ��
		  		adBean.setTotalPage(totalpage);
    		}
    		session.setAttribute("adBean",adBean);
    		//�õ���һҳ������
    		Vector<String[]> vorder = DataBase.getPageContent(1,sql);
    		DataBase.setSpan(2);
    		if(vorder.size()==0)
    		{//û���������û�Ҫ�ҵ���Ʒ
    			String msg = "�Բ���,û���ѵ���Ҫ��ѯ�Ķ���!!!";
    			String url = "/error.jsp";
    			pageForward(msg,request,response);
    		}
    		else
    		{//��������Ϣ������
    			request.setAttribute("vorder",vorder);
    			String url = "/meordermanage.jsp";
	    		ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
    		}
    	}
		
    	else if(action.equals("orderPageChange"))
    	{//������ҳʱ
    		//�õ�javaBean����
    		AdminBean adBean = (AdminBean)session.getAttribute("adBean");
    		if(adBean==null)
    		{
    			adBean = new AdminBean();
    		}
    		//���ܲ���
    		String curPage = request.getParameter("curPage");
    		String selPage = request.getParameter("selPage");
    		//���õ�ǰҳ��¼����Ϊ10
    		DataBase.setSpan(10);
    		if(curPage!=null)
    		{//�û�ͨ�������,��һҳ��ťʱ
    			int page = Integer.parseInt(curPage.trim());
    			//��ס��ǰҳ
    			adBean.setCurPage(page);
    		}
    		else
    		{//���û���������б��ʱ
    			int page = Integer.parseInt(selPage.trim());
    			adBean.setCurPage(page);
    		}
    		//�õ���ǰ��ҳ��ִ�е�sql
    		String sql = adBean.getSql();
    		//�õ���ҳ��ҳ�������
    		Vector<String[]> vorder = DataBase.getPageContent(adBean.getCurPage(),sql);
			request.setAttribute("vorder",vorder);
    		session.setAttribute("adBean",adBean);
    		//�ָ���¼���Ϊ2
    		DataBase.setSpan(2);
    		//forward���޸ĵ���ҳ��
			String url = "/meordermanage.jsp";
    		ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);
    	}
    	
    	else if(action.equals("ordermanage"))
    	{//����鿴/����ʱ
    		String oid = request.getParameter("oid").trim();
    		int id = Integer.parseInt(oid);
    		//�õ������Ļ�����Ϣ
    		String osql = "select Orecname,Orecadr,Orectel,Odate,Ostate,Oid from OrderInfo"+
    							" where Oid="+id;
    		Vector<String[]> vorderinfo = DataBase.getInfoArr(osql);
    		//�õ������л�����Ϣ
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
		JFreeChart chart = ChartFactory.createPieChart("��Ʒ����ָ������ͼ", // ͼ�����
				
				 cz.selectAll1(), // ���ݼ�	
				true, // �Ƿ����ͼ��
				false, // �Ƿ����ͼ��˵��
				false // �Ƿ��������
				);
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN"); // ����������ʽ
		standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20)); // ���ñ�������
		standardChartTheme.setRegularFont(new Font("΢���ź�", Font.PLAIN, 15)); // ����ͼ��������
		standardChartTheme.setLargeFont(new Font("΢���ź�", Font.PLAIN, 15)); // �������������
		ChartFactory.setChartTheme(standardChartTheme);
		return chart;

		
	}
}
