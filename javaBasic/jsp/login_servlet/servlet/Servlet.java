package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.tools;

public class Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	//拿到session对象
    	HttpSession session = request.getSession(true);
    	//拿到输出流对象
    	PrintWriter out = response.getWriter();
    	//拿到请求的动作
    	String action = request.getParameter("submit");
    	if(action.equals("submit")){
		try{
			String userName=null;
			String passWord=null;
			boolean rs;
			userName=request.getParameter("username");
			passWord=request.getParameter("password");
			
			
			tools cz=new tools();
			
		    rs=cz.select(userName,passWord);
			
			if(rs){
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}catch(Exception e){
                e.printStackTrace();
		}
    	}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request,response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
