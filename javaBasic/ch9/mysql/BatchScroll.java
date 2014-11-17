package mysql;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class BatchScroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("������ʾ��ҳ����");
		int page = scan.nextInt();
		
		//batchSql();
		//scroll(page);
		srollSql(page);
		System.out.println("��һҳ��");
		srollSql(page-1);
		System.out.println("��һҳ��");
		srollSql(page+1);
		System.out.println("��ǰҳ��");
		srollSql(1);
		System.out.println("���ҳ��");
		srollSql(100);
		
	}

//	static void batchSql() {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "insert into test(sno,sname,birthday,salary)values(?,?,?,?)";
//
//		try {
//			con = Jdbc.getCon();
//			ps = con.prepareStatement(sql);
//
//			for (int i = 10; i < 20; i++) {
//				ps.setString(1, "" + i);
//				ps.setString(2, "new" + i);
//				ps.setDate(3, new Date(System.currentTimeMillis()));
//				ps.setBigDecimal(4, new BigDecimal("100" + i));
//				ps.addBatch();
//			}
//
//			int[] i = ps.executeBatch();
//			// System.out.println(i+"rows");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		} finally {
//			Jdbc.free(rs, ps, con);
//		}
//	}

	static void scroll(int page) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from fenye";
		int lines;

		try {
			con = Jdbc.getCon();
			ps = con.prepareStatement(sql, 

ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();

			// ���������
			rs.last();
			int totalRows = rs.getRow();

			// ��ҳ��
			int pageSize = 4;
			int totalPages;

			if (totalRows % pageSize == 0) {
				totalPages = totalRows / pageSize;
			} else {
				totalPages = totalRows / pageSize + 1;
			}
			if (page > totalPages) {
				page = totalPages;
				System.out.println("��ǰ���ҳ��Ϊ��" + page);
			}
			rs.absolute((page - 1) * pageSize + 1);
			int i = 0;
			do {
				i++;
				System.out.println(rs.getString("sno") + "\t"
						+ rs.getString("sname") + "\t" + 

rs.getDate("birthday")
						+ "\t" + rs.getBigDecimal("salary"));
			} while (rs.next() && i < pageSize);
			System.out.println("--------------------" + page
					+ "-------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
	}

	static void srollSql(int page) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =null;
			try {
			con = Jdbc.getCon();
			// ���������
			
			int totalRows=0;
			ps = con.prepareStatement("select count(*) from test");
			rs = ps.executeQuery();
			if (rs.next())
			 {
				 totalRows=rs.getInt(1);
			 }
			 
			// ��ҳ��
			int pageSize = 4;
			int totalPages;

			if (totalRows % pageSize == 0) {
				totalPages = totalRows / pageSize;
			} else {
				totalPages = totalRows / pageSize + 1;
			}
			
			if (page <=0) {
				page =1;
				System.out.println("��ʼҳ��Ϊ��" + page);
			}
			if (page > totalPages) {
				page = totalPages;
				System.out.println("��ǰ���ҳ��Ϊ��" + page);
			}
			
			sql= "select * from test limit ?,?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,pageSize*(page-1));
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			
			int i = 0;
			 while (rs.next())
			 {
				i++;
				System.out.println(rs.getString("sno") + "\t"
						+ rs.getString("sname") + "\t" + 

rs.getDate("birthday")
						+ "\t" + rs.getBigDecimal("salary"));
			}
			System.out.println("--------------------" + page
					+ "-------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
	}
	
}
