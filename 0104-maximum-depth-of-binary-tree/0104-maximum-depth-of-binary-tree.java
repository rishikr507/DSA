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
    private int findDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lh = findDepth(root.left);
        int rh = findDepth(root.right);

        return Math.max(lh, rh) + 1;
    }

    public int maxDepth(TreeNode root) {
        return findDepth(root);
    }
}