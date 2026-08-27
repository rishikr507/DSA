class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int curr = 1, prev = 0, next = 1;
        for (int i = 2; i <= n; i++) {
            next = curr + prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}