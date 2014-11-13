package dao;

import java.util.Date;
//实体类：数据库表的面向对象表示
public class Person {
  private String sno;
  private String sname;
  private Date birthday;
  private int state;
  
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
@Override
public String toString() {
	return "Person [sno=" + sno + ", sname=" + sname + ", birthday=" + birthday
			+ ", state=" + state + "]";
}
  
}
