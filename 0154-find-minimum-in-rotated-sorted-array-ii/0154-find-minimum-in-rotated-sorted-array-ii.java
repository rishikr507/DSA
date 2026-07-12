class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                ans = Math.min(ans, arr[low]);
                low++;
                high--;
                continue;
            }
            else if (arr[mid] <= arr[high]) {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            } else {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
        }
        return ans;

        // int n = arr.length;
        // int ans = -1;
        // if(n == 1 || arr[0] <= arr[1]){
        //     ans = arr[0];
        // }

        // for( int i = 1; i < n ; i++){
        //     if(arr[i] < arr[i-1]){
        //         ans = arr[i];
        //     }
        // }
        // return ans;
    }
}