class Solution {
    // How many subarrays are possible with maximum sum among them is maxSum
    private int noOfSubarrays(int[] arr, long maxSum) {
        long sum = 0, arrayCount = 1;
        for (int x : arr) {
            if (sum + x > maxSum) {
                sum = x;
                arrayCount++;
            } else {
                sum += x;
            }
        }
        return (int) arrayCount;
    }

    public int splitArray(int[] arr, int k) {
        int n = arr.length; // n -> No of elements in subarray
        // no of subarray > no of element
        if (k > n) {
            return -1;
        }

        int maxi = Integer.MIN_VALUE;
        long sum = 0l;

        for (int x : arr) {
            sum += x;
            maxi = Math.max(maxi, x);
        }

        long low = maxi, high = sum;

        while (low <= high) {
            // mid -> maxSum
            long mid = low + (high - low) / 2;
            // Yes possible find lower one move left
            if (noOfSubarrays(arr, mid) <= k) {
                high = mid - 1;
            }
            // Not possible find higher one move right
            else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
}