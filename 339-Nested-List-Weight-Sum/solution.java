/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        int level = 1;
        int res = 0;
        Queue<List<NestedInteger>> queue = new LinkedList<List<NestedInteger>>();
        for(NestedInteger n : nestedList){
            if(!n.isInteger()){
                queue.offer(n.getList());
            } else {
                res += level * n.getInteger();
            }
        }
        while(!queue.isEmpty()){
            level ++;
            int size = 0;
            for(int i = 0; i < size; i ++){
                NestedInteger cur = queue.poll();
                for(NestedInteger n : cur.getList()){
                    if(!n.isInteger()){
                        queue.offer(n.getList());
                    } else {
                        res += level * n.getInteger();
                    }
                }
            }
        }
        return res;
    }
}