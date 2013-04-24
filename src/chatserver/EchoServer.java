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
			System.out.println("���ڼ����� ������>>");
			listening();
		}catch(Exception ex){
			System.out.println("���ڼ��� ������ �����߻� : "+ex);
		}
	}

	//Ŭ���Ʈ�� ������ �����ϴ� ��� (�޼ҵ�)
	public void listening(){
		while(ss !=null){
			try{
				Socket s = ss.accept();
				System.out.println(s.getInetAddress().getHostAddress()+
						"���� �����߽��ϴ�...");

				//������ Ŭ���̾�Ʈ�� ����� ����ϴ� ������ ����
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

