package hehe.haha.nihao;

public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Calculator c=new Calculator();
      
      int i=c.add(1, 2);
      if(3==i){
    	  System.out.println("Calculator is good");
    	  
      }else
      {
    	  System.out.println("Calculator is bad");
    	  
      }
		//System.out.println(c.add(1,2));
		System.out.println(c.sub(1,2));
		System.out.println(c.mul(1,2));
		try {
			System.out.println(c.div(1,2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   public int add(int a, int b)
   {
	   return a+b;
   }
   public int sub(int a, int b)
   {
	   return a-b;
   }
   public int mul(int a, int b)
   {
	   return a*b;
   }
   public int div(int a, int b) throws Exception
   {
	   if(0==b){
		   throw new Exception("b cannot equals 0");
	   }
	   return a/b;
   }
}
