
package rmi.object;

import java.rmi.*;

public interface Hello extends java.rmi.Remote {
	String sayHello(String client_msg) throws java.rmi.RemoteException;

}
