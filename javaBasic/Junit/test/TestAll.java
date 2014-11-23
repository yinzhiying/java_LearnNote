package hehe.haha.nihao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {
   public static Test suite(){
	   TestSuite ts=new TestSuite();
	   ts.addTestSuite(CalculatorTest.class);
	   ts.addTestSuite(HeapStackTest.class);
	   ts.addTestSuite(RemoveAllFileTest.class);
	   return ts;
   }
}
