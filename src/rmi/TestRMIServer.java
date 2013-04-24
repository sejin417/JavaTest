package rmi;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import rmi.object.Hello;
import rmi.object.HelloImpl;

public class TestRMIServer {
	public static void main(String args[]) {
		int PORT = 43219;
		
		if (args.length>0) {
			PORT = Integer.parseInt(args[0]);
		}
		
		
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			String thisHost = address.getHostAddress();
			System.out.println("thisHost : " + thisHost);
			Properties properties = System.getProperties();
			properties.put("java.rmi.server.hostname", thisHost);
			
			System.setProperties(properties);
			//
			
			Hello server = new HelloImpl("HelloServer");

			if (PORT!=1099) {
				LocateRegistry.createRegistry(PORT);
				System.out.println("LocateRegistry.createRegistry(" + PORT + ")");
				Naming.rebind("rmi://" + thisHost + ":" + PORT + "/HelloServer", server);
			} else {
//				System.setSecurityManager(new RMISecurityManager());
//				Naming.rebind("rmi://" + thisHost + ":" + PORT + "/HelloServer", server);
			}
//			LocateRegistry.createRegistry(PORT);

			System.out.println("Hello server is ready...");
		} catch (Exception e) {
			System.out.println("an exception occurred.");
			e.printStackTrace();
		}
	}
}
