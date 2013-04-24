package oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/*
 * (@)# JdbcDateTest.java
 * 
 * 2006. 7. 19
 *
 * ====================================================================
 *
 * WarePlus., Software License, Version 1.0
 *
 * Copyright (c) 2002-2004 Ware Plus.,
 * WarePlus  * All rights reserved.
 *
 * DON'T COPY OR REDISTRIBUTE THIS SOURCE CODE WITHOUT PERMISSION.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL WarePlus OR ITS
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * For more information on this product, please see 
 * WarePlus
 *
 */

/**
 * @author Sejin
 * 
 */
public class JdbcDateTest {
    
    private String _driver = "oracle.jdbc.driver.OracleDriver",
    _url, _user, _password ;

    Connection conn = null;
    Connection conn2 = null;
	Statement stmt = null;
	Statement stmt2 = null;
	ResultSet rs = null;
    
    public JdbcDateTest() throws ClassNotFoundException, SQLException{
        String sql = "UPDATE COLLECT " +
        		"SET AGENT_CONNECT = '5' " +
        		"WHERE COLLECT_ID = '06'";
        
        String sql2 = "SELECT AGENT_CONNECT FROM COLLECT " +
        		"WHERE COLLECT_ID = '06'";
        
	    _url = "jdbc:oracle:thin:@220.123.31.69:1521:ntmsdb";
	    _user = "ipflow";
	    _password = "flow00";

		Class.forName( _driver);

		conn = DriverManager.getConnection(_url,_user,_password);
		conn2 = DriverManager.getConnection(_url,_user,_password);

		stmt = conn.createStatement();
		stmt2 = conn2.createStatement();
		
		conn.setAutoCommit(true);
		
		stmt.executeUpdate(sql);
		
		rs = stmt2.executeQuery( sql2 );
		
		String edatetime = null;

		while ( rs.next() ){
            edatetime = rs.getString("AGENT_CONNECT");
            System.out.println(edatetime);
        }

		long vReturn;
        if ( edatetime == null ){
            vReturn = 0;
        } else {
            Calendar cal = Calendar.getInstance();
            
            cal.set(Calendar.YEAR, Integer.parseInt(edatetime.substring(0,4)));
            cal.set(Calendar.MONTH, Integer.parseInt(edatetime.substring(4,6)));
            cal.set(Calendar.DATE, Integer.parseInt(edatetime.substring(6,8)));
            cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(edatetime.substring(8,10)));
            cal.set(Calendar.MINUTE, Integer.parseInt(edatetime.substring(10,12)));
            cal.set(Calendar.SECOND, 0);

            vReturn = cal.getTimeInMillis();
        }
        
        System.out.println(vReturn);
        
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( vReturn);
        
        String activity = "[" + cal.get(Calendar.MONTH) 
        + "/" + cal.get(Calendar.DAY_OF_MONTH) 
        + "/" + cal.get(Calendar.YEAR) 
        + " " 
        + cal.get(Calendar.HOUR_OF_DAY) 
        + ":" + cal.get(Calendar.MINUTE) 
        + ":" + cal.get(Calendar.SECOND);

        // --- display the activity
        System.out.println(activity);
        
    }

    public static void main( String[] args){
        try {
            new JdbcDateTest();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
