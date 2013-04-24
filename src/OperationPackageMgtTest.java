
public class OperationPackageMgtTest {
	public static void main(String[] args){
		OperationPackageMgt opm = OperationPackageMgt.getInstance();
		
		System.out.println( "Start:"+ opm.getString());
		
		OperationPackageMgt.removeInstance();

		if ( opm == null ){
			System.out.println("null");
		}else {
			System.out.println( "End:"+opm.getString());
		}
		
	}
}
