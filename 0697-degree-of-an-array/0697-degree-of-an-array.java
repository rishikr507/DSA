class Solution {
    public int findShortestSubArray(int[] arr) {
        int n = arr.length;
        HashMap<Integer, tuple> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                var t = map.get(arr[i]);
                map.replace(arr[i], new tuple(t.s, i, t.count + 1));
            } else {
                map.put(arr[i], new tuple(i, i, 1));
            }
        }
        int maxi = -1, len = 50001;
        for (var e : map.entrySet()) {
            tuple t = e.getValue();
            if (t.count > maxi) {
                maxi = t.count;
                len = t.e - t.s + 1;
            } else if (t.count == maxi) {
                len = Math.min(len, t.e - t.s + 1);
            }
        }
        return len;
    }
}

class tuple {
    int s, e, count;

    public tuple(int _s, int _e, int _c) {
        s = _s;
        e = _e;
        count = _c;
    }
}