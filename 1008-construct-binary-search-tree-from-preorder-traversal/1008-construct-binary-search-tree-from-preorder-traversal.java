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
    private TreeNode constBST(int[] inorder, int is, int ie, int[] preorder, int ps, int pe,
            HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = map.get(root.val);
        int cnt = idx - is;
        root.left = constBST(inorder, is, idx - 1, preorder, ps + 1, ps + cnt, map);
        root.right = constBST(inorder, idx + 1, ie, preorder, ps + cnt + 1, pe, map);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0)
            return null;

        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = constBST(inorder, 0, n - 1, preorder, 0, n - 1, map);
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