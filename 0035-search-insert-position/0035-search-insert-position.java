class Solution {
    private int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int searchInsert(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        return lb;
    }
}