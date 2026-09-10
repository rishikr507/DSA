class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, maxi = 0, maxf = 0;
        int[] hash = new int[26];

        while (r < n) {
            hash[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);
            if (r - l + 1 - maxf > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            if (r - l + 1 - maxf <= k)
                maxi = Math.max(maxi, r - l + 1);
            r++;
        }
        return maxi;
    }
}