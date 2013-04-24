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
            System.out.println("Player�� �ּ� 2���� �Ǿ�� �մϴ�.");
            System.exit(0);
        }

        //ī�� ����, ī�� �׸�, �÷��̾�
        //ī��� �� 12���̳� ������ �� Joker�� 0,1 ����Ʈ�� �����ϰ� ���常 ����.
        pCard = new int[player][14][4];

        //ī�����̺�(0:��� �ȵ�, 1:����)
        cardTable = new int[14][4];

        //Joker�� ���� �� ����ϱ� ������ ī���� �� ����Ʈ �κκ��� �������� �ٲ۴�.
        cardTable[13][0] = 1;
        cardTable[13][1] = 1;
        cardTable[13][2] = 1;
        cardTable[13][3] = 1;

        //Player�� ī�� ���� (
        pKind = new int[player][3];	//Four Card, Straight, Flush ��
    }

    /**
     * ī�带 Player���� ������.
     *
     */
    public void dealCard(){
        Random cardValue = new Random();
        
        int dealCardCnt = 0;
        int cardNum;
        int cardPic;
        
        while(dealCardCnt < (5 * player) ){

            //ī�� ����
            cardNum = cardValue.nextInt(14*4);
            cardPic = cardNum/14;
            cardNum = cardNum%14;

            //ī�尡 ���� ������ ī�尡 �ƴϸ�
            if ( cardTable[cardNum][cardPic] == 0 ){
                //ī�带 ������ ī��� �ٲٰ�
                cardTable[cardNum][cardPic] = 1;

                //Player���� �����ϰ�
                pCard[dealCardCnt/5][cardNum][cardPic] = 1;

                //ī�尡 �������� �����Ǹ� ����ī����� �߰��ϰ� ������ ��� �����Ѵ�.
                dealCardCnt++;
            }
        }
    }

    /**
     * ī���� ������ ã�´�.
     *
     */
    public void kindCard(){
        int jokerCnt=0;
        
        for( int i=0; i<player; i++){
            
            //Joker�� �ִ��� �˻��Ѵ�.
            for(int k=0;k<4;k++){
                if ( pCard[i][13][k] == 1 ){
                    jokerCnt++;
                }
            }

            //Joker �� �����̸� �ش� ������ ī�忡 ����Ʈ�� �����ϸ鼭 ���� ���� ������ ã�Ƴ���.
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

        //���� ���� ����� ������ ã�´�
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
     * ī�� ���̺��� �޾Ƽ� �ش� ī�尡 ��� ������ �Ǵ��� ã�´�.
     * �迭�� ����Ͽ� ���� �Ѱ��ش� 
     * [0] : ī���� ����("Straight","Flush", ... ... );
     * [1] : ī���ȣ�� ������
     * [2] : ī���� �׸�
     * @param cardTable
     * @return
     */
    public int[] playerkindCard(int[][] checkCardTable){
        int[] vReturn = new int[3];
        
        //ī�� ������ ���
        int cardCnt =0;
        
        //ī���� ��ȣ�� �׸��� ����
        int[] cardNum = new int[5];
        int[] cardPic = new int[5];
        
        //ī���� ������ ���ڰ� �ִ��� ����
        Hashtable cardOverlap = new Hashtable(5);
        String overlapTemp = "";
        int[] overlapCard = new int[2];
        
        //������ �ִ� ī�带 ����
        //�� ��ȣ������� �Է��Ѵ�.
        for(int k=0;k<14;k++){
            for(int j=0;j<4;j++){
                if ( checkCardTable[k][j]==1 ){
                    cardNum[cardCnt] = k;
                    cardPic[cardCnt] = j;
                    cardCnt++;
                }
            }
        }

        //���� ���ڰ� �ִ��� ���Ѵ�.
        //��ȣ ������ �Ǿ� �ֱ� ������ ���� ��ȣ �� ��� 
        for(int i=0;i<5-1;i++){
            if( cardNum[i] == cardNum[i+1] ){
                overlapTemp = (String)cardOverlap.get( String.valueOf( cardNum[i]) );
                if( overlapTemp == null ){
                    overlapTemp="1";
                }else{
                    overlapTemp = String.valueOf( Integer.valueOf(overlapTemp).intValue() + 1 );
                }
                
                //������ ��ȣ�� �����Ѵ�.
                overlapCard[0] = cardNum[i];
                overlapCard[1] = cardPic[i];
            }
        }

        //��ȣ�� ������� �Ǿ� �ִ��� ���Ѵ�.
        
        
        //�׸��� �������� �ִ��� ���Ѵ�.
        
        return vReturn;
    }

    /**
     * ī���� ������ a,b�� �޾ƽ� a�� ������ true, b�� ������ false�� �Ѱ��ش�.
     * [0] : ī���� ����("Straight","Flush", ... ... );
     * [1] : ī���ȣ�� ������
     * [2] : ī���� �׸�
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
     * ī�带 ����Ʈ �ϰ� ���ڸ� �����ش�.
     *
     */
    public void printCard(){
        // 2   3   4   5   6   7   8   9   10   J   Q   K   A    Joker	ī�� ��ȣ
        // 0   1   2   3   4   5   6   7   8    9   10  11  12   13     Index Point
        
        for(int i=0;i<player;i++){		//�÷��̾� ����ŭ �����ش�.
            System.out.println("\n\n Player:" + (i + 1));
            for(int k=0;k<14;k++){		//ī�����ŭ �����ش�.
                for(int j=0;j<4;j++){	//ī�� ���� ��ŭ �����ش�.
                    if ( pCard[i][k][j]==1 ){
                        
                        //����Ŀ �̸� ǥ���� �ٸ��� �Ѵ�.
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
