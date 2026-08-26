class Solution {
    String helper(int n, int k, String ans, int fact, ArrayList<Integer> al) {
        if (k == 0) {
            for (int x : al) {
                ans = ans + x;
            }
            return ans;
        }
        fact = fact / n;
        int rem = k / fact;
        ans = ans + al.get(rem);
        al.remove(rem);
        return helper(n - 1, k % fact, ans, fact, al);
    }

    public String getPermutation(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            al.add(i);
            fact *= i;
        }

        return helper(n, k-1 , "", fact, al);
    }
}