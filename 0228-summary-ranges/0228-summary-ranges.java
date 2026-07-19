class Solution {
    public List<String> summaryRanges(int[] arr) {
        int n = arr.length;
        ArrayList<String> al = new ArrayList<>();
        if (n == 0)
            return al;
        int curr = arr[0], next = arr[0] + 1;
        String str;
        for (int i = 1; i < n; i++) {
            if (arr[i] == next) {
                next += 1;
            } else {
                if (curr == next - 1) {
                    str = "" + curr;
                } else {
                    str = curr + "->" + (next - 1);
                }
                al.add(str);
                curr = arr[i];
                next = arr[i] + 1;
            }
        }
        if (curr == next - 1) {
            str = "" + curr;
        } else {
            str = curr + "->" + (next - 1);
        }
        al.add(str);

        return al;
    }
}