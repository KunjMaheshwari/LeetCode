class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;

        // Corrected the loop condition to iterate through the array
        for(int i = 0; i < nums.length; i++) {
            // If the current index is beyond the maximum reachable index, return false
            if(i > maxIndex) {
                return false;
            }
            // Update the maximum reachable index
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true; //
    }
}
