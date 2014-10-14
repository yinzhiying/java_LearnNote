import  java.util.*; 

public class TestVector2
{
	public static void main(String [] args)
	{
		//Vector  MyVector=new Vector();
		Vector<Integer> MyVector = new Vector<Integer>();
		
		for (int i=1;i<=10;i++)
       MyVector.addElement(new Integer(i));
       
		MyVector.insertElementAt(Integer.parseInt("10000"),5);

		for (int i=0;i<=10;i++)
    	System.out.println(MyVector.elementAt(i));
	}
}
