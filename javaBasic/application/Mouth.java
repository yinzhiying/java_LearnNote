import java.io. *;

public class Mouth
{
  public static void main(String args[])
   {
     int j=0;
     String s;{
     	
  try   {  System.out.print("请输入一个整数"); 
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              s= br.readLine();
              j=Integer.parseInt(s);
            }
            catch(IOException e){}   
       if(j<1||j>12)
  
         try{   
         	System.out.println("输入有错，请重新一个1至12之间的整数"); 
              System.out.print("请输入一个整数"); 
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              s= br.readLine();
              j=Integer.parseInt(s);
            }
            catch(IOException e){}            
} 
{switch(j)
     { case 1:   System.out.println("这是1月份，该月有31天");break;
       case 2:   System.out.println("这是2月份，该月有28天或29天");break;
       case 3:   System.out.println("这是3月份，该月有31天");break;
       case 4:   System.out.println("这是4月份，该月有30天");break;
       case 5:   System.out.println("这是5月份，该月有31天");break;
       case 6:   System.out.println("这是6月份，该月有30天");break;
       case 7:   System.out.println("这是7月份，该月有31天");break;
       case 8:   System.out.println("这是8月份，该月有31天");break;
       case 9:   System.out.println("这是9月份，该月有30天");break;
       case 10:   System.out.println("这是10月份，该月有31天");break;
       case 11:   System.out.println("这是11月份，该月有30天");break;
       case 12:   System.out.println("这是12月份，该月有31天"); break;
      
     } 
   }
 }
}
 

