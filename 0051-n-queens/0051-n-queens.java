class Solution {

    private void solve(int c, int n, List<String> board, List<List<String>> ans, int[] row, int[] up, int[] down) {
        if (c == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int r = 0; r < n; r++) {
            if (row[r] == 1 || up[n + c - r - 1] == 1 || down[r + c] == 1)
                continue;
            else {
                StringBuilder sb = new StringBuilder(board.get(r));
                sb.setCharAt(c, 'Q');
                board.set(r, sb.toString());
                row[r] = 1;
                up[n + c - r - 1] = 1;
                down[r + c] = 1;

                solve(c + 1, n, board, ans, row, up, down);
                row[r] = 0;
                up[n + c - r - 1] = 0;
                down[r + c] = 0;
                sb.setCharAt(c, '.');
                board.set(r, sb.toString());
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
        int row[] = new int[n];
        int[] upward = new int[2 * n - 1];
        int[] downward = new int[2 * n - 1];
        
        solve(0, n, board, ans, row, upward, downward);
        return ans;
    }
}