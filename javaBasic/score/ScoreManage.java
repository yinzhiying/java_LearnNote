
import java.util.Scanner;
import java.util.Vector;
public class ScoreManage
{
	public static void main(String args[])
	{ 
		Student s1=new Student("sam",89);
	    Student s2=new Student("joy",80);
		Vector MyVector=new Vector();
	      MyVector.addElement(s1);
	      MyVector.addElement(s2);
	/* for(int i=0;i<MyVector.size();i++){
		 System.out.print(MyVector.elementAt(i).getName());
	*/ //}
		float avg;
		int sum=0;
		int a;
		
		//System.out.print(name[0]);
		//System.out.println(name[1]);

		//int score[]=new int[2];
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
			for(int i=0;i<MyVector.size();i++)
			{ Student str=(Student)MyVector.elementAt(i);
				System.out.println("请输入"+str.name+"的成绩：");
				str.score = scan.nextInt();
				}
				break;
			case 2:
				for(int i =0; i<MyVector.size(); i++)
			{ 
				Student str=(Student)MyVector.elementAt(i);
				System.out.println(str.name+"的成绩为："+str.score);
				sum=sum+str.score;
				
			}
				avg=sum/MyVector.size();
				System.out.println("avg:"+avg);
			break;
			case 3:
			//Arrays.sort(name);
			System.out.println("请输入你要查找的名字");
			String n=scan.next();
			for(int i=0;i<MyVector.size();i++){
				Student str=(Student)MyVector.elementAt(i);
			if(str.name.equals(n))
				System.out.print(str);
			}break;
		}
			}while(a!=0);
		}
		}
	class Student
	{
	
		String name;
		int score;
		public String toString(){
			String s="score"+score+"\nname"+name+"\n";
			return s;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		Student(String n,int s){
			name=n;
			score=s;
		}
	}