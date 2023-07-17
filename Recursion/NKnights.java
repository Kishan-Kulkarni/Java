package Recursion;

public class NKnights {
    public static void main(String[] args) {
        int n=4;
        boolean chessBoard[][]=new boolean[n][n];
        printPosition(chessBoard, 0, 0, n);
        System.out.println(i);
    }

    static int i=0; 

    private static void printPosition(boolean[][] chessBoard, int r, int c , int knights) {
        if(knights==0){
            i++;
            display(chessBoard);
            return;
        }

        if (r == chessBoard.length - 1 && c == chessBoard.length) {
            return;
        }

        if(c==chessBoard.length){
            printPosition(chessBoard, r+1, 0, knights);
            return;
        }

        if(isSafe(chessBoard, r, c)){
            chessBoard[r][c]=true;
            printPosition(chessBoard, r, c+1, knights-1);
            chessBoard[r][c]=false;
        }

        printPosition(chessBoard, r, c+1, knights);
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        if (isValid(board, r - 2, c - 1)) {
            if (board[r - 2][c - 1]) {
                return false;
            }
        }

        if (isValid(board, r - 1, c - 2)) {
            if (board[r - 1][c - 2]) {
                return false;
            }
        }

        if (isValid(board, r - 2, c + 1)) {
            if (board[r - 2][c + 1]) {
                return false;
            }
        }

        if (isValid(board, r - 1, c + 2)) {
            if (board[r - 1][c + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int r, int c) {
        if (r >= 0 && r < board.length && c >= 0 && c < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] chessBoard) {
        for(boolean arr[] : chessBoard){
            for(boolean bool: arr){
                if(bool){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
