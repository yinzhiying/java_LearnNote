package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servlet.Jdbc;

public class tools {
		public static boolean select(String username, String password) {
	        Connection con=null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
	            String sql="select password from student where name=?";
	            con=Jdbc.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String s1 = null;
			try {
				if (rs.next())
					s1 = rs.getString("password");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (s1.equals(password))
				return true;
			else
			   return false;
		}
	}