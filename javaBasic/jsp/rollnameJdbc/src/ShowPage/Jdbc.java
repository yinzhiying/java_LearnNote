package ShowPage;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
//import Page.Jdbc;

	public class Jdbc {
		public static void main(String args[]){
			 List<Map<String,Object>> list=Jdbc.readDB("select * from person where id="+2);
				
			 System.out.println(list);
			
			
			
		}
			private static String url = "jdbc:mysql://localhost:3306/xscj";
			private static String user = "root";
			private static String password = "";
			private Jdbc(){};
			static{
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			public static Connection getCon(){
				try {
					return DriverManager.getConnection(url, user, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			} 
			
			//数据库通用读方法
		public	static List<Map<String,Object>> readDB(String sql){
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			    
				try {
					con = Jdbc.getCon();
					ps =(PreparedStatement) con.prepareStatement(sql);
					
					
					rs=ps.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
				//测试rsmd方法使用	
					int count=rsmd.getColumnCount();
					String[] columnName=new String[count];
					for(int i=0;i<count;i++){
//						System.out.println(rsmd.getColumnName(i+1));
//						System.out.println(rsmd.getColumnTypeName(i+1));
						columnName[i]=rsmd.getColumnName(i+1);
					}
					while(rs.next()){
						HashMap<String,Object>map=new HashMap<String,Object>();
						for(int i=0;i<count;i++)
						{
						map.put(columnName[i], rs.getObject(i+1));
						}
						list.add(map);
					}
				}	catch(SQLException e){
				}finally{
					Jdbc.free(rs, ps, con);
				}
				return list;
				}
			
			
			//数据库通用写方法
		public	static int writeDB(String sql,Object[] params){
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int rows=0;
		    
			try {
				con = Jdbc.getCon();
				ps =(PreparedStatement) con.prepareStatement(sql);
				if(params!=null){
		    for(int i = 0;i<params.length;i++){
		    	ps.setObject(i+1, params[i]);
		    }
				}
				rows=ps.executeUpdate();
			}	catch(SQLException e){
			}finally{
				Jdbc.free(rs, ps, con);
			}
			return rows;
			}
			public static void free(ResultSet rs,Statement st,Connection con ){
				try {
					if(rs != null){
					rs.close();
					rs = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					try {if(st != null){
						st.close();
						st = null;
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if(con != null){
						con.close();
						con = null;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

			
				

		
		



