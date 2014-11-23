package hehe.haha.nihao;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RemoveAllFileTest extends TestCase{
  public void testRemoveAll(){
	  File f=new File("c:\\err.txt");
	  try {
		f.createNewFile();
       RemoveAllFile.removeAll(f);
	} catch (IOException e) {
	}
	  boolean isExist=f.exists();
	  Assert.assertEquals(false, isExist);
	  
  }
  public void testRemoveAllD()
  {
	  File dir=new File("c:\\err");
	  try
	  {
		  dir.mkdir();
		  File d1=new File(dir,"d1");
		  File d2=new File(dir,"d2");
		  File f1=new File(dir,"f1.txt");
		  d1.mkdir();
		  d2.mkdir();
		  f1.createNewFile();
		  File d1f1=new File(d1,"dif1.txt");
		  d1f1.createNewFile();
		  RemoveAllFile.removeAll(dir);
	  }catch(Exception e){
		  
	  }
	  Assert.assertNotNull(dir);
	  File[] fs=dir.listFiles();
	  Assert.assertEquals(0, fs.length);
	  
	  dir.delete();
  }
}
