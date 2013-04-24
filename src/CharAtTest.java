
public class CharAtTest {
	public static void main(String[] args){
		
		
		String routerIp = "00210.183.28.12";
		int index = 0;
		
		while ( routerIp.charAt(index) == '0' ){
			index++;
		}
		routerIp = routerIp.substring(index);
	}
}
