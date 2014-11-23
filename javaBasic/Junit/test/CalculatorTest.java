package hehe.haha.nihao;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
   
	private Calculator c;
	public void testAdd()
	{
		//Calculator c=new Calculator();
		int result=c.add(1, 2);
		Assert.assertEquals(3,result);
	}
	
	public void testDiv(){
		
		//Calculator c=new Calculator();
		int result=-1;
		try {
			result=c.div(1, 2);
		} catch (Exception e) {
			Assert.fail();
		}
		Assert.assertEquals(0,result);
	}
	public void testDivByZero(){
		//Calculator c=new Calculator();
		int result=-1;
		Throwable t=null;
		try {
			result=c.div(1, 0);
			Assert.fail();
		} catch (Exception e) {
			t=e;
		}
		Assert.assertNotNull(t);
		Assert.assertEquals(Exception.class, t.getClass());
		Assert.assertEquals("b cannot equals 0", t.getMessage());
	}

	@Override
	public void setUp() throws Exception {
		//建立测试环境
	//	System.out.println("setup");
		c=new Calculator();
	//	System.out.println(c);
	}

	@Override
	public void tearDown() throws Exception {
		//拆除测试环境
	//	System.out.println("tearDown");
	}
}
