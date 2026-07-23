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
    private boolean check(TreeNode left, TreeNode right){
        if(left == null || right == null) return (left == right);
        boolean lr = check(left.left,right.right);
        boolean rl = check(left.right, right.left);

        return (left.val == right.val) && lr && rl;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
}