package Recursion;

public class Nqueens {
    public static void main(String[] args) {
        int n=4;
        boolean chessBoard[][]=new boolean[n][n];
        printPosition(chessBoard, 0);
    }

    private static void printPosition(boolean[][] chessBoard, int r) {
        if(r==chessBoard.length){
            // print(chessBoard);
            dispaly(chessBoard);
            return;
        }

        for(int c=0; c<chessBoard.length; c++){
            if(isSafe(chessBoard, r, c)){
                chessBoard[r][c]=true;
                printPosition(chessBoard, r+1);
                chessBoard[r][c]=false;
            }
        }
    }


    private static boolean isSafe(boolean[][] chessBoard, int r, int c) {
        //vertical check
        for(int i=0; i<r; i++){
            if(chessBoard[i][c]){
                return false;
            }
        }

        int maxLeft= Math.min(r,c);
        //diagonal left check
        for(int i=1; i<=maxLeft; i++){
            if(chessBoard[r-i][c-i]){
                return false;
            }
        }

        int maxRight=Math.min(r, chessBoard.length-c-1);
        //diagonal right check
        for(int i=1; i<=maxRight; i++){
            if(chessBoard[r-i][c+i]){
                return false;
            }
        }



        return true;
    }

    // private static void print(boolean[][] chessBoard) {
    //     for(boolean arr[] : chessBoard){
    //         for(boolean bool: arr){
    //             System.out.print(bool + " - ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }

    private static void dispaly(boolean[][] chessBoard) {
        for(boolean arr[] : chessBoard){
            for(boolean bool: arr){
                if(bool){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
