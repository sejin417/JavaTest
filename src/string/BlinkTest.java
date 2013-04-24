package string;

public class BlinkTest {
	public static String setMmcCmdName(String mmcCmdName) {

		char[] blinkFilter = mmcCmdName.toCharArray();
		StringBuffer buffer = new StringBuffer();

		//이전 항목이 Space 이면 true
		boolean preSpace = false;

		for ( int i=0;i<blinkFilter.length;i++ ){
			if ( blinkFilter[i] == ' ' ) {
				if ( preSpace ) {
					continue;
				} else {
					preSpace = true;
				}
			} else {
				preSpace = false;
			}
			buffer.append( blinkFilter[i] );
		}

		return buffer.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(  BlinkTest.setMmcCmdName("STrING    AA bb    Cd") );
	}
}
