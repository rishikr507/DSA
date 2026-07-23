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
    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    private void invert(TreeNode root) {
        if (isLeaf(root) == true)
            return;
        if(root.left != null) invert(root.left);
        if(root.right != null) invert(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || isLeaf(root) == true)
            return root;
        invert(root);
        return root;
    }
}