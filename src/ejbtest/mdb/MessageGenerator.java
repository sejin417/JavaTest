package ejbtest.mdb;

public class MessageGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MDBThread mdbt;

		try {
			//A,B,A,C,A,B,B,C,A
			mdbt = new MDBThread("A");
			mdbt.start();
			Thread.sleep(1000);
			
			mdbt = new MDBThread("A");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("A");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("B");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("B");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("A");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("B");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("C");
			mdbt.start();
			Thread.sleep(1000);

			mdbt = new MDBThread("C");
			mdbt.start();
			Thread.sleep(1000);
			
		}catch (Exception e){
			System.out.println("모야이건?  ");
		}
	}
}
