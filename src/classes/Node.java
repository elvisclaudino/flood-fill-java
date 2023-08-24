package classes;

public class Node<T> {

    Node<T> previous;
    Node<T> next;
    T data;

    public Node(T value) {
        data = value;
    }
}
