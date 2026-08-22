class Solution {
    private boolean canPlace(int row, int col, int n, List<String> board) {
        int r = row, c = col;

        // Diagonally left upward
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        // Same column
        while (c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            c--;
        }

        r = row;
        c = col;
        // Diagonally left downward
        while (r < n && c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r++;
            c--;
        }

        return true;
    }

    private void solve(int col, int n, List<String> board, List<List<String>> ans) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (canPlace(row, col, n, board)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                solve(col + 1, n, board, ans);

                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }

        solve(0, n, board, ans);
        return ans;
    }
}