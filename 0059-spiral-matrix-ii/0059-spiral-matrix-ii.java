class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int k = 1;

        while (top <= bottom && left <= right) {
            // left -> right;
            for (int j = left; j <= right; j++) {
                matrix[top][j] = k++;
            }
            top++;
            // top -> bottom
            if (top > bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = k++;
            }
            right--;

            // right -> left
            if (left > right)
                break;
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = k++;
            }
            bottom--;

            // bottom -> up
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = k++;
            }
            left++;
        }
        return matrix;
    }
}