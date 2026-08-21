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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, false);
        helper(nums, flag, new ArrayList<>(), res);
        return res;
    }
}