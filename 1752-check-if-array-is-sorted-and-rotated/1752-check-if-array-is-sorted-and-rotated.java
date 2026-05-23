class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peakPoint = 0;

        for(int i=0;i<n;i++){
            if(nums[i] > nums[(i+1)%n]){
                peakPoint++;
            }
        }
        return peakPoint <= 1;
    }
}