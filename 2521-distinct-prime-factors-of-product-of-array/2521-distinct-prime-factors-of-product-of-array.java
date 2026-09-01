class Solution {
    int[] getSPF(int n) {
        int[] spf = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            spf[i] = i;
        }
        spf[0] = 0;
        spf[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    spf[j] = i;
                }
            }
        }
        return spf;
    }

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] spf = getSPF(1000);
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != 1) {
                set.add(spf[nums[i]]);
                nums[i] /= spf[nums[i]];
            }
        }
        return set.size();
    }
}