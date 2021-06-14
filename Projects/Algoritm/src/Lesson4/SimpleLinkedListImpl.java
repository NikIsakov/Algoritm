package Lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        System.out.println(this);
        System.out.println("----------");
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> node) {
        return node != null ? node.item : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements LinkInterator<E> {
        private Node<E> current;
        private Node<E> previous;
        private SimpleLinkedListImpl<E> list;


        public LinkedIterator() {
            this.list = SimpleLinkedListImpl.this;
            reset();
        }

        public void reset(){
            current = list.firstElement;
            previous = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E nextValue = current.item;
            previous = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void deleteCurrent(){
            if (previous == null){
                list.firstElement=current.next;
                reset();
            } else {
                previous.next = current.next;
                if (!hasNext()){
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

    }
}
