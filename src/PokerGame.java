import java.util.Hashtable;
import java.util.Random;
/*
 * (@)# PokerGame.java
 * 
 * 2006. 6. 16
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
public class PokerGame {
    private int player;

    //Player Card
    private int pCard[][][];
    
    //Card
    private int cardTable[][];
    
    //Player Card Kind
    private int pKind[][];
    
    String[] cardkind = { "High Card", "Pair", "Two Pairs", "Three of a Kind","Straight","Flush","Full Housse","Four of a kind","Straight Flush" };
    
    String[] picKind = { "S","D","H","C" };
    String[] numCard = { "2","3","4","5","6","7","8","9","10","J","Q","K","A" };
    
    public PokerGame(int player){
        this.player = player;

        if ( player < 2 ) {
            System.out.println("Player가 최소 2명은 되어야 합니다.");
            System.exit(0);
        }

        //카드 숫자, 카드 그림, 플레이어
        //카드는 총 12장이나 마지막 은 Joker가 0,1 포인트에 삽입하고 두장만 들어간다.
        pCard = new int[player][14][4];

        //카드테이블(0:사용 안됨, 1:사용됨)
        cardTable = new int[14][4];

        //Joker가 두장 만 사용하기 때문에 카드의 끝 포인트 두부분은 사용됨으로 바꾼다.
        cardTable[13][0] = 1;
        cardTable[13][1] = 1;
        cardTable[13][2] = 1;
        cardTable[13][3] = 1;

        //Player의 카드 족보 (
        pKind = new int[player][3];	//Four Card, Straight, Flush 등
    }

    /**
     * 카드를 Player에게 돌린다.
     *
     */
    public void dealCard(){
        Random cardValue = new Random();
        
        int dealCardCnt = 0;
        int cardNum;
        int cardPic;
        
        while(dealCardCnt < (5 * player) ){

            //카드 생성
            cardNum = cardValue.nextInt(14*4);
            cardPic = cardNum/14;
            cardNum = cardNum%14;

            //카드가 아직 생성된 카드가 아니면
            if ( cardTable[cardNum][cardPic] == 0 ){
                //카드를 생성된 카드로 바꾸고
                cardTable[cardNum][cardPic] = 1;

                //Player에게 설정하고
                pCard[dealCardCnt/5][cardNum][cardPic] = 1;

                //카드가 유저에게 설정되면 돌린카드수를 추가하고 없으면 계속 생성한다.
                dealCardCnt++;
            }
        }
    }

    /**
     * 카드의 종류를 찾는다.
     *
     */
    public void kindCard(){
        int jokerCnt=0;
        
        for( int i=0; i<player; i++){
            
            //Joker가 있는지 검색한다.
            for(int k=0;k<4;k++){
                if ( pCard[i][13][k] == 1 ){
                    jokerCnt++;
                }
            }

            //Joker 가 한장이면 해당 유저의 카드에 포인트를 대입하면서 가장 높은 종류를 찾아낸다.
            if ( jokerCnt == 1) {
                for(int k=0; k<13;k++){
                    for(int j=0;j<4;j++){
                        
                    }
                }
            }else if ( jokerCnt == 2){
                for(int k=0; k<13;k++){
                    for(int j=0;j<4;j++){
                        
                    }
                }
            }else {
                pKind[i] = playerkindCard( pCard[i]);
            }
        }

        //가장 높은 등급의 유저를 찾는다
        int winPlayer = 0;
        for( int i=0; i<player-1; i++){
            if( checkCard( pKind[winPlayer],pKind[i+1] ) ){
                winPlayer = i;
            }else {
                winPlayer = i+1;
            }
        }

        System.out.println("----------------------------");
        System.out.println("  Player " + winPlayer + " Winner");
        System.out.println("----------------------------");
    }
    
    /**
     * 카드 테이블을 받아서 해당 카드가 어떠한 종류가 되는지 찾는다.
     * 배열을 사용하여 값을 넘겨준다 
     * [0] : 카드의 종류("Straight","Flush", ... ... );
     * [1] : 카드번호중 높은수
     * [2] : 카드의 그림
     * @param cardTable
     * @return
     */
    public int[] playerkindCard(int[][] checkCardTable){
        int[] vReturn = new int[3];
        
        //카드 갯수를 계산
        int cardCnt =0;
        
        //카드의 번호와 그림을 추출
        int[] cardNum = new int[5];
        int[] cardPic = new int[5];
        
        //카드의 동일한 숫자가 있는지 추출
        Hashtable cardOverlap = new Hashtable(5);
        String overlapTemp = "";
        int[] overlapCard = new int[2];
        
        //가지고 있는 카드를 추출
        //단 번호순서대로 입력한다.
        for(int k=0;k<14;k++){
            for(int j=0;j<4;j++){
                if ( checkCardTable[k][j]==1 ){
                    cardNum[cardCnt] = k;
                    cardPic[cardCnt] = j;
                    cardCnt++;
                }
            }
        }

        //같은 숫자가 있는지 비교한다.
        //번호 순서로 되어 있기 때문에 같은 번호 일 경우 
        for(int i=0;i<5-1;i++){
            if( cardNum[i] == cardNum[i+1] ){
                overlapTemp = (String)cardOverlap.get( String.valueOf( cardNum[i]) );
                if( overlapTemp == null ){
                    overlapTemp="1";
                }else{
                    overlapTemp = String.valueOf( Integer.valueOf(overlapTemp).intValue() + 1 );
                }
                
                //마지막 번호를 저장한다.
                overlapCard[0] = cardNum[i];
                overlapCard[1] = cardPic[i];
            }
        }

        //번호가 순서대로 되어 있는지 비교한다.
        
        
        //그림이 같은것이 있는지 비교한다.
        
        return vReturn;
    }

    /**
     * 카드의 종류를 a,b를 받아스 a가 높으면 true, b가 높으면 false를 넘겨준다.
     * [0] : 카드의 종류("Straight","Flush", ... ... );
     * [1] : 카드번호중 높은수
     * [2] : 카드의 그림
     * @param a
     * @param b
     * @return
     */
    public boolean checkCard( int[] a, int[] b){
        boolean vReturn;
        
        if ( a[0] > b[0] ){
            vReturn = true;
        }else if ( a[0] == b[0] ){
            if( a[1] > b[1] ){
                vReturn = true;
            }else if (a[1] == b[1] ){
                if( a[2] > b[2] ){
                    vReturn = true;
                }else{
                    vReturn = false;
                }
            }else{
                vReturn = false;
            }
        }else {
            vReturn = false;
        }

        return vReturn;
    }
    
    /**
     * 카드를 프린트 하고 승자를 보여준다.
     *
     */
    public void printCard(){
        // 2   3   4   5   6   7   8   9   10   J   Q   K   A    Joker	카드 번호
        // 0   1   2   3   4   5   6   7   8    9   10  11  12   13     Index Point
        
        for(int i=0;i<player;i++){		//플레이어 수만큼 보여준다.
            System.out.println("\n\n Player:" + (i + 1));
            for(int k=0;k<14;k++){		//카드수만큼 보여준다.
                for(int j=0;j<4;j++){	//카드 종류 만큼 보여준다.
                    if ( pCard[i][k][j]==1 ){
                        
                        //조우커 이면 표현을 다르게 한다.
                        if ( k < 13 ){
                            System.out.print( numCard[k] + picKind[j] + "     " );                            
                        } else {
                            System.out.print( "Joker  " );
                        }
                        
                        
                    }
                }
            }
        }
    }
    
    public static void main(String[] args){
        PokerGame pg = new PokerGame(2);
        pg.dealCard();
        pg.printCard();
    }
}
