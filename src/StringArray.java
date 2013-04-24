/*
 * Created on 2005. 7. 31
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ¼¼Áø
 */
public class StringArray {

    public static void main(String[] args) {
        
        String[] test;
        String[] test1 = {"a","b","c","d"};
        String[] test2 = {"a","b","c"};
        boolean chk = false;
          
        if ( chk ){
            test = new String[2];
            test = test1;
        }else {
            test = test2;
        }
        System.out.println( test.length );
    }
}
