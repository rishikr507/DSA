class Solution {
    private boolean check(char[][] mat, int x, int y) {
        char n = mat[x][y];
        for (int i = 0; i < 9; i++) {
            // Checking row x -> fix
            if (i != y && mat[x][i] == n) {
                return false;
            }
            // Checking column y -> fix
            if (i != x && mat[i][y] == n) {
                return false;
            }
            // Checking block
            int r = 3 * (x / 3) + i / 3;
            int c = 3 * (y / 3) + i % 3;
            if (r != x && c != y && mat[r][c] == n)
                return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && check(board, i, j) == false)
                    return false;
            }
        }
        return true;
    }
}