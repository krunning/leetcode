public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <= 2){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 2; i ++){
            int cur = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(cur + nums[start] + nums[end] >= target){
                    end --;
                }else{
                    res += end - start;
                    start ++;
                }
            }
        }
        return res;
    }
}