package Backtrack;

public class NQueensChess {

    private static boolean isBoardSafe(int[][] board, int n, int row, int col) {
        // vertical check
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 1){
                return false;
            }
        }
        // horizontal check - ignored because we are using only one queen per row

        // diagonal check
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1){
                return false;
            }
        }

        for (int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    private static void placeQueens(int[][] board, int n, int row) {
        if(row == n){
            // valid config
            printBoard(board, n);
            System.out.println();
            return;
        }

        // check for all cols in the row
        for (int j = 0; j < n; j++) {
            // check if safe to place the queen
            if(isBoardSafe(board, n, row,j)){
                // if it's safe -> then place the queen and move to the next row
                board[row][j] = 1;
                placeQueens(board, n, row+1);
                // resetting the board
                board[row][j] = 0;
            }
        }

    }


    public static void placeNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueens(board, n, 0);
    }

    public static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
//            System.out.println();
        }
    }

    public static void main(String[] args) {
        placeNQueens(4);
    }
}
