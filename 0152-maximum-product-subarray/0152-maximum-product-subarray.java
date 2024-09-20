class Solution {
    public int maxProduct(int[] nums) {
        // Initialize the result with the first element
        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0]; // Track the minimum product

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current number is negative, swap the current max and min
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Update the current max and min
            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            // Update the global maximum product
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
