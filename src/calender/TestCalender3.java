package calender;

import java.sql.Timestamp;
import java.util.Calendar;

public class TestCalender3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		String lastTime = "20071107165301";
		cal.set( Calendar.YEAR, 		Integer.parseInt( lastTime.substring(0,4)) );
		cal.set( Calendar.MONTH, 		Integer.parseInt( lastTime.substring(4,6))-1 );
		cal.set( Calendar.DAY_OF_MONTH, Integer.parseInt( lastTime.substring(6,8)) );
		cal.set( Calendar.HOUR_OF_DAY,	Integer.parseInt( lastTime.substring(8,10)) );
		cal.set( Calendar.MINUTE , 		Integer.parseInt( lastTime.substring(10,12)) );
		cal.set( Calendar.SECOND , 		Integer.parseInt( lastTime.substring(12,14)) );
		
		Timestamp a = new Timestamp( cal.getTimeInMillis() );
		lastTime = a.toString().substring(0,a.toString().indexOf("."));
		System.out.println( cal.toString() );
		System.out.println( lastTime );
	}

}
