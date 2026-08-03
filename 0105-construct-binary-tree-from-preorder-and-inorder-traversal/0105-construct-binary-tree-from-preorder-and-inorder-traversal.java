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
    private TreeNode buildTree(int inorder[], int inS, int inE,
            int preorder[], int preS, int preE, HashMap<Integer, Integer> map) {
        if (inS > inE || preS > preE)
            return null;

        TreeNode root = new TreeNode(preorder[preS]);
        int idx = map.get(root.val);
        int cnt = idx - inS;

        root.left = buildTree(inorder, inS, idx - 1, preorder, preS + 1, preS + cnt, map);
        root.right = buildTree(inorder, idx + 1, inE, preorder, preS + cnt + 1, preE, map);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preN = preorder.length, inN = inorder.length;
        if (preN == 0 || inN == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inN; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, inN - 1, preorder, 0, preN - 1, map);
        return root;
    }
}