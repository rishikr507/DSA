class Solution {
    private void combSum(int[] arr, int i, int t, ArrayList<Integer> al, List<List<Integer>> res) {
        if (i == arr.length || t == 0) {
            if (t == 0)
                res.add(new ArrayList(al));
            return;
        }

        for (int idx = i; idx < arr.length; idx++) {
            if ((idx == i || arr[idx] != arr[idx - 1]) && arr[idx] <= t) {
                al.add(arr[idx]);
                combSum(arr, idx + 1, t - arr[idx], al, res);
                al.remove(al.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combSum(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
}