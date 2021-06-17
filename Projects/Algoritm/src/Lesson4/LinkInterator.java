package Lesson4;

import java.util.Iterator;

public interface LinkInterator<E> extends Iterator<E> {
    void deleteCurrent();
}
