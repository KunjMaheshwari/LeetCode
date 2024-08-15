class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positiveArr = new ArrayList<>();
        ArrayList<Integer> negativeArr = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                positiveArr.add(nums[i]);
            }else{
                negativeArr.add(nums[i]);
            }
        }

        int result[] = new int[nums.length];
        int idx = 0;

        for(int i=0;i<positiveArr.size();i++){
            result[idx++] = positiveArr.get(i);
            result[idx++] = negativeArr.get(i);
        }
        return result;
    }
}