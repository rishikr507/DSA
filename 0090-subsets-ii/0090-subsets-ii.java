class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void helper(int[] arr, int i, int n, ArrayList<Integer> al) {
        res.add(new ArrayList<>(al));
        if (i == n) {
            return;
        }

        for (int j = i; j < n; j++) {
            if (j == i || arr[j] != arr[j - 1]) {
                al.add(arr[j]);
                helper(arr, j + 1, n, al);
                al.remove(al.size() - 1);
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return res;
        Arrays.sort(nums);
        helper(nums, 0, n, new ArrayList<>());
        return res;
    }
}