class Solution {
    private int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int first = lowerBound(arr, target);
        if (first == n || arr[first] != target) {
            return new int[] { -1, -1 };
        }
        int last = upperBound(arr, target);
        return new int[] { first, last - 1 };
    }
}