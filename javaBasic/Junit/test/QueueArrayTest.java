package hehe.haha.nihao;

import junit.framework.Assert;
import junit.framework.TestCase;

public class QueueArrayTest extends TestCase {
	//测试正常入队
	public void testInsert(){
		QueueArray qa=new QueueArray();
		for(int i=0;i<100;i++){
			try {
				qa.inQueue(i+"");
			} catch (Exception e) {
				Assert.fail();
			}
		}for(int i=0;i<100;i++)
		{
			String result=null;
			try {
				result=qa.outQueue();
			} catch (Exception e) {
				Assert.fail();
			}
			Assert.assertEquals(i+"", result);
		}
		
	}
	//测试异常入队
public void testInsertE()
	{
	QueueArray qa=new QueueArray();
		Throwable t=null;
		try{
		for(int i=0;i<=100;i++){
		qa.inQueue(i+"");
		
		}
		Assert.fail();
		}catch(Exception e){
			t=e;
		}
		Assert.assertNotNull(t);
		Assert.assertEquals(Exception.class, t.getClass());
	    Assert.assertEquals("队列已满", t.getMessage());
	}
//测试异常出队
	public void testRemoveE(){
		QueueArray qa=new QueueArray();
		Throwable t=null;
		try{
		qa.outQueue();
		Assert.fail();
		}catch(Exception e){
			t=e;
		}
		
		
	
		Assert.assertNotNull(t);
		Assert.assertEquals(Exception.class, t.getClass());
		Assert.assertEquals("队列为空", t.getMessage());
	}
}
	
