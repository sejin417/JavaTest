package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDDLTest {
	public static void main(String[] args){
	    String _driver = "oracle.jdbc.driver.OracleDriver",
	    _url, _user, _password ;

	    Connection conn = null;
		Statement stmt = null;
		
		String packageId = "TEST";
        String sql = "CREATE TABLE RAWDATA_" + packageId +
        		" ( " +
        		"	SRCADDR	 				VARCHAR2(15), " +
        		"	DSTADDR					VARCHAR2(15), " +
        		" 	SRCPORT					NUMBER(5), " +
        		" 	DSTPORT					NUMBER(5), " +
        		"	INPUT_IF				NUMBER(10), " +
        		"	OUTPUT_IF				NUMBER(10), " +
        		"	SRC_AS					NUMBER(8), " +
        		"	DST_AS					NUMBER(8), " +
        		"	PKTS					NUMBER(10), " +
        		"	BYTES					NUMBER(10), " +
        		"	PROTOCOL				NUMBER(3), " +
        		"	TOS						NUMBER(4), " +
        		"	FLOW_START				CHAR(14), " +
        		"	FLOW_END				CHAR(14), " +
        		"	MPLS_LABEL1				NUMBER(10), " +
        		"	MPLS_LABEL2				NUMBER(10), " +
        		"	MPLS_LABEL3				NUMBER(10) " +
        		" ) ";

	    _url = "jdbc:oracle:thin:@220.123.31.69:1521:ntmsdb";
	    _user = "ipflow";
	    _password = "flow00";

		try {
			Class.forName( _driver);
			
			conn = DriverManager.getConnection(_url,_user,_password);

			stmt = conn.createStatement();

			conn.setAutoCommit(false);
			
			boolean ddl = stmt.execute( sql );
			
			System.out.println(ddl);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
