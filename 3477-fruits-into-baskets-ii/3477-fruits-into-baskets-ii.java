class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    cnt++;
                    break;
                }
                if (baskets[j] != -1 && baskets[j] >= fruits[i]) {
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return cnt;
    }
}