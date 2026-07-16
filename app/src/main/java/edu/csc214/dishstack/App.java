package edu.csc214.dishstack;

/**
 * Demonstrates a dish-specific stack and a generic array-backed stack.
 */
public class App {
    // This is just a quick demonstrator for the classes.  It is not meant
    // to be exhaustive.  The JUnit tests for ArrayStack and DishStack take
    // care of this.  This file just shows how to implement and use these
    // two objects.

    public static void main(String[] args) {
        System.out.println();
        System.out.println("CSC214-M14A1-DishStack Functionality Demonstrator");
        System.out.println();
        System.out.println();
        System.out.println("A demonstration of DishStack:");
        demonstrateDishStack();
        System.out.println();
        System.out.println();
        System.out.println("A demonstration of ArrayStack:");
        demonstrateGenericStack();
        System.out.println();
        System.out.println("Done.");

    }

    private static void demonstrateDishStack() {
    DishStack dishes = new DishStack(3);

    System.out.println("  Dish Stack");

    System.out.println("   -Pushing dinner plate.");
    dishes.push(new Dish("dinner plate"));

    System.out.println("   -Pushing soup bowl.");
    dishes.push(new Dish("soup bowl"));

    System.out.println("   -Pushing coffee mug.");
    dishes.push(new Dish("coffee mug"));

    System.out.println("   -Attempting to push extra saucer.");
    dishes.push(new Dish("extra saucer"));

    System.out.println("   -Size after pushes: " + dishes.size());
    System.out.println("   -Peek: " + dishes.peek().description);
    System.out.println("   -Pop: " + dishes.pop().description);
    System.out.println("   -Pop: " + dishes.pop().description);
    System.out.println("   -Size after pops: " + dishes.size());
}
 private static void demonstrateGenericStack() {
    ArrayStack<String> tasks = new ArrayStack<>(3);

    System.out.println("  Generic Stack");

    System.out.println("   -Pushing wash.");
    tasks.push("wash");

    System.out.println("   -Pushing dry.");
    tasks.push("dry");

    System.out.println("   -Pushing put away.");
    tasks.push("put away");

    System.out.println("   -Size before clear: " + tasks.size());
    System.out.println("   -Peek: " + tasks.peek());

    System.out.println("   -Clearing the stack.");
    tasks.clear();

    System.out.println("   -Size after clear: " + tasks.size());

    System.out.println("   -Pushing Another Plate after clear.");
    tasks.push("Another Plate after clear");

    System.out.println("   -Pop after reuse: " + tasks.pop());
}
}
