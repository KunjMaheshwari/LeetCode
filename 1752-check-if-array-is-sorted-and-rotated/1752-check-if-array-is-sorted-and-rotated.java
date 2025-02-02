class Solution {
    public boolean check(int[] nums) {
        int ans = 0;
        if(nums[0] < nums[nums.length-1]){
            ans++;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                ans++;
            }
            if(ans >1){
                return false;
            }
        }
        return true;
    }
}