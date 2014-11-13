package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.Jdbc;

public class Acid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		transfer("1201","1202",new BigDecimal("100"));
	}
      static void  transfer(String from,String to,BigDecimal num)
     {
    	 Connection con = null;
 		PreparedStatement ps = null;
 		ResultSet rsFrom = null;
 		ResultSet rsTo = null;
 		String sql =null; 

 		try {
 			//BigDecimal salary;
 			BigDecimal fromSalary;
 			BigDecimal toSalary;
 			
 			con = Jdbc.getCon();
 			con.setAutoCommit(false);
 			
 			
 			
 			ps = con.prepareStatement("select salary from test where sno=?");
 		    ps.setString(1, from);
 		   fromSalary=rsFrom.getBigDecimal("salary");
 			rsFrom = ps.executeQuery();
 			//rsTo=ps.executeQuery();
 			
 			
 				
 				if (fromSalary.compareTo(num)>0){
 				if(rsFrom.next()){
 					ps = con.prepareStatement("update test set salary=? where sno=?");
 		 		    ps.setBigDecimal(1, fromSalary.subtract(num));
 		 		   ps.setString(2, from);
 		 		   System.out.println( ps.executeUpdate()+"rows effect.");
 		 		 toSalary=rsTo.getBigDecimal("salary");
 		 		 ps = con.prepareStatement("update test set salary=? where sno=?");
		 		    ps.setBigDecimal(1, toSalary.add(num));
		 		   ps.setString(2, to);
		 		   System.out.println( ps.executeUpdate()+"rows effect.");
 				/*f(rsTo.next()){
 		 		 toSalary=rsTo.getBigDecimal("salary");
 		 		 ps = con.prepareStatement("update test set salary=? where sno=?");
		 		    ps.setBigDecimal(1, toSalary.add(num));
		 		   ps.setString(2, to);
		 		   System.out.println( ps.executeUpdate()+"rows effect.");
 				}*/
 				}
 		         }
 			
         con.commit();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			try {
 				if(con!=null){
				con.rollback();
 				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 			
 			e.printStackTrace();
	} finally {
		Jdbc.free(rsFrom, ps, con);
		//
		}
     }
}
