
public class TestInter
{
	public static void main(String arg[])
	{
		SoftwareStudent s=new SoftwareStudent("09","lihua",8);
		
		s.doPractice();
		s.printInfo();
		}
	}
interface Student
{
void printInfo();
}
abstract class InfoStudent implements Student
{
String id;
String name;
int age;
abstract void doPractice();
}

class SoftwareStudent extends InfoStudent
{
	SoftwareStudent(String i,String n,int a)
	{
		this.id=i;
		name=n;
		age=a;
		}
void doPractice()
{
System.out.println("java study....");
}
public void printInfo()
{
	System.out.println("student id is"+id+"\t,name is"+name+"\t,age ia "+age);
	}
}