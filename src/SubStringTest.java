import java.util.Hashtable;

/*
 * Created on 2005. 7. 18
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ¼¼Áø
 */
public class SubStringTest {

    public static void main(String[] args) {
        //String message = "AG000024050902030509020400030000";
        //05101002 14165000 0000000001042221 0000000562577544 
        //String message = "051020020510200220190400051020022019040000000000003847884";
        //String status = message.substring(8,16);
        Hashtable netFlowData = new Hashtable(4,1);
		int dataSize = 42;
		
        String data, packageId;
		int dataLen;
		Hashtable ht;
		data = "BI000048051020022019040000000000003847880000000207751344";
        dataLen = Integer.parseInt( data.substring( 4,8 ) );
        
        for( int i=0; i < (dataLen/42); i++ ){
            
            ht = new Hashtable(4);
            System.out.println(data.substring( i * dataSize + 16 , 32 + ( i * dataSize ) ) );
            packageId = data.substring( i * dataSize + 8 , 16 + ( i * dataSize ) );
            ht.put( "packet", data.substring( i * dataSize + 16 , 32 + ( i * dataSize ) ) );
            ht.put( "byte", data.substring( i * dataSize + 32, 48 + ( i * dataSize ) ) );
            ht.put( "type", data.substring( i * dataSize + 48, 50 + ( i * dataSize ) ) );
	        
            netFlowData.put( packageId, ht );
            
            System.out.println(ht.get("type"));
        }
        System.out.println( data);
        
        
        
        String result = "1";
        
        if ( Integer.parseInt( result ) > 0 ) {
            
        }
        
        String temp = "200510061000";
        
        System.out.println( "temp:" + temp.substring(2,8) );
    }
}

//BI000048051020022019040000000000003847880000000207751344
//BK000042051020020000000000384788000000020775134404

//BI000048051020022019040000000000003847880000000207751344
//0510200220190400051020022019040000000000003847880510200220190400000000000038478800000002077513444
//BK0000490510200220190400000000000038478800000002077513444

//BJ000000