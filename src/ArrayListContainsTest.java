import java.util.ArrayList;


public class ArrayListContainsTest {
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		
		list.add("aaaa");
		list.add("cccc");
		list.add("bbbb");
		
		System.out.println(list.contains("aaa"));
		
	}
}
