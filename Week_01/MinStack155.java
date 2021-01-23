import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class MinStack155 {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> MinStack;
    public MinStack155() {
        stack = new Stack<>();
        MinStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (MinStack.isEmpty())
            MinStack.push(x);
        else{
            if (x <= MinStack.peek()){
                MinStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.peek().equals(MinStack.peek())){
            this.MinStack.pop();
        }
        this.stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MinStack.peek();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(7);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
    }
}