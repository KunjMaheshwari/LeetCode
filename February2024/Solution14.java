class Solution14 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int prevMax = 0;  // Represents dp[i-2]
        int currentMax = 0;  // Represents dp[i-1]

        for (int num : nums) {
            int temp = currentMax;
            currentMax = Math.max(prevMax + num, currentMax);
            prevMax = temp;
        }

        return currentMax;
    }
}
