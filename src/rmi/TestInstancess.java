package rmi;

public class TestInstancess extends Thread {
	String msg;
	public TestInstancess(String msg){
		this.msg = msg;
	}
	
	public void run() {
		
		System.out.println( msg );
		System.out.println( TestInstancess.getMsg(msg) );
	}
	
	
	public static String getMsg(String msg){
		
		String var = msg;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var;
	}

	public static void main(String arg[]) {
		TestInstancess a = new TestInstancess("AAA");
		TestInstancess b = new TestInstancess("CCC");
		TestInstancess c = new TestInstancess("BBB");
		
		
		a.start();
		c.start();
		b.start();
	}
}
