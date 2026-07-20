class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 < n2)
            return intersect(nums2, nums1);
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int x : nums1) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        for (int x : nums2) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (var e : map1.entrySet()) {
            int key = e.getKey();
            if (map2.containsKey(key)) {
                for(int i =0; i < Math.min(e.getValue(),map2.get(key)) ; i++){
                    al.add(key);
                }
            }
        }

        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}