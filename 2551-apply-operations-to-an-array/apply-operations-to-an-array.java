class Solution {

    // Method to apply operations on an array of integers
    public int[] applyOperations(int[] nums) {
        int length = nums.length; // Get the length of the array

        // Loop through each element, except the last one
        for (int i = 0; i < length - 1; ++i) {
            // Check if the current element is equal to the next element
            if (nums[i] == nums[i + 1]) {
                // If so, double the current element
                nums[i] <<= 1; // Same as nums[i] = nums[i] * 2
                // And set the next element to zero
                nums[i + 1] = 0;
            }
        }

        int[] result = new int[length]; // Create a new array to store the results
        int index = 0; // Initialize result array index

        // Iterate through the original array
        for (int num : nums) {
            // Copy non-zero elements to the result array
            if (num > 0) {
                result[index++] = num; // Assign and then increment the index
            }
        }

        return result; // Return the resulting array
    }
}