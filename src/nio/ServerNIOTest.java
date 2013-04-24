package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Logger;

public class ServerNIOTest {
	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	private static Logger logger = Logger.getLogger("net.daum.javacafe");

	private Selector selector = null;
	private ServerSocketChannel serverSocketChannel = null;
	private ServerSocket serverSocket  = null;

	public void initServer() throws IOException{
		selector = Selector.open();
		serverSocketChannel = ServerSocketChannel.open();
		serverSocket = serverSocketChannel.socket();

		InetSocketAddress isa = new InetSocketAddress( HOST, PORT);

		serverSocket.bind(isa);

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}

	private void info(String msg){
		System.out.println("INFO:"+msg);
	}

	private void addUser(SocketChannel sc ){

	}

	private void registerChannel( Selector selector, SocketChannel sc, int ops) throws IOException {
		if ( sc==null) {
			info("Invalid connection");
			return;
		}
		sc.configureBlocking(false);
		sc.register(selector, ops);
		addUser(sc);
	}

	public void startServer(){
		info("Start Server");
		try {
			while ( true ) {
				info("Wait ... ... ...");
				selector.select();
				Iterator it = selector.selectedKeys().iterator();

				while( it.hasNext()) {
					SelectionKey key = (SelectionKey)it.next();
					if ( key.isAcceptable() ) {
						
					} else if ( key.isReadable() ) {
						
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
	}
}
