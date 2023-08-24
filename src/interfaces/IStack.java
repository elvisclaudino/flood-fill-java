package interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface IStack<T> extends IStructureCollection<T> {
    /**
     * @param element Element to add at queue.
     */
    void add(T element);
    /**
     * @return Element removed from Stack
     */
    T remove();
}
