package io;

import java.io.File;
import java.util.ArrayList;

public class FileListTest {
	public static void main(String[] args){
		File file = new File("C:/raw_data");
		String projectInfo ="06080802";
		String[] fileList;

		ArrayList importList = new ArrayList();

		if ( file.isDirectory()){
			fileList = file.list();

			for (int i=0;i<fileList.length;i++){
				if ( fileList[i].startsWith(projectInfo) ){
					importList.add(fileList[i]);
					System.out.println(fileList[i].substring(0,fileList[i].length()-4 ));
				}
			}
				
		}
	}
}
