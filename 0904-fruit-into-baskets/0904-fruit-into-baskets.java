class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, maxi = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //[fruits,freq]

        while (r < n) {
            int f = fruits[r];
            map.put(f, map.getOrDefault(f, 0) + 1);
            if (map.size() > 2) {
                int ele = fruits[l];
                map.put(ele, map.get(ele) - 1);
                map.remove(ele, 0);
                l++;
            }
            if (map.size() <= 2) {
                maxi = Math.max(maxi, r - l + 1);
            }
            r++;
        }
        return maxi;
    }
}