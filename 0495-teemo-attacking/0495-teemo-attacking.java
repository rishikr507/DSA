class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int start = timeSeries[0];
        int end = start + duration - 1;
        int time = 0;
        for (int i = 1; i < n; i++) {
            if (timeSeries[i] > end) {
                time += (end - start + 1);
                start = timeSeries[i];
                end = timeSeries[i] + duration - 1;
            } else {
                end = timeSeries[i] + duration - 1;
            }
        }
        time += (end - start + 1);
        return time;
    }
}