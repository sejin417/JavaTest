package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
	public static void main(String[] args){
		
		SimpleDateFormat a = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
		long datss = 71395;
		Date d = new Date(datss);
		Date f = new Date(d.getTime() + 38281);

		String  b = a.format( d );
		String  fb = a.format( f );
		
		System.out.println( b );
		System.out.println( fb );
		
		String aa = "YYYY-MM";
		
		System.out.println( aa.substring(0,4) + aa.substring(5,7) );
		
		
		Date dd = new Date(d.getTime() + (5 * 60* 3000));
		
//		System.out.println( bb );
//		System.out.println( dd );
		
	}
}
