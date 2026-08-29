class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;
        int cnt = 0;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (prime[i] == true)
                cnt++;
        }
        return cnt;
    }
}