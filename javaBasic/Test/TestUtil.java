import java.util.*;
public class TestUtil{
public static void main(String args[]){
	String s;
	String s1="";
	char c;
	int i=0;
	int j;
Scanner scan=new Scanner(System.in);	
System.out.print("������һ���ַ���\n");
s=scan.nextLine();
System.out.print("������Ҫɾ�����ַ�\n");
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