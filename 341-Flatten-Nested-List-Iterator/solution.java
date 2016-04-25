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
public class NestedIterator implements Iterator<Integer> {
    NestedInteger cur = null;
    Stack<Iterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList != null){
            stack.push(nestedList.listIterator());
        }
    }

    @Override
    public Integer next() {
        cur.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            Iterator<NestedInteger> peek = stack.peek();
            if(peek.hasNext()){
                NestedInteger next = peek.next();
                if(next.isInteger()){
                    cur = next;
                    return true;
                }else{
                    stack.push(next.getList.listIterator());
                }
            }else{
                stack.pop();
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */