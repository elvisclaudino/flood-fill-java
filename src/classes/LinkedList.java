package classes;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class LinkedList<T> implements Iterable<T> {

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
 
    protected Node<T> getNode(int index) throws Exception {
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
        } else {
            var oldTop = this.top;
            oldTop.next = node;
            node.previous = oldTop;
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

    public void set(T element, int index) throws Exception {
        getNode(index).data = element;
    }

    public T remove() throws Exception {
        return remove(length - 1);
    }
    
    public T remove(int index) throws Exception {
        T element = null;

        if (!isEmpty()) {
            Node<T> node = getNode(index);
            length--;
            element = node.data;
            
            if (node.previous != null) {
                node.previous.next = node.next;
            } else {
                base = node.next;
            }

            if (node.next != null) {
                node.next.previous = node.previous;
            } else {
                top = node;
            }

            if (length == 0) {
                this.clear();
            }
        } else {
            throw new Exception("Trying to remove element from empty List.");
        }
        
        return element;
    }

    public void forEach(Consumer<? super T> fn) {
        var currentElement = this.base;

        while (currentElement != null) {
            System.out.println(currentElement.toString());
            fn.accept(currentElement.data);
            currentElement = currentElement.next != null ? currentElement.next : null;
        }
    }

    public void forEach(BiConsumer<? super T, Integer> fn) {
        var currentElement = this.base;
        int index = 0;

        while (currentElement != null) {
            fn.accept(currentElement.data, index);
            currentElement = currentElement.next != null ? currentElement.next : null;
            index++;
        }
    }

    public T find(Function<? super T, Boolean> predicate) {
        var currentElement = this.base;

        while (currentElement != null) {
            if (predicate.apply(currentElement.data)) {
                return currentElement.data;
            }
            currentElement = currentElement.next != null ? currentElement.next : null;
        }
        return null;
    }

    public LinkedList<T> filter(Function<? super T, Boolean> predicate) {
        LinkedList<T> filterList = new LinkedList<>();

        var currentElement = this.base;

        while (currentElement != null) {
            if (predicate.apply(currentElement.data)) {
                filterList.add(currentElement.data);
            }
            currentElement = currentElement.next != null ? currentElement.next : null;
        }
        
        return filterList;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

}

class ListIterator<T> implements Iterator<T> {
    private Node<T> current;
    
    ListIterator(LinkedList<T> obj) {
        try {
            current = obj.size() > 0 ? obj.getNode(0) : null;
        } catch (Exception e) {
        }
    }      

    public boolean hasNext() {
        return current.next != null;
    }
      
    public T next() {
        T data = current.data;
        current = current.next;
        return data;
    }
      
}