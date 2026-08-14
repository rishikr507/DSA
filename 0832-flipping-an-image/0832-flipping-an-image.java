class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            int i = 0, j = n - 1;
            while (i <= j) {
                if (row[i] == row[j]) {
                    row[i] = row[i] == 1 ? 0 : 1;
                    row[j] = row[i];
                }
                i++;
                j--;
            }
        }
        return image;
    }
}