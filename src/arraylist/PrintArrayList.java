package arraylist;

import java.util.ArrayList;

public class PrintArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList temp = new ArrayList();
		
		String a = "a";
		String b = "b";
		String c = "c";
		
		temp.add(a);
		temp.add(b);
		temp.add(c);
		
		System.out.println(temp);
		
		System.out.println("--------------------------");
		System.out.println("Size:"+ temp.size());
		System.out.println((temp.size()>0?true:false));
		System.out.println("--------------------------");
		for(int i=0;i<temp.size();i++){
			System.out.println(temp.get(i));
		}
	}

}
