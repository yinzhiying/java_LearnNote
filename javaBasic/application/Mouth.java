import java.io. *;

public class Mouth
{
  public static void main(String args[])
   {
     int j=0;
     String s;{
     	
  try   {  System.out.print("������һ������"); 
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              s= br.readLine();
              j=Integer.parseInt(s);
            }
            catch(IOException e){}   
       if(j<1||j>12)
  
         try{   
         	System.out.println("�����д�������һ��1��12֮�������"); 
              System.out.print("������һ������"); 
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              s= br.readLine();
              j=Integer.parseInt(s);
            }
            catch(IOException e){}            
} 
{switch(j)
     { case 1:   System.out.println("����1�·ݣ�������31��");break;
       case 2:   System.out.println("����2�·ݣ�������28���29��");break;
       case 3:   System.out.println("����3�·ݣ�������31��");break;
       case 4:   System.out.println("����4�·ݣ�������30��");break;
       case 5:   System.out.println("����5�·ݣ�������31��");break;
       case 6:   System.out.println("����6�·ݣ�������30��");break;
       case 7:   System.out.println("����7�·ݣ�������31��");break;
       case 8:   System.out.println("����8�·ݣ�������31��");break;
       case 9:   System.out.println("����9�·ݣ�������30��");break;
       case 10:   System.out.println("����10�·ݣ�������31��");break;
       case 11:   System.out.println("����11�·ݣ�������30��");break;
       case 12:   System.out.println("����12�·ݣ�������31��"); break;
      
     } 
   }
 }
}
 

