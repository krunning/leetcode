public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 1 && (nums[i - 1] > nums[i]) || i % 2 == 0 && (nums[i - 1] < nums[i])){
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}