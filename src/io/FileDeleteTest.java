package io;

import java.io.File;

public class FileDeleteTest {
	public static void main(String[] args){
		File  file = new File ("D:/Amator.zip");
		file.isFile();
		file.delete();
	}
}
