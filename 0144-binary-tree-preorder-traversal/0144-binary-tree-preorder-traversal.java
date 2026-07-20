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
    private void preorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }

        al.add(root.val);
        preorder(root.left, al);
        preorder(root.right, al);
    }

    private void iterativePreorder(TreeNode root, ArrayList<Integer> al) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return ;
        }
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            al.add(temp.val);
            if (temp.right != null)
                st.push(temp.right);
            if (temp.left != null)
                st.push(temp.left);
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        // preorder(root, al);
        iterativePreorder(root, al);
        return al;
    }
}