class Solution {
    private boolean isPalindrome(String s) {
        if (s.isEmpty())
            return false;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private void solve(String str, int s, int e, List<List<String>> res, List<String> al) {
        if (str.length() == s) {
            res.add(new ArrayList<>(al));
            return;
        }

        for (int i = s; i < str.length(); i++) {
            String temp = str.substring(s, i+1);
            if (isPalindrome(temp)) {
                al.add(temp);
                solve(str, i + 1, e, res, al);
                al.remove(al.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> al = new ArrayList<>();
        solve(s, 0, s.length(), res, al);
        return res;
    }
}