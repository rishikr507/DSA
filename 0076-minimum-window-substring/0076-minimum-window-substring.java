class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, cnt = 0;
        int minLen = Integer.MAX_VALUE, idx = -1;
        int[] hash = new int[256];
        for (int i = 0; i < t.length(); i++)
            hash[t.charAt(i)]++;
        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0)
                cnt++;
            hash[s.charAt(r)]--;
            while (cnt == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    idx = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0)
                    cnt--;
                l++;
            }
            r++;
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(idx, idx + minLen);
    }
}