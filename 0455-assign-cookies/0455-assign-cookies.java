class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;
        int l = 0, r = 0;

        while (l < n && r < m) {
            if (s[r] >= g[l]) {
                l++;
            }
            r++;
        }
        return l;
    }
}