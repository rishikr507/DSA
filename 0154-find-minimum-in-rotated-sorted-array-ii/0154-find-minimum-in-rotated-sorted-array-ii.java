class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int ans = -1;
        if(n == 1 || arr[0] <= arr[1]){
            ans = arr[0];
        }

        for( int i = 1; i < n ; i++){
            if(arr[i] < arr[i-1]){
                ans = arr[i];
            }
        }
        return ans;
    }
}