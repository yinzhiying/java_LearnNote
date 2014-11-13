package Acid;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.PreparedStatement;

public class UpdateAccount {
  java.sql.PreparedStatement ps=null;
  UpdateAccount(){
	  
  }
  
  public boolean Update(BigDecimal fromSalary,BigDecimal toSalary,int from,int to,BigDecimal num,Connection con)
  {
       int temp=0;
       if(fromSalary.compareTo(num)>0){
    	   try{

    			ps = (PreparedStatement) con.prepareStatement("update bank set salary=?where id=?");
    		    ps.setBigDecimal(1, fromSalary.subtract(num));
    		    ps.setInt(2,from);
    			//rsFrom = ps.executeQuery();
    			 System.out.println( ps.executeUpdate()+"rows effect.");
    			
    			
    		 		 ps = con.prepareStatement("update bank set salary=? where id=?");
   		 		    ps.setBigDecimal(1, toSalary.add(num));
   		 		   ps.setInt(2, to);
   		 		   System.out.println( ps.executeUpdate()+"rows effect.");
   		 		   temp=1;
   		 		   recordLog(from,to,num,con);
    				}catch (SQLException e){
    					e.printStackTrace();
    				}
    				}
       if(temp==1){
    	   return true;
    		   }else {
    			   return false;
    		   }
    		         }
    		         public void recordLog(int from ,int to,BigDecimal num,Connection con){
    		        	 java.sql.PreparedStatement ps=null; 
    		        	 try {
    		     			ps = con.prepareStatement("INSERT INTO transferlog VALUES(?,?,?,?)");
    		     			ps.setInt(1, from);
    		     			ps.setInt(2, to);
    		     			ps.setBigDecimal(3, num);
    		     			//加入时间戳
    		     			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); 
    		     			System.out.println(ps.executeUpdate() + "row effect");
    		     		} catch (SQLException e) {
    		     			e.printStackTrace();
    		     		}

    		         }
    	   }
    