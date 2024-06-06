class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        // here 2 ^ n is 1<<n

        for(int i=0;i<(1<<n);i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0;j<n;j++){
                // checking the ith bit is set or not
                if((i & (1 <<j))>0){
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}