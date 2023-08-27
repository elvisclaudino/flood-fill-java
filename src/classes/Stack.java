package classes;

public class Stack<T> extends LinkedList<T> {
    
    private int top = -1;

    public T first() throws Exception {
        return !isEmpty() ? super.get(0) : null;
    }

    public T last() throws Exception {
        return !isEmpty() ? super.get(top) : null;
    }

    public void add(T element) {
        super.add(element);
        top++;
    }

    public T remove() throws Exception {
        T deletedElement = null;

        if (top == 0) {
            deletedElement = super.get(top);
            this.clear();
            return deletedElement;
        }

        if (!isEmpty()) {
            deletedElement = super.remove();
        }

        top--;
        return deletedElement;
    }

    public void clear() {
        super.clear();
        top = -1;
    }

}