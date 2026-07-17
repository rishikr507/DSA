class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
        // int[] res = new int[m + n];
        // int i = 0, j = 0, k = 0;
        // while (i < m && j < n) {
        //     if (arr1[i] < arr2[j]) {
        //         res[k++] = arr1[i++];
        //     } else {
        //         res[k++] = arr2[j++];
        //     }
        // }
        // while (i < m) {
        //     res[k++] = arr1[i++];
        // }
        // while (j < n) {
        //     res[k++] = arr2[j++];
        // }
        // for (i = 0; i < m + n; i++) {
        //     arr1[i] = res[i];
        // }
    }
}