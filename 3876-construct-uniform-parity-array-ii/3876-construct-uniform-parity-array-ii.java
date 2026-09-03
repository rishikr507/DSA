class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int ele = Integer.MAX_VALUE;
        for (int x : nums1) {
            if (x % 2 == 1)
                ele = Math.min(ele, x);
        }
        if (ele == Integer.MAX_VALUE)
            return true;
        for (int x : nums1) {
            if (x % 2 == 0 && ((x - ele) < 1 || (x - ele) % 2 == 0))
                return false;
        }
        return true;
    }
}