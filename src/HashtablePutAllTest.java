import java.util.Enumeration;
import java.util.Hashtable;

/*
 * (@)# HashtablePutAllTest.java
 * 
 * 2006. 7. 11
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
public class HashtablePutAllTest {
    public static void main(String[] args){
        Hashtable ht1 = new Hashtable(3);
        Hashtable ht2 = new Hashtable(3);
        
        ht1.put("a","a");
        ht1.put("b","b");
        
        ht2.put("c","c");
        ht2.put("d","d");
        ht2.put("a","A");
        
        ht1.putAll(ht2);
        
        
//        Enumeration e = ht1.elements();
        Enumeration e = ht1.keys();
        String key;
        for( ;e.hasMoreElements();){

            key = (String)e.nextElement();
            
            System.out.println( "key:"+ key + "  " +(String)ht1.get(key));
        }
    }
}
