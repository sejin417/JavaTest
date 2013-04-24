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
 * @author ����
 */
public class MainGraph {
    DBConnectionMgr pool = null;
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    private final String monCount = "6";		//-1  ��ŭ �����ش�
    private final String dataCount = "4";		//-1 ��ŭ �����ش�
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
        
        //���� ������ �����Ѵ�
        Hashtable table = new Hashtable();
        Hashtable sortMonths = new Hashtable();
        Hashtable sortNote = new Hashtable();
        int xcount = 0;
        
        //������ �޴� ���� 
        String app;
        String month;
        long traffic;
        
        //sql������ �Ѱܼ� Result ���� �޴´�.
        try{
            pool = DBConnectionMgr.getInstance();
            
            conn = pool.getConnection();
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery( sql );
            
            while( rs.next() ){
                //Application���� ������ �´�
                app = rs.getString("NM");
                month = rs.getString("MONTHS");
                traffic = rs.getLong("AVGTRAFFIC");
                
                //�ش� ���� table�� ������ �´�
                Hashtable data = (Hashtable)table.get( month );
                
                //�ش� ���� Table ���� ������ ����
                if ( data == null ){
                    data = new Hashtable();
                    sortMonths.put( String.valueOf( xcount ) , month);
                    xcount++;
                }
                
                //���� ���� �� ī��Ʈ�� ����ϱ� ���Ͽ� �����Ѵ�
                sortNote.put( app,"" );
                
                //Table�� Application�� �׿� ���� Traffic ���� �ִ´�.
                data.put( app, String.valueOf( traffic ) );
                
                //Table �� data�� �ִ´�.
                table.put( month, data );
                
                traffic = 0;
            }
            
            //�ش� �߰�
            tag.append( getHeader() );
            
            //Ÿ��Ʋ �߰�
            tag.append( "title=" );
            tag.append( title );
            
            //���� ����
            tag.append( "&graphcount=" );
            tag.append( sortNote.size() );
            
            
            //X �� ����		xcount=
            tag.append( "&xcount=" );
            tag.append( xcount );
            
            //Y �� ����		ycount=
            tag.append( "&ycount=" );
            tag.append( maxYCount );
            
            //Y �� ���� Ÿ��	ytype=
            tag.append( "&ytype=" + yType );
            
            //X ���� ������ ���� X�� ��Ī
            Hashtable tempData;
            String tempApp;
            String trafficData;
            int ycount = 0;
            Enumeration e;
            
            //Y�� ��Ī
            for( e = sortNote.keys(); e.hasMoreElements(); ){
                tempApp = (String)e.nextElement();
                tag.append( "&yname" + ( ycount + 1 ) + "=" + tempApp );
                ycount++;
            }
            
            for( int i = 0, j; i < sortMonths.size(); i++){
                //ó�� ������ ���� �����´�.
                month = (String)sortMonths.get( String.valueOf(i) );
                tag.append( "&xname" + (i + 1) + "=" + month );
                
                //�ش� ���� ���� ���ʿ� Traffic ���� �����´�.
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
            
            // �ϴ� �߰�
            tag.append( getFooter() );
            
        }catch(Exception e){
            System.out.println("Error : Ŀ�ؼ� �������� ����!!");
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
        
        sql.append( "SELECT TRIM(MONTHS||'��') MONTHS, D.APPLICATION_DESC NM, A.AVGTRAFFIC/1024 AVGTRAFFIC ");
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

        sql.append("SELECT TRIM(MONTHS||'��') MONTHS, D.OFFICE_NAME NM, SUM(A.AVGTRAFFIC)/1024 AVGTRAFFIC ");
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
        
        sql.append("SELECT TRIM(MONTHS||'��') MONTHS, D.SERVICE_NAME NM, SUM(A.AVGTRAFFIC)/1024 AVGTRAFFIC ");
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
        
        sql.append("SELECT TRIM(MONTHS||'��') MONTHS, NVL(D.ASNAME, A.ASNUM) NM , SUM(A.AVGTRAFFIC)/1024 AVGTRAFFIC ");
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
