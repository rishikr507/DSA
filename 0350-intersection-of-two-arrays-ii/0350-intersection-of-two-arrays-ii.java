class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int k : nums2) {
            if(map.containsKey(k) && map.get(k) > 0){
                al.add(k);
                map.replace(k, map.get(k) - 1);
            }
        }

        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}