package gctest;

import java.util.Vector;

public class GcTest {
	private static final int SIZE = 100000; 
	private static final long SLEEP_TIME = 5 * 1000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector[] vec = new Vector[SIZE];
		
		try {
			System.out.println("준비하세요");
			Thread.sleep(SLEEP_TIME);
			System.out.println("1 Start");
			for( int i=0;i<SIZE;i++) {
				vec[i] = new Vector();
			}
//			요부분 수정
//			System.gc();
			System.out.println("1 End");
			Thread.sleep(SLEEP_TIME);
			System.out.println("2 Start");
			for( int i=0;i<SIZE;i++) {
				vec[i] = new Vector();
			}
//			요부분 수정
//			System.gc();
			System.out.println("2 End");
			Thread.sleep(SLEEP_TIME);
			System.out.println("3 Start");
			for( int i=0;i<SIZE;i++) {
				vec[i] = new Vector();
			}
			System.out.println("3 End");
			System.gc();
			System.out.println("모니터링 하세요");
			Thread.sleep(1 * 60 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
	}

}
