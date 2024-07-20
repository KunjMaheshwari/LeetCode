class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int kMod = 1_000_000_007;
        final int n = arr.length;
        long ans = 0;

        int[] prevMin = new int[n];
        int[] nextMin = new int[n];
        Arrays.fill(prevMin, -1);
        Arrays.fill(nextMin, n);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                nextMin[index] = i;
            }
            prevMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; ++i) {
            ans = (ans + (long) arr[i] * (i - prevMin[i]) * (nextMin[i] - i) % kMod) % kMod;
        }

        return (int) ans;
    }
}