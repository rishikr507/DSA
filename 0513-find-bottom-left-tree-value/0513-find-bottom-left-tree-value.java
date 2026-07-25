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
    int data, level;

    public Pair(int d, int l) {
        data = d;
        level = l;
    }
}

class Solution {
    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null) return true;
        return false;
    }
    private void findBLV(TreeNode root,int level,ArrayList<Pair> p){
        if(isLeaf(root)){
            if(level > p.get(0).level){
                p.get(0).level = level;
                p.get(0).data = root.val;
            }
            return;
        }
        if(root.left != null) findBLV(root.left,level +1,p);
        if(root.right != null) findBLV(root.right,level +1,p);
    }

    public int findBottomLeftValue(TreeNode root) {
        ArrayList<Pair> p = new ArrayList<>();
        p.add(new Pair(root.val,0));
        findBLV(root,0,p);
        
        return p.get(0).data;
    }
}