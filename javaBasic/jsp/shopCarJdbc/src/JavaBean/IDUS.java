package JavaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDUS {
	public List<GoodsSingle> selectAll() {

		List<GoodsSingle> list = new ArrayList<GoodsSingle>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = Jdbc.getCon();
			pst = con.prepareStatement("select * from shop");
			rs = pst.executeQuery();
			while (rs.next()) {
				GoodsSingle buylist = new GoodsSingle();
				buylist.setName(rs.getString(1));
				buylist.setPrice(rs.getFloat(2));
				buylist.setNum(rs.getInt(3));

				list.add(buylist);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, pst, con);
		}
		return null;
	}
	
	public List<Things> select() {

		List<Things> list = new ArrayList<Things>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = Jdbc.getCon();
			pst = con.prepareStatement("select * from things");
			rs = pst.executeQuery();
			while (rs.next()) {
				Things g = new Things();
				g.setName(rs.getString(1));
				g.setPrice(rs.getFloat(2));
				
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, pst, con);
		}
		return null;
	}

	public void insert(GoodsSingle buylist) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = Jdbc.getCon();
			pst = con.prepareStatement("insert into shop values(?,?,?)");
			pst.setString(1, buylist.getName());
			pst.setFloat(2, buylist.getPrice());
			pst.setInt(3, buylist.getNum());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, pst, con);
		}
	}

}

