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
    private void rightView(TreeNode root, int level, List<Integer> res) {
        if (root == null)
            return;
        if (level == res.size()) // That means we reach this level for the first time
            res.add(root.val);
        rightView(root.right, level + 1, res);
        rightView(root.left, level + 1, res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        rightView(root, 0, res);
        return res;
    }
}