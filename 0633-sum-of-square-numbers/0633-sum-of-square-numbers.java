class Solution {
    public boolean judgeSquareSum(int c) {
        // for( int a = 0; a <= Math.sqrt(c) ; a++){
        //     int b2 = c - a * a;
        //     if(b2 < 0){
        //         break;
        //     }
        //     int b = (int)Math.sqrt(b2);
        //     if( b * b == b2){
        //         return true;
        //     }
        // }
        // return false;
        int low = 0, high =  (int)Math.sqrt(c);
        while (low <= high) {
            long sum = (long)low * low + (long)high * high;
            if (sum == (long)c) {
                return true;
            } else if (sum < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
}