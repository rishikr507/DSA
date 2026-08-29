class Solution {
    private int[] getSieve(int N) {
        int[] prime = new int[N + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i * i <= N; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }

    public int[] closestPrimes(int left, int right) {
        int[] prime = getSieve(right);
        int num1 = -1, num2 = -1;
        int mini = 0;
        for (int i = left; i <= right; i++) {
            if (prime[i] == 1) {
                num1 = i;
                break;
            }
        }
        if(num1 == -1 || num1 == right) return new int[]{-1,-1};
        int last = -1;
        for (int i = num1 + 1; i <= right; i++) {
            if (prime[i] == 1) {
                if (num2 == -1) {
                    num2 = i;
                    mini = num2 - num1;
                    last = num2;
                } else if (num1 != num2) {
                    if (i - last < mini) {
                        mini = i - last;
                        num1 = last;
                        num2 = i;
                    }
                }
                last = i;
            }
        }

        if (num1 == num2 || num1 == -1 || num2 == -1)
            return new int[] { -1, -1 };
        return new int[] { num1, num2 };
    }
}