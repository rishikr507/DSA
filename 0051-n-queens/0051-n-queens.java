class Solution {

    private void solve(int c, int n, List<StringBuilder> board, List<List<String>> ans, int[] row, int[] up,
            int[] down) {
        if (c == n) {
            List<String> temp = new ArrayList<>();
            for (var sb : board)
                temp.add(new String(sb));
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int r = 0; r < n; r++) {
            if (row[r] == 1 || up[n + c - r - 1] == 1 || down[r + c] == 1)
                continue;
            else {
                board.get(r).setCharAt(c, 'Q');
                row[r] = 1;
                up[n + c - r - 1] = 1;
                down[r + c] = 1;

                solve(c + 1, n, board, ans, row, up, down);
                row[r] = 0;
                up[n + c - r - 1] = 0;
                down[r + c] = 0;
                board.get(r).setCharAt(c, '.');
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new StringBuilder(new String(row)));
        }
        int row[] = new int[n];
        int[] upward = new int[2 * n - 1];
        int[] downward = new int[2 * n - 1];

        solve(0, n, board, ans, row, upward, downward);
        return ans;
    }
}