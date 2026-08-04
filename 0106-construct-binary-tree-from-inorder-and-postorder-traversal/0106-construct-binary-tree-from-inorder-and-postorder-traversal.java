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
    private TreeNode buildTree(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE,
            HashMap<Integer, Integer> map) {
        if (inS > inE || postS > postE)
            return null;

        TreeNode root = new TreeNode(postorder[postE]);
        int idx = map.get(root.val);
        int cnt = idx - inS;

        root.left = buildTree(inorder, inS, inS + cnt - 1, postorder, postS, postS + cnt - 1, map);
        root.right = buildTree(inorder, inS + cnt + 1, inE, postorder, postS + cnt, postE - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inN = inorder.length, postN = postorder.length;
        if (inN == 0 || postN == 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inN; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inN - 1, postorder, 0, postN - 1, map);

        return root;
    }
}