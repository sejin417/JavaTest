package string;

public class StringBufferDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer test = new StringBuffer();

		test.append("1234567890");
//		test.deleteCharAt( test.length() -1);

//		test.delete(test.length()-2, test.length());
		test.delete(0, 4);
		System.out.println( test.toString() );

		String dateType = "EEEEEEE2";
		String result= null;;
		int day = Integer.valueOf( dateType.substring(7,8) );
		switch ( day ) {
		case 1:
			result = "일요일";
			break;
		case 2:
			result = "월요일";
			break;
		case 3:
			result = "화요일";
			break;
		case 4:
			result = "수요일";
			break;
		case 5:
			result = "목요일";
			break;
		case 6:
			result = "금요일";
			break;
		case 7:
			result = "토요일";
			break;
		}
		System.out.println(result);
	}

}
