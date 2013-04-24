import java.util.Hashtable;

/*
 * Created on 2005. 9. 3
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ¼¼Áø
 */
public class ArrayTest {

    public static void main(String[] args) {
        String[] x = { "a","a","a","b","b","b" };
        String[] y = { "1","2","3","1","4","5" };
        
        Hashtable ht = new Hashtable();
        String[] temp;
        
        int length = x.length;
        int chkArry;
        for ( int i = 0 ; i < length; i++ ){
            temp = (String[])ht.get( x[i] );
            if ( temp == null ){
                temp = new String[length + 1];
                temp[0] = y[i];
                temp[length] = "1";
                ht.put( x[i], temp );
            }else {
                chkArry = Integer.parseInt( temp[length] ); 
                temp[chkArry] = y[i];
                temp[length] = String.valueOf(++chkArry);
                ht.put( x[i], temp );
            }
        }
        
        temp = (String[])ht.get("b");
        for(int i = 0 ; i < temp.length; i++){
            if ( temp[i] != null)
            System.out.println( temp[i]);
            else break;
        }
    }
}
