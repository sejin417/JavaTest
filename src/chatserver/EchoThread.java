package chatserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoThread extends Thread{
	Socket s;
	PrintWriter pw;
	DataInputStream br;
	DataOutputStream pww;
	
	public EchoThread(){
		this(null);
	}
	public EchoThread(Socket s){
		this.s = s;
		try{
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
//			pw = new PrintWriter(out);
			br = new DataInputStream(in);
			
			pww = new DataOutputStream(out);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public void run(){
		try{
			String clientMessage;
			String msg = "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"*\" /></cross-domain-policy>" + '\0';
			byte[] _tmp = new byte[1024];

			while( ( br.read(_tmp) ) > 0 )
			{
				clientMessage = new String(_tmp);
				System.out.println("클라언트 메세지 : "+ clientMessage);
				
//				pww.write(msg.getBytes());
//				pww.flush();
			}
			s.close();
			System.out.println("클라이언트 종료");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}

