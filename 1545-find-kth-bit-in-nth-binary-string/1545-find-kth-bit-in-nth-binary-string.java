class Solution {
    private String invert(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() ; i++) {
            if (str.charAt(i) == '1')
                sb.append('0');
            else
                sb.append('1');
        }
        return sb.reverse().toString();
    }

    private void Si(ArrayList<String> al, int i) {
        String si_1 = al.get(i - 1);
        String inv = invert(si_1);
        al.add(si_1 + "1" + inv);
    }

    public char findKthBit(int n, int k) {
        ArrayList<String> al = new ArrayList<>();
        al.add("");
        al.add("0");

        for (int i = 2; i <= n; i++) {
            Si(al, i);
        }
        String str = al.get(n);
        return str.charAt(k-1);
    }
}