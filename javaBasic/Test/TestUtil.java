import java.util.*;
public class TestUtil{
public static void main(String args[]){
	String s;
	String s1="";
	char c;
	int i=0;
	int j;
Scanner scan=new Scanner(System.in);	
System.out.print("请输入一个字符串\n");
s=scan.nextLine();
System.out.print("输入想要删除的字符\n");
c=scan.nextLine().charAt(0);

while(s.indexOf((int)c,i)!=-1){
	j=s.indexOf((int)c,i);
	s1+=s.substring(i,j);
	i=j+1;
	}
s1+=s.substring(i);
System.out.print(s1);
}
}