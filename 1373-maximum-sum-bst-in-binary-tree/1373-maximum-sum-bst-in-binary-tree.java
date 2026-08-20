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
    int sum, min, max;

    public Tuple(int _c, int _s, int _l) {
        sum = _c;
        min = _s;
        max = _l;
    }
}

class Solution {
    final int MIN = Integer.MIN_VALUE;
    final int MAX = Integer.MAX_VALUE;
    int ans = 0;

    private Tuple postorder(TreeNode root) {
        if (root == null)
            return new Tuple(0, MAX, MIN); // [0, inf, -inf]

        Tuple l = postorder(root.left);
        Tuple r = postorder(root.right);

        // We need maximum sum of BST, if we condsider a valide BST then all sum of all node should be maximum ... so there is a possiblity a smaller BST can have sum > than a larger BST... That's why we taking ans as making sum.
        if (l.max < root.val && root.val < r.min) {
            int sum = l.sum + r.sum + root.val;
            // We need Max sum of a Valid BST
            ans = Math.max(sum, ans);
            return new Tuple(sum,
                    Math.min(l.min, root.val),
                    Math.max(r.max, root.val));
        }
        return new Tuple(Math.max(l.sum, r.sum), MIN, MAX);
    }

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return ans;
    }
}
