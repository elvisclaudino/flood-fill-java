package classes;

import interfaces.IStack;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class Stack<T> implements IStack<T> {
    
    private final Object[] stack;
    private int top = -1;

    public Stack(int size) {
        this.stack = new Object[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top + 1 == stack.length;
    }

    public int size() {
        int counter = 0;
        for (Object object : stack) {
            counter += !Objects.isNull(object) ? 1 : 0;
        }
        return counter;
    }

    public T first() {
        return (T) stack[0];
    }

    public T last() {
        return !isEmpty() ? (T) stack[top] : null;
    }

    public void add(T element) {
        if (!isFull()) {
            top++;
            stack[top] = element;
        }
    }

    public T remove() {
        if (!isEmpty()) {
            T deletedElement = (T) stack[top];
            stack[top] = null;
            top--;
            return deletedElement;
        }
        return null;
    }

    public void clear() {
        Arrays.fill(stack, null);
        top = -1;
    }

    public void forEach(BiConsumer<T, Integer> fn) {
        for (int i = 0; i < stack.length; i++) {
            fn.accept( (T) stack[i], i);
        }
    }

    public void forEach(Consumer<T> fn) {
        for (Object o : stack) {
            fn.accept((T) o);
        }
    }


}