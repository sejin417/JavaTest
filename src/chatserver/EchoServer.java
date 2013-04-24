package chatserver;

import java.io.*;
import java.net.*;

public class EchoServer {
	ServerSocket ss;
	int port;
	public EchoServer(){
		this(5700);
	}
	public EchoServer(int port){
		this.port = port;
		try{
			ss = new ServerSocket(port);
			System.out.println("에코서버가 구동됨>>");
			listening();
		}catch(Exception ex){
			System.out.println("에코서버 구동중 에러발생 : "+ex);
		}
	}

	//클라언트의 연결을 수신하는 기능 (메소드)
	public void listening(){
		while(ss !=null){
			try{
				Socket s = ss.accept();
				System.out.println(s.getInetAddress().getHostAddress()+
						"님이 접속했습니다...");

				//각각의 클라이언트와 통신을 담당하는 스레드 생성
				EchoThread echoThread = new EchoThread(s);
				echoThread.start();

			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		EchoServer server = new EchoServer();
	}
}

