package edu.csc214.dishstack;

/**
 * Represents a bounded stack specifically for {@link Dish} objects.
 *
 * <p>This class keeps the dish-focused assignment interface while reusing the
 * generic array-backed stack implementation.</p>
 */
public class DishStack extends ArrayStack<Dish> {
    // Since I planned to do the Add-on, rather than rewriting code, I designed it
    // from the outset to make DishStack an ArrayStack to fullfill the requirements
    // of both tasks at the same time.

    // If we had specific dish behavior or data that we wanted to capture, we could
    // build it in here.  Right now, it is just a relabling of ArrayStack with no real
    // functionality difference.

    private static final int DEFAULT_CAPACITY = 10;

    public DishStack() {
        super(DEFAULT_CAPACITY);
    }

    public DishStack(int capacity) {
        super(capacity);
    }
}
