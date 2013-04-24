import java.awt.Point;

/*
 * (@)# ChessQueen.java
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
public class ChessQueen {
    //ü����  0:��� ����  1:��� ������ �ڸ��� ��ġ �Ҽ� ����  2:���� �ڸ�
    int[][] chessBorder;		//ü�� ��
    int width, height;			//ü������ ũ��
    Point[] badPoint;			//��ġ�Ҽ� ���� ����Ʈ
    int queenCount = 5;			//queen �����ؾ� �� ����
    int createQueen = 0;		//queen ���� ����
    
    public ChessQueen(){

        width = 8;
        height = 8;
        chessBorder = new int[width][height];
    }

    /**
     * ���� ��ġ�Ҽ� ���� ����Ʈ ����
     *
     */
    public void addBadPoint(){
        badPoint = new Point[3];
        badPoint[0] = new Point(0,0);
        badPoint[1] = new Point(2,2);
        badPoint[2] = new Point(5,5);        
    }
    
    /**
     * �ش� ����Ʈ�� ���� ��ġ ������ �̵� �κ��� ��ġ�Ҽ� ���� ����Ʈ�� �����Ѵ�. 
     * @param x
     * @param y
     */
    public void queenPoint( int pointX, int pointY){
        int x=pointX;
        int y=pointY;

        chessBorder[x][y] = 2;
        createQueen++;

        //�������κп� ���ϼ� ���� ����
        for(int i=0; i < width; i++ ){
            if ( chessBorder[x][i] == 0){
                chessBorder[x][i] = 1;                
            }
        }
        
        //���ο��κп� ���ϼ� ���� ����
        for(int i=0; i < height; i++ ){
            if ( chessBorder[i][y] == 0){
                chessBorder[i][y] = 1;                
            }
        }
        
        //���ʿ��� ������ �밢�� �κп� ���ϼ� ���� ����
        //1. x�� y�� ������ ã�� x�� y�� ����ŭ �����Ѵ�.
        //2. �ش� ����Ʈ�� ��ġ�Ҽ� ���� ����Ʈ�� �ٲٰ� x�� y�� +1�� �Ѵ�.
        //3. x�� y�� ���� ü���Ǻ��� ũ�� �����Ѵ�.
        if ( x > y ) {
            x-=y;
            y=0;
        }else{
            x=0;
            y-=x;

        }
        while ( x < width && y < height ){
            if ( chessBorder[x][y] == 0){
                chessBorder[x][y] = 1;                
            }
            x++;
            y++;
        }

        x=pointX;
        y=pointY;
        //�����ʿ���  ���� �밢�� �κп� ���ϼ� ���� ����
        //1. 
        //2. �ش� ����Ʈ�� ��ġ�Ҽ� ���� ����Ʈ�� �ٲٰ� x�� -1�� y�� +1�� �Ѵ�.
        //3. x�� y�� ���� 0���� ������ �����Ѵ�.
        if ( (width - 1) - x > y ) {
            x+=y;
            y=0;
        }else{
            x=(width-1);
            y= y - ((width - 1) - x);
        }

        while ( x >= 0 && y < height ){
            if ( chessBorder[x][y] == 0){
                chessBorder[x][y] = 1;                
            }
            x--;
            y++;
        }
    }
    
    public void initialize(){
        //BadPoint �� �����ǿ� �����Ѵ�.
        addBadPoint();
        
        for(int i=0; i<badPoint.length;i++){
            chessBorder[ badPoint[i].x ][ badPoint[i].y ] = 1;
        }
    }
    
    /**
     * ù��° ���� ���������� �˻��� �Ͽ� ���� ��ġ�ϴ� ���
     * @param nextHop ���� ����Ʈ �̵�����( 1 ~ 3 )
     */
    public void staticPoint( int nextHop ){
        initialize();
        int x = 0;
        int y = 0;
        
        //�� �����Ҽ� �ִ��ڸ��� ������ �ֱ⶧���� ������ ������ �ɾ� �ش� Ƚ���� �Ѿ�� �ߴܽ�Ų��.
        int loopcnt = 0;
        
        while ( createQueen != queenCount ){
            //�ڸ��� ��� ������
            if ( chessBorder[x][y] == 0 ){
                queenPoint(x,y);
            }

            if ( x + nextHop >= width ){
                x = 0;
                y++;
            }else {
                x+=nextHop;
            }

            //y���� ũ�⺸�� ũ�� �ʱ�ȭ ��Ų��.
            if ( y >= height ){
                loopcnt++;
                x=loopcnt%(width-1);
                y=loopcnt/8;
            }

            if ( x >= width || y >= height){
                break;
            }
        }
    }

    /**
     * ü������ ����Ѵ�.
     *
     */
    public void print(){
        System.out.print("     ");
        for(int k=0; k < width; k++){
            System.out.print("|" + (k+1) + "|\t");
        }
        System.out.println();

        for( int i=0;  i < height; i++){
            System.out.print("|"+(i+1)+"|  ");
            for(int k=0; k < width; k++){
                if ( chessBorder[k][i] == 2 ){
                    System.out.print("|Q|\t");
                }else {
                    System.out.print("| |\t");
                }
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Queen ����:" +createQueen);
    }
    
    /**
     * ����� ���
     *
     */
    public void usePrint(){
        System.out.println( "�����");
        System.out.println( "java ChessQueen [next hop(1~5)]");
        System.out.println( "��)java ChessQueen 1");
        System.exit(0);
    }
    
    public static void main(String[] args){
        ChessQueen chess = new ChessQueen();
        
        //�Ķ���Ͱ� args < 0 ~ 2 < args ���� ó�� 
        if ( args.length <= 0 || args.length > 2) chess.usePrint(); 
        
        try{
            int nextHop = Integer.parseInt(args[0]);
            if ( nextHop <= 0 || nextHop > 5 ){
                chess.usePrint();
            }
            chess.staticPoint( Integer.parseInt(args[0]));
        }catch(Exception e){
            chess.usePrint();
        };

        chess.print();
    }
}
