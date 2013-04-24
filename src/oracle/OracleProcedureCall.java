package oracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.transform.Result;

/*
 * Created on 2005. 11. 8
 *
 */

/**
 * @author 세진
 */
public class OracleProcedureCall {
    
    Connection con;
    Result rs;
    
    
    
    public OracleProcedureCall(){    /////////////// 생성자함수////////////////////////////////////////

        try{
            String temp = "05110704";
            String _driver = "oracle.jdbc.driver.OracleDriver",
            _url = "jdbc:oracle:thin:@61.74.75.49:1521:FLOW",
            _user = "ipflow",
            _password = "flow00";

            Class.forName(_driver);
            con = DriverManager.getConnection(_url,_user,_password);

            CallableStatement cstmt = null;    
            cstmt = con.prepareCall( "{call IPFLOW.PROJECT_PACKAGE.DELETE_PACKAGE( ? ) }" );  

            cstmt.setString(1, temp);;
            cstmt.executeQuery();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    public static void main(String[] args) {
        new OracleProcedureCall();
    }
}
