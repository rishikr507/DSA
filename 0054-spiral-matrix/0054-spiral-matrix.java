class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        List<Integer> al = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // left -> right;
            for (int j = left; j <= right; j++) {
                al.add(matrix[top][j]);
            }
            top++;
            // top -> bottom
            if (top > bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                al.add(matrix[i][right]);
            }
            right--;

            // right -> left
            if (left > right)
                break;
            for (int j = right; j >= left; j--) {
                al.add(matrix[bottom][j]);
            }
            bottom--;

            // bottom -> up
            for (int i = bottom; i >= top; i--) {
                al.add(matrix[i][left]);
            }
            left++;
        }
        return al;
    }
}