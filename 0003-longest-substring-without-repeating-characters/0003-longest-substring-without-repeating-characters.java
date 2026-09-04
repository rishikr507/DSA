class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxi = 0, l = 0, r = 0;
        int[] hash = new int[255];
        Arrays.fill(hash, -1);
        while (r < n) {
            int ch = s.charAt(r);
            if (hash[ch] != -1 && hash[ch] >= l) {
                l = hash[ch] + 1;
            }
            maxi = Math.max(maxi, r - l + 1);
            hash[ch] = r;
            r++;
        }
        return maxi;
    }
}