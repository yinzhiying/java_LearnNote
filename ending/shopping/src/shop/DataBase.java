package shop;



import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.jfree.data.general.DefaultPieDataset;



public class DataBase {
	
	//����ÿҳ��ʾ��Ʒ������
		private static int span=2;
		
		public static int getSpan()
		{
			return span;
		}
		
		public static void setSpan(int i)
		{
			span = i;
		}
	// �û���¼�ж�
		public static boolean isLegal(String sql)
		{
			boolean flag = false;
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con=Jdbc.getCon();
			try
			{
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
	            if(rs.next())
	            {
	            	flag = true;
	            }			
	            Jdbc.free(rs, ps, con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return flag;
		}

	public static  boolean select(String sql){
		//�����û���
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con=Jdbc.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
			Jdbc.free(rs, ps, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static  int selectid(String sql){
		//�����û���
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id1=0;
		con=Jdbc.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				id1=rs.getInt("Uid");
				return id1;
			}
			Jdbc.free(rs, ps, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	public static int getID(String tname,String colname)
	{
		//��ȡID���
		int id = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select Max("+colname+") from "+tname;
		con=Jdbc.getCon();
		try
		{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
            if(rs.next())
            {
            	id = rs.getInt(1);
            }
            id++;
            Jdbc.free(rs, ps, con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}	
	
	public static int addUser(String sql) {
		//����û�
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		con = Jdbc.getCon();
		try {
			ps = con.prepareStatement(sql);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (row >= 1)
			Jdbc.free(rs, ps, con);
		return row;
	}

	public static Vector<String> getInfo(String sql) {
		Vector<String> vclass = new Vector<String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = Jdbc.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String str = rs.getString(1);
				// str = new String(str.getBytes("ISO-8859-1"),"gb2312");
				vclass.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Jdbc.free(rs, ps, con);
		return vclass;
	}

	public static int getTotalPage(String sql)
	{
		//��ȡ��ҳ��
		int totalpage = 1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = Jdbc.getCon();
		
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				rs.next();
				//�õ��ܼ�¼����
				int rows = rs.getInt(1);
	            totalpage = rows/span;
	            if(rows%span!=0)
	            {
	            	totalpage++;
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}           
            //�رս����,���
           Jdbc.free(rs, ps, con);
		
		return totalpage;
	}
	
	public static Vector<String[]> getPageContent(int page,String sql)
	{
		//������ǰҳ��ʾ����Ʒ
		Vector<String[]> vcon = new Vector<String[]>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = Jdbc.getCon();
		try
		{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
            //��ȡ�������Ԫ����
            ResultSetMetaData rsmt = rs.getMetaData();
            //�õ�������е�������
            int count = rsmt.getColumnCount();
            int start = (page-1)*span;
            if(start!=0)
            {
            	rs.absolute(start);
            }
			int temp=0;
            while(rs.next()&&temp<span)
            {
            	temp++;
            	String[] str = new String[count];
            	for(int i=0;i<str.length;i++)
            	{
            		str[i] = rs.getString(i+1);
            		//ת��
            	//	str[i] = new String(str[i].getBytes("ISO-8859-1"),"utf-8");
            	}
            	vcon.add(str);
            }
            //�رս����,���
            Jdbc.free(rs, ps, con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vcon;
	}
	
	public static int updateTable(String sql)
	{
		//���±�
		int i = 0;
		try
		{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			i = ps.executeUpdate();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public static Vector<String[]> getInfoArr(String sql)
	{
		Vector<String[]> vtemp = new Vector<String[]>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = Jdbc.getCon();
		try
		{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
            //��ȡ�������Ԫ����
            ResultSetMetaData rsmt = rs.getMetaData();
            //�õ�������е�������
            int count = rsmt.getColumnCount();
            while(rs.next())
            {
            	String[] str = new String[count];
            	for(int i=0;i<count;i++)
            	{
            		str[i] = rs.getString(i+1);
            		//str[i] = new String(str[i].getBytes("ISO-8859-1"),"gb2312");
            	}
            	vtemp.add(str);
            }
            Jdbc.free(rs, ps, con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vtemp;
	}
	
	public static int getSelectId(String sql)
	{
		int id = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = Jdbc.getCon();
		try
		{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
            rs.next();
            id = rs.getInt(1);
           			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Jdbc.free(rs, ps, con);
		return id;
	}
	
	public static boolean batchSql(String[] sql)
	{
		boolean flag = true;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try
		{
           
            con = Jdbc.getCon();
            //�������
            st = con.createStatement();
            for(String str:sql)
            {
            	//str = new String(str.getBytes(),"ISO-8859-1");
            	//����������е�sql
            	st.addBatch(str);
            }
            //ִ��������
            st.executeBatch();
            //�������ύ
           	}
		catch(Exception e)
		{
			flag = true;
				}
		finally
		{
			Jdbc.free(rs, st, con);
		}
		return flag;
	}
	
	public DefaultPieDataset selectAll1() {
		//�������ɱ�������ݲ�ѯ
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DefaultPieDataset buylist = new DefaultPieDataset();
		try {
			con = Jdbc.getCon();
			pst = con.prepareStatement("select Gname,Glook from goodsinfo");
			rs = pst.executeQuery();
			while (rs.next()) {

				buylist.setValue(rs.getString("Gname"), rs.getInt("Glook"));
			}
			return buylist;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, pst, con);
		}
		return null;

	}

	public List<goods> read() {
		List<goods> list = new ArrayList<goods>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		//String sql="select * from yonghu where Id=?";
		try {
			con = Jdbc.getCon();
			ps=con.prepareStatement("select * from goodsinfo");
			//ps.setString(1, ii);
			//System.out.println("select * from yonghu where Id=?");
			rs=ps.executeQuery();
			while (rs.next()) {
				goods d = new goods();
				 d.setGid(rs.getInt("Gid"));
				 d.setGname(rs.getString("Gname"));
				 d.setGprice(rs.getDouble("Gprice"));
				 d.setGlass(rs.getString("Gclass"));
				 d.setGamount(rs.getInt("Gamount"));
				 d.setGlook(rs.getInt("Glook"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return list;
	}
	
}
