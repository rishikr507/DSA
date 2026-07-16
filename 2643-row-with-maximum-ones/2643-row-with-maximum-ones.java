class Solution {
    private int countOnes(int[] arr) {
        int count = 0;
        for(int x: arr){
            count += x;
        }
        return count;
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx = 0, maxCount = 0;
        for (int i = 0; i < mat.length; i++) {
            int count = countOnes(mat[i]);
            if (count > maxCount) {
                maxCount = count;
                idx = i;
            }
        }
        return new int[]{idx,maxCount};
    }
}