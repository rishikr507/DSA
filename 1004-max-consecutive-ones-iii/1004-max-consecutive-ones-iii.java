class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = 0, maxi = 0, cnt = 0;
        while (r < n) {
            if (arr[r] == 0)
                cnt++;
            if (cnt > k) {
                if (arr[l] == 0)
                    cnt--;
                l++;
            }
            if (cnt <= k) {
                maxi = Math.max(maxi, r - l + 1);
            }
            r++;
        }
        return maxi;
    }
}