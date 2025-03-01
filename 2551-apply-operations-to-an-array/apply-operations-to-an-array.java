class Solution {
    public int[] applyOperations(int[] nums) {
        int length = nums.length; 
        for (int i = 0; i < length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1; 
                nums[i + 1] = 0;
            }
        }
        int[] result = new int[length]; 
        int index = 0;
        for (int num : nums) {
            if (num > 0) {
                result[index++] = num;
            }
        }
        return result; 
    }
}