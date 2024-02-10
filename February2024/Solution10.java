class Solution10 {
 public int climbStairs(int N) {
        if (N == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= N; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
