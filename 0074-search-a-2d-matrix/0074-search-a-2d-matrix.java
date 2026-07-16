class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0 , high = n * m -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            int i = mid /m , j = mid % m;
            if(matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) low = mid + 1;
            else high = mid -1;
        }
        return false;
    }
}