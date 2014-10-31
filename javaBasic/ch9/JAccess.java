import java.sql.*;
public class JAccess {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       read();
       create();
	}
   static void read() throws SQLException
   {
	   Connection con=null;
       Statement stmt=null;
       ResultSet rs=null;
       
      // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       con=JdbcTool.getConnection();
       
       stmt=con.createStatement();
       rs=stmt.executeQuery("select * from personal");
       System.out.println("name"+"\t"+"password"+"\t");
       while(rs.next())
       {
       System.out.print(rs.getObject("name")+"\t");
       System.out.println(rs.getObject("password"));
       }
       //con.close();
       JdbcTool.free(rs, stmt, con);
   }
   static void create() throws SQLException
   {
	   Connection con=null;
       Statement stmt=null;
       ResultSet rs=null;
       
      // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       con=JdbcTool.getConnection();
       
       stmt=con.createStatement();
       //rs=stmt.executeQuery("select * from personal");
       int i=stmt.executeUpdate("insert into personal(name,password) values('–°¿Ó','8888')");
       
       //System.out.println("name"+"\t"+"password"+"\t");
//       while(rs.next())
//       {
//       System.out.print(rs.getObject("name")+"\t");
//       System.out.println(rs.getObject("password"));
//       }
//       //con.close();
    		   System.out.println(i+"rows effects. ");
      JdbcTool.free(rs, stmt, con);
    		   
       
   }
}   
