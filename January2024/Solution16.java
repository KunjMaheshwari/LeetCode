class Solution16 {
    public int maxSum(int[] nums) {
        int maxPairSum = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (hasEqualMaxDigit(nums[i], nums[j])) {
                    int currSum = nums[i] + nums[j];
                    maxPairSum = Math.max(maxPairSum, currSum);
                }
            }
        }

        return maxPairSum;
    }

    private boolean hasEqualMaxDigit(int num1, int num2) {
        int maxDigitNum1 = getMaxDigit(num1);
        int maxDigitNum2 = getMaxDigit(num2);

        return maxDigitNum1 == maxDigitNum2;
    }

    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }
}
