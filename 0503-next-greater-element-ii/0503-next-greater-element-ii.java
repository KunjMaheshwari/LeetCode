import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[n];

        for (int i = 0; i < n; i++) {
            nextGreater[i] = -1;
        }

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[i % n] >= nums[s.peek()]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                nextGreater[i % n] = nums[s.peek()];
            }
            s.push(i % n);
        }
        return nextGreater;
    }
}
