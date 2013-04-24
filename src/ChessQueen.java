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
    //체스판  0:비어 있음  1:비어 있으나 자리에 위치 할수 없음  2:퀸의 자리
    int[][] chessBorder;		//체스 판
    int width, height;			//체스판의 크기
    Point[] badPoint;			//위치할수 없는 포인트
    int queenCount = 5;			//queen 생성해야 할 갯수
    int createQueen = 0;		//queen 생성 갯수
    
    public ChessQueen(){

        width = 8;
        height = 8;
        chessBorder = new int[width][height];
    }

    /**
     * 퀸이 위치할수 없는 포인트 설정
     *
     */
    public void addBadPoint(){
        badPoint = new Point[3];
        badPoint[0] = new Point(0,0);
        badPoint[1] = new Point(2,2);
        badPoint[2] = new Point(5,5);        
    }
    
    /**
     * 해당 포인트에 퀸이 위치 했을때 이동 부분을 위치할수 없는 포인트로 변경한다. 
     * @param x
     * @param y
     */
    public void queenPoint( int pointX, int pointY){
        int x=pointX;
        int y=pointY;

        chessBorder[x][y] = 2;
        createQueen++;

        //같은열부분에 놓일수 없게 변경
        for(int i=0; i < width; i++ ){
            if ( chessBorder[x][i] == 0){
                chessBorder[x][i] = 1;                
            }
        }
        
        //세로열부분에 놓일수 없게 변경
        for(int i=0; i < height; i++ ){
            if ( chessBorder[i][y] == 0){
                chessBorder[i][y] = 1;                
            }
        }
        
        //왼쪽에서 오른쪽 대각선 부분에 놓일수 없게 변경
        //1. x와 y중 적은수 찾아 x와 y에 수많큼 삭제한다.
        //2. 해당 포인트를 위치할수 없는 포인트로 바꾸고 x와 y에 +1을 한다.
        //3. x와 y의 값이 체스판보다 크면 종료한다.
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
        //오른쪽에서  왼쪽 대각선 부분에 놓일수 없게 변경
        //1. 
        //2. 해당 포인트를 위치할수 없는 포인트로 바꾸고 x는 -1을 y는 +1을 한다.
        //3. x와 y의 값이 0보다 작으면 종료한다.
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
        //BadPoint 를 보드판에 적용한다.
        addBadPoint();
        
        for(int i=0; i<badPoint.length;i++){
            chessBorder[ badPoint[i].x ][ badPoint[i].y ] = 1;
        }
    }
    
    /**
     * 첫번째 부터 순차적으로 검색을 하여 퀸을 배치하는 방법
     * @param nextHop 다음 포인트 이동간격( 1 ~ 3 )
     */
    public void staticPoint( int nextHop ){
        initialize();
        int x = 0;
        int y = 0;
        
        //더 생성할수 있는자리가 있을수 있기때문에 루프를 제한을 걸어 해당 횟수가 넘어가면 중단시킨다.
        int loopcnt = 0;
        
        while ( createQueen != queenCount ){
            //자리가 비어 있으면
            if ( chessBorder[x][y] == 0 ){
                queenPoint(x,y);
            }

            if ( x + nextHop >= width ){
                x = 0;
                y++;
            }else {
                x+=nextHop;
            }

            //y값이 크기보다 크면 초기화 시킨다.
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
     * 체스판을 출력한다.
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
        System.out.println("Queen 개수:" +createQueen);
    }
    
    /**
     * 사용방법 출력
     *
     */
    public void usePrint(){
        System.out.println( "사용방법");
        System.out.println( "java ChessQueen [next hop(1~5)]");
        System.out.println( "예)java ChessQueen 1");
        System.exit(0);
    }
    
    public static void main(String[] args){
        ChessQueen chess = new ChessQueen();
        
        //파라미터가 args < 0 ~ 2 < args 오류 처리 
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
