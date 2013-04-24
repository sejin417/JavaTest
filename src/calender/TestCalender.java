package calender;

import java.util.Calendar;

public class TestCalender {
	public String getCalander2(){
		Calendar cal = Calendar.getInstance();

		cal.set( Calendar.DATE , cal.get(Calendar.DATE) - 1);
		
		String year = String.valueOf(cal.get(Calendar.YEAR) );
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));

		if (month.length() == 1){
			month = "0" + month;
		}

		if (day.length() == 1){
			day = "0" + day;
		}

		return year + month + day;
	}
	
	public String getCalander(){
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
		
		cal.set( Calendar.DATE , cal.get(Calendar.DATE) - 1);
		System.out.println(cal.get(Calendar.DATE));

		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE) );

		if (month.length() == 1){
			month = "0" + month;
		}

		if (day.length() == 1){
			day = "0" + day;
		}

		System.out.println(month + day + "0000");
		return month + day + "0000";
	}
	
	public String getCalander4(){
		Calendar cal = Calendar.getInstance();
 
		String year = String.valueOf(cal.get(Calendar.YEAR) );
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE) -1 );

		if (month.length() == 1){
			month = "0" + month;
		}

		if (day.length() == 1){
			day = "0" + day;
		}

		return year + month + day;
	}	
	
	public String getCalander3(){
		Calendar cal = Calendar.getInstance();

		cal.set( Calendar.DATE , cal.get(Calendar.DATE) - 2);

		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));

		if (month.length() == 1){
			month = "0" + month;
		}

		if (day.length() == 1){
			day = "0" + day;
		}

		return month + day + "0000";
	}

	public static void main(String[] args){
		
		System.out.println(new TestCalender().getCalander2());
	}
}
