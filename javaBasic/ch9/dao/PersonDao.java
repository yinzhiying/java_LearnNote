package dao;

//定义业务逻辑与数据库之间的接口
public interface PersonDao {
	//根据工号查找个人信息
  public Person findPerson(String sno);
  //办理离职
	public boolean invalidPerson(Person p);
	
	public boolean newPerson(Person p);
}
