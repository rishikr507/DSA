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
class Tuple {
    int sum, small, larg;

    public Tuple(int _c, int _s, int _l) {
        sum = _c;
        small = _s;
        larg = _l;
    }
}

class Solution {
    final int MIN = Integer.MIN_VALUE;
    final int MAX = Integer.MAX_VALUE;
    int ans = 0;

    private Tuple postorder(TreeNode root) {
        if (root == null)
            return new Tuple(0, MAX, MIN);

        Tuple left = postorder(root.left);
        Tuple right = postorder(root.right);
        if (left.larg < root.val && root.val < right.small) {
            int sum = left.sum + right.sum + root.val;
            ans = Math.max(sum, ans);
            return new Tuple(sum,
                    Math.min(left.small, root.val),
                    Math.max(right.larg, root.val));
        }
        return new Tuple(Math.max(left.sum, right.sum), MIN, MAX);
    }

    public int maxSumBST(TreeNode root) {
        Tuple t = postorder(root);
        return ans;
    }
}
