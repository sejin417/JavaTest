package nio.original;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleChatServer {

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	private static FileHandler fileHandler;
	private static Logger logger = Logger.getLogger("net.daum.javacafe");

	private Selector selector = null;
	private ServerSocketChannel serverSocketChannel = null;
	private ServerSocket serverSocket  = null;

	private Vector room = new Vector();

	public void initServer() {
		try {
			selector = Selector.open();

			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocket = serverSocketChannel.socket();

			InetSocketAddress isa = new InetSocketAddress(HOST,PORT);
			serverSocket.bind(isa);

			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			log(Level.WARNING, "CHAT Server.initServer()", e);
		}
	}

	public void startServer() {
		info("Server is started...");
		try {
			while(true) {
				info("요청을 기다리는 중..");
				selector.select();

				Iterator it = selector.selectedKeys().iterator();

				while ( it.hasNext() ) {
					SelectionKey key =(SelectionKey) it.next();
					if ( key.isAcceptable() ) {
						accept(key );
					} else if ( key.isReadable() ){
						read(key);
					}
					it.remove();
				}
			}
		} catch (Exception e) {
			log(Level.WARNING, "Chat Server.startServer()", e);
		}
	}

	private void accept(SelectionKey key) {
		ServerSocketChannel server = (ServerSocketChannel)key.channel();
		SocketChannel sc;
		try {
			sc = server.accept();
			registerChannel(selector, sc, SelectionKey.OP_READ);

			info(sc.toString()+" 클라이언트 접속");
		} catch (Exception e) {
			log(Level.WARNING, "Chat Server.accep()", e);
		}
	}

	private void registerChannel(Selector selector, SocketChannel sc, int ops ) throws IOException {
		if ( sc == null ){
			info("Invalid Connection");
			return;
		}
		sc.configureBlocking(false);
		sc.register(selector, ops);
		addUser(sc);
	}

	private void read(SelectionKey key ){
		SocketChannel sc = (SocketChannel)key.channel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try {
			int read = sc.read(buffer);
			info(read + " byte read");
		} catch (Exception e) {
			try {
				sc.close();
			} catch (Exception e1) {
			}
			removeUser(sc);
			info(sc.toString() + " 클라이언트 접속 해제 ");
		}

		try {
			broadcast(buffer);
		} catch (Exception e) {
			log( Level.WARNING, "Chat Server.broadcast()",e);
		}
		clearBuffer(buffer);
	}

	private void broadcast(ByteBuffer buffer) throws IOException {
		buffer.flip();

		Iterator iter = room.iterator();
		while ( iter.hasNext() ) {
			SocketChannel sc = (SocketChannel)iter.next();
			if ( sc != null ) {
				sc.write(buffer);
				buffer.rewind();
			}
		}
	}

	private void clearBuffer(ByteBuffer buffer) {
		if ( buffer != null ) {
			buffer.clear();
			buffer =null;
		}
	}

	private void addUser(SocketChannel sc ) {
		room.add(sc);
	}

	private void removeUser(SocketChannel sc ) {
		room.remove(sc);
	}

	public void initLog() {
		try {
			fileHandler = new FileHandler("ChatServer.log");
		} catch (Exception e) {
		}
		logger.addHandler(fileHandler);
		logger.setLevel(Level.ALL);
	}
	
	public void log ( Level level, String msg, Throwable error) {
		logger.log(level, msg, error);
	}
	
	public void info ( String msg ) {
		logger.info(msg);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleChatServer scs = new SimpleChatServer();
		scs.initLog();
		scs.initServer();
		scs.startServer();
	}
}
