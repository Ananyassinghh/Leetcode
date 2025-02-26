class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = 0;
        int minEndingHere = 0; 
        int maxAbsoluteSum = 0; 
        for (int num : nums) {
            maxEndingHere = Math.max(maxEndingHere + num, 0);
            minEndingHere = Math.min(minEndingHere + num, 0);
            maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.max(maxEndingHere, Math.abs(minEndingHere)));
        }
        return maxAbsoluteSum;
    }
}