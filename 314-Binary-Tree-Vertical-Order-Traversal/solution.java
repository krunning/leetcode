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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                Pair cur = queue.poll();
                min = Math.min(min, cur.col);
                max = Math.max(max, cur.col);
                if(!map.containsKey(cur.col)){
                    map.put(cur.col, new ArrayList<Integer>());
                }
                map.get(cur.col).add(cur.node.val);
                if(cur.node.left != null){
                    queue.offer(new Pair(cur.node.left, cur.col - 1));
                }
                if(cur.node.right != null){
                    queue.offer(new Pair(cur.node.right, cur.col + 1));
                }
            }
        }
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
    class Pair{
        TreeNode node;
        int col;
        public Pair(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
}