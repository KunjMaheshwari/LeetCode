class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> evenNum = new ArrayList<>();
        ArrayList<Integer> oddNum = new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                evenNum.add(nums[i]);
            }else{
                oddNum.add(nums[i]);
            }
        }

        for(int i=0;i<evenNum.size();i++){
            result.add(evenNum.get(i));
            result.add(oddNum.get(i));
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}