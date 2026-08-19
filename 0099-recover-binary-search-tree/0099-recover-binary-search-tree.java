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
    private TreeNode viol1, viol2, middle, prev;

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (viol1 == null) {
                viol1 = prev;
                middle = root;
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
    private void swap(TreeNode a, TreeNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        viol1 = viol2 = middle = prev = null;
        inorder(root);
        if (viol1 != null) {
            if (viol2 != null) {
                swap(viol1, viol2);
            } else {
                swap(viol1, middle);
            }
        }
    }
}