class Solution {
    private void helper(int[] arr, boolean[] flag, ArrayList<Integer> al, List<List<Integer>> res) {
        if (arr.length == al.size()) {
            res.add(new ArrayList<>(al));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (flag[i] == false) {
                al.add(arr[i]);
                flag[i] = true;
                helper(arr, flag, al, res);
                flag[i] = false;
                al.remove(al.size() - 1);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void helper2(int [] arr, int i , List<List<Integer>> res){
        if(i == arr.length){
            ArrayList<Integer> al = new ArrayList<>();
            for(int x: arr){
                al.add(x);
            }
            res.add(al);
            return;
        }

        for(int j = i; j < arr.length; j++){
            swap(arr,i,j);
            helper2(arr,i+1,res);
            swap(arr,i,j);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper2(nums,0,res);
        // int n = nums.length;
        // boolean[] flag = new boolean[n];
        // Arrays.fill(flag, false);
        // helper(nums, flag, new ArrayList<>(), res);
        return res;
    }
}