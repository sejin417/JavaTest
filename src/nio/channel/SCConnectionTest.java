package nio.channel;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

public class SCConnectionTest {
	private static int PORT = 8080;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InetAddress ia = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(ia, PORT);
		
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);
		System.out.println("IS Connection Pending 1 :"+ sc.isConnectionPending() );
		sc.connect(isa);
		System.out.println("IS Connection Pending 2 :"+ sc.isConnectionPending() );
		sc.finishConnect();
		System.out.println("IS Connection Pending 3 :"+ sc.isConnectionPending() );
		
		System.out.println("IS Connected 1 :"+ sc.isConnected() );
		System.out.println("IS Blocking Mode :"+ sc.isBlocking() );
	}

}
