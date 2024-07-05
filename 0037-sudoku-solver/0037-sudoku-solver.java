class Solution {
    public boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == ch) {
                return false;
            }
            // Check column
            if (board[i][col] == ch) {
                return false;
            }
            // Check 3x3 grid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}
