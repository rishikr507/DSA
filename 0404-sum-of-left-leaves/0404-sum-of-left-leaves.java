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
    int sum = 0;

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    private void findSum(TreeNode root, TreeNode prev) {
        if (isLeaf(root) == true) {
            if (prev.left != null && prev.left == root)
                sum += root.val;
            return;
        }
        if (root.left != null)
            findSum(root.left, root);
        if (root.right != null)
            findSum(root.right, root);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        findSum(root, root);
        return sum;
    }
}