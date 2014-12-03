package jdbc;
import java.sql.*;

public class Jdbc {
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

	

