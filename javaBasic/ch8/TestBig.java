import java.math.BigDecimal;
import java.math.BigInteger;




public class TestBig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   BigInteger b1=new BigInteger("9000000");
   System.out.println(b1);
   BigInteger b2=b1.add(b1);
   System.out.println(b2);
   BigInteger b3=b1.subtract(b1);
   System.out.println(b3);
   BigInteger b4=b1.multiply(b1);
   System.out.println(b4);
   BigInteger b5=b1.divide(b1);
   System.out.println(b5);
   
   BigDecimal d1=new BigDecimal("0.24422");
   System.out.println(d1);
   BigDecimal d2=d1.add(d1);
   System.out.println(d2);
   BigDecimal d3=d1.subtract(d1);
   System.out.println(d3);
   BigDecimal d4=d1.multiply(d1);
   System.out.println(d4);
   
   
   
	}

}
