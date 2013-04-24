package file;

import java.io.File;

public class CreateDirectoryTest {
	public static void main(String[] args){
		
		String file = "c:/NTMSTEST/"; 
		String date= "20070829.java";
		
		File createDir = new File(file);
		
		if ( !(createDir.exists() && createDir.isDirectory()) ) {
			createDir.mkdir();
		}
		
		createDir = new File( file + "/" + date);
		
		if ( !(createDir.exists() && createDir.isDirectory()) ) {
			createDir.mkdir();
		}
		
		System.out.println( createDir.getPath() );
		System.out.println( createDir.getParentFile() );
		System.out.println( createDir.getParent() );
		System.out.println( createDir.getName() );
		
		String entityName = createDir.getName().substring(0, createDir.getName().indexOf("."));
		System.out.println( entityName);
		
	}
}
