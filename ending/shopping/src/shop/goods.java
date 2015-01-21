package shop;

import java.sql.Date;

public class goods {
int Gid;
String Gname;
double Gprice;
String Glass;
int Gamount;
int Glook;

public goods() {
	super();
	// TODO Auto-generated constructor stub
}
public int getGid() {
	return Gid;
}
public void setGid(int gid) {
	Gid = gid;
}
public String getGname() {
	return Gname;
}
public void setGname(String gname) {
	Gname = gname;
}
public double getGprice() {
	return Gprice;
}
public void setGprice(double gprice) {
	Gprice = gprice;
}
public String getGlass() {
	return Glass;
}
public void setGlass(String glass) {
	Glass = glass;
}
public int getGamount() {
	return Gamount;
}
public void setGamount(int gamount) {
	Gamount = gamount;
}

public int getGlook() {
	return Glook;
}
public void setGlook(int glook) {
	Glook = glook;
}
@Override
public String toString() {
	return "goods [Gid=" + Gid + ", Gname=" + Gname + ", Gprice=" + Gprice
			+ ", Glass=" + Glass + ", Gamount=" + Gamount + ", Glook=" + Glook
			+ "]";
}

}


