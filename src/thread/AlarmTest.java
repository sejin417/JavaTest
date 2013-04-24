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

					System.out.println("Sleep Time �� �Է��Ͻʽÿ�. (Ŭ���̾�Ʈ)");
					theLine = userInput.readLine();

					write( "---���� ----------------------------------" );
					write( "����:"+Calendar.getInstance().toString() );
					write( theLine );

					int sleepTime = Integer.parseInt(theLine);
					
					Thread.sleep( sleepTime );
					write( "����:"+Calendar.getInstance().toString() );
				} catch (InterruptedIOException e) {
					e.printStackTrace();
					break;
				} catch (NumberFormatException e) {
					write( " ���ڸ� �Է��Ͽ� �ֽñ� �ٶ��ϴ�");
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
