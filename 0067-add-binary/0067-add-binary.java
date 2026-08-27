class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        if (n2 > n1)
            return addBinary(b, a);
        int i = n1 - 1, j = n2 - 1;
        int carry = 0;
        String ans = "";
        for (; j >= 0; i--, j--) {
            char _a = a.charAt(i), _b = b.charAt(j);
            int sum = (_a - '0') + (_b - '0') + carry;
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }
        while (i >= 0) {
            int sum = carry + (a.charAt(i) - '0');
            ans = (sum % 2) + ans;
            carry = sum / 2;
            i--;
        }
        if (carry == 1) {
            ans = carry + ans;
        }
        return ans;
    }
}