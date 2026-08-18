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
    private boolean find(TreeNode curr,TreeNode root, int x) {
        while (root != null) {
            if (root.val == x && root != curr)
                return true;
            else if (x < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }

    private boolean helper(TreeNode curr, TreeNode root, int k) {
        if (curr == null)
            return false;
        int x = k - curr.val;
        boolean flag = find(curr,root, x);

        if (flag == true)
            return true;

        return helper(curr.left, root, k) || helper(curr.right, root, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }
}