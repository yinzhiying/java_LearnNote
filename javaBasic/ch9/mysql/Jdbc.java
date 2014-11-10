package mysql;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Jdbc {
	 private static String url="jdbc:mysql://localhost:3306/xscj";
	 private static String user="root";
	 private static String password="";
    private Jdbc()
    {
    	 

    }
    static{
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   public static Connection getCon()
    {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
       
    }
    public static void free(ResultSet rs,java.sql.Statement sm,Connection con)
    {
    	try {
    		if(rs!=null)
    		{
			rs.close();
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
    	try {
    		if(sm!=null)
			{
    			sm.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		{
    	try {
    		if(con!=null)
			{
    			con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
    }
    }
}
