class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return true;
        int i = 1;
        while (i < n && (nums[i] - nums[i - 1]) == 0)
            i++;
        if (i == n)
            return true;
        int flag = nums[i] - nums[i - 1];
        for (; i < n; i++) {
            int diff = (nums[i] - nums[i - 1]);
            if (flag * diff < 0)
                return false;
            flag = diff != 0 ? diff : flag;
        }
        return true;
    }
}