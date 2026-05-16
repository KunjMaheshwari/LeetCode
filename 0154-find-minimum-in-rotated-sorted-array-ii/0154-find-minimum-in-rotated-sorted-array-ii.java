class Solution {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int resultantIdx = 0;

        while (left <= right) {

            if (nums[left] < nums[right]) {
                if (nums[left] < nums[resultantIdx]) {
                    resultantIdx = left;
                }
                break;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[resultantIdx]) {
                resultantIdx = mid;
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[right]) {
                right = mid - 1;
            }
            else {
                right--;
            }
        }

        return nums[resultantIdx];
    }
}