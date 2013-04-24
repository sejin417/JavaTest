package oracle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;

public class CreateDataFile {

	private static final String DATA_SPLIT = "|";
	private static final String NEW_LINE = "\n";

	private Properties prop;

	private String createDirectory = null;
	private String date = null;
	private File _file = null;
	private FileWriter _fileWrite = null;

	Connection conn = null;
	
	private static void writeLog(String msg){
		System.out.println( msg );
	}

	/**
	 * TGW_STATISTICS Table 데이타 생성
	 * @param _date
	 * @param conn
	 * @throws SQLException
	 * @throws Exception
	 */
	private void tgwStatistics() throws SQLException, Exception {
		writeLog("- TGW_STATISTICS 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/TGW_STATISTICS_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 TGW_STATISTICS 연동 작업을 취소합니다.");
			return;
		}

		StringBuffer query = new StringBuffer();

		query.append("SELECT TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') AS COLLECTIONTIME, \n");
		query.append("     EQUIPMENTID,  \n");
		query.append("     STATISTICSTYPE,  \n");
		query.append("     TRAFFICTYPE,  \n");
		query.append("     BOARDID, \n");
		query.append("     PORTID,  \n");
		query.append("     SUM(TOTAL) AS TOTAL,  \n");
		query.append("     SUM(SUCC) AS SUCC,  \n");
		query.append("     SUM(FAIL) AS FAIL,  \n");
		query.append("     SUM(TDM2PKT) AS TDM2PKT,  \n");
		query.append("     SUM(TDM2TDM) AS TDM2TDM,  \n");
		query.append("     SUM(GOODOCTETSRCV) AS GOODOCTETSRCV,  \n");
		query.append("     SUM(BADOCTETSRCV) AS BADOCTETSRCV,  \n");
		query.append("     SUM(GOODPKTSRCV) AS GOODPKTSRCV,  \n");
		query.append("     SUM(BADPKTSRCV) AS BADPKTSRCV,  \n");
		query.append("     SUM(GOODOCTETSSENT) AS GOODOCTETSSENT,  \n");
		query.append("     SUM(GOODPKTSSENT) AS GOODPKTSSENT,  \n");
		query.append("     SUM(TX) AS TX,  \n");
		query.append("     SUM(RX) AS RX,  \n");
		query.append("     SUM(TXREPLY) AS TXREPLY,  \n");
		query.append("     SUM(RXREPLY) AS RXREPLY,  \n");
		query.append("     SUM(TXREPLYERR) AS TXREPLYERR,  \n");
		query.append("     SUM(RXREPLYERR) AS RXREPLYERR,  \n");
		query.append("     SUM(TXERRMSG) AS TXERRMSG,  \n");
		query.append("     SUM(RXERRMSG) AS RXERRMSG,  \n");
		query.append("     SUM(TXTRANS) AS TXTRANS,  \n");
		query.append("     SUM(RXTRANS) AS RXTRANS,  \n");
		query.append("     SUM(RXERRTRANS) AS RXERRTRANS,  \n");
		query.append("     SUM(TXTRANSPEND) AS TXTRANSPEND,  \n");
		query.append("     SUM(RXTRANSPEND) AS RXTRANSPEND,  \n");
		query.append("     SUM(TXRETXTRANS) AS TXRETXTRANS,  \n");
		query.append("     SUM(TXTRANSREPLY) AS TXTRANSREPLY,  \n");
		query.append("     SUM(RXTRANSREPLY) AS RXTRANSREPLY,  \n");
		query.append("     SUM(RXPACKET) AS RXPACKET,  \n");
		query.append("     SUM(RXMULTICAST) AS RXMULTICAST,  \n");
		query.append("     SUM(RXBROADCAST) AS RXBROADCAST,  \n");
		query.append("     SUM(TXPACKET) AS TXPACKET,  \n");
		query.append("     SUM(TXMULTICAST) AS TXMULTICAST,  \n");
		query.append("     SUM(TXBROADCAST) AS TXBROADCAST,  \n");
		query.append("     SUM(INTERFACEID) AS INTERFACEID,  \n");
		query.append("     SUM(TXBYTE) AS TXBYTE,  \n");
		query.append("     SUM(RXBYTE) AS RXBYTE \n");
		query.append("FROM TGW_STATISTICS PARTITION ( TGW_STATISTICS_200709 ) \n");
		query.append("GROUP BY TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24'), \n");
		query.append("     EQUIPMENTID,  \n");
		query.append("     STATISTICSTYPE,  \n");
		query.append("     TRAFFICTYPE,  \n");
		query.append("     BOARDID,  \n");
		query.append("     PORTID \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query.toString());
			while(rs.next()) {
				resultData = new StringBuffer();
				resultData.append( rs.getString("COLLECTIONTIME") + DATA_SPLIT );			//1
				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );				//2
				resultData.append( rs.getInt("STATISTICSTYPE") + DATA_SPLIT );				//3
				resultData.append( rs.getInt("TRAFFICTYPE") + DATA_SPLIT );				//4
				resultData.append( rs.getString("BOARDID") + DATA_SPLIT );					//5
				resultData.append( rs.getString("PORTID") + DATA_SPLIT );					//6
				resultData.append( rs.getInt("TOTAL") + DATA_SPLIT );						//7
				resultData.append( rs.getInt("SUCC") + DATA_SPLIT );						//8
				resultData.append( rs.getInt("FAIL") + DATA_SPLIT );						//9
				resultData.append( rs.getInt("TDM2PKT") + DATA_SPLIT );					//10
				resultData.append( rs.getInt("TDM2TDM") + DATA_SPLIT );					//11
				resultData.append( rs.getInt("GOODOCTETSRCV") + DATA_SPLIT );				//12
				resultData.append( rs.getInt("BADOCTETSRCV") + DATA_SPLIT );				//13
				resultData.append( rs.getInt("GOODPKTSRCV") + DATA_SPLIT );				//14
				resultData.append( rs.getInt("BADPKTSRCV") + DATA_SPLIT );					//15
				resultData.append( rs.getInt("GOODOCTETSSENT") + DATA_SPLIT );				//16
				resultData.append( rs.getInt("GOODPKTSSENT") + DATA_SPLIT );				//17
				resultData.append( rs.getInt("TX") + DATA_SPLIT );							//18
				resultData.append( rs.getInt("RX") + DATA_SPLIT );							//19
				resultData.append( rs.getInt("TXREPLY") + DATA_SPLIT );					//20
				resultData.append( rs.getInt("RXREPLY") + DATA_SPLIT );					//21
				resultData.append( rs.getInt("TXREPLYERR") + DATA_SPLIT );					//22
				resultData.append( rs.getInt("RXREPLYERR") + DATA_SPLIT );					//23
				resultData.append( rs.getInt("TXERRMSG") + DATA_SPLIT );					//24
				resultData.append( rs.getInt("RXERRMSG") + DATA_SPLIT );					//25
				resultData.append( rs.getInt("TXTRANS") + DATA_SPLIT );					//26
				resultData.append( rs.getInt("RXTRANS") + DATA_SPLIT );					//27
				resultData.append( rs.getInt("RXERRTRANS") + DATA_SPLIT );					//28
				resultData.append( rs.getInt("TXTRANSPEND") + DATA_SPLIT );				//29
				resultData.append( rs.getInt("RXTRANSPEND") + DATA_SPLIT );				//30
				resultData.append( rs.getInt("TXRETXTRANS") + DATA_SPLIT );				//31
				resultData.append( rs.getInt("TXTRANSREPLY") + DATA_SPLIT );				//32
				resultData.append( rs.getInt("RXTRANSREPLY") + DATA_SPLIT );				//33
				resultData.append( rs.getInt("RXPACKET") + DATA_SPLIT );					//34
				resultData.append( rs.getInt("RXMULTICAST") + DATA_SPLIT );				//35
				resultData.append( rs.getInt("RXBROADCAST") + DATA_SPLIT );				//36
				resultData.append( rs.getInt("TXPACKET") + DATA_SPLIT );					//37
				resultData.append( rs.getInt("TXMULTICAST") + DATA_SPLIT );				//38
				resultData.append( rs.getInt("TXBROADCAST") + DATA_SPLIT );				//39
				resultData.append( rs.getInt("INTERFACEID") + DATA_SPLIT );				//40
				resultData.append( rs.getInt("TXBYTE") + DATA_SPLIT );						//41
				resultData.append( rs.getInt("RXBYTE") + NEW_LINE );							//42

				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- TGW_STATISTICS 완료");
	}

	/**
	 * EquipPerformance Table 데이타 생성
	 * @param date
	 * @param conn
	 * @throws SQLException
	 * @throws Exception
	 */
	private void equipPerformance() throws SQLException, Exception {
		writeLog("- EquipPerformance 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/EQUIPPERFORMANCE_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 EQUIPPERFORMANCE 연동 작업을 취소합니다.");
			return;
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT EQUIPMENTID,  \n");
		query.append("    TO_CHAR(COMPRESSIONTIME,'yyyy-mm-dd hh24') AS COMPRESSIONTIME,  \n");
		query.append("    BOARDNAME,  \n");
		query.append("    NVL(CONFIGTYPE,'') AS CONFIGTYPE,  \n");
		query.append("    MEMORYUSED_MAX,  \n");
		query.append("    MEMORYUSED_MIN,  \n");
		query.append("    MEMORYUSED_AVERAGE,  \n");
		query.append("    CPUUSED_MAX,  \n");
		query.append("    CPUUSED_MIN,  \n");
		query.append("    CPUUSED_AVERAGE,  \n");
		query.append("    DISKUSED_MAX,  \n");
		query.append("    DISKUSED_MIN,  \n");
		query.append("    DISKUSED_AVERAGE,  \n");
		query.append("    BOARDTYPE  \n");
		query.append(" FROM EQUIPPERFORMANCEHOURLY E \n");
		query.append(" WHERE E.COMPRESSIONTIME BETWEEN TO_DATE('20070901','YYYYMMDD') AND SYSDATE \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery( query.toString() );
			while(rs.next())
			{
				resultData = new StringBuffer();
				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );
				resultData.append( rs.getString("COMPRESSIONTIME") + DATA_SPLIT );
				resultData.append( rs.getString("BOARDNAME") + DATA_SPLIT );
				resultData.append( rs.getInt("CONFIGTYPE") + DATA_SPLIT );
				resultData.append( rs.getDouble("MEMORYUSED_MAX") + DATA_SPLIT );
				resultData.append( rs.getDouble("MEMORYUSED_MIN") + DATA_SPLIT );
				resultData.append( rs.getDouble("MEMORYUSED_AVERAGE") + DATA_SPLIT );
				resultData.append( rs.getDouble("CPUUSED_MAX") + DATA_SPLIT );
				resultData.append( rs.getDouble("CPUUSED_MIN") + DATA_SPLIT );
				resultData.append( rs.getDouble("CPUUSED_AVERAGE") + DATA_SPLIT );
				resultData.append( rs.getDouble("DISKUSED_MAX") + DATA_SPLIT );
				resultData.append( rs.getDouble("DISKUSED_MIN") + DATA_SPLIT );
				resultData.append( rs.getDouble("DISKUSED_AVERAGE") + DATA_SPLIT );
				resultData.append( rs.getDouble("BOARDTYPE") + NEW_LINE );

				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- EquipPerformance 완료");
	}

	/**
	 * Sgw_M3uaasputil Table 데이타 생성
	 * @param date
	 * @param conn
	 * @throws SQLException
	 * @throws Exception
	 */
	private void sgwM3uaasputil() throws SQLException, Exception {
		writeLog("- Sgw_M3uaasputil 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/SGW_M3UAASPUTIL_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 SGW_M3UAASPUTIL 연동 작업을 취소합니다.");
			return;
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT \n");
		query.append("     EQUIPMENTID,  \n");
		query.append("     TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') AS COLLECTIONTIME,   \n");
		query.append("     SUM(ASNO) AS ASNO,  \n");
		query.append("     SUM(ASPNO) AS ASPNO,  \n");
		query.append("     SUM(IP_MP_RX) AS IP_MP_RX,  \n");
		query.append("     SUM(IP_MP_TX) AS IP_MP_TX,  \n");
		query.append("     SUM(IP_MO_RX) AS IP_MO_RX,  \n");
		query.append("     SUM(IP_MO_TX) AS IP_MO_TX,  \n");
		query.append("     SUM(DR_IP_MP) AS DR_IP_MP,  \n");
		query.append("     SUM(DR_SS7_MP) AS DR_SS7_MP,  \n");
		query.append("     SUM(TOT_SSNM) AS TOT_SSNM,  \n");
		query.append("     SUM(DUNA) AS DUNA,  \n");
		query.append("     SUM(DAVA) AS DAVA,  \n");
		query.append("     SUM(SCON) AS SCON,  \n");
		query.append("     SUM(DRST) AS DRST,  \n");
		query.append("     SUM(DUPU) AS DUPU,  \n");
		query.append("     SUM(ASP_ERR_RX) AS ASP_ERR_RX,  \n");
		query.append("     SUM(ASP_ERR_TX) AS ASP_ERR_TX,  \n");
		query.append("     SUM(UP_CNT) AS UP_CNT,  \n");
		query.append("     SUM(DOWN_CNT  ) AS DOWN_CNT  \n");
		query.append(" FROM SGW_M3UAASPUTIL \n");
		query.append(" WHERE COLLECTIONTIME BETWEEN TO_DATE('20070901','YYYYMMDD') AND SYSDATE \n");
		query.append(" GROUP BY EQUIPMENTID,  \n");
		query.append("      TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			while(rs.next())
			{
				resultData = new StringBuffer();
				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );
				resultData.append( rs.getString("COLLECTIONTIME") + DATA_SPLIT );
				resultData.append( rs.getInt("ASNO") + DATA_SPLIT );
				resultData.append( rs.getInt("ASPNO") + DATA_SPLIT );
				resultData.append( rs.getInt("IP_MP_RX") + DATA_SPLIT );
				resultData.append( rs.getInt("IP_MP_TX") + DATA_SPLIT );
				resultData.append( rs.getInt("IP_MO_RX") + DATA_SPLIT );
				resultData.append( rs.getInt("IP_MO_TX") + DATA_SPLIT );
				resultData.append( rs.getInt("DR_IP_MP") + DATA_SPLIT );
				resultData.append( rs.getInt("DR_SS7_MP") + DATA_SPLIT );
				resultData.append( rs.getInt("TOT_SSNM") + DATA_SPLIT );
				resultData.append( rs.getInt("DUNA") + DATA_SPLIT );
				resultData.append( rs.getInt("DAVA") + DATA_SPLIT );
				resultData.append( rs.getInt("SCON") + DATA_SPLIT );
				resultData.append( rs.getInt("DRST") + DATA_SPLIT );
				resultData.append( rs.getInt("DUPU") + DATA_SPLIT );
				resultData.append( rs.getInt("ASP_ERR_RX") + DATA_SPLIT );
				resultData.append( rs.getInt("ASP_ERR_TX") + DATA_SPLIT );
				resultData.append( rs.getInt("UP_CNT") + DATA_SPLIT );
				resultData.append( rs.getInt("DOWN_CNT") + NEW_LINE );

				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- Sgw_M3uaasputil 완료");
	}

	/**
	 * Sgw_Mtprouteavail Table 데이타 생성
	 * @param date
	 * @param conn
	 * @throws SQLException
	 * @throws Exception
	 */
	private void sgwMtprouteavail() throws SQLException, Exception {
		writeLog("- Sgw_Mtprouteavail 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/SGW_MTPROUTEAVAIL_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 SGW_MTPROUTEAVAIL 연동 작업을 취소합니다.");
			return;
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT \n");
		query.append("      EQUIPMENTID,  \n");
		query.append("      TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') AS COLLECTIONTIME,  \n");
		query.append("      SUM(UNAV_RTE_S) AS UNAV_RTE_S,  \n");
		query.append("      SUM(DUR_UNAV) AS DUR_UNAV,  \n");
		query.append("      SUM(START_UNAV) AS START_UNAV,  \n");
		query.append("      SUM(STOP_UNAV) AS STOP_UNAV,  \n");
		query.append("      SUM(OPC_RX_MSU) AS OPC_RX_MSU,  \n");
		query.append("      SUM(OPC_RX_OCT) AS OPC_RX_OCT,  \n");
		query.append("      SUM(DPC_TX_MSU) AS DPC_TX_MSU,  \n");
		query.append("      SUM(DPC_TX_OCT) AS DPC_TX_OCT \n");
		query.append(" FROM SGW_MTPROUTEAVAIL \n");
		query.append(" WHERE COLLECTIONTIME BETWEEN TO_DATE('20070901','YYYYMMDD') AND SYSDATE \n");
		query.append(" GROUP BY EQUIPMENTID,  \n");
		query.append("      TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query.toString());
			while(rs.next())
			{
				resultData = new StringBuffer();
				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );
				resultData.append( rs.getString("COLLECTIONTIME") + DATA_SPLIT );
				resultData.append( rs.getInt("UNAV_RTE_S") + DATA_SPLIT );
				resultData.append( rs.getInt("DUR_UNAV") + DATA_SPLIT );
				resultData.append( rs.getInt("START_UNAV") + DATA_SPLIT );
				resultData.append( rs.getInt("STOP_UNAV") + DATA_SPLIT );
				resultData.append( rs.getInt("OPC_RX_MSU") + DATA_SPLIT );
				resultData.append( rs.getInt("OPC_RX_OCT") + DATA_SPLIT );
				resultData.append( rs.getInt("DPC_TX_MSU") + DATA_SPLIT );
				resultData.append( rs.getInt("DPC_TX_OCT") + NEW_LINE );

				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- Sgw_Mtprouteavail 완료");
	}

	/**
	 * Sgw_Mtpslkavail Table 데이타 생성
	 * @param date
	 * @param conn
	 * @throws SQLException
	 * @throws Exception
	 */
	private void sgwMtpslkavail() throws SQLException, Exception {
		writeLog("- Sgw_Mtpslkavail 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/SGW_MTPSLKAVAIL_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 SGW_MTPSLKAVAIL 연동 작업을 취소합니다.");
			return;
		}

		StringBuffer query = new StringBuffer();

		query.append("  SELECT  \n");
		query.append("    EQUIPMENTID,  \n");
		query.append("    TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') AS COLLECTIONTIME,  \n");
		query.append("    SUM(LKSNO) AS LKSNO,  \n");
		query.append("    SUM(SLKNO) AS SLKNO,  \n");
		query.append("    SUM(D_UNAV_ANY) AS D_UNAV_ANY,  \n");
		query.append("    SUM(D_LOC_INH) AS D_LOC_INH,  \n");
		query.append("    SUM(D_RMT_INH) AS D_RMT_INH,  \n");
		query.append("    SUM(D_UNAV_SLKF) AS D_UNAV_SLKF,  \n");
		query.append("    SUM(LOC_INH) AS LOC_INH,  \n");
		query.append("    SUM(LOC_UNINH) AS LOC_UNINH,  \n");
		query.append("    SUM(START_LOC_INH) AS START_LOC_INH,  \n");
		query.append("    SUM(END_LOC_INH) AS END_LOC_INH,  \n");
		query.append("    SUM(START_RMT_INH) AS START_RMT_INH,  \n");
		query.append("    SUM(END_RMT_INH) AS END_RMT_INH \n");
		query.append("  FROM SGW_MTPSLKAVAIL \n");
		query.append(" WHERE COLLECTIONTIME BETWEEN TO_DATE('20070901','YYYYMMDD') AND SYSDATE \n");
		query.append(" GROUP BY EQUIPMENTID,  \n");
		query.append("      TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query.toString());
			while(rs.next())
			{
				resultData = new StringBuffer();
				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );
				resultData.append( rs.getString("COLLECTIONTIME") + DATA_SPLIT );
				resultData.append( rs.getInt("LKSNO") + DATA_SPLIT );
				resultData.append( rs.getInt("SLKNO") + DATA_SPLIT );
				resultData.append( rs.getInt("D_UNAV_ANY") + DATA_SPLIT );
				resultData.append( rs.getInt("D_LOC_INH") + DATA_SPLIT );
				resultData.append( rs.getInt("D_RMT_INH") + DATA_SPLIT );
				resultData.append( rs.getInt("D_UNAV_SLKF") + DATA_SPLIT );
				resultData.append( rs.getInt("LOC_INH") + DATA_SPLIT );
				resultData.append( rs.getInt("LOC_UNINH") + DATA_SPLIT );
				resultData.append( rs.getInt("START_LOC_INH") + DATA_SPLIT );
				resultData.append( rs.getInt("END_LOC_INH") + DATA_SPLIT );
				resultData.append( rs.getInt("START_RMT_INH") + DATA_SPLIT );
				resultData.append( rs.getInt("END_RMT_INH") + NEW_LINE );

				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- Sgw_Mtpslkavail 완료");
	}

	/**
	 * Sgw_Mtpslkutil Table 데이타 생성
	 * @param date
	 * @param conn
	 * @throws SQLException
	 * @throws Exception
	 */
	private void sgwMtpslkutil() throws SQLException, Exception {
		writeLog("- Sgw_Mtpslkutil 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/SGW_MTPSLKUTIL_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 SGW_MTPSLKUTIL 연동 작업을 취소합니다.");
			return;
		}
		
		StringBuffer query = new StringBuffer();

		query.append("   SELECT   \n");
		query.append("     EQUIPMENTID,   \n");
		query.append("     TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24') AS COLLECTIONTIME,   \n");
		query.append("     SUM(N_SIF_O_TX) AS N_SIF_O_TX,  \n");
		query.append(" 	SUM(N_OCT_RE_TX) AS N_OCT_RE_TX,  \n");
		query.append(" 	SUM(N_MSU_TX) AS N_MSU_TX,  \n");
		query.append(" 	SUM(N_SIF_O_RX) AS N_SIF_O_RX,  \n");
		query.append(" 	SUM(N_MSU_RX) AS N_MSU_RX,  \n");
		query.append(" 	SUM(SLK_CONG_IND) AS SLK_CONG_IND,  \n");
		query.append(" 	SUM(CUM_D_SLK_CONG) AS CUM_D_SLK_CONG,  \n");
		query.append(" 	SUM(MSU_TX_DISC) AS MSU_TX_DISC,  \n");
		query.append(" 	SUM(MSU_RX_DISC) AS MSU_RX_DISC,  \n");
		query.append(" 	SUM(ERLANG_TX) AS ERLANG_TX,  \n");
		query.append(" 	SUM(ERLANG_RX) AS ERLANG_RX \n");
		query.append("   FROM SGW_MTPSLKUTIL \n");
		query.append("  WHERE COLLECTIONTIME LIKE TO_DATE('"+date+"','YYYYMMDD') \n");
		query.append("  GROUP BY EQUIPMENTID,   \n");
		query.append("       TO_CHAR(COLLECTIONTIME,'yyyy-mm-dd hh24')  \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			writeLog("NTMS 연동::SGW_MTPSLKUTIL Table = \n"+ query.toString());
			writeLog("Test11");
			rs = stmt.executeQuery(query.toString());
			writeLog("Test");
			while(rs.next())
			{
				writeLog("0");
				resultData = new StringBuffer();
				writeLog("1");
				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );
				writeLog("2");
				resultData.append( rs.getString("COLLECTIONTIME") + DATA_SPLIT );
				writeLog("3");
				resultData.append( rs.getLong("N_SIF_O_TX") + DATA_SPLIT );
				writeLog("4");
				resultData.append( rs.getLong("N_OCT_RE_TX") + DATA_SPLIT );
				writeLog("5");
				resultData.append( rs.getLong("N_MSU_TX") + DATA_SPLIT );
				writeLog("6");
				resultData.append( rs.getLong("N_SIF_O_RX") + DATA_SPLIT );
				writeLog("7");
				resultData.append( rs.getLong("N_MSU_RX") + DATA_SPLIT );
				writeLog("8");
				resultData.append( rs.getLong("SLK_CONG_IND") + DATA_SPLIT );
				writeLog("9");
				resultData.append( rs.getLong("CUM_D_SLK_CONG") + DATA_SPLIT );
				writeLog("10");
				resultData.append( rs.getLong("MSU_TX_DISC") + DATA_SPLIT );
				writeLog("11");
				resultData.append( rs.getLong("MSU_RX_DISC") + DATA_SPLIT );
				writeLog("12");
				resultData.append( rs.getLong("ERLANG_TX") + DATA_SPLIT );
				writeLog("13");
				resultData.append( rs.getLong("ERLANG_RX") + NEW_LINE );
				
				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- Sgw_Mtpslkutil 완료");
	}

	private void mgwInfo() throws SQLException, Exception {
		writeLog("- MGW_INFO 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/MGW_INFO_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 MGW_INFO 연동 작업을 취소합니다.");
			return;
		}
		
		StringBuffer query = new StringBuffer();

		query.append("   SELECT EQUIPMENTID,  \n");
		query.append("      MGWEQUIPMENTID,  \n");
		query.append("      MGWNAME,  \n");
		query.append("      MGWTYPE,  \n");
		query.append("      FIRSTLIN,  \n");
		query.append("      MAXCARD,  \n");
		query.append("      EQUIPCARD,  \n");
		query.append("      MAXEQ,  \n");
		query.append("      EQUIP,  \n");
		query.append("      IPADDR,  \n");
		query.append("      OPTIMUMPATH,  \n");
		query.append("      CONNECTEDMGWIP,  \n");
		query.append("      MCIP,  \n");
		query.append("      MGWID,  \n");
		query.append("      OSWID \n");
		query.append("   FROM MGW_INFO \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			stmt = conn.createStatement();
			writeLog("NTMS 연동::MGW_INFO Table = \n"+ query.toString());
			rs = stmt.executeQuery(query.toString());
			while(rs.next())
			{
				resultData = new StringBuffer();

				resultData.append( rs.getString("EQUIPMENTID") + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("MGWEQUIPMENTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("MGWNAME")) + DATA_SPLIT );
				resultData.append( rs.getInt("MGWTYPE") + DATA_SPLIT );
				resultData.append( rs.getInt("FIRSTLIN") + DATA_SPLIT );
				resultData.append( rs.getInt("MAXCARD") + DATA_SPLIT );
				resultData.append( rs.getInt("EQUIPCARD") + DATA_SPLIT );
				resultData.append( rs.getInt("MAXEQ") + DATA_SPLIT );
				resultData.append( rs.getInt("EQUIP") + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("IPADDR")) + DATA_SPLIT );
				resultData.append( nullCheck(  rs.getString("OPTIMUMPATH")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("CONNECTEDMGWIP")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("MCIP")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("MGWID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("OSWID")) + NEW_LINE );
				
				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- MGW_INFO 완료");
	}
	
	/**
	 * BcN_LINK TABLE DATA 생성
	 * @throws SQLException
	 * @throws Exception
	 */
	private void bcnLink() throws SQLException, Exception {
		writeLog("- BcN_LINK 파일 생성");
		boolean isOpen = fileOpen( createDirectory + "/BcN_LINK_" + date + ".DAT" );
		if ( !isOpen ) {
			writeLog("파일이 생성되어 있어 BcN_LINK 연동 작업을 취소합니다.");
			return;
		}
		
		StringBuffer query = new StringBuffer();

		query.append("   SELECT LINKID,  \n");
		query.append("        FROMINTERFACEID,  \n");
		query.append("        FROMPORTID,  \n");
		query.append("        FROMEQUIPMENTID,  \n");
		query.append("        FROMEQUIPMENTNAME,  \n");
		query.append("        FROMEQUIPMENTTYPE,  \n");
		query.append("        FROMHEADQUARTERID,  \n");
		query.append("        FROMOFFICEID,  \n");
		query.append("        TOINTERFACEID,  \n");
		query.append("        TOPORTID,  \n");
		query.append("        TOEQUIPMENTID,  \n");
		query.append("        TOEQUIPMENTNAME,  \n");
		query.append("        TOEQUIPMENTTYPE,  \n");
		query.append("        TOHEADQUARTERID,  \n");
		query.append("        TOOFFICEID,  \n");
		query.append("        LINKTYPE,  \n");
		query.append("        LINKBW,  \n");
		query.append("        FROMRACKID,  \n");
		query.append("        FROMSHELFID,  \n");
		query.append("        FROMSLOTID,  \n");
		query.append("        FROMCARDID,  \n");
		query.append("        TORACKID,  \n");
		query.append("        TOSHELFID,  \n");
		query.append("        TOSLOTID,  \n");
		query.append("        TOCARDID,  \n");
		query.append("        LINKNAME \n");
		query.append("   FROM BCNLINK \n");

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultData;
		try {
			stmt = conn.createStatement();
			writeLog("NTMS 연동::BcN_LINK Table = \n" + query.toString());
			rs = stmt.executeQuery(query.toString());
			while(rs.next())
			{
				resultData = new StringBuffer();
				
				resultData.append( rs.getString("LINKID") + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMINTERFACEID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMPORTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMEQUIPMENTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMEQUIPMENTNAME")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMEQUIPMENTTYPE")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMHEADQUARTERID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMOFFICEID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOINTERFACEID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOPORTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOEQUIPMENTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOEQUIPMENTNAME")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOEQUIPMENTTYPE")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOHEADQUARTERID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOOFFICEID")) + DATA_SPLIT );
				resultData.append( rs.getInt("LINKTYPE") + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("LINKBW")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMRACKID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMSHELFID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMSLOTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("FROMCARDID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TORACKID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOSHELFID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOSLOTID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("TOCARDID")) + DATA_SPLIT );
				resultData.append( nullCheck( rs.getString("LINKNAME")) + NEW_LINE );

				write(resultData.toString());
			}
		} finally {
			if(rs != null) try{rs.close();}catch(Exception e){};
			if(stmt != null) try{stmt.close();}catch(Exception e){};
		}
		writeLog("- BcN_LINK 완료");
	}

	/**
	 * 연동데이타를 순차적으로 생성 시키는 매소드
	 * @param date
	 * @return
	 */
	public boolean start(String date){
		boolean result = false;

		this.date = date;

		try {
			writeLog("NTMS Link:: START ["+ this.date + "]\n");
			//DB Connection 생성
			conn = getDBConnection();
			writeLog("NTMS Link:: DB Connection 연결");

			createDirectory = getCreateDirectory();

			if ( createDirectory.equals( "" )){

				return false;
			}

			writeLog("NTMS Link:: 생성 Directory="+createDirectory );

//			equipPerformance();

//			tgwStatistics();

//			sgwM3uaasputil();
//
//			sgwMtprouteavail();
//
//			sgwMtpslkavail();
//
			sgwMtpslkutil();
//
//			mgwInfo();
//
//			bcnLink();

			result = true;
		} catch(SQLException e) {

		} catch(Exception e) {

		}finally {
			try {
				fileClose();
			} catch (IOException e1) { }
			if(conn != null) try{conn.close();}catch(Exception e){};
		}

		return result;
	}

	private String getCreateDirectory() throws SQLException{
		
		return "d:\\NTMSDATA";
//		StringBuffer query = new StringBuffer();
//		String result = "";
//
//		query.append(" SELECT DATADIRECTORY AS DATADIRECTORY FROM LINKAGESYSTEM \n");
//		query.append(" WHERE LINKAGESYSTEMID = 'NTMS' \n");
//
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query.toString());
//			if (rs.next()) {
//				result = rs.getString("DATADIRECTORY");
//			}
//
//			if ( result != null && result.length() > 1){
//				File createDir = new File(result);
//
//				if ( createDir.exists() && createDir.isDirectory() ){
//					createDir = new File( result + "/" + date);
//
//					if ( !(createDir.exists() && createDir.isDirectory()) ){
//						createDir.mkdir();
//						result = result + "/" + date;
//					}
//				}
//			}else  {
//				result = "";
//			}
//		} finally {
//			if(rs != null) try{rs.close();}catch(Exception e){};
//			if(stmt != null) try{stmt.close();}catch(Exception e){};
//		}
//		return result;
	}

	private boolean fileOpen(String fileName) throws IOException{
		fileClose();

		_file = new File( fileName );

		if ( _file.isFile() ){
			return false;
		}

		if ( _file.isDirectory() ){
			return false;
		}

		_fileWrite = new FileWriter( _file ); 

		return true;
	}

	private void fileClose() throws IOException{
		if ( _fileWrite != null ) {
			_fileWrite.close();
			_fileWrite = null;
		}
		if ( _file != null ) {
			_file = null;
		}
	}

	/**
	 * 파일기록 
	 * @param msg
	 * @throws IOException 
	 */
	private void write(String msg) throws IOException{
		_fileWrite.write( msg );
	}

	/**
	 * DB Connection
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private Connection getDBConnection() throws SQLException, ClassNotFoundException
	{

//		String propertiesFile = System.getProperty("server.properties");

//		propertiesFile = "/opt/SUNWappserver/domains/noms/config/server.properties";
//		loadProperties( propertiesFile );

		Connection conn= null;

//		String oracleDriverClassName = prop.getProperty("jdbc.db.driverclass");
//		String dbUrl = prop.getProperty("jdbc.db.url");
//		String dbUser = prop.getProperty("jdbc.db.user");
//		String dbPasswd = prop.getProperty("jdbc.db.password");
		
		String oracleDriverClassName = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@10.240.0.114:1521:bcnnms";
		String dbUser = "noms";
		String dbPasswd = "noms375";

		if ( this.conn != null ) {
			this.conn.close();
			this.conn = null;
		}

		Class.forName(oracleDriverClassName);
		Properties p = new Properties();
		p.put("user", dbUser);
		p.put("password", dbPasswd);
		p.put("CHARSET", "eucksc");
		conn = DriverManager.getConnection(dbUrl, p);
		return conn;
	}

	/**
	 * Load Properties
	 * @param propertiesPath
	 */
	private void loadProperties(String propertiesPath)
	{
		File f = new File(propertiesPath);
		if(!f.exists())
		{
			writeLog("ERROR - Properties not loaded. path["+propertiesPath+"]");
			return;
		}

		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(f);
			prop = new Properties();
			prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(fis != null) try{fis.close();}catch(Exception e){};
		}
	}
	
    
    private String nullCheck(String msg){
    	if (msg == null){
    		return "";
    	}else{
    		return msg;
    	}
    		
    }

	/**
	 * NTMS 연동 Process 시작
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		writeLog("\n↓↓↓↓↓↓↓↓↓↓↓   NTMS 연동 시작   ↓↓↓↓↓↓↓↓↓↓");
		String date;
		if ( args.length != 1 ){

			Calendar cal = Calendar.getInstance();

			cal.set( Calendar.DATE , cal.get(Calendar.DATE) - 1);

			String year = String.valueOf(cal.get(Calendar.YEAR) );
			String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
			String day = String.valueOf(cal.get(Calendar.DATE));

			if ( month.length() < 2) month =  "0" + month;
			if ( day.length() < 2) day = "0" + day;

			date = year + month + day;
		}else {
			date = args[0];

			//날짜 형식이 맞는지 검사
			try {
				Calendar cal = Calendar.getInstance();

				cal.set( Calendar.YEAR, Integer.parseInt(date.substring(0,4)));
				cal.set( Calendar.MONTH, Integer.parseInt(date.substring(4,6)));
				cal.set( Calendar.DATE, Integer.parseInt(date.substring(6,8)));

			}catch(Exception e){
				System.out.println( "날짜 형식이 잘못되었습니다");
				System.exit(0);
			}
		}

		writeLog(date + " 일 NTMS 연동자료를 생성합니다.");

		CreateDataFile ntms = new CreateDataFile();

		if ( !ntms.start( date ) ) {
			writeLog("NTMS 연동 도중 일부 오류가 발생하였습니다.");
			writeLog("NTMS 연동 도중 일부 오류가 발생하였습니다.");
		}

		writeLog("\n↑↑↑↑↑↑↑↑↑↑↑   NTMS 연동 종료   ↑↑↑↑↑↑↑↑↑↑");
	}
}
