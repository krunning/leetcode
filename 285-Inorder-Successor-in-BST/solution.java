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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        TreeNode res = null;
        while(root != null){
            if(root.val > p.val){
                res = root;
                root = root.left;
            } else {
              root = root.right;  
            }
        }
        return res;
    }
}