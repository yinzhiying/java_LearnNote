package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.jdbc.PreparedStatement;


public class ShowRecordByPage {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sqlBatch();
	
		Scanner scan = new Scanner(System.in);
		System.out.print("������ʾ��ҳ����");
		int page = scan.nextInt();
	
		scrollPage(page);
		System.out.println("��һҳ��");
		previousPage(page);
		//scrollPage(page-1);
		System.out.println("��һҳ��");
		nextPage(page);
		//scrollPage(page+1);
		System.out.println("��ǰҳ��");
		
		scrollPage(1);
		System.out.println("���ҳ��");
		scrollPage(pageCount);
	}

	
   public static void setShowPage(int i){
	   if(inOfBounds(i)){
		   showPage=i;
	   }
	   if(i>pageCount){
		   showPage=pageCount;
	   }
	   if(i<=0){
		   showPage=1;
	   }
   }

//   public static String getPageResult(){
//	   return scrollPage(showPage);
//   }
//   public int getPageSize()
//   {
//	   return pageSize;
//   }
//   public void setPageSize(int i){
//	   if(i>0){
//		   pageSize=i;
//	   }
//   }
//   public int getPageCount(){
//	   return pageCount;
//   }
   static int pageSize=3;//ÿҳ��ʾ3����¼
   static int pageCount=getPageCountDB();
   static int showPage=1;
   //��תҳ��
   static String scrollPage(int page){
	   getPageResult(page);
	   setShowPage(page);
	   Connection con=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   String sql="select * from test limit ?,?";
	   
	   try{
		 
		  // 
		   if(inOfBounds(page)){
			   con = Jdbc.getCon();
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1,(page-1)*pageSize);
				ps.setInt(2,pageSize);
			    rs= ps.executeQuery();
				while(rs.next()){
					
					System.out.println(rs.getString("sno")+"\t"+
							rs.getString("sname")+"\t"+
							rs.getDate("birthday")+"\t"+
							rs.getBigDecimal("salary"));
				}
		   }else{}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Jdbc.free(rs, ps, con);
			}
	return sql;
	   }
  
	private static void getPageResult(int page) {
	// TODO Auto-generated method stub
	
}
	//�Ƿ����
   static boolean inOfBounds(int page){
	   if(page<=pageCount&&page>0){
		   return true;
	   }else{
		   return false;
	   }
   }
   //ǰһҳ
   static void previousPage(int page){
	   if(inOfBounds(page-1)){
		scrollPage(page-1);   
	   }else{
		   scrollPage(1);
	   }
	   }
   
//��һҳ
   static void nextPage(int page){
	   if(inOfBounds(page+1)){
		   scrollPage(page+1);
	   }else{scrollPage(pageCount);
   }
	   
   }
   //�����ҳ��
   public static int getPageCountDB(){
	   Connection con=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   String sql="select count(*) from test";
	   try{
		   con=Jdbc.getCon();
		   ps=con.prepareStatement(sql);
		  rs=ps.executeQuery();
		  
		  int size=0;
		  int pageCount=0;
		  if(rs.next()){
			  size=rs.getInt(1);
			  if(size%pageSize==0){
				  pageCount=size/pageSize;
			  }else{
				  pageCount=size/pageSize+1;
			  }
		  }
		  return pageCount;
	   }catch(SQLException e){
		   e.printStackTrace();
	   }finally{
		   Jdbc.free(rs, ps, con);
	   }
	   return pageCount;
   }
   
   }
