class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = k;
        for(int x: nums){
            if(x% k != 0 && x > ans){
                return ans;
            }else if(x %k == 0 && x == ans){
                ans += k;
            }
        }
        return ans;
    }
}