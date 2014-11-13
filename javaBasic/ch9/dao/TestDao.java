package dao;

public class TestDao {

	
	public static void main(String[] args){
		/*PersonDaoJdbc pdj=new PersonDaoJdbc();
		Person p=pdj.findPerson("1202");
		System.out.println(p);
		//Person p1=pdj.invalidPerson("1202");
		if(pdj.invalidPerson(p)){
			System.out.println("offline...");
		}
		p=pdj.findPerson("1202");
		System.out.println(p);
		
		Person pp=new Person();
		pp.setSno("1204");
		pp.setSname("xinxi");
		pp.setBirthday(new java.util.Date());
		pp.setState(1);
		try{
		if(pdj.newPerson(pp))
			{
			System.out.println("new person");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("after  dao...");*/
	PersonDao pd=DaoFactory.getInstance().getPersonDao();
	Person p=pd.findPerson("1201");
	System.out.println(p);
	}
}
