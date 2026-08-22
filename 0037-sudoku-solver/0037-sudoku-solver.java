class Solution {
    private boolean possible(char[][] mat, int r, int c, char x) {
        for (int i = 0; i < 9; i++) {
            if (mat[i][c] == x)
                return false;
            if (mat[r][i] == x)
                return false;
            int _r = 3 * (r / 3) + i / 3;
            int _c = 3 * (c / 3) + i % 3;
            if (mat[_r][_c] == x)
                return false;
        }
        return true;
    }

    private boolean solve(char[][] mat, int row, int col) {
        if (col == 9)
            row++;
        for (int r = row; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (mat[r][c] == '.') {
                    for (char i = '1'; i <= '9'; i++) {
                        if (possible(mat, r, c, i)) {
                            mat[r][c] = i;
                            if (solve(mat, r, c + 1))
                                return true;
                            mat[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}