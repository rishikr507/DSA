class Solution {
    public int findComplement(int num) {
        int ans = 0;
        for (int i = 0; num > 1; i++) {
            int bit = num % 2;
            if (bit == 0)
                ans = ans | (1 << i);
            num = num / 2;
        }

        return ans;
    }
}