package date;

import java.sql.Timestamp;
import java.util.Date;

import com.kt.bcn.framework.DateTimeUtility;

public class DateToTimestamp {
	public static void main(String args[]) {
		Date aa = new Date();
		
		Timestamp stamp = new Timestamp(aa.getTime());
		
		System.out.println( stamp.toString() );
		System.out.println( DateTimeUtility.getFormatString(aa, "yyyy-MM-dd HH:mm:ss"));
	}
}
