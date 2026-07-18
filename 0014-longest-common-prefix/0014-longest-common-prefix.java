class Solution {
    private boolean isCommon(String[] strs, int i, char ch) {
        for (String str : strs) {

            if (str.length() <= i || str.charAt(i) != ch)
                return false;
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            if (!isCommon(strs, i, str.charAt(i))) {
                return str.substring(0, i);
            }
        }
        return str;
    }
}