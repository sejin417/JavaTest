
public class IpLongTest {
	private String getIp(String column ) {
		String vReturn="";
		if (column.length() >= 6)
			vReturn = column.substring(0, 6);//AREA_IN
		else if (column.length() > 0)
			vReturn = column.substring(0, column.length());//AREA_IN
		else
			vReturn = "999999";
		
		return vReturn;

	}

	public static void main(String[] args){
		String a = "0";
		System.out.println(Long.parseLong(a));
		IpLongTest t = new IpLongTest (); 
//		String[] s = {"3537826165","0","0","9999","9999","0","0","999999","999999","136119198","179362","1420","31.4","1533945.3","-1512284.4","V","B"};
		System.out.println(t.getIp("0000000000"));
//		for( int i=0; i< s.length; i++){
//			System.out.println(s[i]);
//		}
	}
}
