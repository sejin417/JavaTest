package smstest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class XroshotTest {
	private Connection conn = null;
	private Statement stmt = null;
	String driver = "org.git.mm.mysql.Driver";
	String url = "jdbc:mysql://147.6.97.46:3306/xshotdb";
	
	public void connect() throws SQLException{
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url,"xshot","xshot123");
			System.out.println("Connection ¼º°ø");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() throws SQLException{
		if ( stmt != null) stmt.close();
		if ( conn != null) conn.close();
	}
	
	public boolean sendNmsSMS( String message, String senderNumber, String receiverNumber) throws SQLException{
		boolean result = true;
		
		connect();
		
		
		
		disconnect();
		
		return result;
	}
	
	public static void main(String[] args) {
		XroshotTest test = new XroshotTest();
		
		try {
			test.sendNmsSMS("", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
