import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Collect elements into boxed collection for flexible querying
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Locate pair whose sum equals target
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (list.contains(complement)) {
                int complementIdx = list.lastIndexOf(complement);
                if (complementIdx != i) {
                    return new int[]{i, complementIdx};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
