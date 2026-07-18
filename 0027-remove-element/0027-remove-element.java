class Solution {
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int removeElement(int[] arr, int val) {
        int n = arr.length;
        int k = n;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (arr[i] == val) {
                swap(arr, i, j);
                j--;
            } else {
                i++;
            }
        }
        return i;
    }
}