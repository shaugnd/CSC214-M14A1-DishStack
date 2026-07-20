package edu.csc214.dishstack;

import java.util.Objects;

/**
 * Represents a bounded, array-backed stack.
 *
 * <p>The stack stores values in last-in-first-out order. It supports pushing,
 * popping, peeking, checking its size, and clearing its contents.</p>
 *
 * @param <T> the type of item stored in the stack
 */
public class ArrayStack<T> {
    // Java doesn't have a way, that I'm aware of, to directly create an array of a generic type.
    // I think it has something to do with type erasure.  At runtime, Java doesn't know what to do with T
    // so I am going the long way around and using an array of Objects since every Java object can
    // be stored in an Object[].
    // When I return the stack, I will cast it as T.  That should be safe since this object controls
    // all access to the underlying array with accessor methods.
    // So internally, my array is technically Object, but the public facing behavior will be
    // a type-safe ArrayStack<T>.
    // That's the idea anyway, we will see how it plays out.

    private final Object[] items;
    private int size;

    public ArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1.");
        }

        items = new Object[capacity];
        size = 0;
    }

    public void push(T item) {
        Objects.requireNonNull(item, "Item cannot be null.");

        if (size == items.length) {
            System.out.println("Stack is full. Item was not added.");
            return;
        }

        items[size] = item;
        size++;
    }

    public T pop() {
        if (size == 0) {
            return null;
        }

        size--;
        T item = itemAt(size);
        items[size] = null;
        return item;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }

        return itemAt(size - 1);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    @SuppressWarnings("unchecked")  // Don't worry Java, I know what I'm doing. . . sort of.
    private T itemAt(int index) {
        // Here we centralize the generic cast from Object[] back to the stacks
        // public type.  This way when pop() or peek() needs to return a value
        // it gets converted appropriately but we have only one code block to
        // maintain for that behavior.  Private because I don't want anyone messing
        // about with it.
        return (T) items[index];
    }
}
