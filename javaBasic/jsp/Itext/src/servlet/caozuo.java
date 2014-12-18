package servlet;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class caozuo {
	public List<D> read() {
		List<D> list = new ArrayList<D>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		//String sql="select * from yonghu where Id=?";
		try {
			con = Jdbc.getCon();
			ps=con.prepareStatement("select * from Curriculum");
			//ps.setString(1, ii);
			//System.out.println("select * from yonghu where Id=?");
			rs=ps.executeQuery();
			while (rs.next()) {
				D d = new D();
				 d.setYi(rs.getString("xingqiyi"));
				 d.setEr(rs.getString("xingqier"));
				 d.setSan(rs.getString("xingqisan"));
				 d.setSi(rs.getString("xingqisi"));
				 d.setWu(rs.getString("xingqiwu"));
				 d.setLiu(rs.getString("xingqiliu"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return list;
	}
}
