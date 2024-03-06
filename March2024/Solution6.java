class Solution6 {
    public int numSquares(int n) {
        // Initialize an array to store results
        int[] dp = new int[n + 1];
        // Initialize all values to maximum possible value
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Base case
        dp[0] = 0;

        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Loop through all perfect square numbers less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update the dp array with the minimum number of perfect squares required
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // Return the result
        return dp[n];
    }
}
