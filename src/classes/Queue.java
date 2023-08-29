package classes;

public class Queue<T> extends LinkedList<T> {

    private final int base = 0;
    private int top = -1;

    //#region members 'API'

    public T first() throws Exception {
        return super.get(base);
    }

    public T last() throws Exception {
        return !isEmpty() ? super.get(top) : null;
    }

    public void add(T element) {
        super.add(element);
        top++;
    }

    public T remove() throws Exception {
        T element = null;

        if (top == base) {
            element = super.get(top);
            this.clear();
            return element;
        }
        
        if (!isEmpty()) {

            element = super.remove(0);
        }

        top--;

        return element;
    }

    public void clear() {
        super.clear();
        top = -1;
    }

    //#endregion
}