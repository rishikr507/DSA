class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;
        int cnt = n - 2;
        int[] prime = new int[n + 1];
        Arrays.fill(prime, 1);
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    if (prime[j] == 1) {
                        cnt--;
                        prime[j] = 0;
                    }
                }
            }
        }

        return cnt;
    }
}