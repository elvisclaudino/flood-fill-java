package interfaces;

public interface IStack<T> extends IStructureCollection<T> {
    /**
     * @param element Element to add at Queue.
     */
    void add(T element);
    /**
     * @return Element removed from Stack
     */
    T remove();
}
