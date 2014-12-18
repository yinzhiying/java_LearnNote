package servlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Jdbc {

	private static String url = "jdbc:mysql://localhost:3306/xscj";
	private static String user = "root";
	private static String password = "";

	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getCon() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void free(ResultSet rs, Statement sm, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (sm != null)
					sm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	// 数据库通用读方法
	// select

	public static List readDB() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement("select * from Curriculum");

			/*if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}*/
			rs = ps.executeQuery();
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] columnName = new String[count];
			for (int i = 0; i < count; i++) {
				// System.out.println(rsmd.getColumnName(i+1));
				// System.out.println(rsmd.getColumnTypeName(i+1));
				columnName[i] = rsmd.getColumnName(i + 1);
			}
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object> ();
				for (int i = 0; i < count; i++) {
					map.put(columnName[i], rs.getObject(i + 1));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return list;
	}

	// 数据库通用写方法
	// 写模板insert,update,delete
	public static int writeDB(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return row;
	}

}
