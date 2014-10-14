import java.io.*;
public class TestPerfectNum
{
public static void main(String args[])
{
	int a1,a2;
	if(args.length<2)
	{
		System.out.println("运行本程序应该提供两个命令行参数");
		System.exit(0);
		
		}
		a1=Integer.parseInt(args[0]);
		a2=Integer.parseInt(args[1]);
		int count=1;
		PerfectNum pn=new PerfectNum();
		for(int i=a1;i<a2;i++)
		{
			if(pn.isPerfect(i))
			{
				System.out.print(i+String.valueOf('\t'));
				count++;
				if(count%3==3)System.out.println();
				
				}
			}
	}
}
class PerfectNum
{
	boolean isPerfect(int x)
	{
		int y=0;
		for(int i=1;i<x;i++)
		if(x%i==0)y+=i;
		if(y==x)
		return true;
		else
		return false;
		}
	}