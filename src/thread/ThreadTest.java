package thread;

public class ThreadTest implements Runnable{
	private int index =0;
	public void run(){
		try{
			
			while( true ){
				System.out.println("run " + index++);
				Thread.sleep(1000);
			}
		}catch( Exception e){
			
		}
	}
	
	public static void main(String[] args){
		
		try {
			ThreadTest test = new ThreadTest();
			
			Thread temp = new Thread (test);
			
			temp.start();
			
			Thread.sleep(3000);
			
			temp.interrupt();
			temp=null;
			
			Thread.sleep(2000);
			
			temp = new Thread (test);
			
			temp.start();
			
			Thread.sleep(3000);

			temp.interrupt();
			System.exit(0);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
