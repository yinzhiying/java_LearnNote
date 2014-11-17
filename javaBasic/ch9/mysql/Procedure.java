package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class Procedure {
	

	public static void main(String[] args) {

		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		
		try{
			con=Jdbc.getCon();
			cs=con.prepareCall("{call newProcedure(?,?,?)}");
			
			cs.setString(1,"9001");
			cs.setString(2,"9000");
	
			cs.registerOutParameter(3, Types.BOOLEAN);
			
			cs.executeUpdate();
			System.out.println(cs.getBoolean(3));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, cs, con);
		}
		
	}

}
