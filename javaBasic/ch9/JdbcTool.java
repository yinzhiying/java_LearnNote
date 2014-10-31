import java.sql.*;
final class JdbcTool {
    private static String url="jdbc:odbc:javaaccess";
    
    private JdbcTool()
    {
    	
    }
    static
    {
    	 try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new ExceptionInInitializerError(e);
			
		}
    	 
    }
    public static Connection getConnection() throws SQLException
    {
    	return DriverManager.getConnection(url);
    	
    }
    public static void free(ResultSet rs,Statement st,Connection conn)
    {
    	if(rs!=null)
    	{
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		finally
        	{
        		if(st!=null)
        		{
        			try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			finally
        			{
        				if(conn!=null)
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        			}
        		}
        	}
    	}
    	
    }
}
