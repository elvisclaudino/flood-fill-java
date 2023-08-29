package classes;

import interfaces.ILinkedList;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class LinkedList<T> implements Iterable<T>, ILinkedList<T> {

    protected int length = 0;
    private Node<T> top = null;
    private Node<T> base = null;
    private Exception indexOutBoundsException = new Exception("Index out of bounds");
    
    protected boolean isEmpty() {
        return length == 0;
    }

    protected Node<T> getFromTop(int index) {
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

    protected Node<T> getFromBase(int index) {
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
 
    protected synchronized Node<T> getNode(int index) throws Exception {
        boolean direction = index > length / 2;
        return direction ? getFromTop(index) : getFromBase(index);
    }

    protected void validIndex(int index) throws Exception {
        if (index > 0 && index > length - 1 || index < 0) {
            throw indexOutBoundsException;
        }
    }

    protected T remove(int index) throws Exception {
        T element = null;

        if (!isEmpty()) {
            Node<T> node = getNode(index);
            element = node.data;
            length--;

            if (node.previous != null) {
                node.previous.next = node.next;
            } else {
                base = node.next;
            }

            if (node.next != null) {
                node.next.previous = node.previous;
            } else {
                top = node.previous;
            }

            if (length == 0) {
                this.clear();
            }
        } else {
            throw new Exception("Trying to remove element from empty List.");
        }

        return element;
    }

    private Node<T> middleNode(Node<T> start, Node<T> last)
    {
        if (start == null)
            return null;
 
        Node<T> slow = start;
        Node<T> fast = start.next;
 
        while (fast != last)
        {
            fast = fast.next;
            if (fast != last)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    public Node<T> binarySearch(T value)
    {
        Node<T> start = base;
        Node<T> last = null;
 
        do
        {
           
            Node<T> mid = middleNode(start, last);
 
           
            if (mid == null)
                return null;
 
            if (mid.data == value)
                return mid;
 
            else if (mid.data != value)
            {
                start = mid.next;
            }
            else
                last = mid;
        } while (last == null || last != start);
 
        return null;
    }

    public void clear() {
        this.base = null;
        this.top = null;
        this.length = 0;
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

    public T remove() throws Exception {
        
        return remove(length - 1);
    }

    public void addIfNotPresent(T element) {
        if (find(x -> x.equals(element)) == null) {
            add(element);
        }
    }


    public void forEach(Consumer<? super T> fn) {
        var currentElement = this.base;

        while (currentElement != null) {
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
        LinkedList<T> filterList = new List<>();

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
            current = !obj.isEmpty() ? obj.getNode(0) : null;
        } catch (Exception ignored) {
        }
    }      

    public boolean hasNext() {
        return current != null && current.next != null;
    }
      
    public T next() {
        T data = current.data;
        current = current.next;
        return data;
    }
      
}