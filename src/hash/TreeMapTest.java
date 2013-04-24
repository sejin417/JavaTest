package hash;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapTest {
	TreeMap tm = new TreeMap();
	
	public void sort(){
		tm.put("13", "13");
		tm.put("15", "15");
		tm.put("11", "11");
		tm.put("14", "14");
		tm.put("12", "12");
		tm.put("10", "10");

		Iterator iterator = tm.entrySet().iterator();
		Entry entry;
		while(iterator.hasNext()){
			entry = (Entry)iterator.next();
			System.out.println( (String)entry.getKey() );
		}
	}
	
	public static void main(String[] args){
		TreeMapTest tmt = new TreeMapTest();
		tmt.sort();
	}
}
