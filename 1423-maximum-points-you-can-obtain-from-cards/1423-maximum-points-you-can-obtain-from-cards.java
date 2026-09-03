class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }
        int maxi = lsum;
        for (int i = 0; i <= k; i++) {
            if (n - i < n)
                rsum += cardPoints[n - i];
            if (k - i < k)
                lsum -= cardPoints[k - i];
            if (lsum + rsum > maxi)
                maxi = lsum + rsum;
        }

        return maxi;
    }
}
