package common;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

/*
 * Created on 2005. 10. 10
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author 세진
 */
public class MainGraph {
    DBConnectionMgr pool = null;
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    private final String monCount = "6";		//-1  만큼 보여준다
    private final String dataCount = "4";		//-1 만큼 보여준다
    //    public MainGraph(){
    //        this.flashFile = "";
    //    }
    //    
    //    public MainGraph( String flashFile){
    //        this.flashFile = flashFile;
    //
    //    }
    
    public String getHeader(){
        StringBuffer header = new StringBuffer();
        
        header.append("<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0\" width=\"394\" height=\"190\" id=\"flash_graph\" align=\"middle\"> \n");
        header.append("<param name=\"allowScriptAccess\" value=\"sameDomain\" /> \n");
        header.append("<param name=\"movie\" value=\"flash/flash_graph.swf?");
        //<embed name="graph" Src="flash/main_grid.swf?
        return header.toString();
    }
    
    public String getFooter(){
        StringBuffer footer = new StringBuffer();
        
        footer.append("<param name=\"quality\" value=\"high\" /> \n");
        footer.append("<param name=\"bgcolor\" value=\"#ffffff\" /> \n");
        footer.append("<embed src=\"flash/flash_graph.swf\" quality=\"high\" bgcolor=\"#ffffff\" ");
        footer.append("width=\"394\" height=\"190\" name=\"flash_graph\" align=\"middle\" ");
        footer.append("allowScriptAccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" /> \n");
        footer.append("</object> \n");
        
        return footer.toString();
    }
    
    public String createBody( String title, String yType, String sql ) 
    throws SQLException {
        int maxYCount = 5;
        StringBuffer tag = new StringBuffer();
        
        //저장 공간을 설정한다
        Hashtable table = new Hashtable();
        Hashtable sortMonths = new Hashtable();
        Hashtable sortNote = new Hashtable();
        int xcount = 0;
        
        //데이터 받는 변수 
        String app;
        String month;
        long traffic;
        
        //sql문장을 넘겨서 Result 값을 받는다.
        try{
            pool = DBConnectionMgr.getInstance();
            
            conn = pool.getConnection();
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery( sql );
            
            while( rs.next() ){
                //Application값을 가지고 온다
                app = rs.getString("NM");
                month = rs.getString("MONTHS");
                traffic = rs.getLong("AVGTRAFFIC");
                
                //해당 월의 table을 가지고 온다
                Hashtable data = (Hashtable)table.get( month );
                
                //해당 월의 Table 값이 없으면 생성
                if ( data == null ){
                    data = new Hashtable();
                    sortMonths.put( String.valueOf( xcount ) , month);
                    xcount++;
                }
                
                //범례 문자 및 카운트를 계산하기 위하여 저장한다
                sortNote.put( app,"" );
                
                //Table에 Application과 그에 따른 Traffic 값을 넣는다.
                data.put( app, String.valueOf( traffic ) );
                
                //Table 에 data를 넣는다.
                table.put( month, data );
                
                traffic = 0;
            }
            
            //해더 추가
            tag.append( getHeader() );
            
            //타이틀 추가
            tag.append( "title=" );
            tag.append( title );
            
            //범례 갯수
            tag.append( "&graphcount=" );
            tag.append( sortNote.size() );
            
            
            //X 축 갯수		xcount=
            tag.append( "&xcount=" );
            tag.append( xcount );
            
            //Y 축 갯수		ycount=
            tag.append( "&ycount=" );
            tag.append( maxYCount );
            
            //Y 축 값의 타입	ytype=
            tag.append( "&ytype=" + yType );
            
            //X 축의 갯수에 따른 X축 명칭
            Hashtable tempData;
            String tempApp;
            String trafficData;
            int ycount = 0;
            Enumeration e;
            
            //Y축 명칭
            for( e = sortNote.keys(); e.hasMoreElements(); ){
                tempApp = (String)e.nextElement();
                tag.append( "&yname" + ( ycount + 1 ) + "=" + tempApp );
                ycount++;
            }
            
            for( int i = 0, j; i < sortMonths.size(); i++){
                //처음 보여줄 월을 가져온다.
                month = (String)sortMonths.get( String.valueOf(i) );
                tag.append( "&xname" + (i + 1) + "=" + month );
                
                //해당 월에 대한 범례와 Traffic 값을 가져온다.
                tempData = (Hashtable)table.get( month );
                j = 1;
                for( e = sortNote.keys(); e.hasMoreElements(); ){
                    tempApp = (String)e.nextElement();
                    trafficData = (String)tempData.get( tempApp );
                    tag.append( "&x" + j + ( i + 1 ) + "=" + trafficData );
                    j++;
                }
            }
            
            tag.append("\" /> \n"); 
            
            // 하단 추가
            tag.append( getFooter() );
            
        }catch(Exception e){
            System.out.println("Error : 커넥션 가져오기 실패!!");
        }finally {
            try {
                pool.freeConnection(conn,stmt,rs);
            }catch(Exception ee) {}
        }
        
        //Return
        return tag.toString();
    }
    
    public String getApplicationSql(){
        
        StringBuffer sql = new StringBuffer();
        
        sql.append( "SELECT TRIM(MONTHS||'월') MONTHS, D.APPLICATION_DESC NM, A.AVGTRAFFIC/1024 AVGTRAFFIC ");
        sql.append( "FROM D_APPLICATION D, MONRPT_APPLICATION A " );
        sql.append( "WHERE A.YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND TO_CHAR( SYSDATE,'YYYY' ) AND " );
        sql.append( "A.MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append( "A.APPLICATION IN ( SELECT APPLICATION ");
        sql.append( "FROM ( SELECT APPLICATION, SUM(AVGTRAFFIC), ");
        sql.append( "RANK() OVER( ORDER BY SUM(AVGTRAFFIC) DESC ) RANK ");
        sql.append( "FROM MONRPT_APPLICATION ");
        sql.append( "WHERE YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND ");
        sql.append( "TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append( "MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND ");
        sql.append( "TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append( "APPLICATION < 999 ");
        sql.append( "GROUP BY APPLICATION ) ");
        sql.append( "WHERE RANK < "+dataCount+" ) AND ");
        sql.append( "A.APPLICATION = D.APPLICATION_CODE ");
        sql.append( "ORDER BY APPLICATION_DESC, YEAR_, MONTHS ");
        
        return sql.toString();
    }

    public String getOfficeSql(){

        StringBuffer sql = new StringBuffer();

        sql.append("SELECT TRIM(MONTHS||'월') MONTHS, D.OFFICE_NAME NM, SUM(A.AVGTRAFFIC)/1024 AVGTRAFFIC ");
        sql.append("FROM D_REGION D, ");
        sql.append("MONRPT_SERVICE A ");
        sql.append("WHERE A.YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append("A.MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append("A.OFFICE_CODE IN ( SELECT OFFICE_CODE ");
        sql.append("FROM (  SELECT OFFICE_CODE, SUM(AVGTRAFFIC), ");
        sql.append("RANK() OVER( ORDER BY SUM( AVGTRAFFIC ) DESC ) RANK ");
        sql.append("FROM MONRPT_SERVICE ");
        sql.append("WHERE YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND ");
        sql.append(" TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append("MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND ");
        sql.append("TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append("OFFICE_CODE < 9999 ");
        sql.append("GROUP BY OFFICE_CODE ) ");
        sql.append("WHERE RANK < "+dataCount+" ) AND ");
        sql.append("A.OFFICE_CODE = D.OFFICE_CODE ");
        sql.append("GROUP BY D.OFFICE_NAME, A.YEAR_, A.MONTHS ");
        
        return sql.toString();
    }
    
    public String getServiceSql(){
        StringBuffer sql = new StringBuffer();
        
        sql.append("SELECT TRIM(MONTHS||'월') MONTHS, D.SERVICE_NAME NM, SUM(A.AVGTRAFFIC)/1024 AVGTRAFFIC ");
        sql.append("FROM D_SERVICE D, ");
        sql.append("MONRPT_SERVICE A ");
        sql.append("WHERE A.YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append("A.MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append("A.SERVICE_CODE IN ( SELECT SERVICE_CODE ");
        sql.append("FROM (  SELECT SERVICE_CODE, SUM(AVGTRAFFIC), ");
        sql.append("RANK() OVER( ORDER BY SUM( AVGTRAFFIC ) DESC ) RANK ");
        sql.append("FROM MONRPT_SERVICE ");
        sql.append("WHERE YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND ");
        sql.append("TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append("MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND ");
        sql.append("TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append("SERVICE_CODE < 9999 ");
        sql.append("GROUP BY SERVICE_CODE ) ");
        sql.append("WHERE RANK < "+dataCount+" ) AND ");
        sql.append("A.SERVICE_CODE = D.SERVICE_CODE ");
        sql.append("GROUP BY D.SERVICE_NAME, A.YEAR_, A.MONTHS ");
        
        return sql.toString();
    }
    
    public String getASSql(){
        StringBuffer sql = new StringBuffer();
        
        sql.append("SELECT TRIM(MONTHS||'월') MONTHS, NVL(D.ASNAME, A.ASNUM) NM , SUM(A.AVGTRAFFIC)/1024 AVGTRAFFIC ");
        sql.append("FROM D_AS D, ");
        sql.append("MONRPT_AS A ");
        sql.append("WHERE A.YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append("A.MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND TO_CHAR( SYSDATE,'MM' ) AND ");
        sql.append("A.ASNUM IN ( SELECT ASNUM ");
        sql.append("FROM (  SELECT ASNUM, SUM(AVGTRAFFIC), ");
        sql.append("RANK() OVER( ORDER BY SUM( AVGTRAFFIC ) DESC ) RANK ");
        sql.append("FROM MONRPT_AS ");
        sql.append("WHERE YEAR_ BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'YYYY' ) AND ");
        sql.append("TO_CHAR( SYSDATE,'YYYY' ) AND ");
        sql.append("MONTHS BETWEEN TO_CHAR( ADD_MONTHS(SYSDATE,-" + monCount + "),'MM' ) AND ");
        sql.append("TO_CHAR( SYSDATE,'MM' ) ");
        sql.append("GROUP BY ASNUM ) ");
        sql.append("WHERE RANK < "+dataCount+" ) AND ");
        sql.append("A.ASNUM = D.ASNUM(+) ");
        sql.append("GROUP BY NVL(D.ASNAME, A.ASNUM), A.YEAR_, A.MONTHS ");
        
        return sql.toString();
    }
    
    public static void main(String[] args) {
        MainGraph tag = new MainGraph();
        try {
            String temp = tag.createBody("Application","GByte", tag.getOfficeSql() );
            System.out.println(temp);
            temp = tag.createBody("Application","GByte", tag.getServiceSql() );
            System.out.println(temp);
            temp = tag.createBody("Application","GByte", tag.getApplicationSql() );
            System.out.println(temp);
            temp = tag.createBody("Application","GByte", tag.getASSql() );
            System.out.println(temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
