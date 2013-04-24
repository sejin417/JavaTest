package rmi.object;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {
	private static String name;
	public HelloImpl(String s) throws java.rmi.RemoteException {
		super();
		name = s;
		System.out.println("name:"+name + ":" + this);
	}
	
	public String sayHello(String client_msg) throws RemoteException {
		name = client_msg; 
		String var = client_msg;
		System.out.println("Client :: "+this.getClass()+"::" + client_msg);
		String response_msg = new String(" Oh! How are you? I`m Remote " + name);
		
		System.out.println( "Response Msg 1:"+this.getClass()+"::"+client_msg+"::"+var+"::" +response_msg);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( "Response Msg 2:"+this+"::"+client_msg+"::"+var+"::" +name);

		return "Response Msg 3:"+this.getClass()+"::"+client_msg+"::"+var+"::" +name;
	}
}
