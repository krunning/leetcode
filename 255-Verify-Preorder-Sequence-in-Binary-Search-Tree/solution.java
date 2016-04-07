public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for(int cur : preorder){
            if(cur < low){
                return false;
            }
            while(!stack.isEmpty() && stack.peek() < cur){
                low = stack.pop();
            }
            stack.push(cur);
        }
        return true;
    }
}

/*
10, 7, 6, 9, 8, 10, 15,13, 18
How to build BSF from preOrder Sequnece
public TreeNode build(int[] preorder){
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode root = null;
    TreeNode p = root;
    for(int cur : preorder){
        if(root == null){
            root = new TreeNode(cur);
            continue;
        }
        TreeNode node = new TreeNode(cur);
        if(!stack.isEmpty() && stack.peek().val > cur){
            stack.peek().left = node;
        }else{
            while(!stack.isEmpty() && stack.peek.val < cur){
                p = stack.pop();
            }
            p.right = node;
        }
        stack.push(node);
    }
    return root;
}
*/