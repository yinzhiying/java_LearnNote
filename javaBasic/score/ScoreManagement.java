import java.util.*;
public class ScoreManagement
{
	public static void main(String args[])
	{ float avg;
		int sum=0;
		int a;
		String name[]={"sam","joy"};

		System.out.print(name[0]);
		System.out.println(name[1]);

		int score[]=new int[2];
		System.out.print("----欢迎使用成绩管理系统----");
		do{
		System.out.println("1.成绩录入  2.成绩单  3.查询  0.离开  ");
		System.out.print("请选择：");
		Scanner scan=new Scanner(System.in);
		a=scan.nextInt();
		
		switch(a)
		{
			case 0:
			System.out.println("byebye");
			break;
			case 1:
			for(int i=0;i<score.length;i++)
			{System.out.println("请输入"+name[i]+"的成绩：");
				score[i] = scan.nextInt();
				}
				break;
			case 2:
				for(int i =0; i<name.length; i++)
			{
				System.out.println(name[i]+"的成绩为："+score[i]);
				sum=sum+score[i];
				
			}
				avg=sum/2;
				System.out.println("avg:"+avg);
			break;
			case 3:
			//Arrays.sort(name);
			System.out.println("请输入你要查找的名字");
			String n=scan.next();
			if(n.equals("sam"))System.out.println(name[1]+"的成绩"+score[1]);
			if(n.equals("joy"))System.out.println(name[0]+"的成绩"+score[0]);
			break;
		}
			}while(a!=0);
		}
		}
	