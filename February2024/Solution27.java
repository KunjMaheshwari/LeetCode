class Solution27 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n]; // using an array instead of Deque
        int top = -1;

        for (int i = 0; i < n; ++i) {
            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
                int index = stack[top--];
                ans[index] = i - index;
            }
            stack[++top] = i;
        }

        return ans;
    }
}
