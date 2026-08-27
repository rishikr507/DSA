class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1, n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }
        reverse(nums, idx + 1, n - 1);
    }

    private void reverse(int[] a, int l, int r) {
        while (l <= r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }
}