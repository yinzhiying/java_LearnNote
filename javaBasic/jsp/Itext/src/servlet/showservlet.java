package servlet;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     

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

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.List.*;
public class showservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	public float mmTopx(float mm){
		mm=(float)(mm*3);
		return mm;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			Paragraph p=new Paragraph(new Paragraph("¿Î³Ì±í",cn));
			p.setAlignment(Element.ALIGN_CENTER);
			cell.setColspan(6);
			cell.addElement(p);
			table.addCell(cell);
			cell.setBorderWidth(1);
			cell.setPadding(1);
			
			
			caozuo s=new caozuo();
			List<D> a=s.read();
			System.out.println(a);
		
			for(int i=0;i<a.size();i++){
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getYi()+"");
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getEr()+"");
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getSan()+"");
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getSi()+"");
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getWu()+"");
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
					
					cell=new PdfPCell();
					p=new Paragraph(a.get(i).getLiu()+"");
					p.setAlignment(Element.ALIGN_CENTER);
					cell.addElement(p);
					table.addCell(cell);
			}
			/*
			for(int i=0;i<a.size();i++){
			//PdfPTable table1=new PdfPTable(7);
			cell=new PdfPCell();
			 p=new Paragraph(a.get(i)+"");
			p.setAlignment(Element.ALIGN_CENTER);
			cell.addElement(p);
	
			cell.setBorderWidth(1);
			table.addCell(cell);
			}*/
			doc.add(table);
			doc.close();
			ServletOutputStream out=response.getOutputStream();
			os.writeTo(out);
			out.flush();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	

}
