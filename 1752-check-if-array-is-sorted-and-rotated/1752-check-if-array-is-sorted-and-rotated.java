class Solution {
    public boolean check(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return true;
        }
        int pivot = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1)
            return true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[(pivot + i) % n] > arr[(pivot + i + 1) % n]) {
                return false;
            }
        }
        return true;
    }
}