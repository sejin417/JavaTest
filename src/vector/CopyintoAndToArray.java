package vector;

import java.util.Vector;

public class CopyintoAndToArray {
	public String[] copyInto(Vector v){
		String[] result = new String[v.size()];
		
		v.copyInto(result);

		return result;
	}
	
	public String[] toArray(Vector v){
		String[] result = new String[v.size()];
		
		v.toArray(result);
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyintoAndToArray test = new CopyintoAndToArray();

		Vector v = new Vector();
		String[] value;

		v.add("AAA");
		v.add("BBB");
		v.add("CCC");
		v.add("DDD");
		v.add("FFF");

		value = test.toArray(v);
		
		for(int i=0;i<value.length;i++)
			System.out.println( v.get(i) );
	}

}
