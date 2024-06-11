class Solution {
    public boolean isPowerOfFour(int n) {
        return n!= 0 && n%4 == 0 && isPowerOfFour(n/4) || n ==1;
    }

}