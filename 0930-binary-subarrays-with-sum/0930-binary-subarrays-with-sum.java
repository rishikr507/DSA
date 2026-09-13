class Solution {
    // Count number subarrays less than or equal to goal.
    private int countLE(int[] arr, int g) {
        if (g < 0)
            return 0; // In binary array sum can't be lesser than 0
        int l = 0, r = 0, n = arr.length, sum = 0, cnt = 0;
        while (r < n) {
            sum += arr[r];
            while (sum > g) {
                sum -= arr[l];
                l++;
            }
            if (sum <= g) {
                cnt += (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return countLE(nums, goal) - countLE(nums, goal - 1);
    }
}