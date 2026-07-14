class Solution {
    private boolean checkDivSum(int arr[], int div, int threshold) {
        int sum = 0;
        for (int x : arr) {
            sum += (x + div - 1) / div;
            if (sum > threshold)
                return false;
        }
        return true;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        if (threshold < nums.length)
            return -1;
        int low = 1;
        int maxi = Integer.MIN_VALUE;
        for (int x : nums) {
            maxi = x > maxi ? x : maxi;
        }
        int high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkDivSum(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}