import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> input = new ArrayDeque<>();
    private Deque<Integer> output = new ArrayDeque<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            transferElements();
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            transferElements();
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void transferElements() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }
}
