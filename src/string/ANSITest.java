package string;

public class ANSITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String temp = ";KT";
		
		if ( temp.charAt(0) < 48 || temp.charAt(0) > 57 ) {
			
			System.out.println(temp);
		}
		System.out.println(temp.charAt(0));
	}

}
