import java.io. *;
public class TenNumber
{
	public static void main(String args[])
	{
		int max=0,min=0,value=0;String s;
		for(int i=1;i<=10;i++)
		{
			try{
				System.out.println("请输入第"+i+"个整数：");
				BufferedReader br=new
				BufferedReader(new InputStreamReader(System.in));
				 s=br.readLine();
				value=Integer.parseInt(s);
				if(i==1)
				{
					max=min=value;
					}
					else
					{
						max=value>max?value:max;
						min=value<min?value:min;
					}
				
			}catch(IOException e){}
		
			}
			System.out.println("最大数为："+ max);
			System.out.println("最小数为："+ min);
		}
	}
				