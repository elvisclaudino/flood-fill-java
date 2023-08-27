package classes;

public class List<T> extends LinkedList<T> {
    public void add(T element, int index) throws Exception {
        validIndex(index);

        Node<T> toInsertNode = new Node<T>(element);

        Node<T> toMoveNode = getNode(index);
        Node<T> previousNode = toMoveNode.previous;

        previousNode.next = toInsertNode;
        toInsertNode.previous = previousNode;

        toInsertNode.next = toMoveNode;
        toMoveNode.previous = toInsertNode;

        length++;
    }

    public void set(T element, int index) throws Exception {
        getNode(index).data = element;
    }

    public T remove(int index) throws Exception {
        return super.remove(index);
    }
}
