package chatserver;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class ESBackup
{
	Vector list = null;
	ServerSocket agentDaemon = null;

	public void write(String msg){
		System.out.println( msg );
	}

	public void start(){
		
		Socket clientSocket = null;
		try {
			agentDaemon = new ServerSocket(5700);
			agentDaemon.setReuseAddress(true);
			write( "" +agentDaemon.getReuseAddress() );
			write( "Server Socket 생성   Port Number:" + 5700 );
			list = new Vector();
			
			agentDaemon.setReuseAddress(true);
			ConnectionClientBackup cc;
			while( true ){

				clientSocket = agentDaemon.accept();
				
				cc = new ConnectionClientBackup(this,clientSocket);

				list.add(cc);
				write( "Count:" +list.size());
				//Daemon Thread로 생성
//				cc.setDaemon( true );
				cc.start();
			}
		} catch (SocketException e){
			write("Socket을 생성할 수 없습니다.");
		} catch (IOException e) {
			write("Socket을 생성할 수 없습니다.");
		} finally {
			try {
				write( "Analyzer Daemon Close");
				clientSocket.close();
				agentDaemon.close();
			} catch (Exception e1) {
				write( "수집서버를 초기화 하지 못하였습니다.");
			}
		}
	}

	public static void main(String args[]){
		new ESBackup().start();
	}
}

class ConnectionClientBackup extends Thread {
	ESBackup _es =null;
	Socket _client = null;
	protected DataInputStream in;
	protected DataOutputStream out;

	public ConnectionClientBackup(ESBackup es, Socket client){
		this._es = es;
		this._client = client;

		try {
			in = new DataInputStream( _client.getInputStream());
			out = new DataOutputStream( _client.getOutputStream());
//			write( "PORT:"+_client.getPort() + "  IP:"+_client.getInetAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aa(){
		try {
			_client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){
		try {
			byte[] _tmp = new byte[1024];

			String clientMessage; 
			String msg = "<?xml version= \"1.0 \"?><cross-domain-policy><allow-access-from domain= \"*\" to-ports= \"5700 \" /></cross-domain-policy>" + '\0';

			while ( ( in.read( _tmp )) > 0  ){

				clientMessage = new String(_tmp);
				write("Connection Msg:" + clientMessage + ";");

				out.write(msg.getBytes());
				out.flush();
			}
			aa();
			System.out.println("클라이언트 종료");
		}catch (IOException e) {
			e.printStackTrace();
//			kill();
		}
	}

	public void write(String msg){
		System.out.println(msg);
	}
}
