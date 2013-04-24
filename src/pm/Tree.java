package pm;

import java.sql.*;
import java.util.*;
import common.*;

public class Tree {

	private DBConnectionMgr pool = null;

    public Tree() {
		try{
			pool = DBConnectionMgr.getInstance();
		}
		catch(Exception e){
			System.out.println("Error : 커넥션 가져오기 실패!!");
		}
    }

	public Vector getName(String parentIndex){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String strQuery = null;
		Vector vReturn = new Vector();
		ScopeInfoBean scope;
		try {
			con = pool.getConnection();
			stmt = con.createStatement();
			strQuery = " SELECT PARENT_IDX, NM, IDX, CLASS_ID, LOCATIONCODE, STACKMODULENUM " +
						"FROM TREE " +
						"WHERE PARENT_IDX = '" + parentIndex + "' " +
						"ORDER BY IDX";

			//System.out.println(strQuery);
			rs = stmt.executeQuery(strQuery);
		
			while (rs.next()) {
				scope = new ScopeInfoBean( rs.getString("NM"), rs.getInt("IDX"), rs.getInt("CLASS_ID"), 
					rs.getString("LOCATIONCODE" ), rs.getString("STACKMODULENUM"));
				vReturn.addElement( scope );
			}
		}catch(Exception ex){
			System.out.println("Exception" + ex);
		}finally{
			pool.freeConnection(con,stmt,rs);	  
		}
		return vReturn;
	}
}
