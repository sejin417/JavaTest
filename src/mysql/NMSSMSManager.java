package mysql;

import java.sql.Connection;
import java.sql.DriverManager;


public class NMSSMSManager {
	
	Connection conn = null;
	String driver = "org.gjt.mm.mysql.Driver";
	String url = "jdbc:mysql://10.81.204.41:3306/mysql";
	
	public void connect(){
		try {
			Class.forName(driver);
			
			System.out.println("DRIVER 성공");
			conn = DriverManager.getConnection( url,"sejin","1q2w3e");
			System.out.println("성공입니다");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if ( conn != null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deliveryMessage(String message, String senderNumber, String receiverNumber) 
	{
		
	}
	
	public static void main(String[] args){
		NMSSMSManager nmsSms = new NMSSMSManager();
		
		nmsSms.connect();
		nmsSms.disconnect();
	}
}
