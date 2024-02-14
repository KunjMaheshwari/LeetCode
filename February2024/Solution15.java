class Solution15 {
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0, missing = 0;

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0)
                duplicate = Math.abs(num);
            else
                nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
