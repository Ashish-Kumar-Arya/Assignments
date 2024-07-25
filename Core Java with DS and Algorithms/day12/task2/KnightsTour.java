package assignments.day12.task2;

public class KnightsTour {
    private static final int N=8;

    public static boolean solveKnightTour(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        if(moveCount==N*N){
            return true; //All cells are visited
        }

        for(int i=0; i<8; i++) {
            int nextX=moveX+xMove[i];
            int nextY=moveY+yMove[i];
            if(isSafe(nextX,nextY,board)) {
                board[nextX][nextY]=moveCount;
                if(solveKnightTour(board, nextX, nextY, moveCount+1, xMove, yMove)) {
                    return true;
                }
                // Backtrack
                board[nextX][nextY]=-1;
            }
        }
        return false;
    }

    public static boolean isSafe(int x, int y, int[][] board) {
        return (x>=0&&x<N&&y>=0&&y<N&&board[x][y]==-1);
    }

    public static void main(String[] args) {
        int[][] board=new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0; j<N; j++) {
                board[i][j]=-1;
            }
        }
        //Knight's possible moves
        int[] xMove={2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove={1, 2, 2, 1, -1, -2, -2, -1};

        //Starting position
        board[0][0]=0;

        if(solveKnightTour(board, 0, 0, 1, xMove, yMove)) {
            printBoard(board);
        }
        else {
            System.out.println("No solution exists.");
        }
    }

    public static void printBoard(int[][] board) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}