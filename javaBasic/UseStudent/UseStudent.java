import java.io.*;
public class UseStudent
{
	public static void main(String args[]){
		Student stu=new Student("12061124","12","����","��",20);
		System.out.println(stu.toString());
		stu.setAge(32);
		System.out.println("�޸ĺ������Ϊ��"+stu.getAge());
		 CollegeStudent student=new CollegeStudent("12061124","12","����","��",20,"��ɽ����","��Ϣ����");	
		 System.out.println(stu.toString());
		 System.out.println("��ѧ����רҵ"+student.getProfessional());
	  
	  }
} 
class Student{
String xuehao;
String banhao;
String name;
String sex;
int age;
Student(String sn,String cn,String na,String s,int a){
	xuehao=sn;
	banhao=cn;
	name=na;
	sex=s;
	age=a;
}
Student(){}
public String getNumber(){
return xuehao;}
public String getClassNum(){
	return banhao;
}
public String getName(){
	return name;
}
public String getSex(){
	return sex;
}
public int getAge(){
	return age;
}
int setAge( int b)
{ age=b;
	return age;
	}
	 public String toString()
{
	String s="ѧ��:"+xuehao+"\n���"+banhao+"\n����"+name+"\n�Ա�"+sex+"\n����"+age;
  return s;
  }
}
class CollegeStudent extends Student
{
	String Company;
	String Professional;
	CollegeStudent(String sn,String cn,String na,String s,int a,String c,String p)
	{super(sn,cn,na,s,a);
	Company=c;
		Professional=p;
		}
		
	 String getProfessional()
	 {
	 	return Professional;
	 	}

	 }

	