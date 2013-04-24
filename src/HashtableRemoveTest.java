import java.util.Enumeration;
import java.util.Hashtable;

/*
 * (@)# HashtableRemoveTest.java
 * 
 * 2006. 7. 18
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
public class HashtableRemoveTest {
    public static void main(String[] args){
        
        Hashtable data = new Hashtable(5);
        
        data.put("A","a");
        data.put("B","b");
        data.put("C","c");
        data.put("D","d");
        data.put("E","e");
        
        Enumeration e = data.keys();
        
        String key;
        String rti;
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            rti = (String)data.get(key);
            
            System.out.println("KEY:"+key+"  Data:"+rti);
            if ( key.equals( "A")){
                data.remove(key);
            }
        }
        
        System.out.println("\n\n");
        e = data.keys();
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            rti = (String)data.get(key);
            
            System.out.println("KEY:"+key+"  Data:"+rti);
        }

        System.out.println( "Empty:"+data.isEmpty() );
    }
}
