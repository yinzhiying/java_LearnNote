import java.io. *;

public class sushu
{
 public static void main(String args[])
 {
     int i=0;
     long value=0;
     String s;
     
     try{
             System.out.print("请输入一个整数"); 
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             s= br.readLine();
             value=Integer.parseInt(s);
              for(i=2;i<=value;i++)
              {
               while(value%i == 0)
              {
                value = value/i ; 
                  
              } 	System.out.println("这个数的素数因子为"+ i);
         
              }
             
     }catch(IOException e){}
    
 }  
}