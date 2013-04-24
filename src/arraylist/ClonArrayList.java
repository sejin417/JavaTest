package arraylist;

import java.util.ArrayList;

public class ClonArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ArrayList temp = new ArrayList();

			DataObjectaa a = new DataObjectaa("aaa");
			DataObjectaa b = new DataObjectaa("bbb");
			DataObjectaa c = new DataObjectaa("ccc");

			ArrayList<DataObjectaa> clonTemp = new ArrayList();
			clonTemp.add(a);
			clonTemp.add(b);
			clonTemp.add(c);

			temp.addAll( clonTemp );

			DataObjectaa t1= (DataObjectaa)clonTemp.get(0);
			System.out.println(t1);
			t1.setAaa("ttt");

			System.out.println(temp);

			System.out.println("--------------------------");
			System.out.println("Size:"+ temp.size());
			System.out.println((temp.size()>0?true:false));
			System.out.println("--------------------------");
			for(int i=0;i<temp.size();i++){
				System.out.println(temp.get(i));
			}
			System.out.println("--------------------------");
			for(int i=0;i<clonTemp.size();i++){
				System.out.println(clonTemp.get(i));
			}
		} catch (Exception e) {
			
		}
	}

}
class DataObjectaa {
	String aaa ="";
	public DataObjectaa() {
	}
	public DataObjectaa(String aa) {
		this.aaa= aa;
	}
	
	/**
	 * @return the aaa
	 */
	public String getAaa() {
		return aaa;
	}
	
	/**
	 * @param aaa the aaa to set
	 */
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}
	
	public String toString() {
		return this.aaa;
	}
}
