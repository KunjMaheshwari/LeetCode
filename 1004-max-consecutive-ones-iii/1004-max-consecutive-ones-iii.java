class Solution {
    public int longestOnes(int[] nums, int k) {
        // 2 pointer striver approach
        int left = 0;
        int right = 0;
        int zeroes = 0;
        int maxLen = 0;
        int n = nums.length;

        while(right < n){
            if(nums[right] == 0){
                zeroes++;
            }
            if(zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            if(zeroes <= k){
                int len = right-left+1;
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        return maxLen;
    }
}