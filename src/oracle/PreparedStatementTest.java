package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {
	private Connection conn;
	private PreparedStatement project_update_ps;

	String project_update_sql =
		"UPDATE PROJECT SET PROJECT_STATUS=? WHERE PROJECT_ID=?";

	public PreparedStatementTest(){
		try {
			String sDriver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(sDriver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@220.123.31.69:1521:ntmsdb","ipflow","flow00");
			project_update_ps      = conn.prepareStatement(project_update_sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStatus(String status, String project_id){
		int rc = 1;
	    try {
			project_update_ps.setString(1,status);
			project_update_ps.setString(2,project_id);
			rc = project_update_ps.executeUpdate();
			System.out.println(rc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(){
		try{
			if (project_update_ps!=null) try { project_update_ps.close (); } catch (Exception ee)	{}
			if (conn != null) {conn.close(); conn = null;}
		}catch(Exception e){}
	}
	
	public static void main(String[] args){
		PreparedStatementTest temp = new PreparedStatementTest();
		temp.updateStatus("6","06110704");
	}
}
