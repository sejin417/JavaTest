
public class StringBufferCapacityTest {
	public static void main(String[] args){
		StringBuffer temp = new StringBuffer(10);
		
		temp.append("012345678");
		
		temp.append("abcdefg");
		
		System.out.println(temp.toString());
	}
}
