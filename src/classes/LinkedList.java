package classes;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LinkedList<T> {

    private int length = 0;
    private Node<T> top = null;
    private Node<T> base = null;
    private Exception indexOutBoundsException = new Exception("Index out of bounds");
    
    private boolean isEmpty() {
        return length == 0;
    }

    private void clear() {
        this.base = null;
        this.top = null;
        this.length = 0;
    }

    private Node<T> getFromTop(int index) {
        int _i = length - 1;
        Node<T> curr = top;

        while (curr != null) {
            if (index == _i) {
                return curr;
            }
            curr = curr.previous != null ? curr.previous : null;
            _i--;
        }
        return null;
    }

    private Node<T> getFromBase(int index) {
        int _i = 0;
        Node<T> curr = base;

        while (curr != null) {
            if (index == _i) {
                return curr;
            }
            curr = curr.next != null ? curr.next : null;
            _i++;
        }
        return null;
    }
 
    private Node<T> getNode(int index) throws Exception {
        boolean direction = index > length / 2;
        return direction ? getFromTop(index) : getFromBase(index);
    }

    private boolean validIndex(int index) throws Exception {
        if (index > 0 && index > length - 1 || index < 0) {
            throw indexOutBoundsException;
        }
        return true;
    }

    public int size() {
        return this.length;
    }
    
    public T get(int index) throws Exception {
        validIndex(index);
        return getNode(index).data;
    }

    public void add(T element) {
        Node<T> node = new Node<T>(element);

        if (this.isEmpty()) {
            this.base = node;
            this.top = node;
        } else {
            var oldTop = this.top;
            oldTop.next = node;
            node.previous = oldTop;
            this.top = node;
        }

        this.top = node;
        this.length++;
    }
    
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

    public T remove() throws Exception {
        T element = null;

        if (!isEmpty()) {
            length--;
            element = top.data;
            
            this.top = top.equals(base) ? base : top.previous;
            this.top.next = null;

            if (length == 0) {
                this.clear();
            }
            
        } else {
            throw new Exception("Trying to remove element from empty List.");
        }
        
        return element;
    }
    
    public void forEach(Consumer<T> fn) {
        var currentElement = this.base;

        while (currentElement != null) {
            System.out.println(currentElement.toString());
            fn.accept(currentElement.data);
            currentElement = currentElement.next != null ? currentElement.next : null;
        }
    }

    public void forEach(BiConsumer<T, Integer> fn) {
        var currentElement = this.base;
        int index = 0;

        while (currentElement != null) {
            fn.accept(currentElement.data, index);
            currentElement = currentElement.next != null ? currentElement.next : null;
            index++;
        }
    }

}