class Solution {

    private boolean check(int g, int[][] paths, HashMap<Integer, Integer> map, int p) {
        for (int i = 0; i < paths.length; i++) {
            if (paths[i][0] == g && map.get(paths[i][1]) == p) {
                return false;
            } else if (paths[i][1] == g && map.get(paths[i][0]) == p)
                return false;
        }
        return true;
    }

    boolean solve(int g, int n, int[][] paths, HashMap<Integer, Integer> map) {
        if (g > n)
            return true;

        for (int p = 1; p <= 4; p++) {
            if (check(g, paths, map, p)) {
                map.replace(g, p);
                if (solve(g + 1, n, paths, map) == true)
                    return true;
                map.replace(g, 0);
            }
        }
        return false;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, Integer> map = new HashMap<>(); // garden , plant

        for (int g = 1; g <= n; g++) {
            map.put(g, 0);
        }
        solve(1, n, paths, map);
        int[] ans = new int[n];
        int k = 0;
        for (var e : map.entrySet()) {
            ans[k++] = e.getValue();
        }
        return ans;
    }
}