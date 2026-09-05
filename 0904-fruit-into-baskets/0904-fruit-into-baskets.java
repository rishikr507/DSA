class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, maxi = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //[fruits,freq]

        while (r < n) {
            int f = fruits[r];
            map.put(f, map.getOrDefault(f, 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                map.remove(fruits[l], 0);
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