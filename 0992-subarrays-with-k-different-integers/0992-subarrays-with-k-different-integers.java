class Solution {
    private int count(int [] arr, int k){
        if( k < 0) return 0;
        int l = 0, r = 0, n = arr.length,cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while( r< n){
            map.put(arr[r] , map.getOrDefault(arr[r], 0) + 1);
            while(map.size() > k){
                map.put(arr[l],map.get(arr[l])-1);
                map.remove(arr[l], 0);
                l++;
            }
            if(map.size() <= k){
                cnt += (r-l+1);
            }
            r++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums,k-1);
    }
}