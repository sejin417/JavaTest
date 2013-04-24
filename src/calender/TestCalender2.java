package calender;

import java.sql.Timestamp;
import java.util.Calendar;

public class TestCalender2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String date = "20071019175010";
		
		Calendar cal = Calendar.getInstance();

		cal.set( Calendar.DATE , cal.get(Calendar.DATE) - 400);
		
		System.out.println( "TEST:"+new Timestamp( cal.getTimeInMillis() ) );
		
		cal.set( Calendar.YEAR, 		Integer.parseInt( date.substring(0,4)) );
		cal.set( Calendar.MONTH, 		Integer.parseInt( date.substring(4,6))-1 );
		cal.set( Calendar.DAY_OF_MONTH, Integer.parseInt( date.substring(6,8)) );
		cal.set( Calendar.HOUR_OF_DAY,	Integer.parseInt( date.substring(8,10)) );
		cal.set( Calendar.MINUTE , 		Integer.parseInt( date.substring(10,12)) );
		cal.set( Calendar.SECOND , 		Integer.parseInt( date.substring(12,14)) );

		System.out.println( new Timestamp( cal.getTimeInMillis() ) );
	}

}
