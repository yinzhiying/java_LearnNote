import java.io.*;

public class getNumber
{
public static void main(String args[])
{
int i=0;
String s;

try{
System.out.print("������һ����������");
BufferedReader br=
new BufferedReader(new InputStreamReader(System.in));
s=br.readLine();
i=Integer.parseInt(s);
}catch(IOException e){}
System.out.print("������������:"+i);
System.out.println("\t,����");
}
}

