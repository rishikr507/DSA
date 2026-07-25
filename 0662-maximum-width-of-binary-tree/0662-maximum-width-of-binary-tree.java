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
class Pair {
    int idx;
    TreeNode node;

    public Pair(TreeNode n, int i) {
        node = n;
        idx = i;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        int width = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int first = -1, last = -1;
            // int mini = q.peek().idx;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode temp = p.node;

                if (i == 0)
                    first = p.idx;
                if (i == size - 1)
                    last = p.idx;

                if (temp.left != null)
                    q.offer(new Pair(temp.left, 2 * p.idx - 1));
                if (temp.right != null)
                    q.offer(new Pair(temp.right, 2 * p.idx));
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }
}