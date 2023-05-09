package il.co.lird.FS133.Projects.Zemingo;

import sun.awt.Mutex;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;

public class QuickPushDataStructure <T> implements IQuickDataStructure<T>{
    private final Semaphore semaphore = new Semaphore(0);
    private final Mutex lock = new Mutex();
    private Node head = null;
    private final Comparator<T> comparator;

    public QuickPushDataStructure(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private class Node {
        private final T data;
        private Node next;
        private Node prev;
        private Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    @Override
    public void push(T data) {
        lock.lock();
        Node frontNode = new Node(data);
        frontNode.next = head;
        head = frontNode;
        lock.unlock();
        semaphore.release();
    }

    @Override
    public T pop(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.lock();
        if (head == null) {
            throw new NoSuchElementException();
        }

        T max = head.data;
        Node maxNode = head;
        Node prev = null;
        Node curr = head;

        while (curr.next != null) {
            if (comparator.compare(curr.next.data, max) < 0) {
                max = curr.next.data;
                maxNode = curr.next;
                prev = curr;
            }
            curr = curr.next;
        }

        if(prev != null){
            prev.next = maxNode.next;
            maxNode.next = null;
        }

        lock.unlock();
        return max;
    }
}
