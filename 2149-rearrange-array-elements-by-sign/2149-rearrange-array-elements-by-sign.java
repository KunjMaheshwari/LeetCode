class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positiveNum = new ArrayList<>();
        ArrayList<Integer> negativeNum = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                positiveNum.add(nums[i]);
            }else{
                negativeNum.add(nums[i]);
            }
        }

        int positiveIdx = 0;
        int negativeIdx = 0;

        while(positiveIdx < positiveNum.size() && negativeIdx < negativeNum.size()){
            result.add(positiveNum.get(positiveIdx));
            result.add(negativeNum.get(negativeIdx));

            positiveIdx++;
            negativeIdx++;
        }

        while(positiveIdx < positiveNum.size()){
            result.add(positiveNum.get(positiveIdx));
            positiveIdx++;
        }

        while(negativeIdx < negativeNum.size()){
            result.add(negativeNum.get(negativeIdx));
            negativeIdx++;
        }

        int combinedResult[] = new int[result.size()];
        for(int i=0;i<combinedResult.length;i++){
            combinedResult[i] = result.get(i);
        }

        return combinedResult;
    }
}