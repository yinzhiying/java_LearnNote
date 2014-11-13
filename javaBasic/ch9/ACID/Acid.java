package Acid;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import mysql.Jdbc;

public class Acid {

	/**
	 * @param args
	 */
	static Connection con=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int s=transfer(1,"1234",2,"liming", new BigDecimal(100.00));
    System.out.println(s);
	}

	 static int transfer(int from, String Pwd, int to, String toName,
			BigDecimal num) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rsFrom = null;
		ResultSet rsTo = null;
		int temp = 0;

     try{
    	 BigDecimal fromSalary;
    	 BigDecimal toSalary;
    	 con = Jdbc.getCon();
    	con.setAutoCommit(false);
    	 
    	 rsFrom=read(from);
    	 rsTo=read(to);
    	 
    	 if(login(from,Pwd,con)){
    		 System.out.println("登陆成功");
    		 if(verifyName(toName,rsTo)){
    			 System.out.println("姓名匹配");
    			 rsFrom=read(from);
    			 rsTo=read(to);
    			 if(rsFrom.next()){
    				 fromSalary=rsFrom.getBigDecimal("salary");
    				 if(rsTo.next()){
    					 toSalary=rsTo.getBigDecimal("salary");
    					 UpdateAccount test=new UpdateAccount();
    					 if(test.Update(fromSalary, toSalary, from, to,num,con)){
    						 System.out.println("转账成功");
    						 temp=1;
    					 }else{
    						 System.out.println("金额不足");
    						 temp=-2;
    					 }
    				 }
    			 }
    		 }else{
    			 System.out.println("姓名不匹配");
    			 temp=-3;
    		 }
    	 }else{
    		 System.out.println("密码不正确");
    		 temp=-1;
    	 }
    	 if(temp==1){
    		 con.commit();
    		 
    	 }else{
    		 con.rollback();
    	 }
     }catch(SQLException e){
    	try{
    		if(con!=null){
    	
    		 con.rollback();
    		}
    	 }catch(SQLException e1){
    		 e1.printStackTrace();
    	 }
    	 e.printStackTrace();
    	}
    	 finally{
    		 //Jdbc.freeConnection(con);
    	 }
switch(temp){
case 1:
	return 1;
case -1:
	return  -1;
case -2:
   return -2;
case -3:
   return -3;
default:
	return 0;
	
}
     }
	

	private static ResultSet read(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,pwd,name,salary FROM bank WHERE id=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@SuppressWarnings("finally")
	private static boolean login(int from, String pwd, Connection con) {
		// TODO Auto-generated method stub
		CallableStatement cs = null;
		int temp = 0;

		try {
			cs = con.prepareCall("{Call verifyPerson(?,?,?)}");
			cs.setInt(1, from);
			cs.setString(2, pwd);
			cs.registerOutParameter(3, Types.INTEGER);

			// 执行
			cs.executeUpdate();
			temp = cs.getInt(3);
			System.out.print(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (temp == 1) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean verifyName(String toName, ResultSet rsTo) {
		// TODO Auto-generated method stub
		String Name = null;
		int i = 0;
		try {
			if (rsTo.next()) {
				Name = rsTo.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (toName.trim().equals(Name.trim())) {
			i = 1;
		}
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

}
