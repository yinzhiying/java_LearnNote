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
            html+="<table><tr><td><a href=\"insertdb.jsp\">增加学生信息</a></td></tr>";
			html += "<table><tr><td>工号</td><td>姓名</td><td>照片</td><td>操作</td></tr>";
			int i = 0;
			do {
				i++;
				html += "<tr><td>" + rs.getString("id") + "</td><td>"
						+ rs.getString("name") + "</td><td>"
						+"<image src=\""+rs.getString("image")+"\" height=200 width=200>"
						 + "</td><td><a href=\"updatedb.jsp?id="+ rs.getString("id")+"\">修改</td>"
						  + "<td><a href=\"deletedb.jsp?id="+ rs.getString("id")+"\">删除</td></tr>";

			} while (rs.next() && i < pageSize);
			html+="<tr><td>共有"+size+"条记录符合查询条件，共分"+pageCount+"页，当前为第"+page+"页</td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+first+"\">首页</a></td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+before+"\">前页</a></td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+next+"\">后页</a></td></tr>";
			html+="<tr><td><a href=\"selectdb.jsp?page="+last+"\">末页</a></td></tr>";
			html+="<tr><td><form action=\"\" method=\"post\">跳转至:<input type=\"text\" name=\"page\"><input type=\"submit\"></form></td></tr>";
			html += "</table>";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.free(rs, ps, con);
		}
		return html;
	}

}
