import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;


public class ReferanceTest {
	public static void main(String[] args){
		HashMap a = new HashMap(4);
		HashMap b;
		a.put("A",new Test(true));
		
		b = a;
		
		Test t = (Test)b.get("A");
		
		t.t= false;
		

		a.put("B",new Test(true));
		
		
		Iterator i = b.entrySet().iterator();
		Entry entry;
		Test tt;
		while( i.hasNext() ){
			entry = (Entry)i.next();
			tt = (Test)entry.getValue();
			System.out.println((String)entry.getKey()+tt.t);
		}
	}	
}


class Test{
	boolean t;
	public Test(boolean t){
		this.t= t;
	}
}
