class Solution16 {
    public boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        if(n<1){
            return false; // negative condition
        }
        if(n%2!=0){
            return false; // odd condition
        }
        return isPowerOfTwo(n/2);
    }
}
