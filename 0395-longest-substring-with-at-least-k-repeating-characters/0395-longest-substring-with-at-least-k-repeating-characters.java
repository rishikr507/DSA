class Solution {
    private boolean check(HashMap<Character, Integer> map, int k) {
        for (var freq : map.values()) {
            if (freq < k)
                return false;
        }
        return true;
    }

    public int longestSubstring(String s, int k) {
        int n = s.length(), maxi = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (check(map, k)) {
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
        return maxi;
    }
}