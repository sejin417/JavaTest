package random;

import java.util.Random;

public class RandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxCnt = 10;
		Random ran = new Random();
		
		for(int i=0;i<100;i++){
		int ranResult = ran.nextInt(maxCnt);
		System.out.print(ranResult + "  ");
		
		}
		
		
	}

}
