import java.util.*;


class Student {

	String sno;
	String name;
	int age;
	Student(String s,String n,int a)
	{
		sno=s;
		name=n;
		age=a;
		
	}
	 public String toString()
{
	return "ѧ��:"+sno+"\n����"+name+"\n����"+age;
}
}
	/**
	 * @param args
	 */
	 class Teacher
	 {
	 	String Id;
	 	String Tname;
	 	String Job;
	 	
	 Teacher(String i,String t,String j)
	{
		Id=i;
		Tname=t;
		Job=j;
		
	}
	public String toString()
{
	return "��ʦ���:"+Id+"\n����"+Tname+"\n��λ"+Job;
}
}
public class useVector
{
	public static void main(String[] args) {
		Vector <Object>  MyVector=new Vector <Object> ();
		
	
		MyVector.addElement(new Student("12061101","����",20));
		MyVector.addElement(new Student("12061102","�",22));
		MyVector.addElement(new Student("12061103","����",20));
		MyVector.addElement(new Teacher("12061103","�����","����ѧԺ"));
		for(int i=0;i<MyVector.size();i++)
		{System.out.println(MyVector.elementAt(i));
		}
			// TODO Auto-generated method stub
System.out.println("name:");
Scanner scan=new Scanner(System.in);
String Key=scan.nextLine();
for(int i=0;i<MyVector.size();i++)
		{
		if(MyVector.elementAt(i) instanceof Student)
		{
			Student ss=(Student)MyVector.elementAt(i);
			if(ss.name.equals(Key))
			System.out.println(ss);
			}
			if(MyVector.elementAt(i) instanceof Teacher)
		{
			Teacher tt=(Teacher)MyVector.elementAt(i);
			if(tt.Tname.equals(Key))
			System.out.println(tt);
			}
			
		}
	}
}
