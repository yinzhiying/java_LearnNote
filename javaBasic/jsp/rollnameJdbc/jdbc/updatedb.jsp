<%@ page language="java" import="java.util.*" import="java.mysql.*" import="ShowPage.Jdbc" pageEncoding="UTF-8"%>


<html>
 <HTML><BODY bgcolor="#999999"><FONT size=5>
	<body>
		 <%
		  System. out.print(request.getParameter("id"));
		  int j=Integer.parseInt(request.getParameter("id"));
		  System. out.print(j);
		 List<Map<String,Object>> list=Jdbc.readDB("select * from person where id="+j);
		
		 System.out.println(list);
		 
		  %>
         
		<form action="" method="post">
			学号：
			<input type="text" name="id" value=<%=list.get(0).get("id") %>>
			<br>
			姓名：
			<input type="text" name="name" value=<%=list.get(0).get("name") %>>
			<br>
			<input type="submit" value="提交">
		</form>
		<%
		
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String str = "";
			if ((id == null) || (name == null)) {
				str = "请正确输入学号和姓名";
				out.print(str);
			} else {
				try {
					int idd = Integer.parseInt(id);
					int i =Jdbc.writeDB(
							"update person set name=? where id=?",
							new Object[] { name, idd });

					if (i == 1) {
					%>
					<script type="text/javascript">
					alert("数据入库成功！")
					</script>
					<%
						
					} else {
						out.print("数据入库失败<br>");
					}
					
				 } catch (Exception e) {
				// out.print("数据入库失败<br>");
				//out.print("请正确输入学号和姓名");
				}
				
			}
		%>


		
	</body>
</html>

















