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
    private void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }

        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // ArrayList<Integer> al = new ArrayList<>();
        // inorder(root, al);
        // return al;
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                al.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    al.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return al;
    }
}