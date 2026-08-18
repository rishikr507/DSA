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
    private TreeNode constBST(int[] preorder, int ub, int[] i) {
        if (i[0] >= preorder.length || preorder[i[0]] > ub)
            return null;
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;

        root.left = constBST(preorder, root.val, i);
        root.right = constBST(preorder, ub, i);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0)
            return null;

        TreeNode root = constBST(preorder, Integer.MAX_VALUE, new int[] { 0 });
        return root;
        // int n = preorder.length;
        // if (n == 0)
        //     return null;

        // TreeNode root = new TreeNode(preorder[0]);
        // for (int i = 1; i < n; i++) {
        //     TreeNode curr = root;
        //     int val = preorder[i];
        //     while (curr != null) {
        //         if (val < curr.val) {
        //             if (curr.left != null)
        //                 curr = curr.left;
        //             else {
        //                 curr.left = new TreeNode(val);
        //                 break;
        //             }
        //         } else {
        //             if (curr.right != null)
        //                 curr = curr.right;
        //             else {
        //                 curr.right = new TreeNode(val);
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return root;
    }
}