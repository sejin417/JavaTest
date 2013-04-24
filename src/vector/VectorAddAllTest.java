package vector;

import java.util.Vector;

public class VectorAddAllTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector temp = new Vector();
		Vector temp2 = new Vector();
		Vector temp3 = new Vector();
		CallStatistics call;
		for (int i=0;i<10;i++){
			call = new CallStatistics(); 
			temp2.add(call);
		}
		temp.addAll( temp2 );
		
		for (int i=0;i<10;i++){
			call = new CallStatistics(); 
			temp3.add(call);
		}
		
		temp.addAll( temp3 );
		CallStatistics t;
		for(int i=0;i<temp.size();i++){
			t = (CallStatistics)temp.get(i);
			System.out.println(i);
		}
	}
}
