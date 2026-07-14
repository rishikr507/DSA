class Solution {
    private boolean checkDivSum(int arr[], int div, int threshold) {
        int sum = 0;
        for (int x : arr) {
            sum += (x + div - 1) / div;
            if (sum > threshold)
                return false;
        }
        return true;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int maxi = Arrays.stream(nums).max().getAsInt();
        int high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkDivSum(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}