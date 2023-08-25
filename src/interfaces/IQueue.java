package interfaces;

public interface IQueue<T> extends IStructureCollection<T> {
    /**
     * @param element An element to insert in Queue.
     */
    void enqueue(T element);
    /**
     * @return Element The element removed from Queue.
     */
    T dequeue();

}
