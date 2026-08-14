/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int floor(TreeNode root, int x) {
        int f = -1;
        while (root != null) {
            if (root.val == x) {
                f = root.val;
                break;
            } else if (root.val < x) {
                f = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return f;
    }

    private int ceil(TreeNode root, int x) {
        int c = -1;
        while (root != null) {
            if (root.val == x) {
                c = root.val;
                break;
            } else if (root.val > x) {
                c = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return c;
    }

    private void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;

        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        for (int x : queries) {
            int low = 0, high = in.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (in.get(mid) < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int f = -1, c = -1;
            if (low < in.size())
                c = in.get(low);
            if (high > -1)
                f = in.get(high);
            if (c == x)
                f = x;
            res.add(Arrays.asList(f, c));
        }
        return res;
    }
}