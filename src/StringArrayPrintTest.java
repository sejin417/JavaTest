
public class StringArrayPrintTest {
	public static void main(String[] args){
		
		String[] temp = {"aaaaa","bbbb"};
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(temp[0]);
		buffer.append(temp[1]);
		System.out.println(buffer.toString());
		
	}
}
