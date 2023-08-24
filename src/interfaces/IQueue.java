package interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface IQueue<T> extends IStructureCollection<T> {
    /**
     * @param element An element to insert in queue.
     */
    void enqueue(T element);
    /**
     * @return Element The element removed from queue.
     */
    T dequeue();

}
