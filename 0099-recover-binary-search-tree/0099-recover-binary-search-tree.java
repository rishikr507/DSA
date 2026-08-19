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
    private TreeNode viol1, viol2, prev;

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (viol1 == null) {
                viol1 = prev;
                viol2 = root;
            } else {
                viol2 = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    // private void verifyBST(TreeNode root, ArrayList<Integer> inorder, int[] i) {
    //     if (root == null)
    //         return;

    //     verifyBST(root.left, inorder, i);
    //     root.val = inorder.get(i[0]++);
    //     verifyBST(root.right, inorder, i);
    // }
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        viol1 = viol2 = prev = null;
        inorder(root);
        if (viol1 != null) {
            int t = viol1.val;
            viol1.val = viol2.val;
            viol2.val = t;
        }
    }
}