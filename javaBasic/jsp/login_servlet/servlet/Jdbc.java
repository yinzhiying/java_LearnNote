package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	private static String url = "jdbc:mysql://localhost:3306/xscj";
	private static String user = "root";
	private static String password = "";


	private Jdbc() {
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getCon() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void free(ResultSet rs, Statement stmt, Connection con)
			throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
