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

    private boolean check(TreeNode root, int target) {
        if(root == null) return false;
        if (isLeaf(root) == true) {
            if (root.val == target)
                return true;
            else
                return false;
        }
        return check(root.left, target - root.val) || check(root.right, target - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return check(root, targetSum);
    }
}