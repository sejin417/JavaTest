import java.util.Calendar;


public class TimeTest {
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		
		Calendar cal = Calendar.getInstance();

		cal.setTimeInMillis(startTime);
		
		System.out.println(cal.toString());
	}
}
