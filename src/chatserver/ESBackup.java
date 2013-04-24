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
			write( "Server Socket ����   Port Number:" + 5700 );
			list = new Vector();
			
			agentDaemon.setReuseAddress(true);
			ConnectionClientBackup cc;
			while( true ){

				clientSocket = agentDaemon.accept();
				
				cc = new ConnectionClientBackup(this,clientSocket);

				list.add(cc);
				write( "Count:" +list.size());
				//Daemon Thread�� ����
//				cc.setDaemon( true );
				cc.start();
			}
		} catch (SocketException e){
			write("Socket�� ������ �� �����ϴ�.");
		} catch (IOException e) {
			write("Socket�� ������ �� �����ϴ�.");
		} finally {
			try {
				write( "Analyzer Daemon Close");
				clientSocket.close();
				agentDaemon.close();
			} catch (Exception e1) {
				write( "���������� �ʱ�ȭ ���� ���Ͽ����ϴ�.");
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
			System.out.println("Ŭ���̾�Ʈ ����");
		}catch (IOException e) {
			e.printStackTrace();
//			kill();
		}
	}

	public void write(String msg){
		System.out.println(msg);
	}
}
