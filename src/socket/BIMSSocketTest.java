package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIMSSocketTest {
	private static final int DEFAULT_PORT					= 9000;
	private ServerSocket bimsDaemon = null;

	public void start(){
		try {
			bimsDaemon = new ServerSocket( DEFAULT_PORT );
			Socket clientSocket = null;

			try {
				clientSocket = bimsDaemon.accept();

				System.out.println("connect");
				
				System.out.println("IPADDRESS:"+clientSocket.getInetAddress());
			}catch(Exception e){

			}finally{
				System.out.println("close");
				clientSocket.close();
				bimsDaemon.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		BIMSSocketTest test= new BIMSSocketTest();
		test.start();
	}
}
