package performance;

import java.util.Date;

public class VariableTest {
	public static void main(String[] args) {
		
		
		long startDate2 = new Date().getTime();
		for( int j=0;j<10000000;j++){
			String a = new String("TEST");
			String c = new String("TEST");
			String d = new String("TEST");
			String b = new String("TEST");
		}
		
		System.out.println( new Date().getTime() -  startDate2 );
		
		
		long startDate = new Date().getTime();
		String aa;
		String bb;
		String cc;
		String dd;
		for( int i=0;i<10000000;i++){
			aa = new String("TEST");
			cc = new String("TEST");
			dd = new String("TEST");
			bb = new String("TEST");
		}

		System.out.println( new Date().getTime() -  startDate );

	}
}
