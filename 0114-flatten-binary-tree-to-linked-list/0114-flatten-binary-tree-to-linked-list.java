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
    TreeNode prev = null;

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left, right = root.right;

        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }
        prev = root;


        preorder(left);
        preorder(right);
    }

    public void flatten(TreeNode root) {
        preorder(root);
    }
}