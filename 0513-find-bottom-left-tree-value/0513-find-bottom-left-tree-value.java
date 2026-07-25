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
    int maxLevel = -1;
    int value = -1;
    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null) return true;
        return false;
    }
    private void findBLV(TreeNode root,int level){
        if(isLeaf(root)){
            if(level > maxLevel){
                maxLevel = level;
                value = root.val;
            }
            return;
        }
        if(root.left != null) findBLV(root.left,level +1);
        if(root.right != null) findBLV(root.right,level +1);
    }

    public int findBottomLeftValue(TreeNode root) {
        ArrayList<Pair> p = new ArrayList<>();
        maxLevel = 0;
        value = root.val;
        findBLV(root,0);
        
        return value;
    }
}