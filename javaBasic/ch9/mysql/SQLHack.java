package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHack {
	public static void main(String[] args) {
		// String sql="select sname from test where sno=?";
		// CRUD.read(sql);
	
		// sno="1202";
		// sno="'1202'or 1";
		// sql=sql+sno;
		// System.out.println("SQL:"+sql);
		// CRUD.read(sql);
		
		rread();

	}

	static void rread() {
		Connection con = null;
		// Statement sm=null;
		PreparedStatement ps = null;
		//String sno;
		ResultSet rs = null;
		// String sql="select * from xs";
		String sql = "select birthday from test where sno=?";
		try {
			con = Jdbc.getCon();
			// sm=con.createStatement();
			// System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, "1203");

			rs = ps.executeQuery();
			// rs=sm.executeQuery(sql);
			while (rs.next()) {
				// System.out.println(rs.getObject("sno")+"\t"+rs.getObject("birthday")+"\t"+rs.getObject("age"));
				System.out.println(rs.getObject(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
	}
}
