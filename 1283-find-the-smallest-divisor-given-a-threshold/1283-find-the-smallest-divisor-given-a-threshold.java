class Solution {
    private int divSum(int arr[], int div) {
        int sum = 0;
        for (int x : arr) {
            sum += Math.ceil((double) x / (double) div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int maxi = Arrays.stream(nums).max().getAsInt();
        int high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (divSum(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}