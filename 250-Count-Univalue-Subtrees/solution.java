/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        count(root, 0);
        return count;
    }
    private boolean count(TreeNode root, int val){
        if(root == null){
            return true;
        }
        boolean left = count(root.left, root.val);
        boolean right = count(root.right, root.val);
        if(left && right){
            count ++;
        }
        return val == root.val && left && right;
    }
}