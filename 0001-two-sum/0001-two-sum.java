class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] temp = { -1, -1 };
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                temp[0] = idx;
                temp[1] = i;
                return temp;
            }
            map.put(nums[i], i);
        }

        return temp;
    }
}