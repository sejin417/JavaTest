package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPEchoServer {
	protected int port;
	
	public UDPEchoServer(int port){
		this.port = port;
	}
	
	public void execute() throws IOException , InterruptedException {
		java.nio.channels.DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress("localhost",port));
		channel.configureBlocking(false);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		while ( true ) {
			buffer.clear();
			SocketAddress addr = channel.receive(buffer);
			
			if (addr != null ) {
				System.out.println("패킷이 도착했습니다");
				buffer.flip();
				channel.send(buffer,addr);
			} else {
				System.out.println("패킷 없음");
				Thread.sleep(5000);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UDPEchoServer server =new UDPEchoServer(8080);
		try {
			server.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
