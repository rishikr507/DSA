class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int ans = 0;
        for (int i = 0; n > 0; i++) {
            int bit = n % 2;
            if (bit == 0)
                ans = ans | (1 << i);
            n = n >> 1;
        }

        return ans;
    }
}