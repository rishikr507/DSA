class Solution {
    private boolean isPossible(int[] arr, int day, int k, int m) {
        int count = 0, bouqCount = 0;
        for (int x : arr) {
            if (x <= day) {
                count++;
            } else {
                bouqCount += (count / k);
                count = 0;
            }
        }
        bouqCount += (count / k);

        return bouqCount >= m;
    }

    // K -> No of adjacent flowers
    // M -> no of Bouquet
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) k * (long) m > (long) n)
            return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int maxi = Arrays.stream(bloomDay).max().getAsInt();
        int high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, k, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low > maxi)
            return -1;
        return low;
    }
}