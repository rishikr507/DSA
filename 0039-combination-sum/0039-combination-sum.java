class Solution {
    private void combSum(int[] arr, int i, int t, ArrayList<Integer> al, List<List<Integer>> res) {
        if (i == arr.length || t == 0) {
            if (t == 0)
                res.add(new ArrayList(al));
            return;
        }

        if (arr[i] <= t) {
            al.add(arr[i]);
            combSum(arr, i, t - arr[i], al, res);
            al.remove(al.size() - 1);
        }
        combSum(arr, i + 1, t, al, res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combSum(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
}