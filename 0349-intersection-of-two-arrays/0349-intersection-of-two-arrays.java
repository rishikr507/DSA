class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        for(int x: nums1){
            a.add(x);
        }
        for(int y : nums2){
            if(a.contains(y)){
                b.add(y);
            }
        }
        int ans[] = new int[b.size()];
        int k = 0;
        for(var x:b){
            ans[k++] = x;
        }
        return ans;
    }
}