class Solution {

    private boolean checkCapacity(int[] weights, int cap, int limit) {
        int day = 1, load = 0;

        for (int w : weights) {
            if (load + w > cap) {
                day++;
                if (day > limit) {
                    return false;
                }
                load = w;
            } else {
                load += w;
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int w : weights) {
            maxi = w > maxi ? w : maxi;
            sum += w;
        }

        int low = maxi, high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkCapacity(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}