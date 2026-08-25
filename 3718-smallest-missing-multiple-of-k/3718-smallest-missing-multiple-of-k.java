class Solution {
    public int missingMultiple(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> hash = new HashSet<>(); 
        for (int x : nums) {
            if (x % k == 0) {
                max = Math.max(max, x);
            }
            hash.add(x);
        }
        for(int i = k ; i<= max ; i += k){
            if(!hash.contains(i)){
                return i;
            }
        }
        if(max == Integer.MIN_VALUE) max = 0;
        return max+k;
    }
}