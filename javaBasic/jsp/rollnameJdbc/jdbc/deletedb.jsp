<%@ page language="java" import="java.util.*" import="java.sql.*" import="ShowPage.*" pageEncoding="UTF-8"%>
<html>
<body>
		
		 <%
		System. out.print(request.getParameter("id"));
		  int j=Integer.parseInt(request.getParameter("id"));
		  System. out.print(j);
		 List<Map<String,Object>> list=Jdbc.readDB("select * from person where id="+j);
		 
		  %>
         
		<form action="" method="post">
			学号：
			<input type="text" name="no" value=<%=list.get(0).get("id") %>>
			<br>
			
			<input type="submit" value="提交">
		</form>
		<%
		
			String id = request.getParameter("no");
			String str = "";
			if ((id == null) ) {
				str = "请正确输入学号";
				out.print(str);
			} else {
				try {
					int idd = Integer.parseInt(id);
					int i =Jdbc.writeDB(
							"delete from person where id=?",
							new Object[] {  idd });

					if (i == 1) {
					%>
					<script type="text/javascript">
					alert("数据删除成功！")
					</script>
					<%
						
					} else {
						out.print("数据删除失败<br>");
					}
					
				 } catch (Exception e) {
				// out.print("数据入库失败<br>");
				//out.print("请正确输入学号和姓名");
				}
				
			}
		%>


		
	</body>
</html>