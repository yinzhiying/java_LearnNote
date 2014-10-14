import java.util.*;
public class TestString{
	public static void main(String args[])
{
		boolean flag=true;
	Scanner scan=new Scanner(System.in);
	System.out.println("please input a string");
	String s=scan.nextLine();
	if(isRev(s))
	System.out.println("是回文");
	else
	System.out.println("非回文");
}	
 static boolean isRev(String s)
{
	for(int i=0;i<s.length()/2;i++){
	if(s.charAt(i)!=s.charAt(s.length()-(i+1)))
return false;
	
	
}
return true;

	
	
	
}
	}

	
	
		
		
	
	


