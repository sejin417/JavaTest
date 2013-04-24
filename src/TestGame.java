/*
 * (@)# TestGame.java
 * 
 * 2006. 6. 14
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
public class TestGame {
    int maxNum = 5;
    int[][] table = new int[maxNum][maxNum];
    
    public void createTable(){
        int cnt=0;
        int x=0;
        
        for(int i=0; i<maxNum; i++){
            for(int k=0; k<maxNum; k++){
                
                table[x][i] = k+1;
                x++;
                
                if (x >= maxNum){
                    x=0;
                }
            }

            cnt++;
            x=cnt;
            
        }
    }
    
    public void print(){
        try{
        for(int i=0; i<maxNum; i++){
            for(int k=0; k<maxNum; k++){
                System.out.print( table[k][i] + "  " );
            }
            System.out.println();
        }
        }catch(Exception e){
            System.out.println("¿¡·¯");
        }
    }
    
    public static void main(String[] args) {
        TestGame tg = new TestGame();
        tg.createTable();
        tg.print();
    }   
}
