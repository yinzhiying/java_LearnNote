1  import java.io. *;
2  public class Exercise {
3  
4  	/**
5  	 * @param args
6  	 */
7  	public static void main(String[] args) {
8  		// TODO Auto-generated method stub
9  		String s=null;
10  		int chi=1;
11  		File myPath = new File("G:\\workspace\\ch8\\src");
12  		if(! myPath.exists())
13  			myPath.mkdir();
14  		File myFile = new File(myPath,"Exercise.java");
15  		
16  		try{
17  			BufferedWriter bw= new BufferedWriter(new FileWriter("G:\\workspace\\ch8\\src\\backup.java"));
18  			BufferedReader br= new BufferedReader(new FileReader(myFile));
19  			while((s=br.readLine())!= null){
20  			    bw.write(chi++ + "  "+s);
21  			    bw.newLine();	
22  			}
23  			    bw.close();
24  			
25  		}catch(IOException e){
26  			e.printStackTrace();
27  		}
28  			
29  
30  	}
31  
32  }
