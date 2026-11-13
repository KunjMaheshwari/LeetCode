import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        // Allocate local tracking buffer for recursive subproblem analysis
        int[] localCache = new int[n + 1];
        Arrays.fill(localCache, -1);

        // Branching recursion to calculate total distinct paths
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
