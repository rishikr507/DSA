class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + ( high - low)/2;

            if(arr[mid] == arr[high]){
                high--;
            }
            else if(arr[mid] > arr[high]){
                low = mid + 1;
            }
            else{
                high = mid ;
            }
        }
        return arr[low];

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