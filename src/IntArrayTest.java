import java.util.Enumeration;
import java.util.Vector;

/*
 * 작성된 날짜: 2005. 7. 4
 *
 * TODO 생성된 파일에 대한 템플리트를 변경하려면 다음으로 이동하십시오.
 * 창 - 환경 설정 - Java - 코드 스타일 - 코드 템플리트
 */

/**
 * @author 주세진
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
