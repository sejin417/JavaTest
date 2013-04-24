package math;

public class MathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ( Math.pow(3, 3) );
		
		int i = (int) (177793542 / Math.pow(2,24));
		int j = (int) (177793542 % Math.pow(2,24) / Math.pow(2,16));
		int k = (int) (177793542 % Math.pow(2,16) / Math.pow(2,8));
		int l = (int) (177793542 % Math.pow(2,8));
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		
		System.out.println(i + "." + j + "." + k + "." + l);
	}

}
