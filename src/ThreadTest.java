import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created on 2005. 11. 10
 *
 */

/**
 * @author 세진
 */
public class ThreadTest implements Runnable{
    Thread temp;
    
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        
        ThreadTest tt = new ThreadTest();
        
        while(true){
            try {
                System.out.print( "입력하세요:");
                String msg = in.readLine();
                
                if ( msg.equals( "exit")){
                    tt.stop();
                }else if ( msg.equals( "start")){
                    tt.start();
                }else if ( msg.equals( "is")){
                    if ( tt.temp != null){
                    System.out.println( !tt.temp.isAlive() );
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println("");
        }
    }
    
    public void start(){
        temp = new Thread(this);
        temp.start();
        
    }
    
    public void stop(){
        temp.interrupt();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        //Abstract Method
        try {
            while(true){
                System.out.println("a");
                Thread.sleep( 2000);
            }
        } catch (InterruptedException e) {
            System.out.println("b");
        }
    }
}
