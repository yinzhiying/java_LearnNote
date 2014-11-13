package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.Jdbc;

public class PersonDaoJdbc implements PersonDao {

	@Override
	public Person findPerson(String sno) {
		// TODO Auto-generated method stub
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from test where sno=?";

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			// System.out.println(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				
				return mapplingPerson(rs);
				// System.out.println(rs.getObject(1));
//				t.sno = rs.getString("sno");
//			    t.sname = rs.getString("sname");
//				t.birthday = rs.getDate("birthday");
//				t.age = rs.getInt("age");
//				t.salary = rs.getBigDecimal("salary");
//				t.score = rs.getDouble("score");
//
//				System.out.print(t.sno + "\t");
//				System.out.print(t.sname + "\t");
//				System.out.print(t.birthday + "\t");
//				System.out.print(t.age + "\t");
//				System.out.print(t.salary + "\t");
//				System.out.println(t.score);
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
		return null;
	}
	private Person mapplingPerson(ResultSet rs) throws SQLException {
		Person p=new Person();
		p.setSno(rs.getString("sno"));
		p.setSname(rs.getString("sname"));
		p.setBirthday(new java.util.Date(rs.getDate("birthday").getTime()));
		p.setState(rs.getInt("state"));
		return p;
	}
	@Override
	public boolean invalidPerson(Person p) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="update test set sname=? where sno=?";
		// String sql="delete from test where sno=? ";
		// String sql="select * from xs";
		// String sql="Update test set age=age-?";
		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			// ps.setInt(1,1);
			ps.setString(1, "joy");
			ps.setString(2, p.getSno());
//			System.out.println(t.sname);
//			ps.setString(2, t.sname);
//			ps.setDate(3, t.birthday);
//			ps.setInt(4, t.age);
//			System.out.println(t.salary);
//
//			ps.setBigDecimal(5, t.salary);
//			
//			ps.setDouble(6, t.score);
//						System.out.println(sql);
			int i = ps.executeUpdate();
			//System.out.println(i + "rows effect");
         if(i>0)
         {
        	 return true;
         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}

		return false;
	
		
	}
	@Override
	public boolean newPerson(Person p) {
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="insert into test(sno,sname,birthday,state) values(?,?,?,?)";
		// String sql="delete from test where sno=? ";
		// String sql="select * from xs";
		// String sql="Update test set age=age-?";
		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql);
			 ps.setString(1,p.getSno());
			ps.setString(2, p.getSname());
//			System.out.println(t.sname);
			ps.setDate(3,new java.sql.Date(p.getBirthday().getTime()));
//			ps.setDate(3, t.birthday);
			ps.setInt(4, p.getState());
//			System.out.println(t.salary);
//
//			ps.setBigDecimal(5, t.salary);
//			
//			ps.setDouble(6, t.score);
//						System.out.println(sql);
			int i = ps.executeUpdate();
			//System.out.println(i + "rows effect");
      if(i>0)
      {
    	  return true;
      }		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new DaoException("登记信息未成功");
		} finally {
			Jdbc.free(rs, ps, con);
		}

		// TODO Auto-generated method stub
		return false;
	}

}
