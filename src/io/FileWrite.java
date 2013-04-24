package io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWrite {
	public static void main(String[] args) {
		String[] temp = {"2007-01-01 오전 12:05:00|10.0.68.200|711|71103|0|0|0|0|0|-1||-1||||||||||||||||||||||||||||||| \n" +
		"2007-01-01 오전 12:05:00|10.0.68.200|713|71301||||||2|0|0|0|0|0|0|0|0|||||||||||||||||||||||-1|| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|713|71301||||||3|0|0|0|0|0|0|0|0|||||||||||||||||||||||-1|| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71401||||||-1||-1|||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71402||||||-1||-1|||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71403||||||-1||-1|||||||0|30|30|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71404||||||-1||-1|||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71406||||||-1||-1|||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71407||||||-1||-1|||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n",
		"2007-01-01 오전 12:05:00|10.0.68.200|714|71408||||||-1||-1|||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||||||| \n" };
		
		File file = new File("C:/raw_data");

		if ( file.isFile() ){
			System.out.println("파일이 생성되어 있습니다. ["+file.getParent() + file.getName());
			return;
		}

		try {
			FileWriter out = new FileWriter(file);

			for ( int i=0;i<temp.length;i++){
				out.write(temp[i]);
			}

			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
