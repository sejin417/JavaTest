package timestamp;

import java.sql.Timestamp;
import java.util.Date;

public class TimeStampTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timestamp a = new Timestamp(new Date().getTime());
		
		System.out.println( a.toString().substring(0, a.toString().lastIndexOf(".")));
		
		String date = "20071019175010";
		
		Date d = new Date();
		
		a = new Timestamp( Integer.parseInt( date.substring(0,4)) ,
				Integer.parseInt( date.substring(0,4)) ,
				Integer.parseInt( date.substring(0,4)) ,
				Integer.parseInt( date.substring(0,4)) ,
				Integer.parseInt( date.substring(0,4)) ,
				Integer.parseInt( date.substring(0,4)) ,
				Integer.parseInt( date.substring(0,4)));
		
		System.out.println( a.toString().substring(0, a.toString().lastIndexOf(".")));
		
	}

}
