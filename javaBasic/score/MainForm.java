

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MainForm {
	
	static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
	static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {

		// ѧ������
		hashMap.put("Tom", 0);
		hashMap.put("Jerry", 0);
		hashMap.put("Andy", 0);
		hashMap.put("John", 0);

		// System.out.print(hashMap);
		welcome();
//		showScore(hashMap);
//		insertScore(hashMap);
//		findScore(hashMap);
		
	}

	public static void welcome() {
		System.out.println("********��ӭ����ɼ�����ϵͳ********");
		System.out.println("��ѡ���ܣ�1�ɼ�¼��" + " 2-�ɼ��б� 3-�ɼ���ѯ"
				+ " 6-�˳�ϵͳ");

		int options = scanner.nextInt();
		try {
			switch (options) {
			
			case 1:
				insertScore(hashMap);
				break;
			case 2:
				showScore(hashMap);
				break;
			case 3:
				findScore(hashMap);
				break;
			}
		} catch (Exception e) {
			System.out.println("������ 1-3 ����");
			welcome();
		}

	}

	public static HashMap<String,Integer> insertScore(HashMap<String,Integer> hashMap) {
		Iterator<String> score = hashMap.keySet().iterator();
		
		System.out.println("������ɼ�");
		
		while (score.hasNext()) {
			String key = (String) score.next();
			
			int s=scanner.nextInt();
			
			hashMap.put(key, s);
			System.out.println("����" + key);
			System.out.println("�ɼ�" + hashMap.get(key));
		}
		return hashMap;
	}
	
	public static void showScore(HashMap hashMap){
		
		Iterator<String> score = hashMap.keySet().iterator();
		
		double average;
		int sum = 0;
		
		while (score.hasNext()) {
			String key = (String) score.next();
			System.out.println("����" + key);
			System.out.println("�ɼ�" + hashMap.get(key));
			
			sum=sum+(Integer)hashMap.get(key);
		}
		
		int length=hashMap.size();
		average=sum/length;
		System.out.println(average);
	}
	
	public static void findScore(HashMap hashMap){
		
		String name = null;
		
		name=scanner.next();
		
		if(hashMap.containsKey(name)){
			System.out.println("����" + name);
			System.out.println("�ɼ�" + hashMap.get(name));
		}
		
	}
	

}