public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(n, res, new ArrayList<Integer>(), 2);
        return res;
    }
    private void helper(int n, List<List<Integer>>res, List<Integer> list, int start){
        if(n <= 1){
            if(list.size() > 1){
                res.add(new ArrayList<Integer>(list));
                return;
            }
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                list.add(i);
                helper(n / i, res, list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}