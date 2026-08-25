class Solution {
    public int[] singleNumber(int[] arr) {
        int num1 = 0, num2 = 0;
        int xor = 0;
        for (int x : arr) {
            xor = xor ^ x;
        }
        int b0 = 0, b1 = 0;
        int mask = (xor & (xor - 1)) ^ xor;
        for (int x : arr) {
            if ((x & mask) == 0)
                b0 ^= x;
            else
                b1 ^= x;
        }
        int[] ans = new int[] { b0, b1 };
        return ans;
    }
}