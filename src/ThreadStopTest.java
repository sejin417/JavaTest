/*
 * (@)# ThreadStop.java
 * 
 * 2006. 7. 21
 *
 * ====================================================================
 *
 * WarePlus., Software License, Version 1.0
 *
 * Copyright (c) 2002-2004 Ware Plus.,
 * WarePlus  * All rights reserved.
 *
 * DON'T COPY OR REDISTRIBUTE THIS SOURCE CODE WITHOUT PERMISSION.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL WarePlus OR ITS
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * For more information on this product, please see 
 * WarePlus
 *
 */

/**
 * @author Sejin
 * 
 */
public class ThreadStopTest implements Runnable{
    private Thread aa = null;
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public ThreadStopTest(){
        aa = new Thread(this);
    }
    
    public void start(){
        aa.start();
    }
    
    public void stop(){
        aa.interrupt();
    }
    
    public void run() {
        //Abstract Method
        
        try {
            while( true ){
                Thread.sleep(5000);
                System.out.println("a");
                
                stop();
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args){
        ThreadStopTest ts = new ThreadStopTest();
        
        ts.aa = new Thread( ts);
        
        ts.start();
    }
}
