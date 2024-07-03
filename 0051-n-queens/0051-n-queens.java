class Solution {
    // Helper method to check if a position is safe for a queen
    public static boolean isSafe(char[][] board, int rows, int cols) {
        // Check vertically up
        for (int i = rows - 1; i >= 0; i--) {
            if (board[i][cols] == 'Q') {
                return false;
            }
        }

        // Check diagonally left
        for (int i = rows - 1, j = cols - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check diagonally right
        for (int i = rows - 1, j = cols + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Helper method to solve the N-Queens problem
    public static void nQueens(char[][] board, int rows, List<List<String>> solutions) {
        // Base case
        if (rows == board.length) {
            solutions.add(createBoard(board));
            return;
        }

        // n queens in n rows
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, rows, j)) {
                board[rows][j] = 'Q';
                nQueens(board, rows + 1, solutions); // Recursion step
                board[rows][j] = '.'; // Backtracking step
            }
        }
    }

    // Helper method to create a solution board
    public static List<String> createBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    // Method to solve the N-Queens problem and return all solutions
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> solutions = new ArrayList<>();
        nQueens(board, 0, solutions);
        return solutions;
    }
}