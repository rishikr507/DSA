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
    ArrayList<String> res = new ArrayList<>();

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    private void path(TreeNode root, String prev) {
        if (isLeaf(root) == true) {
            res.add( prev + root.val );
            return;
        }
        if (root.left != null)
            path(root.left, prev + root.val + "->");
        if (root.right != null)
            path(root.right, prev + root.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        path(root, "");
        return res;
    }
}