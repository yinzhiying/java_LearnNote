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
		System.out.print("----��ӭʹ�óɼ�����ϵͳ----");
		do{
		System.out.println("1.�ɼ�¼��  2.�ɼ���  3.��ѯ  0.�뿪  ");
		System.out.print("��ѡ��");
		Scanner scan=new Scanner(System.in);
		a=scan.nextInt();
		
		switch(a)
		{
			case 0:
			System.out.println("byebye");
			break;
			case 1:
			for(int i=0;i<score.length;i++)
			{System.out.println("������"+name[i]+"�ĳɼ���");
				score[i] = scan.nextInt();
				}
				break;
			case 2:
				for(int i =0; i<name.length; i++)
			{
				System.out.println(name[i]+"�ĳɼ�Ϊ��"+score[i]);
				sum=sum+score[i];
				
			}
				avg=sum/2;
				System.out.println("avg:"+avg);
			break;
			case 3:
			//Arrays.sort(name);
			System.out.println("��������Ҫ���ҵ�����");
			String n=scan.next();
			if(n.equals("sam"))System.out.println(name[1]+"�ĳɼ�"+score[1]);
			if(n.equals("joy"))System.out.println(name[0]+"�ĳɼ�"+score[0]);
			break;
		}
			}while(a!=0);
		}
		}
	