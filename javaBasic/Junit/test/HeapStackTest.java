package hehe.haha.nihao;

import junit.framework.Assert;
import junit.framework.TestCase;

public class HeapStackTest extends TestCase {

	public void testPush(){
		HeapStack hs=new HeapStack();
		for(int i=0;i<100;i++){
			try {
				hs.push(i+"");
			} catch (Exception e) {
				Assert.fail();
			}
		}for(int i=0;i<100;i++)
		{
			String result=null;
			try {
				result=hs.pop();
			} catch (Exception e) {
				Assert.fail();
			}
			Assert.assertEquals((99-i)+"", result);
		}
		
	}
	public void testPushE()
	{
		HeapStack hs=new HeapStack();
		Throwable t=null;
		try{
		for(int i=0;i<=100;i++){
		hs.push(i+"");
		
		}
		Assert.fail();
		}catch(Exception e){
			t=e;
		}
		exceptionProcess(t);
	}
	public void testPop(){
		HeapStack hs=new HeapStack();
		Throwable t=null;
		try{
		hs.pop();
		Assert.fail();
		}catch(Exception e){
			t=e;
		}
		
		exceptionProcess(t);
	}
	private void exceptionProcess(Throwable t) {
		Assert.assertNotNull(t);
		Assert.assertEquals(Exception.class, t.getClass());
		Assert.assertEquals("buffer overflow", t.getMessage());
	}
	public static void main(String[] args){
		//junit.textui.TestRunner.run(HeapStackTest.class);
		junit.awtui.TestRunner.run(HeapStackTest.class);
	}
	}

