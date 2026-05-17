class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int counter1 = 0, counter2 = 0, element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(counter1 == 0 && nums[i] != element2){
                counter1++;
                element1 = nums[i];
            }else if (counter2 == 0 && nums[i] != element1){
                counter2++;
                element2 = nums[i];
            }else if(nums[i] == element1){
                counter1++;
            }else if (nums[i] == element2){
                counter2++;
            }else{
                counter1--;
                counter2--;
            }
        }

        counter1 = 0;
        counter2 = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == element1){
                counter1++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] == element2){
                counter2++;
            }
        }

        if(counter1 > nums.length/3){
            result.add(element1);
        }
        if(counter2 > nums.length/3 && element1 != element2){
            result.add(element2);
        }
        return result;
    }
}