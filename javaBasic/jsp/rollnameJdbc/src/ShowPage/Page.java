package ShowPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Page {
	public static String scroll(int page) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name,image from person";
		String html = "";
		try {
			con = Jdbc.getCon();
			ps = (PreparedStatement) con
					.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

			rs = ps.executeQuery();

			rs.last();
			int size = rs.getRow();

			int pageSize = 3;
			int pageCount = 0;
			if (size % pageSize == 0) {
				pageCount = size / pageSize;
			} else {
				pageCount = size / pageSize + 1;
			}
			if (page > pageCount) {
				page = pageCount;
			}
			if (page <= 0) {
				page = 1;
			}
			int first=1;
			int last=pageCount;
			int before=page-1;
			if(before<=0)
			{
				before=first;
			}
			int next=page+1;
			if(next>pageCount)
			{next=last;
			}
			rs.absolute((page - 1) * pageSize + 1);
            html+="<table><tr><td><a href=\"insertdb.jsp\">����ѧ����Ϣ</a></td></tr>";
			html += "<table><tr><td>����</td><td>����</td><td>��Ƭ</td><td>����</td></tr>";
			int i = 0;
			do {
				i++;
				html += "<tr><td>" + rs.getString("id") + "</td><td>"
						+ rs.getString("name") + "</td><td>"
						+"<image src=\""+rs.getString("image")+"\" height=200 width=200>"
						 + "</td><td><a href=\"updatedb.jsp?id="+ rs.getString("id")+"\">�޸�</td>"
						  + "<td><a href=\"deletedb.jsp?id="+ rs.getString("id")+"\">ɾ��</td></tr>";

			} while (rs.next() && i < pageSize);
			html+="<tr><td>����"+size+"����¼���ϲ�ѯ����������"+pageCount+"ҳ����ǰΪ��"+page+"ҳ</td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+first+"\">��ҳ</a></td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+before+"\">ǰҳ</a></td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+next+"\">��ҳ</a></td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+last+"\">ĩҳ</a></td></tr>";
			html+="<tr><td><form action=\"\" method=\"post\">��ת��:<input type=\"text\" name=\"page\"><input type=\"submit\"></form></td></tr>";
			html += "</table>";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return html;
	}

}
