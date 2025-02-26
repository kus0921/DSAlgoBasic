package DatastructureBasedQuestions;

import java.util.LinkedList;

/*Implement a double-ended queue (abbreviated to deque) that stores strings.
                A deque is a data structure that has characteristics of both a queue and a stack.
                Elements  can be added or removed from either the front or back.
                Signature:
             Create Class Deque */

public class DequeImplementation {
    private LinkedList<String> deque;

    public DequeImplementation() {
        this.deque = new LinkedList<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void addFront(String element) {
        deque.addFirst(element);

    }

    public void addRear(String element) {
        deque.addLast(element);

    }

    public String removeFirst() {
        if (deque.isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return deque.removeFirst();
    }

    public String removeLast() {
        if (deque.isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return deque.removeLast();
    }

    public String peekFirst() {
        if (deque.isEmpty()) {
            return "";
        }
        return deque.getFirst();
    }

    public String peekLast() {
        if (deque.isEmpty()) {
            return "";
        }
        return deque.getLast();
    }

    public int getSize() {
        return deque.size();

    }


    @Override
    public String toString() {
        return "Deque: " + deque.toString();
    }

    public static void main(String[] args) {

    }
}


