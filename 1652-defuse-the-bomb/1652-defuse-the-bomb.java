class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] ans = new int[n];
        int l = 0, r = Math.abs(k) - 1, sum = 0;
        for (int i = 0; i < Math.abs(k); i++) {
            sum += code[i];
        }
        while (l < n) {
            int idx = -1;
            if (k < 0) {
                idx = (r + 1) % n;
            } else {
                idx = (l + n - 1) % n;
            }
 
            ans[idx] = sum;
            r = (r + 1) % n;
            sum = sum + code[r] - code[l];
            l++;
        }
        return ans;
    }
}