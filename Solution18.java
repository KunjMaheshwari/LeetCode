class Solution18 {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double result = 1.0;
        long power = Math.abs((long) n);
        while(power > 0) {
            if(power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }
        if(n < 0) {
            result = 1.0 / result;
        }
        return result;
    }
}
