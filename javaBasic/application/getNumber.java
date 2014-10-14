import java.io.*;

public class getNumber
{
public static void main(String args[])
{
int i=0;
String s;

try{
System.out.print("请输入一个整形数：");
BufferedReader br=
new BufferedReader(new InputStreamReader(System.in));
s=br.readLine();
i=Integer.parseInt(s);
}catch(IOException e){}
System.out.print("你输入了数字:"+i);
System.out.println("\t,对吗");
}
}

