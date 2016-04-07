public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < next){
                continue;
            }
            if(nums[i] == next){
                next ++;
                continue;
            }
            res.add(form(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        if(next <= upper){
            res.add(form(next, upper));
        }
        return res;
    }
    private String form(int a, int b){
        return a == b ? String.valueOf(a) : String.valueOf(a) + "->" + String.valueOf(b);
    }
}