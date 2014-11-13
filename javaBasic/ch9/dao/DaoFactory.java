package dao;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
private static PersonDao personDao=null;
private static DaoFactory instance=new DaoFactory();
 private DaoFactory(){
	 
	 try {
		 Properties p= new Properties();
		 InputStream is=new FileInputStream(new File("G:\\workspace\\Te\\src\\dao\\daoconfig.properties"));
		p.load(is);
		String sc=p.getProperty("PersonDaoClass");
		 Class c=Class.forName(sc);
		 personDao=(PersonDao) c.newInstance();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public static DaoFactory getInstance(){
	 return instance;
 }
 public static PersonDao getPersonDao()
 {
	 return personDao;
	 
 }
}
