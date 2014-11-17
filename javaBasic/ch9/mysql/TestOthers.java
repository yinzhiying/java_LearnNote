package mysql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class TestOthers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sqlBatch();
	scrollShow(1);
	}

	
	

	static void sqlBatch() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into test(sno,sname,birthday,salary) values(?,?,?,?)";

		try {
			con = Jdbc.getCon();
			ps = (PreparedStatement) con.prepareStatement(sql);

			for (int i = 0; i < 100; i++) {
				ps.setString(1, "" + i);
				ps.setString(2, "name" + i);
				ps.setDate(3, new Date(System.currentTimeMillis()));
				ps.setBigDecimal(4, new BigDecimal("" + i + ".50"));
				ps.addBatch();
			}
			int[] i = ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
	}

	static void scrollShow(int page) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select sno,sname,birthday,salary from test";

		try {
			con = Jdbc.getCon();
			ps = (PreparedStatement) con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();
			
			rs.last();
			int size=rs.getRow();
			
			int pageSize=3;
			int pageCount=0;
			if(size%pageSize==0){
			pageCount=size/pageSize	;
			}else
			{
				pageCount=size/pageSize+1;
			}
			if(page>pageCount)
			{
				page=pageCount;
			}
			rs.absolute((page-1)*pageSize+1);
			
			int i=0;
			do
			{
				i++;
				System.out.println(rs.getString("sno")+"\t"+
						rs.getString("sname")+"\t"+
						rs.getDate("birthday")+"\t"+
						rs.getBigDecimal("salary"));
			}while(rs.next()&&i<pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
	}
}
