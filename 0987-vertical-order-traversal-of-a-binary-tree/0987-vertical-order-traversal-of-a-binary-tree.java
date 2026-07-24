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
class Tuple {
    TreeNode node;
    int x, y;

    public Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    class Tuple {
        TreeNode node;
        int x, y;

        public Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();

        // TreeMap<x, TreeMap< y, list>>
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            var t = q.poll();
            TreeNode node = t.node;
            int x = t.x, y = t.y;

            // Does the axis is present in the TreeMap
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            // Inside the axis x is present the level y
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            // In the axis x and level y put data in the ArrayList or Heap for (sorted order)
            map.get(x).get(y).add(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, x + 1, y + 1));
        }
        List<List<Integer>> res = new ArrayList<>();

        for (var yh : map.values()) {
            ArrayList<Integer> al = new ArrayList<>();
            for (var heap : yh.values()) {
                while(!heap.isEmpty())
                    al.add(heap.poll());
            }
            res.add(al);
        }
        return res;
    }
}