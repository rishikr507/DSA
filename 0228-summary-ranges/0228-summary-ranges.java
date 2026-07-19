class Solution {

    private StringBuilder range(int curr, int next) {
        if (curr == next - 1) {
            return new StringBuilder("" + curr);
        }
        return new StringBuilder(curr + "->" + (next - 1));
    }

    public List<String> summaryRanges(int[] arr) {
        int n = arr.length;
        ArrayList<String> al = new ArrayList<>();
        if (n == 0)
            return al;
        int curr = arr[0], next = arr[0] + 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == next) {
                next += 1;
            } else {
                al.add(range(curr, next).toString());
                curr = arr[i];
                next = arr[i] + 1;
            }
        }

        al.add(range(curr, next).toString());
        return al;
    }
}