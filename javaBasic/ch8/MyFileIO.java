import java.io.*;
public class MyFileIO
{
  public static void main(String args[])
  {
     char ch;
     int chi;
     File myPath=new File("subdir");
     if(!myPath.exists())
       myPath.mkdir();
     File myFile=new File(myPath,"crt.txt");
     try
     {
        FileOutputStream fout=new FileOutputStream(myFile);
				System.out.println("������һ���ַ�������#��β");
				while((ch=(char)System.in.read())!='#')
	   			fout.write(ch);
				fout.close();
				System.out.println("�����ǴӸ�д����ļ��ж���������");
				FileInputStream fin=new FileInputStream(myFile);
				while((chi=fin.read())!=-1)
	   			System.out.print((char)chi);
				fin.close();
     }catch(FileNotFoundException e){
        System.err.println(e);
     }
     catch(IOException e){
       System.err.println(e);
     }     
  }
}