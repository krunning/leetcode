public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int mid = (nums.length + 1) >> 1;
        int end = nums.length;
        for(int i = 0; i < nums.length; i++){
            tmp[i] = (i & 1) == 0 ? nums[--mid] : nums[--end];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = tmp[i];
        }
    }
}