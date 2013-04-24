package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverPropertiesPath = System.getProperty("properties.path"); 
		
		File f = new File(serverPropertiesPath);
		
		FileInputStream fis = null;
		Properties prop;
		prop = new Properties();
		try {
			fis = new FileInputStream(f);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sDriver = prop.getProperty("jdbc.db.driverclass");
		String url = prop.getProperty("jdbc.db.url");
		String user = prop.getProperty("jdbc.db.user");
		String passwd = prop.getProperty("jdbc.db.password");
	}

}
