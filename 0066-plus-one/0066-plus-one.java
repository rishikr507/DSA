class Solution {
    public int[] plusOne(int[] arr) {
        int carry = 0, n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        int sum = carry + arr[n - 1] + 1;
        carry = sum / 10;
        int digit = sum % 10;
        al.add(0, digit);
        for (int i = n - 2; i >= 0; i--) {
            sum = carry + arr[i];
            carry = sum / 10;
            
            digit = sum % 10;
            al.add(0, digit);
        }
        if (carry != 0) {
            al.add(0, carry);
        }

        int res[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }
}