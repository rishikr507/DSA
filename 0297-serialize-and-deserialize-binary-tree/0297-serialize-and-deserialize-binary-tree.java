/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null)
                str.append("null,");
            else {
                str.append(curr.val + ",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String values[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode curr = q.poll();
            if (!values[i].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(values[i]));
                curr.left = temp;
                q.offer(temp);
            }
            i++;
            if (!values[i].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(values[i]));
                curr.right = temp;
                q.offer(temp);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));