package edu.csc214.dishstack;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Continuing with the ordered and tagged tests just to experiment with it
// and get comfortable with it again.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayStackTest {
    @Test
    @Order(1)
    @Tag("Z")
    void zeroNewStackHasSizeZeroAndReturnsNullOnPeekAndPop() {
        ArrayStack<String> stack = new ArrayStack<>(3);

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }

    @Test
    @Order(2)
    @Tag("O")
    void onePushedItemCanBePeekedAndPopped() {
        ArrayStack<String> stack = new ArrayStack<>(3);

        stack.push("plate");

        assertEquals(1, stack.size());
        assertEquals("plate", stack.peek());
        assertEquals("plate", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    @Order(3)
    @Tag("M")
    void manyItemsPopInLastInFirstOutOrder() {
        ArrayStack<String> stack = new ArrayStack<>(3);

        stack.push("bottom");
        stack.push("middle");
        stack.push("top");

        assertEquals("top", stack.pop());
        assertEquals("middle", stack.pop());
        assertEquals("bottom", stack.pop());
    }

    @Test
    @Order(4)
    @Tag("B")
    void boundaryFullStackDoesNotAcceptExtraItem() {
        ArrayStack<String> stack = new ArrayStack<>(2);

        stack.push("first");
        stack.push("second");
        stack.push("third");

        assertTrue(stack.isFull());
        assertEquals(2, stack.size());
        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
    }

    @Test
    @Order(5)
    @Tag("B")
    void boundaryCapacityMustBeAtLeastOne() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayStack<String>(0));
    }

    @Test
    @Order(6)
    @Tag("I")
    void interfaceGenericStackWorksWithIntegers() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    @Order(7)
    @Tag("I")
    void interfaceClearRemovesAllItemsAndAllowsReuse() {
        ArrayStack<String> stack = new ArrayStack<>(2);

        stack.push("first");
        stack.push("second");
        stack.clear();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertNull(stack.peek());

        stack.push("after clear");

        assertEquals("after clear", stack.pop());
    }

    @Test
    @Order(8)
    @Tag("E")
    void exceptionNullItemsAreRejected() {
        ArrayStack<String> stack = new ArrayStack<>(2);

        assertThrows(NullPointerException.class, () -> stack.push(null));
    }
}
