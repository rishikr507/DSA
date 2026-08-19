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
    private void findInorder(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        findInorder(root.left, inorder);
        inorder.add(root.val);
        findInorder(root.right, inorder);
    }

    private void verifyBST(TreeNode root, ArrayList<Integer> inorder, int[] i) {
        if (root == null)
            return;

        verifyBST(root.left, inorder, i);
        root.val = inorder.get(i[0]++);
        verifyBST(root.right, inorder, i);
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        ArrayList<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder);
        Collections.sort(inorder);
        verifyBST(root, inorder, new int[] { 0 });
    }
}