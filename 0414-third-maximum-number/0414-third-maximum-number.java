class Solution {
    public int thirdMax(int[] arr) {
        Long first = null, second = null, third = null;

        for (int x : arr) {
            if ((first != null && first == x) || (second != null && second == x) || (third != null && third == x))
                continue;
            if (first == null || x > first) {
                third = second;
                second = first;
                first = (long) x;
            } else if (second == null || x > second) {
                third = second;
                second = (long) x;
            } else if (third == null || x > third) {
                third = (long) x;
            }
        }
        if (arr.length < 3 || third == null) {
            return first.intValue();
        }
        return third.intValue();
    }
}