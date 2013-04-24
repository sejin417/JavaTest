package rmi;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.kt.bcn.adaptor.common.remote.BcnIntegratedInterface;


import rmi.object.Hello;

public class TestRMIClient extends Thread{
	BcnIntegratedInterface internalInf = null;

	String msg = "";

	public TestRMIClient(String msg){
		this.msg = msg;
//		System.out.println("Msg"+msg);
	}
	
	public void run() {
		try {
			internalInf = (BcnIntegratedInterface) Naming.lookup("rmi://10.81.204.21:1099/AdaptorRemote");
			internalInf.getManagedObject(null, 0, 0);
//			System.out.println( internalInf.sayHello(msg));
//			System.out.println( "SLEEP");
			Thread.sleep(1000000);
//			System.out.println( internalInf.sayHello(msg));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void main(String[] args) throws java.rmi.RemoteException 
	{
		for(int i=0;i<10000;i++){
			TestRMIClient aaa = new TestRMIClient("AAA"+i);

			aaa.start();
			System.out.println(i);

//			System.out.println(i);s
		}		
	}
}