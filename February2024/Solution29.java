import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution29 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Adding all single-digit numbers to the queue
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num > high) {
                break;
            }

            if (num >= low) {
                ans.add(num);
            }

            int lastDigit = num % 10;

            if (lastDigit < 9) {
                queue.offer(num * 10 + lastDigit + 1);
            }
        }

        return ans;
    }
}
