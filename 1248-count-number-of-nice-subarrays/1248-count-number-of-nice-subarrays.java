class Solution {
    private int count(int[] arr, int k) {
        if (k < 0)
            return 0;
        int cnt = 0, l = 0, r = 0, n = arr.length;
        int sum = 0;
        while (r < n) {
            sum += (arr[r] % 2);
            while (sum > k) {
                sum -= (arr[l] % 2);
                l++;
            }
            if (sum <= k) {
                cnt += (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }
}