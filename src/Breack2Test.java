/*
 * Created on 2005. 8. 1
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ¼¼Áø
 */
public class Breack2Test {

    public static void main(String[] args) {
        
        other:
        for ( int i = 0 ; i < 4 ; i++ ){
            for ( int j = 0; j<8;j++){
                System.out.println( " J value:"+j);
                if ( j == 5 ){
                    System.out.println( " Breack i/j:"+i+"/"+j);
                    break other;
                }
            }
            
            System.out.println( " i value:" + i);
        }
    }
}
