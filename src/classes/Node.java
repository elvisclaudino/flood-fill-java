package classes;

public class Node<T> {

    Node<T> previous;
    Node<T> next;
    T data;

    public Node(T value) {
        data = value;
    }

    @Override
    public String toString() {
        return "Node [ previous = " + (previous != null ? previous.data : null) + ", data = " + data  + ", next = " + (next != null ? next.data : null) + " ]";
    }
    
}
