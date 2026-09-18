class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, m = flowerbed.length;
        while (i < m && n != 0) {
            if (flowerbed[i] == 1)
                i += 2;
            else {
                if (i == m - 1){
                    n--;
                    i += 2;
                }
                else if (i <= m - 2 && flowerbed[i + 1] != 1) {
                    n--;
                    i += 2;
                }
                else{
                    i++;
                }
            }
        }
        return n == 0;
    }
}