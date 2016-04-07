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
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, Long.MAX_VALUE, 0);
    }
    private int helper(TreeNode node, double target, double diff, int res){
        if(node == null){
            return res;
        }
        int val = node.val;
        if(Math.abs(val - target) < diff){
            res = val;
            diff = Math.abs(val - target);
        }
        if(val < target){
            res = helper(node.right, target, diff, res);
        }else{
            res = helper(node.left, target, diff, res);
        }
        return res;
    }
}