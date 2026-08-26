class Solution {

    public String getPermutation(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            al.add(i);
            fact *= i;
        }
        String ans = "";
        k--;
        for (int i = n; i > 0; i--) {
            fact = fact / i;
            int rem = k / fact;
            ans = ans + al.get(rem);
            al.remove(rem);
            k = k % fact;
            if (k == 0)
                break;
        }
        if (al.size() > 0) {
            for (int x : al)
                ans = ans + x;
        }
        return ans;
    }
}