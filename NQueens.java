public class NQueens {
    private static final int N = 8; // Change this value for different board sizes

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (solveNQueens(board, 0)) {
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Check if it's safe to place a queen at board[row][col]
    private static boolean isSafe(int[][] board, int row, int col) {
        // Check the left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean solveNQueens(int[][] board, int col) {
        if (col >= N) {
            return true; // All queens are placed successfully
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place a queen

                if (solveNQueens(board, col + 1)) {
                    return true;
                }

                // If placing a queen in board[i][col] doesn't lead to a solution,
                // then backtrack and remove the queen from the current cell.
                board[i][col] = 0;
            }
        }

        // If no queen can be placed in this column, return false.
        return false;
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
