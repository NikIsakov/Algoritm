package Lesson3.dack;

import Lesson3.queue.Queue;

public interface DackQueue<E> extends Queue<E> {

    boolean insertLeft(E value);

    E removeRight();

    boolean insertRight(E value);

    E removeLeft();
}