package hehe.haha.nihao;

import java.io.File;

public class RemoveAllFile {
    public static void removeAll(File f){
    	if(f.isFile()||f.list().length==0){
    		f.delete();
    	}else
    	{
    		File[] fs=f.listFiles();
    		for(File file:fs){
    			removeAll(file);
    			file.delete();
    		}
    	}
    }
    public static void main(String[] args){
    	removeAll(new File("c:\\error.txt"));
    }
}
