import java.util.*;
public class TestRectangle{
public static void main(String args[]){
	int a,b;
		
	Scanner scan=new Scanner(System.in);
	System.out.print("输入边长：");
	a=scan.nextInt();
	
  Rectangle rc= new Square(a);
	System.out.print("周长是："+rc.c());
	System.out.println("面积是："+rc.s());

	
}	
}
class Rectangle
{
	int length;
int width;
Rectangle(){}
Rectangle(int len,int wid)
{
	length=len;
	width=wid;
	}
int c()
{

return (length+width)*2;
}
int s(){
return length*width;
}
}
class Square extends Rectangle
{
	Square(int side)
	{
		super(side,side);
		}
	int c()
{
return length*4;
}
int s(){
return (int)Math.pow(length,2);
}
	}