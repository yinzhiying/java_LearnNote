import java.util. *;
public class MathArray
{
public static void main(String args[])
{
	System.out.println("请输入10个整数：");
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
    System.out.println("最大值:"+max+"\n最小值"+min+"\n所有元素的和"+sum+"\n平均值"+average);
	}
	
	
}