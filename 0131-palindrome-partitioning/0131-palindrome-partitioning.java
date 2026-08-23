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

    private void solve(String str, int i, List<String> al, List<List<String>> res) {
        if (i == str.length()) {
            res.add(new ArrayList<>(al));
            return;
        }

        for (int p = i; p < str.length(); p++) {
            String temp = str.substring(i, p + 1);
            if (isPalindrome(temp)) {
                al.add(temp);
                solve(str, p + 1, al, res);
                al.remove(al.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> al = new ArrayList<>();
        solve(s, 0, al, res);
        return res;
    }
}