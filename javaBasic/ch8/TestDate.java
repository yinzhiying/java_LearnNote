import java.text.*;

import java.util.*;


public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String i;
     System.out.print("输入一个日期");
     Scanner scan=new Scanner(System.in);
     i=scan.nextLine();
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   Calendar c=Calendar.getInstance();
	  try{
	   Date d=sdf.parse(i);
	   c.setTime(d);
	   System.out.println(sdf.format(d.getTime()));
	  }  
	  catch (ParseException e){
		  e.printStackTrace();
	  }
	   int week=c.get(Calendar.DAY_OF_WEEK)-1;
	   System.out.println(week);
   }
}

