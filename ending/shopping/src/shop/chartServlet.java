package shop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.List.*;
public class chartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	public float mmTopx(float mm){
		mm=(float)(mm*3.3);
		return mm;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码格式
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	response.setCharacterEncoding("utf-8");
    	//拿到session对象
    	HttpSession session = request.getSession(true);
    	//拿到输出流对象
    	PrintWriter out = response.getWriter();
    	//拿到请求的动作
    	String action = request.getParameter("action").trim();
       if(action.equals("qingdan")){
		response.reset();
		response.setContentType("application/pdf");
	    Document doc=new Document();
	    ByteArrayOutputStream os=new ByteArrayOutputStream();
		try {
			BaseFont bfChinese=BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			Font cn=new Font(bfChinese,12,Font.NORMAL);
			PdfWriter.getInstance(doc, os);
			doc.open();
			PdfPTable table=new PdfPTable(6);
			PdfPCell cell=new PdfPCell();
			Paragraph p=new Paragraph(new Paragraph("商品一览表",cn));
			p.setAlignment(Element.ALIGN_CENTER);
			cell.setColspan(6);
			cell.addElement(p);
			table.addCell(cell);
			cell.setBorderWidth(1);
			cell.setPadding(1);
			
			 cell=new PdfPCell();
			 table.addCell(new Paragraph("商品编号",cn));
			 table.addCell(new Paragraph("商品名",cn));
			 table.addCell(new Paragraph("商品价格",cn));
			 table.addCell(new Paragraph("商品分类",cn));
			 table.addCell(new Paragraph("商品数量",cn));
			 table.addCell(new Paragraph("商品浏览量",cn));
			 cell.setBorderWidth(1);
				cell.setPadding(1);
			DataBase s=new DataBase();
			List<goods> a=  s.read();
			//System.out.println(a);
		
			for(int i=0;i<a.size();i++){
				
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getGid()+"",new Font(bfChinese,8,Font.NORMAL));
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getGname()+"",new Font(bfChinese,8,Font.NORMAL));
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getGprice()+"",new Font(bfChinese,8,Font.NORMAL));
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getGlass()+"",new Font(bfChinese,8,Font.NORMAL));
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getGamount()+"",new Font(bfChinese,8,Font.NORMAL));
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getGlook()+"",new Font(bfChinese,8,Font.NORMAL));
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
			}
			
			doc.add(table);
			doc.close();
			ServletOutputStream out1=response.getOutputStream();
			os.writeTo(out1);
			out1.flush();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	}

}
