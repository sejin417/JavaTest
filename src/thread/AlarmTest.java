package thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.Calendar;

public class AlarmTest {
	
	public void write(String msg){
		System.out.println( msg );
	}

	public void start() {
		// TODO Auto-generated method stub
		BufferedReader userInput;
		String theLine;
		String result;

		try {

			userInput = new BufferedReader(new InputStreamReader(System.in));    
			while(true) {
				try {

					System.out.println("Sleep Time 을 입력하십시오. (클라이언트)");
					theLine = userInput.readLine();

					write( "---실행 ----------------------------------" );
					write( "시작:"+Calendar.getInstance().toString() );
					write( theLine );

					int sleepTime = Integer.parseInt(theLine);
					
					Thread.sleep( sleepTime );
					write( "종료:"+Calendar.getInstance().toString() );
				} catch (InterruptedIOException e) {
					e.printStackTrace();
					break;
				} catch (NumberFormatException e) {
					write( " 숫자를 입력하여 주시기 바랍니다");
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new AlarmTest().start();
	}
}
