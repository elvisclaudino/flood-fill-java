package interfaces;

import java.util.function.BiConsumer;

public interface ILinkedList<T> {
    /**
     * @param element Element to add at Queue.
     */
    void add(T element);
    /**
     * @return Element removed from Stack
     */
    T remove() throws Exception;
    /**
     * @return Current amount of elements present at an <b>List</b>.
     */
    int size();
    /**
     * @implNote Clear all elements at an <b>List</b>.
     */
    void clear();

    /**
     * @param fn (x, i) Callback to invoke for each element in queue, where <b> x </b> is current element and <b> i </b> current index of element.
     */
    void forEach(BiConsumer<T, Integer> fn);
}
