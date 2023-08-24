package interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface IStructureCollection<T> {
    /**
     * @return True when <b>StructureCollection</b> is full. False otherwise.
     */
    boolean isFull();
    /**
     * @return True when <b>StructureCollection</b> is empty. False otherwise.
     */
    boolean isEmpty();
    /**
     * @return Current amount of elements present at an <b>StructureCollection</b>.
     */
    int size();
    /**
     * @return First element at an <b>StructureCollection</b>.
     */
    T first();
    /**
     * @return Last element at an <b>StructureCollection</b>.
     */
    T last();
    /**
     * @implNote Clear all elements at an <b>StructureCollection</b>.
     */
    void clear();
    /**
     * @param fn (x) Callback to invoke for each element in queue, where <b> x </b> is current element.
     */
    void forEach(Consumer<T> fn);
    /**
     * @param fn (x, i) Callback to invoke for each element in queue, where <b> x </b> is current element and <b> i </b> current index of element.
     */
    void forEach(BiConsumer<T, Integer> fn);
}
