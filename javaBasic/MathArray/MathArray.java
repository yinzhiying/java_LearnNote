import java.util. *;
public class MathArray
{
public static void main(String args[])
{
	System.out.println("������10��������");
	int max=0,min=999,sum=0;
	float average;
	int Array[];
	Array=new int[10];
	Scanner scan=new Scanner(System.in);
	for(int i=0;i<10;i++)
	 {
	 	Array[i]=scan.nextInt();
	 	sum+=Array[i];
	 	max=Array[0];min=Array[0];
	 	if(Array[i]>max)
	 	max=Array[i];
    if(Array[i]<min)
    min=Array[i];
    }
    average=(float)sum/10;
    System.out.println("���ֵ:"+max+"\n��Сֵ"+min+"\n����Ԫ�صĺ�"+sum+"\nƽ��ֵ"+average);
	}
	
	
}