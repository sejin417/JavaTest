package string;

public class SubStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String mcip = "125.152.96.208:5080";
		if ( mcip != null && mcip.indexOf(":") > 0 ) {
			mcip = mcip.substring(0, mcip.indexOf(":"));
		} else {
			mcip = "";
		}
		System.out.println("MCIP="+mcip);
		
		StringBuffer result = new StringBuffer();
		String date = "200711091235";
		if ( date != null && date.length() == 12 ){
			result.append( date.substring(0,4)+".");
			result.append( date.substring(4,6)+".");
			result.append( date.substring(6,8)+" ");
			result.append( date.substring(8,10)+":");
			result.append( date.substring(10,12)+"");
			
		}else {
			result.append( date );
		}
		System.out.println(result.toString());
		
		String endTime = "2007.08.09 11:11";
    	endTime = endTime.substring(0,4) + 
    	endTime.substring(5,7) + 
    	endTime.substring(8,10) + 
    	endTime.substring(11,13) +
    	endTime.substring(14,16);
    	System.out.println( endTime );
    	
    	String portId = "GWJSSUU01-010215055";
    	System.out.println(portId.substring(0,portId.indexOf("-")));
    	
    	String temp = "WM-AS1-SSWID2";
    	int index = temp.indexOf("SSWID");
    	System.out.println(temp.substring(0,index - 1));
	}

}
