class Solution {
    public int[] sortedSquares(int[] arr) {
        int i = 0, n = arr.length;
        int res[] = new int[n];
        while (i < n && arr[i] < 0  ) {
            i++;
        }
        i--;
        int j = i + 1, k = 0;

        while (i >= 0 && j < n) {
            if (Math.abs(arr[i]) < Math.abs(arr[j])) {
                res[k++] = arr[i] * arr[i];
                i--;
            } else {
                res[k++] = arr[j] * arr[j];
                j++;
            }
        }
        while (i >= 0) {
            res[k++] = arr[i] * arr[i];
            i--;
        }
        while (j < n) {
            res[k++] = arr[j] * arr[j];
            j++;
        }
        return res;
    }
}