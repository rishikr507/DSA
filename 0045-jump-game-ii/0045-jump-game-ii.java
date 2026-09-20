class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        int jumps = 0;
        while (r < n - 1) {
            int farest = 0;
            for (int i = l; i <= r; i++) {
                farest = Math.max(farest, nums[i] + i);
            }
            l = r + 1;
            r = farest;
            jumps++;
        }

        return jumps;
    }
}