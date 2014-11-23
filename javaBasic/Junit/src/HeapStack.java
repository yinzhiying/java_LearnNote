package hehe.haha.nihao;

public class HeapStack {
   private String[] body;
   private int index;
   
   public HeapStack(){
	   body=new String[100];
	   index=0;
   }
   public void push(String element) throws Exception
   {
	   if(100==index){
		   throw new Exception("buffer overflow");
		   
	   }
	   body[index++]=element;
   }
   public String pop() throws Exception
   {
	   if(0==index){
		   throw new Exception("buffer overflow");
		   
	   }
	   return body[--index];
   }
   public String top() throws Exception
   {
	   if(0==index){
		   throw new Exception("buffer overflow");
	   }
	   return body[index-1];
   }
}
