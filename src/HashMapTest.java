import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class HashMapTest {
	public static void main(String[] args){
		HashMap map = new HashMap();

		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");

		Iterator iterator = map.entrySet().iterator();
		Entry key;
		while(iterator.hasNext()){
			key = (Entry)iterator.next();
			
			System.out.println("KEY="+key.getKey() + "  Value="+key.getValue());
			
			if (((String)key.getKey()).equals("a")){
				iterator.remove();
//				map.remove(key.getKey());
				
//				break;
//				System.out.println("-----");
			}
		}
		
		System.out.println("-------------------------------");
		
		iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			key = (Entry)iterator.next();
			
			System.out.println("KEY="+key.getKey() + "  Value="+key.getValue());
		}
	}

}
