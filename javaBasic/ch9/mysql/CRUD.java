package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
     public static void main(String[] args){
    	
    	 write("insert into test(sno,sname,birthday,age) values(1204,'xiaohua','1993-12-30',19)");
    	 read("select * from test");  
    	 write("update test set age=age+1");
    	 read("select * from test"); 
    	write("delete from test where sno=1204 ");
    	 read("select * from test");
     }
   static  void  read(String sql)
     {
    	 Connection con=null;
    	 Statement sm=null;
    	 ResultSet rs=null;
    	// String sql="select * from xs";
    	 
    	 try {
    		 con=Jdbc.getCon();
			sm=con.createStatement();
			//System.out.println(sql);
			rs=sm.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getObject("sno")+"\t"+rs.getObject("birthday")+"\t"+rs.getObject("age"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			Jdbc.free(rs, sm, con);
		}
     }  
   static  int  write(String sql)
     {
    	 Connection con=null;
    	 Statement sm=null;
    	 ResultSet rs=null;
    	 int rows=0;
    	// String sql="select * from xs";
    	 
    	 try {
    		con=Jdbc.getCon();
			sm=con.createStatement();
			System.out.println(sql);
			rows=sm.executeUpdate(sql);
			System.out.println(rows+"rows effect");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			Jdbc.free(rs, sm, con);
		}
    	 return rows;
     }
}
