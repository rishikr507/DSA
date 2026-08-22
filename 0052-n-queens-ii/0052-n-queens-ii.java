class Solution {
    int count;

    private void solve(int r, int n, int[] column, int[] left, int[] right) {
        if (r == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (column[c] == 1 || right[n + c - r - 1] == 1 || left[r + c] == 1)
                continue;
            else {
                column[c] = 1;
                left[r + c] = 1;
                right[n + c - r - 1] = 1;

                solve(r + 1, n, column, left, right);

                column[c] = 0;
                left[r + c] = 0;
                right[n + c - r - 1] = 0;
            }
        }
    }

    public int totalNQueens(int n) {
        int[] column = new int[n];
        int[] left = new int[2 * n - 1];
        int[] right = new int[2 * n - 1];
        count = 0;
        solve(0, n, column, left, right);
        return count;
    }
}