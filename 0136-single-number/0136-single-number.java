class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;
        // because in xor a^a gives 0.
    }
}