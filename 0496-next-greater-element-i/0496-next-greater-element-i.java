class Solution {
    private int getValue(int[] arr, int idx, int n) {
        int ans = -1;
        for (int i = idx + 1; i < n; i++) {
            if (arr[i] > arr[idx]) {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < n1; i++) {
            int idx = map.get(nums1[i]);
            nums1[i] = getValue(nums2, idx, n2);
        }
        return nums1;
    }
}