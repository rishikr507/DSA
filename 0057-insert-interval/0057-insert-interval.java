class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> al = new ArrayList<>();

        // Left part non-overlapping
        while (i < n && intervals[i][1] < newInterval[0]) {
            al.add(intervals[i]);
            i++;
        }

        // Middle part
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        al.add(newInterval);

        // Right part non-overlapping
        while (i < n) {
            al.add(intervals[i]);
            i++;
        }
        
        return al.toArray(new int[0][0]);
    }
}