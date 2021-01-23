import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    Deque<Integer> deque;
    int size;
    public MyCircularDeque(int k) {
        deque = new LinkedList<>();
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        boolean r = isFull();
        return !r && deque.offerFirst(value);
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        boolean r = isFull();
        return !r && deque.offerLast(value);
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        boolean r = true;
        if (deque.pollFirst() == null){
            r = false;
        }
        return r;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        boolean r = true;
        if (deque.pollLast() == null){
            r = false;
        }
        return r;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (deque.isEmpty())
            return -1;
        return deque.peekFirst();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (deque.isEmpty())
            return -1;
        return deque.peekLast();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (deque.size() == size)
            return true;
        return false;
    }
}
