import java.util.Enumeration;
import java.util.Vector;

/*
 * �ۼ��� ��¥: 2005. 7. 4
 *
 * TODO ������ ���Ͽ� ���� ���ø�Ʈ�� �����Ϸ��� �������� �̵��Ͻʽÿ�.
 * â - ȯ�� ���� - Java - �ڵ� ��Ÿ�� - �ڵ� ���ø�Ʈ
 */

/**
 * @author �ּ���
 *
 */
public class IntArrayTest {

	public static void main(String[] args) {
		int[] test= new int[3];
		test[0] = 1;
		test[1] = 2;
		test[2] = 3;
		test[3] = 4;
		
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]);
		}
		
		Vector a = new Vector();
		for(Enumeration e = a.elements(); e.hasMoreElements(); ){
	    	e.nextElement();
		}
		
	}
}
