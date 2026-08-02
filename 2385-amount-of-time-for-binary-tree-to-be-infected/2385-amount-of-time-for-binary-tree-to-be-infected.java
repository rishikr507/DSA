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
    private HashMap<TreeNode, TreeNode> MapParents(TreeNode root) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) {
                q.offer(temp.left);
                map.put(temp.left, temp);
            }
            if (temp.right != null) {
                q.offer(temp.right);
                map.put(temp.right, temp);
            }
        }

        return map;
    }

    private TreeNode findTarget(TreeNode root, int x) {
        if (root == null)
            return null;
        if (root.val == x)
            return root;
        TreeNode left = findTarget(root.left, x);
        TreeNode right = findTarget(root.right, x);
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

    public int amountOfTime(TreeNode root, int target) {
        if (root == null)
            return 0;
        HashMap<TreeNode, TreeNode> parents = MapParents(root);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        TreeNode tar = findTarget(root, target);
        visited.put(tar, true);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tar);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isBurn = false;
            for (int i = 1; i <= size; i++) {
                TreeNode t = q.poll();
                if (t.left != null && visited.get(t.left) == null) {
                    q.offer(t.left);
                    visited.put(t.left, true);
                    isBurn = true;
                }
                if (t.right != null && visited.get(t.right) == null) {
                    q.offer(t.right);
                    visited.put(t.right, true);
                    isBurn = true;
                }
                TreeNode p = parents.get(t);
                if (p != null && visited.get(p) == null) {
                    q.offer(p);
                    visited.put(p, true);
                    isBurn = true;
                }
            }
            if (isBurn)
                time++;
        }
        return time;
    }
}