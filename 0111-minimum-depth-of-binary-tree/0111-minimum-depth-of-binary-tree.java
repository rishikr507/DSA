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
    int mini = Integer.MAX_VALUE;

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    private void findDepth(TreeNode root, int depth) {
        if (isLeaf(root) == true) {
            mini = Math.min(mini, depth);
            return;
        }
        if(depth > mini) return;
        if (root.left != null)
            findDepth(root.left, depth + 1);
        if (root.right != null)
            findDepth(root.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        findDepth(root, 1);

        return mini;
    }
}