package dao;

//����ҵ���߼������ݿ�֮��Ľӿ�
public interface PersonDao {
	//���ݹ��Ų��Ҹ�����Ϣ
  public Person findPerson(String sno);
  //������ְ
	public boolean invalidPerson(Person p);
	
	public boolean newPerson(Person p);
}
