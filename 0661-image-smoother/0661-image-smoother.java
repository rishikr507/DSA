class Solution {
    private int findAverage(int[][] filter, int is, int ie, int js, int je) {
        int sum = 0;
        for (int i = is; i <= ie; i++) {
            for (int j = js; j <= je; j++) {
                sum += filter[i][j];
            }
        }
        return sum / ((ie - is + 1) * (je - js + 1));
    }

    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int res[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            int is = i - 1 > 0 ? i - 1 : 0;
            int ie = i + 1 < n ? i + 1 : n - 1;
            for (int j = 0; j < m; j++) {
                int js = j - 1 > 0 ? j - 1 : 0;
                int je = j + 1 < m ? j + 1 : m - 1;
                res[i][j] = findAverage(img, is, ie, js, je);
            }
        }
        return res;
    }
}