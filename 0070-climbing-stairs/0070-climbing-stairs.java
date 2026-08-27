class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int curr = 1, prev = 0, next = 1;
        for (int i = 1; i <= n; i++) {
            next = curr + prev;
            prev= curr;
            curr = next;
        }
        return curr;
    }
}