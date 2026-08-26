class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                al.add(i);
            }
        }

        int mini = n + 1;
        String ans = "";

        if (al.size() == 1 && k > 1)
            return ans;
        for (int i = 0; i < al.size() - k + 1; i++) {
            int start = al.get(i), end = al.get(i + k - 1);
            String temp = s.substring(start, end + 1);
            int size = temp.length();
            if (size < mini) {
                mini = size;
                ans = temp;
            } else if (size == mini && temp.compareTo(ans) < 0) {
                ans = temp;
            }
        }
        return ans;
    }
}