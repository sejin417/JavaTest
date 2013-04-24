package file;

import java.io.File;

public class FileRenameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File oldFile = new File( "d:\\test_log.txt" );
		File newFile = new File( "d:\\test_log.txt_insert" );
		oldFile.renameTo(newFile);
	}

}
