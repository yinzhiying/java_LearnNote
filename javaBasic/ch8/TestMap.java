import java.util.HashMap;
import java.util.Scanner;

public class TestMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, user> table = new HashMap<String, user>();
		user u1 = new user("����", "1234");
		user u2 = new user("����", "2234");
		user u3 = new user("С��", "6789");
		table.put(u1.name, u1);
		table.put(u2.name, u2);
		table.put(u3.name, u3);

		System.out.println("�������û���");
		Scanner scan = new Scanner(System.in);
		String i = scan.nextLine();
		System.out.println("����������");
		Scanner s = new Scanner(System.in);
		String j = s.nextLine();

		if (table.containsKey(i)) {
			if (j.equals(table.get(i).password))
				System.out.println("�ǺϷ��û�");

			else
				System.out.println("���ǺϷ��û�");

		} else
			System.out.println("���ǺϷ��û�");
	}

}

class user {
	public user(String string, String string2) {
		name=string;
		password=string2;	// TODO Auto-generated constructor stub
	}

	String name;
	String password;

}
