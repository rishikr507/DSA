class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n ; i++){
            set.add(arr[i]);
        }
        ArrayList<Integer> al = new ArrayList<>();

        for( int i= 1; i <= n ; i++){
            if(! set.contains(i)){
                al.add(i);
            }
        }
        return al;

        // int n = arr.length;

        // for (int i = 0; i < n; i++) {
        //     int x = Math.abs(arr[i]);
        //     if (arr[x - 1] > 0) {
        //         arr[x - 1] = -arr[x - 1];
        //     }
        // }
        // ArrayList<Integer> al = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] > 0) {
        //         al.add(i+1);
        //     }
        // }
        // return al;
    }
}