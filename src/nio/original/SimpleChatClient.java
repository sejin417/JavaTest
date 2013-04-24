package nio.original;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleChatClient {
	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	private static FileHandler fileHandler;
	private static Logger logger = Logger.getLogger("net.daum.javacafe");

	private Selector selector = null;
	private SocketChannel sc = null;

	private Charset charset = null;
	private CharsetDecoder decoder = null;

	public SimpleChatClient() {
		charset = Charset.forName("EUC-KR");
		decoder = charset.newDecoder();
	}

	public void initServer() {
		try {
			selector = Selector.open();

			sc = SocketChannel.open( new InetSocketAddress(HOST,PORT));
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);

		} catch (Exception e) {
			log(Level.WARNING, "ChatClient.initServer()",e );
		}
	}

	public void startServer() {
		startWriter();
		startReader();
	}
	
	private void startWriter() {
		info("Writer is started..");
		Thread t= new MyThread(sc);
		t.start();
	}

	private void startReader() {
		info("Reader is started..");

		try {
			while (true) {
				info("요청 대기..");

				selector.select();

				Iterator it = selector.selectedKeys().iterator();

				while (it.hasNext()) {
					SelectionKey key = (SelectionKey)it.next();

					if ( key.isReadable() ) {
						read(key);
					}
					it.remove();
				}
			}
		} catch (Exception e) {
			log(Level.WARNING, "ChatClient.startReader()",e );
		}
	}

	private void  read(SelectionKey key ) {
		SocketChannel sc = (SocketChannel)key.channel();
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		int read = 0;
		try {
			read = sc.read(buffer);
			info(read +" Byte Read ");
		} catch (Exception e) {
			try {
				sc.close();
			} catch (Exception e1) {
			}
		}

		buffer.flip();
		String data = "";
		try {
			data = decoder.decode(buffer).toString();
		} catch (Exception e) {
			log(Level.WARNING, "ChatClient.read()",e );
		}

		System.out.println("Message - "+data);

		clearBuffer(buffer);
	}

	private void clearBuffer(ByteBuffer buffer) {
		if (buffer != null ) {
			buffer.clear();
			buffer =null;
		}
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
		SimpleChatClient scc = new SimpleChatClient();
		scc.initLog();
		scc.initServer();
		scc.startServer();
	}

	class MyThread extends Thread {
		private SocketChannel sc = null;
		public MyThread(SocketChannel sc ) {
			this.sc = sc;
		}

		public void run() {
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			try {
				while (!Thread.currentThread().isInterrupted()) {
					buffer.clear();
					BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
					String message = in.readLine();

					if ( message.equals("quit") || message.equals("shutdown")) {
						System.exit(0);
					}

					buffer.put(message.getBytes());
					buffer.flip();

					sc.write(buffer);
				}
			} catch (Exception e) {
				log(Level.WARNING, "MyThread.run()",e );
			} finally {
				clearBuffer(buffer);
			}
		}
	}
}
