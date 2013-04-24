package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SSCAcceptExample {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind( new InetSocketAddress(8080));
		ssc.configureBlocking(false);
		while(true) {
			System.out.println("Connection 대기중");
			SocketChannel sc = ssc.accept();
			if ( sc == null) {
				Thread.sleep(1000);
			} else {
				System.out.println( sc.socket().getRemoteSocketAddress() + " 연결시도" );
			}
		}
	}

}
