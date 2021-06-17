package Lesson3.dack;

import Lesson3.queue.Queue;
import Lesson3.queue.QueueImpl;
import Lesson3.stack.Stack;

public class DackQueueImpl<E> extends QueueImpl<E> implements DackQueue<E> {

    private static final int HEAD_DEFAULT = 0;
    private static final int TAIL_DEFAULT = -1;

    private final E[] data;
    private int size;

    private int tail;
    private int head;

    public DackQueueImpl(int maxSize) {
        super(maxSize);
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insertLeft(E value) {

        if (isFull()) {
            return false;
        }

        if (head == HEAD_DEFAULT) {
            head = data.length;

        }

        data[--head]=value;
        size++;

        return true;
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (tail == TAIL_DEFAULT) {
            tail = data.length - 1;
        }

        E value = data[tail--];
        size--;

        return value;
    }

    @Override
    public E peekFront() {
        return super.peekFront();
    }

    @Override
    public int size() {
        //return super.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        //return super.isEmpty();
        return size == 0;
    }

    @Override
    public boolean isFull() {
        //return super.isFull();
        return size == data.length;
    }

    public void display() {
        System.out.println(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
