import java.io.*;

public class ApplicationCharInOut
{
public static void main(String args[])
{
char c=' ';
System.out.print("Enter a character please:");
try{
c=(char)System.in.read();
}catch(IOException e){};
System.out.println("You've entered character"+c);
}
}