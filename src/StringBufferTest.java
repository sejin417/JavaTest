/*
 * Created on 2005. 11. 24
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author 세진
 */
public class StringBufferTest {
    public static void main(String arg[]){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ( ");
		sql.append("SELECT K.PACKAGE_TITLE AS 제목, ");
		sql.append("	   SUM(TRAFFIC_CNT) AS Traffic, ");
		sql.append("	   SUM(BYTE_CNT) AS Byte, ");
		sql.append(" 	   SUM(PACKET_CNT) AS Packet, ");
		sql.append("	   SUM(NETFLOWPKT_CNT) AS NetFlow ");
		sql.append("FROM PACKAGE K, PROJECT P, PROJECT_TRAFFIC_STATUS T ");
		sql.append("WHERE T.PROJECT_ID = P.PROJECT_ID AND ");
		sql.append("	  K.PACKAGE_ID = P.PACKAGE_ID ");
		sql.append("GROUP BY K.PACKAGE_TITLE ) ");
		
		System.out.println(sql.toString());
		
		String ifNum = "111";
        StringBuffer ifNumBuffer = new StringBuffer(ifNum);
        for ( int i =0;i<(10-ifNum.length());i++){
        	ifNumBuffer.insert(0, '0');
        }
        System.out.println(ifNumBuffer.toString());

    }
}
