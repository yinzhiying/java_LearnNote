import java.io. *;
public class Exercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=null;
		int chi=1;
		File myPath = new File("G:\\workspace\\ch8\\src");
		if(! myPath.exists())
			myPath.mkdir();
		File myFile = new File(myPath,"Exercise.java");
		
		try{
			BufferedWriter bw= new BufferedWriter(new FileWriter("G:\\workspace\\ch8\\src\\backup.java"));
			BufferedReader br= new BufferedReader(new FileReader(myFile));
			while((s=br.readLine())!= null){
			    bw.write(chi++ + "  "+s);
			    bw.newLine();	
			}
			    bw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
			

	}

}