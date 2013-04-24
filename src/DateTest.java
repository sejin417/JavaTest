import java.util.Calendar;

/*
 * 累己等 朝楼: 2005. 6. 30
 *
 */

/**
 * @author 林技柳
 *
 */
public class DateTest {

	public static void main(String[] args) {
	    Calendar cal = Calendar.getInstance();

//	    activity.append( cal.get( Calendar.HOUR_OF_DAY ) );
//	    activity.append( cal.get( Calendar.MINUTE ) );
//	    activity.append( cal.get( Calendar.SECOND ) );

	    System.out.println( cal.get( Calendar.MONTH ) );
	    cal.add( Calendar.MONTH, -1);
	    
	    System.out.println( cal.get( Calendar.MONTH) +1 );
        // --- display the activity
//        System.out.println(a);
//        System.out.println(Integer.parseInt(activity.toString())- Integer.parseInt( temp ));

	}
}
