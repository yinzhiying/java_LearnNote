package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;

public class Jchart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		standardChartTheme.setLargeFont(new Font("微软雅黑", Font.PLAIN, 15));
		standardChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 15));
		ChartFactory.setChartTheme(standardChartTheme);
		DefaultPieDataset dataset1 = new DefaultPieDataset();
		dataset1.setValue("ASP专区", 200);
		dataset1.setValue("PHP专区", 150);
		dataset1.setValue("JAVA专区", 450);
		dataset1.setValue("DONET专区", 400);
		JFreeChart chart = ChartFactory.createPieChart("论坛版块人气指数比例图", dataset1,
				true, false, false

		);
		ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
		String fileName=ServletUtilities.saveChartAsPNG(chart,400,270,info,request.getSession());
		String url=request.getContextPath()+"/servlet/DisplayChart?filename="+fileName;
		out.println("<img src=\""+url+"\">");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
