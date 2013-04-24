package string;

public class ComparisonInteger {
	public static void main(String[] args) {
		String alarm = "MGID01234567890 ";
		StringBuffer mgId = new StringBuffer();
		int mgIdIndex = alarm.indexOf("MGID");
		if ( mgIdIndex >= 0 ) {
			char[] mgIdChar = alarm.substring(mgIdIndex+4).toCharArray();
			for( int i=0;i<mgIdChar.length;i++) {
				if( (byte) mgIdChar[i] >= 48 &&  (byte)mgIdChar[i] <= 57 ) {
					mgId.append(mgIdChar[i]);
				} else {
					break;
				}
			}
			mgId.insert(0, "MGID:");
		}
		
		System.out.println(mgId);
	}
}
