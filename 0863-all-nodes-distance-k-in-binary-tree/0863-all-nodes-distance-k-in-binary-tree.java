/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void mapParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, null);
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
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        mapParents(root, map);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        int dist = 0;

        while (!q.isEmpty()) {
            if (dist == k)
                break;
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = q.poll();
                visited.put(temp, true);
                if (temp.left != null && visited.get(temp.left) == null) {
                    q.offer(temp.left);
                }
                if (temp.right != null && visited.get(temp.right) == null) {
                    q.offer(temp.right);
                }
                if (map.get(temp) != null && visited.get(map.get(temp)) == null) {
                    q.offer(map.get(temp));
                }
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}