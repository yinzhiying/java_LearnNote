import java.io.*;
public class ApplicationLineIn{
public static void main(String args[]){
	String s="";
	System.out.print("please enter a string:");
	try{
		BufferedReader in=
		new BufferedReader(new InputStreamReader(System.in));
		s=in.readLine();
	}catch(IOException e){}
		System.out.println("You've entered string:"+s);
	}
}