package mysql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDataType {

	private static int i;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		table t = new table();
		read(t);
		write(t);
	}

	static table  read(table t) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from test where sname=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "yinzhiying");
			// System.out.println(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getObject(1));
				t.sno = rs.getString("sno");
			    t.sname = rs.getString("sname");
				t.birthday = rs.getDate("birthday");
				t.age = rs.getInt("age");
				t.salary = rs.getBigDecimal("salary");
				t.score = rs.getDouble("score");

				System.out.print(t.sno + "\t");
				System.out.print(t.sname + "\t");
				System.out.print(t.birthday + "\t");
				System.out.print(t.age + "\t");
				System.out.print(t.salary + "\t");
				System.out.println(t.score);
				// test
//				System.out.println(rs.getTimestamp("birthday"));
//				System.out.println(rs.getTime("birthday"));
//				java.util.Date d = new java.util.Date(birthday.getTime());
//				System.out.println(d);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

		return t;
	}

	static void write(table t) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into test(sno,sname,birthday,age,salary,score)"
				+ " values(?,?,?,?,?,?)";
		// String sql="delete from test where sno=? ";
		// String sql="select * from xs";
		// String sql="Update test set age=age-?";
		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			// ps.setInt(1,1);
			ps.setString(1, t.sno);
			System.out.println(t.sname);
			ps.setString(2, t.sname);
			ps.setDate(3, t.birthday);
			ps.setInt(4, t.age);
			System.out.println(t.salary);

			ps.setBigDecimal(5, t.salary);
			
			ps.setDouble(6, t.score);
						System.out.println(sql);
			int i = ps.executeUpdate();
			System.out.println(i + "rows effect");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

	}

}

class table {
	String sno;
	String sname;
	Date birthday;
	int age;
	BigDecimal salary;
	Double score;
}
