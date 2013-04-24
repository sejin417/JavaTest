import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created on 2005. 8. 18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author 세진
 */
public class ProcessExec {
    public boolean processCheck( String exec, String result ) {
        boolean vReturn = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec( exec );
            StringBuffer buffer = new StringBuffer();
            BufferedReader b = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String temp;
            while ( ( temp =  b.readLine()) != null ){
                buffer.append( temp );
                buffer.append( '\n' );
            }
            process.waitFor();

            System.out.println( buffer.toString() );
            if ( (buffer.toString().indexOf( result )) >= 0 ){
                vReturn = true;
            }
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }finally{
            process.destroy();
        }
        return vReturn;
    }
    
    public static void main(String[] args) {
        ProcessExec ps = new ProcessExec();
        if ( ps.processCheck( "cmd /c dir", "classpath") ) {
            System.out.println("-----------------되따");
        }
    }
}
