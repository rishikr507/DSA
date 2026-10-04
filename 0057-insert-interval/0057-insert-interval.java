class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        // Left part non-overlapping
        while (i < n && intervals[i][1] < newInterval[0]) {
            al.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }

        // Middle part
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        al.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));

        // Right part non-overlapping
        while (i < n) {
            al.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }
        int[][] res = new int[al.size()][2];
        i = 0;
        for (var li : al) {
            res[i][0] = li.get(0);
            res[i][1] = li.get(1);
            i++;
        }
        return res;
    }
}