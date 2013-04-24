
/*
 * Created on 2005. 7. 27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ¼¼Áø
 */
public class OctetTest {
    public String getOctetData( String data ) throws OctetLengthException {
        int length = data.length();
        if ( length > 8 ){
            throw new OctetLengthException();
        }

        StringBuffer octet = new StringBuffer(8);
        
        int index = 8-length;
        for(int i = 0 ; i < index ; i++){
            octet.append("0");
        }

        String aaa = octet.insert( index , data ).toString(); 
        return aaa;
    }
    public static void main(String[] args) {
        OctetTest aaa = new OctetTest();
        
        try {
            System.out.println( aaa.getOctetData("abcdefgh"));
        } catch (OctetLengthException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
