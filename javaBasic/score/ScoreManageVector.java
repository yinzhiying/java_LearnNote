import java.util.Scanner;
import java.util.Vector;


public class ScoreManageVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Student> myVec = new Vector<Student>();
		Student s1 = new Student("Tom");
		Student s2 = new Student("Jerry");
		Student s3 = new Student("Andy");
		Student s4 = new Student("John");
		myVec.add(s1);
		myVec.add(s2);
		myVec.add(s3);
		myVec.add(s4);
		
		System.out.println("-----欢迎使用成绩管理系统-------");
		while(true){
		System.out.print("1.成绩录入   2.成绩单   3.成绩查询   0.退出");
		
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		
		switch(k)
		{
		case 0: {
			System.out.println("byebye!");
			System.exit(0);}
		case 1: {
			for(int i =0; i<myVec.size(); i++)
			{
				System.out.print(myVec.elementAt(i).getName()+"的成绩为：");
				double d = scan.nextDouble();
				myVec.elementAt(i).setScore(d);				
			}
			break;
		}
		case 2: {
			for(int i =0; i<myVec.size(); i++)
			{
				System.out.println(myVec.elementAt(i).getName()+"的成绩为："+myVec.elementAt(i).getScore());				
			}
			break;
		}
		case 3:{
			String s = scan.next();			
			boolean find = false; 
			for(int i =0; i<myVec.size(); i++)
			{
			if(s.equals(myVec.elementAt(i).getName()))
			{
			System.out.println(s+"的成绩为："+myVec.elementAt(i).getScore());
			find = true;
		}
		}
		if(!find)
		System.out.println("nobody found!");
		}		
	}
	}
}
}
class Student
{
	String name;
	double score;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, double score) {
		this(name);
		this.score = score;
	}
	
	
}
