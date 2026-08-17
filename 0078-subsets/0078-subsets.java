class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void helper(int[] arr, int i, ArrayList<Integer> al) {
        if (i >= arr.length) {
            res.add(new ArrayList<>(al));
            return;
        }

        helper(arr, i + 1, al);
        al.add(arr[i]);
        helper(arr, i + 1, al);
        al.remove(al.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
}