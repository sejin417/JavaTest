package ejbtest.mdb;

public class MDBThread extends Thread{
	private String key;
	
	public MDBThread(String key){
		this.key = key;
	}
	
	public void run(){
		MessagePool mg = MessagePool.getInstance();
		System.out.println("Msg "+ key);
		mg.action(key);
	}
}
