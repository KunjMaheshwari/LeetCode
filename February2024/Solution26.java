import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.BinaryOperator;

class Solution26 {
    public int evalRPN(String[] tokens) {
        final Map<String, BinaryOperator<Long>> op = Map.of(
            "+", (a, b) -> a + b, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
        
        Deque<Long> stack = new ArrayDeque<>();

        for (final String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    final long b = stack.pop();
                    final long a = stack.pop();
                    stack.push(op.get(token).apply(a, b));
                    break;
                default:
                    stack.push(Long.parseLong(token));
            }
        }

        return stack.pop().intValue();
    }
}
