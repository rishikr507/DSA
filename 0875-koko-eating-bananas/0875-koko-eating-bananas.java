class Solution {
    private int totalHours(int []arr, int k){
        int total = 0;
        for(int x: arr){
            total += Math.ceil((double)x/k);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = totalHours(piles,mid);
            if(hours <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}