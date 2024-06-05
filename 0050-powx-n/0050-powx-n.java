class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double ans = 1;
        long absN = Math.abs((long)n); // Use long to handle the edge case of Integer.MIN_VALUE
        
        while (absN > 0) {
            // check the LSB
            if ((absN & 1) != 0) {
                ans = ans * x;
            }
            x = x * x;
            absN = absN >> 1;
        }
        
        return n < 0 ? 1 / ans : ans;
    }
}
